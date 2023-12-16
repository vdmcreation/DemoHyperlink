package com.example.demo.interfaces;

import com.example.demo.utils.AccessTokenModel;
import com.example.demo.utils.LoginRequest;

public interface UserService {
    AccessTokenModel getUserDetailForLogin(LoginRequest loginDto);

    void saveUserToken(Long userId, String token);
}
