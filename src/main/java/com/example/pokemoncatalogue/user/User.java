package com.example.pokemoncatalogue.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;

    @Column(name = "username", nullable = false, unique = true) // Map to "username" column
    private String username;

    @Column(name = "email", nullable = false, unique = true) // Map to "email" column
    private String email;

    @Column(name = "password", nullable = false) // Map to "password" column
    private String password;

    @Column(name = "role", nullable = false) // Store user role (e.g., ADMIN, USER)
    private String role;
}
