package com.example.pokemoncatalogue.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO, @RequestParam String password) {
        return service.createUser(userDTO, password);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }

    @PostMapping("/{id}/change-password")
    public void changePassword(
            @PathVariable String id,
            @RequestParam String oldPassword,
            @RequestParam String newPassword
    ) {
        service.changePassword(id, oldPassword, newPassword);
    }
}
