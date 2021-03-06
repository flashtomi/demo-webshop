package com.example.demowebshop.service;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.model.Order;
import com.example.demowebshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public double getOrderTotal(int cartId) {
        double total=0;
        Cart cart = cartService.getCartByCartId(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item: cartItems){
            total += item.getPrice();
        }
        return total;
    }
}
