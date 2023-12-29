package com.example.backend.controller;

import com.example.backend.entity.Item;
import com.example.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/api/get_all_items")
    @CrossOrigin
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
