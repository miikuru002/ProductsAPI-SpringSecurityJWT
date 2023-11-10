package com.upc.productsapi.users.repository;

import com.upc.productsapi.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que extiende de JpaRepository para poder realizar operaciones de persistencia sobre la entidad User.
 * @author Jamutaq Ortega
 */
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * Busca un usuario por su email o username
     * @param email Email
     * @param username Username
     * @return Usuario encontrado
     */
    Optional<User> findByEmailOrUsername(String email, String username);

    /**
     * Verifica si existe un usuario por su email
     * @param email Email
     * @return True si existe, false si no
     */
    boolean existsByEmail(String email);

    /**
     * Verifica si existe un usuario por su username
     * @param username Username
     * @return True si existe, false si no
     */
    boolean existsByUsername(String username);
}
