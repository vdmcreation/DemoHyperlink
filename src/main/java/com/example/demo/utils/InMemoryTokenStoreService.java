package com.example.demo.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTokenStoreService extends AbstractTokenStore implements TokenStoreService{
    private ConcurrentHashMap<String, Object> token = new ConcurrentHashMap<>();
    @Override
    public AccessTokenModel readAccessToken(String accessToken) {
        AccessTokenModel accessTokenModel = null;
        if (Boolean.TRUE.equals(validateToken(accessToken))) {
            accessTokenModel = (AccessTokenModel) this.token.get(accessToken);
        }
        return accessTokenModel;
    }
    public Boolean validateToken(String token) {
        return (isTokenExist(token) && !isTokenExpired(token));
    }
    @Override
    public boolean isTokenExist(String accessToken) {
        return this.token.containsKey(accessToken);
    }
    public void removeToken(String accessToken) {
        this.token.remove(accessToken);
    }
    public LoginResponse generateAccessToken(AccessTokenModel accessTokenModel) {
        String accessToken = generateToken(accessTokenModel.getUsername());
        if (null != accessToken) {
            this.token.put(accessToken, accessTokenModel);
            return new LoginResponse(accessTokenModel.getUser().getId(), accessTokenModel.getUser().getEmail(), accessToken, accessTokenModel.getUser().getUserName());
        }
        return null;
    }
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userName);
        claims.put(CLAIM_KEY_AUDIENCE, "web");
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims.toString());
    }
}
