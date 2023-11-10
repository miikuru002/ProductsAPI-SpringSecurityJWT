package com.upc.productsapi.products.controller;

import com.upc.productsapi.products.model.dto.request.ProductRequestDto;
import com.upc.productsapi.products.model.dto.response.ProductResponseDto;
import com.upc.productsapi.products.service.IProductService;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de productos, expone los endpoints
 * @author Jamutaq Ortega
 */
@Tag(name = "Product")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    /**
     * Obtiene todos los productos
     * @return Lista de productos
     */
    @Operation(summary = "Obtiene todos los productos")
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> listProducts() {
        var res = service.getAllProducts();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Obtiene un producto por su nombre
     * @param name nombre del producto
     * @return Producto
     */
    @Operation(summary = "Obtiene un producto por su nombre")
    @GetMapping("/detail")
    public ResponseEntity<ApiResponse<ProductResponseDto>> getProductByName(@RequestParam String name) {
        var res = service.getProductByName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Registra un nuevo producto
     * @param product producto a registrar
     * @return Producto registrado
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')") //solo los administradores pueden acceder a este endpoint
    @Operation(summary = "Registra un nuevo producto (ADMIN)")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProductResponseDto>> registerProduct(@RequestBody @Valid ProductRequestDto product) {
        var res = service.registerProduct(product);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    /**
     * Elimina un producto por su ID
     * @param productId ID del producto
     * @return Respuesta
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')") //solo los administradores pueden acceder a este endpoint
    @Operation(summary = "Elimina un producto por su ID (ADMIN)")
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(@PathVariable("productId") Long productId) {
        var res = service.deleteProductById(productId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
