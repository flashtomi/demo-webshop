package com.example.demowebshop.service;

import com.example.demowebshop.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    void saveOrUpdate(Product product);

    void delete(int id);

    void updateProductTotalAmount(int id, int count);

    void updateProductStock(int id, int amount);
}
