package com.upc.productsapi.security.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de la API cuando se loguea un usuario y se le devuelve el token de acceso
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String token;
}
