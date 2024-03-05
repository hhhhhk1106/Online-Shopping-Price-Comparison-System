package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Message;
import com.example.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/api/message_info_by_user")
    @CrossOrigin
    public List<Message> getMessageInfoByUserID(@RequestParam(value = "user_id")Integer user_id) {
        return messageService.searchByuser(user_id);
    }

    @RequestMapping("/api/message_delete_by_id")
    @CrossOrigin
    public int deleteMessageInfoByID(@RequestParam(value = "id")Integer id) {
        return messageService.deleteMessage(id);
    }
}