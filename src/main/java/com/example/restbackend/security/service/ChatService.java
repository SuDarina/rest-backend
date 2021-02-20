package com.example.restbackend.security.service;

import com.example.restbackend.model.Chat;
import com.example.restbackend.model.User;

public interface ChatService {
    Chat findByName(String username);
}
