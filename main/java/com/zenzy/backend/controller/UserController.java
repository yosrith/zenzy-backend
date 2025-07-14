package com.zenzy.backend.controller;

import com.zenzy.backend.model.User;
import com.zenzy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Login API (Auto-registers new users if they don’t exist)
     */
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        User loggedInUser = userService.login(user.getUsername(), user.getPhone());
        return ResponseEntity.ok(loggedInUser);
    }

    /**
     * Fetch User Details (if needed)
     */
    @GetMapping("/user-details")
    public ResponseEntity<User> getUserDetails(@RequestParam String phone) {
        Optional<User> user = userService.getUserDetails(phone);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(null));
    }
}
