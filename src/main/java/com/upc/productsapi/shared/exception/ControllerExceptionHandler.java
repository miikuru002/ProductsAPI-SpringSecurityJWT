package com.upc.productsapi.shared.exception;

import com.upc.productsapi.shared.dto.enums.EStatus;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que se encarga de manejar las excepciones que se producen en los controladores
 * @author Jamutaq Ortega
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    /**
     * Este método se ejecuta cuando se produce una excepción de tipo 404
     * @param ex Excepción que se ha producido
     * @param request Petición web en la que se ha producido la excepción
     * @return Objeto de tipo ErrorMessage con los datos de la excepción
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiResponse<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        var errorMessage = new ErrorMessage(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );

        return new ApiResponse<>("El recurso que intenta acceder no existe", EStatus.ERROR, errorMessage);
    }

    /**
     * Método para manejar las excepciones de las validaciones (cuando se envían datos inválidos)
     * @param ex Excepción de validación
     * @param request Petición web en la que se ha producido la excepción
     * @return Errores de validación
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ApiResponse<List<String>> handleValidationErrors(
            MethodArgumentNotValidException ex,
            WebRequest request
    ) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return new ApiResponse<>("Validaciones de entrada fallidas", EStatus.ERROR, errors);
    }

    /**
     * Método para manejar otras excepciones que no se han contemplado
     * @param ex Excepción que se ha producido
     * @param webRequest Petición web en la que se ha producido la excepción
     * @return Objeto de tipo ErrorMessage con los datos de la excepción
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<ErrorMessage> handleGlobalException(
            Exception ex,
            WebRequest webRequest
    ) {
        var errorDetails = new ErrorMessage(
                ex.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now()
        );

        return new ApiResponse<>("Ha ocurrido un error inesperado", EStatus.ERROR, errorDetails);
    }
}
