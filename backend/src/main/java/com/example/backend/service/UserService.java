package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.User;

public interface UserService {
    User searchByID(int id);

    Result addUser(User user);
}
