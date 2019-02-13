package com.example.demowebshop.repository;

import com.example.demowebshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    void deleteById(int cartItemId);
}
