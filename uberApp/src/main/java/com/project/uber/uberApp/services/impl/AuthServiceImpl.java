package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.SignUpDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignUpDto signUpDTO) {
        return null;
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
