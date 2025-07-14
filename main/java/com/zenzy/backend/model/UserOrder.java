package com.zenzy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_orders")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String phone;
    private String serviceType;  // "Shop & Deliver", "Pick & Drop", etc.
    private String category;  // "Groceries", "Electronics", etc.
    private String customRequest;  // User input (ex: "Buy a birthday cake")
    private String vehicleType;  // "Bike", "Car", etc.
    private String paymentMethod;  // "UPI", "Cash", etc.
    private LocalDateTime timestamp;

    public UserOrder() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCustomRequest() { return customRequest; }
    public void setCustomRequest(String customRequest) { this.customRequest = customRequest; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
