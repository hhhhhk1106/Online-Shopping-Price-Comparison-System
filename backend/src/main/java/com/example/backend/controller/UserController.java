package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/api/user_info_by_id")
    @CrossOrigin
    public User getUserInfoByID(@RequestParam(value = "id")Integer id) {
        return userService.searchByID(id);
    }

    @RequestMapping("/api/user_register")
    @CrossOrigin
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
