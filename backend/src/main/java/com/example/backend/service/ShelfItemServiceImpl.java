package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.ShelfItem;
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

    @Override
    public List<Object> searchByID(Integer id) {
        return shelfItemMapper.selectShelfItemInfoByID(id);
    }

    @Override
    public List<Object> searchByMerchantID(Integer id) {
        return shelfItemMapper.selectShelfItemInfoByMerchantID(id);
    }

    @Override
    public Result addShelfItem(ShelfItem shelfItem) {
        int num1 = shelfItemMapper.countShelfItems();
        shelfItemMapper.insertShelfItem(shelfItem);
        int num2 = shelfItemMapper.countShelfItems();

        System.out.println(num1);
        System.out.println(num2);
        if(num2 - num1 > 0) {
            return new Result(200, "", shelfItem);
        } else {
            return new Result(400,"已经在该平台发布该商品",shelfItem);
        }
    }
}
