package com.example.demowebshop.repository;

import com.example.demowebshop.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
