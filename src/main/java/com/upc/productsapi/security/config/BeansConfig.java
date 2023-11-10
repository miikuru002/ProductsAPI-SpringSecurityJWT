package com.upc.productsapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clase que contiene los beans de seguridad
 * @author Jamutaq Ortega
 */
@Configuration
public class BeansConfig {
    /**
     * Bean que se encarga de encriptar las contraseñas
     * @return Instancia de BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean que se encarga de manejar la autenticación
     * @param configuration Configuración de autenticación
     * @return Instancia de AuthenticationManager
     * @throws Exception Excepción de autenticación
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
