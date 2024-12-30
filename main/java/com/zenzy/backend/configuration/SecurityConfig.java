package com.zenzy.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for development
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                                .anyRequest().permitAll() // Allow all other requests
                )
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // Allow H2 console in frames
        return http.build();
    }
}
