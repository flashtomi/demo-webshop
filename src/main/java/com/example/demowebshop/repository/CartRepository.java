package com.example.demowebshop.repository;

import com.example.demowebshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findById(int cartId);
}
