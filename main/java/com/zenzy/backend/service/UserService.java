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

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = findUserByUsername(username);
        return user.filter(u -> u.getPassword().equals(password));
    }
}
