package com.example.pokemoncatalogue.user;

import lombok.*;

@AllArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String username;
    private String email;
}
