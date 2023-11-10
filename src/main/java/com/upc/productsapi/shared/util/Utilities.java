package com.upc.productsapi.shared.util;

import com.upc.productsapi.users.model.entity.Role;
import com.upc.productsapi.users.model.enums.ERole;
import com.upc.productsapi.users.repository.IRoleRepository;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.List;

/**
 * Clase de utilidades para la seguridad y autenticación de usuarios
 * @author Jamutaq Ortega
 */
@Slf4j
public class Utilities {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    /**
     * Obtiene el token del header Authorization
     * @param request Solicitud http
     * @return Token obtenido
     */
    static public String getJwtTokenFromRequest(HttpServletRequest request) {
        //obtiene el token JWT desde el header
        String jwtTokenFromHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(jwtTokenFromHeader) && jwtTokenFromHeader.startsWith(BEARER_PREFIX)) {
            return jwtTokenFromHeader.substring(BEARER_PREFIX.length());
        }

        return null;
    }

    /**
     * Mapea los roles a una lista de GrantedAuthority
     * @param roles Roles a mapear
     * @return Lista de GrantedAuthority
     */
    static public List<SimpleGrantedAuthority> mapRoles(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .toList();
    }

    /**
     * Obtiene los roles del usuario autenticado
     * @param authenticatedUser Usuario autenticado
     * @return Lista de roles
     */
    static public List<String> getRoles(User authenticatedUser) {
        return authenticatedUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    /**
     * Generar una clave secreta a partir del secret que se utilizará para firmar y verificar los tokens
     * @param secret Secret
     * @return Clave secreta HMAC
     */
    static public SecretKey getKey(String secret) {
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }

    /**
     * Inserta un rol si no existe
     * @param repository Repositorio de roles
     * @param roleName Nombre del rol
     */
    static public void insertRoleIfNotFound(IRoleRepository repository, ERole roleName) {
        if (!repository.existsByName(roleName)) {
            var newRole = new Role();
            newRole.setName(roleName);

            repository.save(newRole);
            log.info("Role {} inserted", roleName);
        }
    }
}
