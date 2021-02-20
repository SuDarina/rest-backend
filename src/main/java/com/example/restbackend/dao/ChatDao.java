package com.example.restbackend.dao;
import com.example.restbackend.model.Chat;

public interface ChatDao {
    Chat findByUsername(String name);
}
