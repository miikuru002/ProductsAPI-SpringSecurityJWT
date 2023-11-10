package com.upc.productsapi.products.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el objeto de petición para el registro de un producto
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;

    @Min(value = 0, message = "El precio del producto no puede ser negativo")
    private double price;

    @Min(value = 0, message = "El stock del producto no puede ser negativo")
    private int stock;
}
