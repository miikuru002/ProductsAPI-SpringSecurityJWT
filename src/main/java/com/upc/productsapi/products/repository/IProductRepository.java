package com.upc.productsapi.products.repository;

import com.upc.productsapi.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que se encarga de realizar las operaciones de persistencia de la entidad Product
 * @author Jamutaq Ortega
 */
public interface IProductRepository extends JpaRepository<Product, Long> {
    /**
     * Busca un producto por su nombre
     * @param name Nombre del producto
     * @return Producto encontrado
     */
    Optional<Product> findByName(String name);
}
