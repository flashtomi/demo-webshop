package com.example.demowebshop.service;

import com.example.demowebshop.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void saveOrUpdate(Product product);

    void delete(long id);

    void updateProductTotalAmount(long id, int count);

    void updateProductStock(long id, int amount);
}
