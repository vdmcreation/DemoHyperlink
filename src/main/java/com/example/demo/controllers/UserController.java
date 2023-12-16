package com.example.demo.controllers;

import com.example.demo.interfaces.UserService;
import com.example.demo.utils.AccessTokenModel;
import com.example.demo.utils.LoginRequest;
import com.example.demo.utils.LoginResponse;
import com.example.demo.utils.TokenStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/u")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    TokenStoreService tokenStoreService;

    @PostMapping(value = "/logIn")
    public LoginResponse logIn(@RequestBody LoginRequest logInRequest) {
        try {
            AccessTokenModel accessTokenModel = this.userService.getUserDetailForLogin(logInRequest);
            LoginResponse value = tokenStoreService.generateAccessToken(accessTokenModel);
            userService.saveUserToken(value.getUserId(), value.getToken());
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
