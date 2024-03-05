package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Item;
import com.example.backend.entity.Platform;
import com.example.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/api/item_info_by_id")
    @CrossOrigin
    public Item getItemInfoByID(@RequestParam(value = "id")Integer id) {
        return itemService.searchByID(id);
    }

    @RequestMapping("/api/item_register")
    @CrossOrigin
    public Result addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @RequestMapping("/api/item_delete_by_id")
    @CrossOrigin
    public int deleteItemInfoByID(@RequestParam(value = "id")Integer id) {
        return itemService.deleteByID(id);
    }

    @RequestMapping("/api/item_update")
    @CrossOrigin
    public Result updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }
}