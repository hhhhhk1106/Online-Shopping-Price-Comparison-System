package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.User;

import java.util.List;

public interface UserService {
    User searchByID(int id);

    Result addUser(User user);

    List<User> getAllUsers();

    int deleteByID(Integer id);

    Result updateUser(User user);
}
