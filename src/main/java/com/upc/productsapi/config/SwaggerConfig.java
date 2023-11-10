package com.upc.productsapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que se encarga de configurar Swagger para la documentación de la API
 * @author Jamutaq Ortega
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Products API")
                        .description("API de productos con Spring Security")
                        .version("1.0.0")
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList("JwtScheme")
                )
                .components(new Components()
                        //JWT
                        .addSecuritySchemes("JwtScheme",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .description("Autorizar por un token JWT")
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }
}
