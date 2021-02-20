package com.example.restbackend.security.service;

import com.example.restbackend.dao.ChatDao;
import com.example.restbackend.dao.UserDao;
import com.example.restbackend.model.Chat;
import com.example.restbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatServiceImplementation implements ChatService {
    @Autowired
    private ChatDao chatDao;

    @Override
    public Chat findByName(String name) {
        return chatDao.findByUsername(name);
    }
}
