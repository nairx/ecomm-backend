package com.mh.ecomm.controller;

import com.mh.ecomm.model.User;
import com.mh.ecomm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    // @PostMapping("/register")
    // public ResponseEntity<String> register(@RequestBody User loginRequest) {
    //      User user = userRepository.findByEmail(loginRequest.getEmail());

    //     if (user == null) {
    //         userRepository.save(loginRequest);
    //         return ResponseEntity.ok("Registration successful!");
    //     } else {
    //         return ResponseEntity.status(401).body("Duplicate Email.");
    //     }
    // }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
         User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user != null && user.getPass().equals(loginRequest.getPass())) {
            return ResponseEntity.ok(user.getEmail());
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }

}
