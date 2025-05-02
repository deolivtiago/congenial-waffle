package com.clarxlabs.ellion.controllers;

import com.clarxlabs.ellion.controllers.dtos.UserData;
import com.clarxlabs.ellion.entities.User;
import com.clarxlabs.ellion.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody UserData input) {
        final var entity = User.builder()
                .fullName(input.fullName())
                .email(input.email())
                .password(input.password())
                .build();

        return userRepository.save(entity);
    }
}
