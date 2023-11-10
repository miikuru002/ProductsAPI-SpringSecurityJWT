package com.upc.productsapi.security.service;

import com.upc.productsapi.shared.util.Utilities;
import com.upc.productsapi.users.repository.IUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz UserDetailsService de Spring Security para obtener los datos del usuario autenticado
 * @author Jamutaq Ortega
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    public CustomUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Obtiene los datos del usuario autenticado por su username o email
     * @param usernameOrEmail Nombre de usuario o email del usuario autenticado
     * @return Datos del usuario autenticado
     * @throws UsernameNotFoundException Excepción de usuario no encontrado
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        //busca al usuario por su username o email
        var user = userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró al usuario con el username o email: " + usernameOrEmail));

        //crea y retorna un objeto que representa al usuario autenticado
        return new User(user.getEmail(), user.getPassword(), Utilities.mapRoles(user.getRoles()));
    }
}
