package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectUsersAll();
    }

    @Override
    public int deleteByID(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Result updateUser(User user) {
        int line = userMapper.updateById(user);
        if(line > 0) {
            return new Result(200, "", user);
        } else {
            return new Result(400,"更新失败",user);
        }
    }
}
