package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User searchByID(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Result addUser(User user) {
        userMapper.insert(user);
        return new Result(200, "", user);
    }
}
