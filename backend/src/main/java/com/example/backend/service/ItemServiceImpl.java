package com.example.backend.service;

import com.example.backend.entity.Item;
import com.example.backend.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Item> getAllItems() {
        return itemMapper.selectAllItems();
    }
}
