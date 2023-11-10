package com.upc.productsapi.security.service;

import com.upc.productsapi.security.model.dto.request.LoginRequestDto;
import com.upc.productsapi.security.model.dto.request.RegisterRequestDto;
import com.upc.productsapi.security.model.dto.response.RegisteredUserResponseDto;
import com.upc.productsapi.security.model.dto.response.TokenResponseDto;
import com.upc.productsapi.shared.dto.response.ApiResponse;

/**
 * Servicio para autenticación y registro de usuarios
 * @author Jamutaq Ortega
 */
public interface IAuthService {
    /**
     * Registra un usuario
     * @param request Datos para el registro
     * @return Usuario registrado
     */
    ApiResponse<RegisteredUserResponseDto> registerUser(RegisterRequestDto request);

    /**
     * Realiza el login del usuario
     * @param request Credenciales
     * @return Token de acceso
     */
    ApiResponse<TokenResponseDto> login(LoginRequestDto request);
}
