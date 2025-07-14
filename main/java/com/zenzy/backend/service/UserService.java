package com.zenzy.backend.service;

import com.zenzy.backend.model.User;
import com.zenzy.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Logs in a user based on username and phone number.
     * If the user does not exist, they will be automatically created.
     */
    public User login(String username, String phone) {
        Optional<User> existingUser = userRepository.findByPhone(phone);

        if (existingUser.isPresent()) {
            return existingUser.get();
        } else {
            if (username == null || username.trim().isEmpty()) {
                username = "Guest"; // Assign default username if empty
            }

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPhone(phone);
            return userRepository.save(newUser);
        }
    }


    /**
     * Fetch user details by phone number.
     */
    public Optional<User> getUserDetails(String phone) {
        return userRepository.findByPhone(phone);
    }
}
