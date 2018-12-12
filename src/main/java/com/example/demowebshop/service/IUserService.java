package com.example.demowebshop.service;

import com.example.demowebshop.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    void deleteUser(int userId);

    void addUser(User user);

    User getUserById(int userId);
}
