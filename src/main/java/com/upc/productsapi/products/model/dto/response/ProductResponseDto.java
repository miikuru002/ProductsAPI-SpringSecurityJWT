package com.upc.productsapi.products.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el objeto de respuesta para el registro de un producto
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String name;
    private double price;
    private int stock;
}
