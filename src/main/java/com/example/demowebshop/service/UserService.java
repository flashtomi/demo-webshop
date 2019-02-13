package com.example.demowebshop.service;

import com.example.demowebshop.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void deleteUser(int userId);

    User getUserById(int userId);

    void save(User user);

    User findByUsername(String username);
}
