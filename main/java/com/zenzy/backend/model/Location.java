package com.zenzy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private double latitude;
    private double longitude;

    // Getters & Setters
}
