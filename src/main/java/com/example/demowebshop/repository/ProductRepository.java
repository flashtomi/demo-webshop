package com.example.demowebshop.repository;

import com.example.demowebshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    void deleteById(int id);

    Product findById(int id);
}
