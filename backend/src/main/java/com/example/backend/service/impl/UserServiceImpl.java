package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        // Implement fetching users from repository
        List<UserDTO> users = new ArrayList<>();
        return new PageImpl<>(users, pageable, 0);
    }

    @Override
    public UserDTO getUserById(Long id) {
        // Implement fetching user by ID
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setUsername("user" + id);
        user.setEmail("user" + id + "@example.com");
        return user;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Implement user creation
        userDTO.setId(1L);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Implement user update
        userDTO.setId(id);
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        // Implement user deletion
    }
}