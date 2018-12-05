package com.example.demowebshop.controller;

import com.example.demowebshop.model.Product;
import com.example.demowebshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    private List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    private void deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
    }

    @PostMapping("/products")
    private long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getId();
    }
}