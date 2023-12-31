package com.example.backend.service;

import com.example.backend.Result;
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

    @Override
    public Item searchByID(Integer id) {
        return itemMapper.selectById(id);
    }

    @Override
    public Result addItem(Item item) {
        itemMapper.insert(item);
        return new Result(200, "", item);
    }

    @Override
    public int deleteByID(Integer id) {
        return itemMapper.deleteById(id);
    }

    @Override
    public Result updateItem(Item item) {
        int line = itemMapper.updateById(item);
        if(line > 0) {
            return new Result(200, "", item);
        } else {
            return new Result(400,"更新失败",item);
        }
    }
}
