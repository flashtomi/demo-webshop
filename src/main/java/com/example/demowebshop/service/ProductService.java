package com.example.demowebshop.service;

import com.example.demowebshop.model.Product;
import com.example.demowebshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService implements IProductService{

    @Autowired(required = false)
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProductTotalAmount(long id, int count) {
        Product product = getProductById(id);
        product.setTotalAmount(product.getTotalAmount() + count);
    }

    @Override
    public void updateProductStock(long id, int amount) {
        Product product = getProductById(id);
        product.setTotalAmount(product.getStock() - amount);
    }
}
