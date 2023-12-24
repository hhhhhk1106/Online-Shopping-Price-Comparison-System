package com.example.backend.service;

import com.example.backend.mapper.ShelfItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfItemServiceImpl implements ShelfItemService{
    @Autowired
    private ShelfItemMapper shelfItemMapper;
    @Override
    public List<Object> searchByKeyword(String keyword) {
        return shelfItemMapper.selectShelfItemInfoByKeyword(keyword);
    }
}
