package com.zenzy.backend.service;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import com.zenzy.backend.repository.UserRepository;
import com.zenzy.backend.model.User;


@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Check if the database is empty
        if (userRepository.count() == 0) {
            // Insert sample data
            User user = new User();
            user.setUsername("testuser");
            user.setPassword("password123");
            user.setEmail("testuser@example.com");
            userRepository.save(user);
            System.out.println("Sample user added to the database.");
        }
    }
}
