package com.upc.productsapi.users.service;

import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.users.model.dto.UserResponseDto;

/**
 * Servicio para operaciones con usuarios
 * @author Jamutaq Ortega
 */
public interface IUserService {
    /**
     * Obtiene los datos de un usuario por su id
     * @param userId id del usuario
     * @return Datos del usuario
     */
    ApiResponse<UserResponseDto> profile(Long userId);

    /**
     * Elimina un usuario por su id
     * @param userId id del usuario
     * @return Respuesta de la operación
     */
    ApiResponse<Object> deleteById(Long userId);
}
