package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    @Override
    public Cart getCartByCartId(int cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public void updateProducts(Cart cart) {
        List<CartItem> cartItems = cartRepository.findById(cart.getId()).getCartItems();
        for (CartItem cartItem : cartItems) {
            cartItemService.update(cartItem);
        }
    }
}
