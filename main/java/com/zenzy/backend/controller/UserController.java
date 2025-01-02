package com.zenzy.backend.controller;

import com.zenzy.backend.model.User;
import com.zenzy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup") // Updated the endpoint from /register to /signup
    public ResponseEntity<String> signupUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User signed up successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        System.out.println("Login request received for username: " + user.getUsername() + " and password: " + user.getPassword());
        return userService.login(user.getUsername(), user.getPassword())
                .map(u -> ResponseEntity.ok("Login successful!"))
                .orElse(ResponseEntity.status(401).body("Invalid username or password"));
    }
}
