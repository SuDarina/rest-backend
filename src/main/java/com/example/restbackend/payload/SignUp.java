package com.example.restbackend.payload;
import javax.validation.constraints.Size;
public class SignUp {
    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
