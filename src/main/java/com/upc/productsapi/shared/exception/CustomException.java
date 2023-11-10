package com.upc.productsapi.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Clase que maneja errores otros errores http
 * @author Jamutaq Ortega
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private HttpStatus status;

    public CustomException(HttpStatus status, String _message) {
        super(_message);
        this.status = status;
    }
}
