package com.example.demowebshop.repository;

import com.example.demowebshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int userId);

    void deleteById(int userId);
}
