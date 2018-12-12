package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartItemService implements ICartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItem();
        cartItemRepository.deleteAll(cartItems);
    }
}
