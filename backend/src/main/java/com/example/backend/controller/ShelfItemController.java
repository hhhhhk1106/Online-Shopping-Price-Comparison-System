package com.example.backend.controller;

import com.example.backend.service.ShelfItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShelfItemController {
    @Autowired
    private ShelfItemService shelfItemService;

    @RequestMapping("/api/shelf_item_info_by_keyword")
    @CrossOrigin
    public List<Object> getShelfItemsByKeyword(@RequestParam(value = "keyword") String keyword) {
        return shelfItemService.searchByKeyword(keyword);
    }
}
