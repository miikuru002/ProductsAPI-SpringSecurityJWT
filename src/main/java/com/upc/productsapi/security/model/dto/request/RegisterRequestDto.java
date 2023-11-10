package com.upc.productsapi.security.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el request body para el registro de un usuario
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @NotEmpty(message = "El nombre y apellido es requerido")
    private String fullName;

    @NotEmpty(message = "El nombre de usuario es requerido")
    @Size(min = 2, message = "El nombre de usuario debe tener por lo menos 2 caracteres")
    private String username;

    @NotEmpty(message = "El email es requerido")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotEmpty(message = "La contraseña es requerida")
    @Size(min = 3, message = "La contraseña debe tener por lo menos 3 caracteres")
    private String password;
}
