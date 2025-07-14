package com.zenzy.backend.service;

import com.zenzy.backend.model.UserOrder;
import com.zenzy.backend.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;

    public void saveUserOrder(String username, String phone, String serviceType, String category, String customRequest, String vehicleType, String paymentMethod) {
        UserOrder order = new UserOrder();
        order.setUsername(username);
        order.setPhone(phone);
        order.setServiceType(serviceType);
        order.setCategory(category);
        order.setCustomRequest(customRequest);
        order.setVehicleType(vehicleType);
        order.setPaymentMethod(paymentMethod);
        userOrderRepository.save(order);
    }

    public List<UserOrder> getUserOrders(String username) {
        return userOrderRepository.findByUsername(username);
    }
}
