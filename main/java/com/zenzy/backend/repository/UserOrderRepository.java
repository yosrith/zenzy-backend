package com.zenzy.backend.repository;

import com.zenzy.backend.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUsername(String username); // Retrieve all orders by username
}

