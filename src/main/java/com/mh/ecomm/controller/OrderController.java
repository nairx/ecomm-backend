package com.mh.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mh.ecomm.model.Order;
import com.mh.ecomm.model.User;
import com.mh.ecomm.repository.OrderRepository;
import com.mh.ecomm.repository.UserRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{email}")
    public List<Order> getOrderById(@PathVariable String email) {
        return orderRepository.findByEmail(email);

    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        Order order = new Order();
        order.setProduct(request.getProduct());
        order.setPrice(request.getPrice());
        order.setQty(request.getQty());
        order.setEmail(request.getEmail());
        order.setOrderStatus("Pending");

        orderRepository.save(order);
        return ResponseEntity.ok("Order saved");
        // Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        // if (userOptional.isPresent()) {
        // Order order = new Order();
        // order.setProduct(request.getProduct());
        // order.setPrice(request.getPrice());
        // order.setQty(request.getQty());
        // order.setEmail(request.getEmail());

        // orderRepository.save(order);
        // return ResponseEntity.ok("Order saved");
        // } else {
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        // }
    }
}
