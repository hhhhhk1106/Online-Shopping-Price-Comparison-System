package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Message;
import com.example.backend.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Message> searchByuser(Integer userid){
        return messageMapper.selectMessagePageByUserID(userid);
    }

    @Override
    public int deleteMessage(Integer id) {
        return messageMapper.deleteById(id);
    }
}
