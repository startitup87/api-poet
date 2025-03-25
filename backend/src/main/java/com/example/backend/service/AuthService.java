package com.example.backend.service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.RegisterRequest;
import com.example.backend.dto.TokenResponse;
import com.example.backend.dto.UserResponse;

public interface AuthService {
    TokenResponse login(LoginRequest request);
    UserResponse register(RegisterRequest request);
    UserResponse getCurrentUser();
    TokenResponse refreshToken(String refreshToken);
}