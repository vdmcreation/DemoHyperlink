package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public abstract class AbstractTokenStore implements TokenStoreService {
    private String secret = "videsh";
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "created";
    private static final String AUDIENCE_WEB = "web";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_EXP_DATE = "expdate";
    protected Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        if (expiration != null) {
            return expiration.before(new Date());
        } else {
            removeToken(token);
            return true;
        }
    }
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = new Date((long) claims.get(CLAIM_EXP_DATE));
            if (new Date().after(expiration)) {
                expiration = null;
            }
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
