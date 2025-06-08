package com.mh.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mh.ecomm.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameContainingIgnoreCase(String keyword);

}
