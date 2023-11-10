package com.upc.productsapi.security.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el request body para el endpoint de login
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "El nombre de usuario o email es requerido")
    private String usernameOrEmail;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 3, message = "La contraseña debe tener por lo menos 3 caracteres")
    private String password;
}
