package com.upc.productsapi.users.service;

import com.upc.productsapi.shared.dto.enums.EStatus;
import com.upc.productsapi.shared.dto.response.ApiResponse;
import com.upc.productsapi.shared.exception.ResourceNotFoundException;
import com.upc.productsapi.users.model.dto.UserResponseDto;
import com.upc.productsapi.users.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Servicio para usuarios
 * @author Jamutaq Ortega
 */
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(IUserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<UserResponseDto> profile(Long userId) {
       var user = userRepository.findById(userId)
               .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

       //se mapea el usuario a un DTO
       var userDto = modelMapper.map(user, UserResponseDto.class);

       return new ApiResponse<>("Usuario encontrado", EStatus.SUCCESS, userDto);
    }

    @Override
    public ApiResponse<Object> deleteById(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

        //elimina al usuario
        userRepository.delete(user);

        return new ApiResponse<>("Usuario eliminado correctamente", EStatus.SUCCESS, null);
    }
}
