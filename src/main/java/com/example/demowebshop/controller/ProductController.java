package com.example.demowebshop.controller;

import com.example.demowebshop.Util.RetryCommand;
import com.example.demowebshop.model.Product;
import com.example.demowebshop.model.User;
import com.example.demowebshop.service.IProductService;
import com.example.demowebshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private UserService userService;

    private RetryCommand<Product> retryCommand;

    @RequestMapping("/products")
    private List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") int id) {
        return retryCommand.run(() -> productService.getProductById(id));
    }

    @RequestMapping("/products/delete/{id}")
    private void deleteProduct(@PathVariable("id") int id, int userId) {
        User user = userService.getUserById(userId);
        if(user.isPermitted("deleteProduct")) {
            productService.delete(id);
        } else {
            System.out.println("Don't have permission");
        }
    }

    @RequestMapping("/product")
    private long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getId();
    }
}
