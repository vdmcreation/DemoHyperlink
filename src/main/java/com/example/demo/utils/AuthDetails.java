package com.example.demo.utils;

public class AuthDetails {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AuthDetails() {
    }

    public AuthDetails(Long userId) {
        this.userId = userId;
    }
}
