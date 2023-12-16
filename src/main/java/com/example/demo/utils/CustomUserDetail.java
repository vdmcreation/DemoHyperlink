package com.example.demo.utils;

import com.example.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class CustomUserDetail extends org.springframework.security.core.userdetails.User{
    private static final long serialVersionUID = 462614302129845955L;

    private User user;
    public CustomUserDetail(String username, String password, boolean enabled, boolean accountNonExpired,
                            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
                            User user) {
        super(username, StringUtils.hasText(password) ? password : "NOPASSWORD", enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }
    public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
                            User user) {
        super(username, password, true, true, true, true, authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
