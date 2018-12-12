package com.example.demowebshop.repository;

import com.example.demowebshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
