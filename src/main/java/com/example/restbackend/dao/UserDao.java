package com.example.restbackend.dao;

import com.example.restbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
    User findByName(String username);
}
