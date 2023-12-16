package com.example.demo.services;

import com.example.demo.interfaces.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.AccessTokenModel;
import com.example.demo.utils.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccessTokenModel getUserDetailForLogin(LoginRequest loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (this.passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new AccessTokenModel(loginDto.getEmail(), loginDto.getPassword(), user);
        }
        return null;
    }

    @Override
    public void saveUserToken(Long userId, String token) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent())
        {
            User user = userOpt.get();
            user.setToken(token);
            userRepository.save(user);
        }

    }
}
