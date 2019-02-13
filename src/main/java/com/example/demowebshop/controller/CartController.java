package com.example.demowebshop.controller;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.User;
import com.example.demowebshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping("/cart/getCart/{cartId}")
    public @ResponseBody
    Cart getCartItems(@PathVariable(value="cartId") int cartId){
        return cartService.getCartByCartId(cartId);
    }

    @RequestMapping("cart/getCartById")
    public String getCartId(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int cartId = user.getCart().getId();
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
