package com.example.demowebshop.service;

import com.example.demowebshop.model.CartItem;

import java.util.List;

public interface ICartItemService {

    void addCartItem(CartItem cartItem);
    void removeCartItem(int CartItemId);
    void removeAllCartItems(List<CartItem> cartItem);
    void update(CartItem cartItem);
}
