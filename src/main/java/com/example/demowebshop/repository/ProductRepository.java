package com.example.demowebshop.repository;

import com.example.demowebshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
}
