package com.upc.productsapi.users.model.entity;

import com.upc.productsapi.users.model.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de roles de usuario
 * @author Jamutaq Ortega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    //se tomará como un String los valores de este enum
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERole name;
}
