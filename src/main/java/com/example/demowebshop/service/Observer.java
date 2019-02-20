package com.example.demowebshop.service;

import com.example.demowebshop.model.CartItem;

public interface Observer {
    void update(CartItem cartItem, int id, int amount);
}
