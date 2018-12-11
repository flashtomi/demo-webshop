package com.example.demowebshop.repository;

import com.example.demowebshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
