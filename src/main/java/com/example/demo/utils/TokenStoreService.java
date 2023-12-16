package com.example.demo.utils;

public interface TokenStoreService {
    AccessTokenModel readAccessToken(String accessToken);

    boolean isTokenExist(String accessToken);
    void removeToken(String accessToken);
    LoginResponse generateAccessToken(AccessTokenModel accessTokenModel);
}
