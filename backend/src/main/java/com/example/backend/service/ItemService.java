package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item searchByID(Integer id);

    Result addItem(Item item);

    int deleteByID(Integer id);

    Result updateItem(Item item);
}
