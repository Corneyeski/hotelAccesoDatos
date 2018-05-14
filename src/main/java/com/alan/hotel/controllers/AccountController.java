package com.alan.hotel.controllers;

import com.alan.hotel.entities.User;
import com.alan.hotel.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import java.util.Optional;

@RestController
public class AccountController {

    private final UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {
        User result = userRepository.findByUsername(user.getUsername());
        if (result != null) {
            throw new BadRequestException("User already exists");
        }
        return userRepository.save(user);
    }

    @GetMapping("users/{username}")
    public User getUser(@PathVariable("username") String username) {
        User result = userRepository.findByUsername(username);
        if (result == null) {
            throw new BadRequestException("The user does not exists");
        }
        return result;
    }

}
