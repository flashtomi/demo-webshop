package com.example.demowebshop.controller;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.Order;
import com.example.demowebshop.model.User;
import com.example.demowebshop.service.ICartService;
import com.example.demowebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {

        Order order = new Order();

        Cart cart = cartService.getCartByCartId(cartId);
        order.setCart(cart);

        User user = cart.getUser();
        order.setUser(user);

        orderService.addOrder(order);

        return "redirect:/checkout?cartId=" + cartId;
    }
}
