package com.upc.productsapi.users.controller;

import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.users.model.dto.UserResponseDto;
import com.upc.productsapi.users.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para usuarios
 * @author Jamutaq Ortega
 */
@Tag(name = "User")
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtiene el perfil de un usuario")
    @GetMapping("/profile/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> profile(@PathVariable Long userId) {
        var res = userService.profile(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Elimina un usuario (ADMIN)")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable Long userId) {
        var res = userService.deleteById(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
