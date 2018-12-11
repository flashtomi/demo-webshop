package com.example.demowebshop.controller;

import com.example.demowebshop.model.Product;
import com.example.demowebshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    private List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    private void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }

    @PostMapping("/products")
    private long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getId();
    }
}
