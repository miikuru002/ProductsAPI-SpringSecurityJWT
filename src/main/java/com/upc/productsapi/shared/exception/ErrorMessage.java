package com.upc.productsapi.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Mensaje de error que se envía al cliente cuando se produce una excepción
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private String description;
    private String requestDescription;
    private LocalDateTime timestamp;
}
