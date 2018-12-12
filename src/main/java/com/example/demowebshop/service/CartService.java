package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartByCartId(int cartId) {
        return cartRepository.findById(cartId).get();
    }
}
