package com.example.demowebshop.service;

import com.example.demowebshop.model.Product;
import com.example.demowebshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public void updateProductTotalAmount(long id, int count) {
        Product product = getProductById(id);
        product.setTotalAmount(product.getTotalAmount() + count);
    }

    public void updateProductStock(long id, int amount) {
        Product product = getProductById(id);
        product.setTotalAmount(product.getStock() - amount);
    }
}
