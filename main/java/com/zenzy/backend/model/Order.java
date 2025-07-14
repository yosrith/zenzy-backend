package com.zenzy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType; // Pick & Drop, Shop & Deliver, Assist at Location
    private String pickupLocation;
    private String dropLocation;
    private String selectedItem;
    private String transportMode;
    private String instructions;
    private String status; // Pending, Completed, Cancelled
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters & Setters
}
