package com.example.practice.service;

import com.example.practice.dto.UserDto;
import com.example.practice.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
    User findUserByName(String name);

    List<UserDto> findAllUsers();

    void addItemToCart(User currentUser, Long itemId);
}
