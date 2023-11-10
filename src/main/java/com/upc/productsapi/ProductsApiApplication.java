package com.upc.productsapi;

import com.upc.productsapi.shared.util.Utilities;
import com.upc.productsapi.users.model.enums.ERole;
import com.upc.productsapi.users.repository.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ProductsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(IRoleRepository roleRepository) {
        return args -> {
            Utilities.insertRoleIfNotFound(roleRepository, ERole.ROLE_USER);
            Utilities.insertRoleIfNotFound(roleRepository, ERole.ROLE_ADMIN);
        };
    }
}
