package com.zenzy.backend.controller;

import com.zenzy.backend.model.UserOrder;
import com.zenzy.backend.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-orders")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    // ✅ Save user order (Supports both category & custom input)
    @PostMapping("/save")
    public ResponseEntity<String> saveUserOrder(@RequestBody UserOrder order) {
        userOrderService.saveUserOrder(
                order.getUsername(),
                order.getPhone(),
                order.getServiceType(),
                order.getCategory(),
                order.getCustomRequest(),
                order.getVehicleType(),
                order.getPaymentMethod()
        );
        return ResponseEntity.ok("User order saved successfully!");
    }

    // ✅ Fetch user orders
    @GetMapping("/{username}")
    public ResponseEntity<List<UserOrder>> getUserOrders(@PathVariable String username) {
        List<UserOrder> orders = userOrderService.getUserOrders(username);
        return ResponseEntity.ok(orders);
    }
}
