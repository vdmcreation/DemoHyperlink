package com.example.demo.utils;

public class LoginResponse {
    private static final long serialVersionUID = 1857935915480495789L;
    private Long userId;
    private String email;
    private String token;
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LoginResponse(Long userId, String email, String token, String userName) {
        this.userId = userId;
        this.email = email;
        this.token = token;
        this.userName = userName;
    }
}
