package com.upc.productsapi.users.model.dto;

import com.upc.productsapi.users.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * DTO para respuesta de datos de usuario
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String fullName;
    private String username;
    private String email;
    private Set<Role> roles = new HashSet<>();
}
