package com.example.demowebshop.service;

import com.example.demowebshop.model.Order;

public interface IOrderService {

    void addOrder(Order order);
    double getOrderTotal(int cartId);
}
