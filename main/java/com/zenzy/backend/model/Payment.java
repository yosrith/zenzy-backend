package com.zenzy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId; // Reference to Order
    private String paymentMethod; // UPI, Card, Cash
    private Double amount;
    private String status; // Pending, Completed, Failed

    // Getters & Setters
}
