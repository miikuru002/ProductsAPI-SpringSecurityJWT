package com.upc.productsapi.security.model.dto.response;

import com.upc.productsapi.users.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa la respuesta de la API cuando se registra un usuario
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredUserResponseDto {
    private Long userId;
    private String fullName;
    private String username;
    private String email;
    private Set<Role> roles = new HashSet<>();
}
