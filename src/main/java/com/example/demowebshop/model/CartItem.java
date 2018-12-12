package com.example.demowebshop.model;

import javax.persistence.*;

@Entity
public class CartItem {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int cartItemId;

        private int quality;
        private double price;

        @ManyToOne
        @JoinColumn(name = "productId")
        private Product product;

        @ManyToOne
        @JoinColumn(name = "cartId")
        private Cart cart;

        public int getCartItemId() {
            return cartItemId;
        }

        public void setCartItemId(int cartItemId) {
            this.cartItemId = cartItemId;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public Cart getCart() {
            return cart;
        }

        public void setCart(Cart cart) {
            this.cart = cart;
        }
    }

