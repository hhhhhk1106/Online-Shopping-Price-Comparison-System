package com.example.backend;

import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("插入user")
    void insertUsers() {
        User user = new User("a",18,"m","12345");
        Integer i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    @DisplayName("打印user表条目数")
    void showUserSize() {
        List<User> userList= userMapper.selectList(null);
        System.out.println(userList.size());
    }

}
