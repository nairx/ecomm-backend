package com.mh.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mh.ecomm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // List<Order> findByEmail(Long userId);
    List<Order> findByEmail(String email);
}
