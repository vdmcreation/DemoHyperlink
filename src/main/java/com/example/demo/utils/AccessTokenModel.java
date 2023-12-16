package com.example.demo.utils;

import com.example.demo.model.User;

import java.io.Serializable;
import java.util.List;

public class AccessTokenModel extends AuthDetails implements Serializable {
    private static final long serialVersionUID = -4263112003385658152L;
    private String username;
    private String password;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessTokenModel(String username, String password, User user) {
        this.username = username;
        this.password = password;
        setUser(user);
    }
}
