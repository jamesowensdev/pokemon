package com.example.pokemoncatalogue.user;

import com.example.pokemoncatalogue.util.enums.Roles;
import lombok.*;

@AllArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private Roles role;
}
