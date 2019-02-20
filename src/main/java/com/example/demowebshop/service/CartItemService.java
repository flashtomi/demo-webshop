package com.example.demowebshop.service;

import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.model.Product;
import com.example.demowebshop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartItemService implements ICartItemService, Observer {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private IProductService productService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void removeAllCartItems(List<CartItem> cartItem) {
        cartItemRepository.delete(cartItem);
    }

    @Override
    public void update(CartItem cartItem, int productId, int amount) {
        Product product = productService.getProductById(productId);
        product.setStock(product.getStock() + amount);
        productService.saveOrUpdate(product);
    }
}
