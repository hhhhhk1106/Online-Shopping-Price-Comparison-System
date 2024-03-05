package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Message;
import com.example.backend.entity.Price;

import java.util.List;
import java.util.Map;

public interface MessageService {
    //用户查看消息列表
    List<Message> searchByuser(Integer userid);
    //用户删除消息
    int deleteMessage(Integer id);
}