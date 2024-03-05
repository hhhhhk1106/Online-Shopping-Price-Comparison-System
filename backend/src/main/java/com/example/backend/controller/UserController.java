package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/api/user_info_by_id")
    @CrossOrigin
    public User getUserInfoByID(@RequestParam(value = "id")Integer id) {
        return userService.searchByID(id);
    }

    @RequestMapping("/api/user_all")
    @CrossOrigin
    public List<User> getUsersAll() {
        return userService.getAllUsers();
    }

    @RequestMapping("/api/user_register")
    @CrossOrigin
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping("/api/user_delete_by_id")
    @CrossOrigin
    public int deleteUserInfoByID(@RequestParam(value = "id")Integer id) {
        return userService.deleteByID(id);
    }

    @RequestMapping("/api/user_update")
    @CrossOrigin
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}