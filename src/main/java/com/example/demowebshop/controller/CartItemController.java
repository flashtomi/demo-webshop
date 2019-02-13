package com.example.demowebshop.controller;

import com.example.demowebshop.model.Cart;
import com.example.demowebshop.model.CartItem;
import com.example.demowebshop.model.Product;
import com.example.demowebshop.model.User;
import com.example.demowebshop.service.ICartItemService;
import com.example.demowebshop.service.ICartService;
import com.example.demowebshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class CartItemController {

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IProductService productService;

    @RequestMapping("/cart/add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(@PathVariable(value = "productId") int productId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart = user.getCart();
        System.out.println(cart);
        List<CartItem> cartItems = cart.getCartItem();
        Product product = productService.getProductById(productId);
        for (CartItem cartItem : cartItems) {
            if (product.getId() == cartItem.getProduct().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setPrice(cartItem.getQuantity() * cartItem.getProduct().getValue());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(1);
        cartItem.setProduct(product);
        cartItem.setPrice(product.getValue() * 1);
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping("/cart/removeCartItem/{cartItemId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }

    @RequestMapping("/cart/removeAllItems/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAllCartItems(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartByCartId(cartId);
        cartItemService.removeAllCartItems(cart);
    }
}
