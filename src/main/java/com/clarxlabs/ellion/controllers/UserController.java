package com.clarxlabs.ellion.controllers;

import com.clarxlabs.ellion.controllers.requests.UserData;
import com.clarxlabs.ellion.entities.Role;
import com.clarxlabs.ellion.entities.Token;
import com.clarxlabs.ellion.entities.User;
import com.clarxlabs.ellion.repositories.RoleRepository;
import com.clarxlabs.ellion.repositories.TokenRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody UserData input) {
        final var role = roleRepository.findById("user").orElseThrow();
        final var entity = User.builder()
                .fullName(input.fullName())
                .email(input.email())
                .password(input.password())
                .role(role)
                .build();

        return userRepository.save(entity);
    }

    @GetMapping("/roles")
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/tokens")
    public List<Token> listTokens() {
        return tokenRepository.findAll();
    }
}
