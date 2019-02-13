package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
        cartItemRepository.removeAllCartItems(cart);
    }
}
