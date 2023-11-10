package com.upc.productsapi.products.service;

import com.upc.productsapi.products.model.dto.request.ProductRequestDto;
import com.upc.productsapi.products.model.dto.response.ProductResponseDto;
import com.upc.productsapi.products.model.entity.Product;
import com.upc.productsapi.products.repository.IProductRepository;
import com.upc.productsapi.shared.dto.enums.EStatus;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que se encarga de implementar los métodos de la interfaz IProductService
 * @author Jamutaq Ortega
 */
@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(IProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<ProductResponseDto> registerProduct(ProductRequestDto productData) {
        //dto a entity
        var product = modelMapper.map(productData, Product.class);

        //crear el producto
        var productSaved = productRepository.save(product);

        //entity a dto
        var productResponse = modelMapper.map(productSaved, ProductResponseDto.class);

        //retornar la respuesta
        return new ApiResponse<>("Producto registrado correctamente", EStatus.SUCCESS, productResponse);
    }

    @Override
    public ApiResponse<Object> deleteProductById(Long productId) {
        //buscar el producto a eliminar
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con el id: " + productId));

        //eliminar el producto
        productRepository.delete(product);

        //retornar la respuesta
        return new ApiResponse<>("Producto eliminado correctamente", EStatus.SUCCESS, null);
    }

    @Override
    public ApiResponse<ProductResponseDto> getProductByName(String name) {
        //buscar el producto
        var product = productRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con el nombre: " + name));

        //entity a dto
        var productResponse = modelMapper.map(product, ProductResponseDto.class);

        //retornar la respuesta
        return new ApiResponse<>("Ok", EStatus.SUCCESS, productResponse);
    }

    @Override
    public ApiResponse<List<ProductResponseDto>> getAllProducts() {
        //buscar todos los productos
        var products = productRepository.findAll();

        //entity a dto
        var productsResponse = products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .toList();

        //retornar la respuesta
        return new ApiResponse<>("Ok", EStatus.SUCCESS, productsResponse);
    }
}
