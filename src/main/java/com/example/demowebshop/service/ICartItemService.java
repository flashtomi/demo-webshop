package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;

public interface ICartItemService {

    void addCartItem(CartItem cartItem);
    void removeCartItem(int CartItemId);
    void removeAllCartItems(Cart cart);
}
