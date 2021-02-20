package com.example.restbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "chats")
public class Chat {
    @Id(strategy =GenerationType.AUTO)
    private Long id;

    name ="name"
    String name;

    name ="admin"
    String admin;

    @ManyToMany
    @JoinTable(name = "chats", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private Set<User> chats;

    public Chat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Set<User> getChats() {
        return chats;
    }

    public void setChats(Set<User> chats) {
        this.chats = chats;
    }
}
