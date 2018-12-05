package com.example.demowebshop.model;

import com.example.demowebshop.service.IPaymentService;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public void addItem(Product product) {
        this.products.add(product);
    }

    public void removeItem(Product product) {
        this.products.remove(product);
    }

    private int calculateTotal() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getValue();
        }
        return sum;
    }

    public void pay(IPaymentService payment) {
        payment.callService(calculateTotal());
    }
}
