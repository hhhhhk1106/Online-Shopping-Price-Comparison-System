package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.ShelfItem;
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

    @RequestMapping("/api/shelf_item_info_by_id")
    @CrossOrigin
    public List<Object> getShelfItemsByID(@RequestParam(value = "id") Integer id) {
        return shelfItemService.searchByID(id);
    }

    @RequestMapping("/api/shelf_item_info_by_merchant_id")
    @CrossOrigin
    public List<Object> getShelfItemsByMerchantID(@RequestParam(value = "id") Integer id) {
        return shelfItemService.searchByMerchantID(id);
    }

    @RequestMapping("/api/shelf_item_all")
    @CrossOrigin
    public List<Object> getShelfItemsAll() {
        return shelfItemService.getAllShelfItems();
    }

    @RequestMapping("/api/shelf_item_register")
    @CrossOrigin
    public Result addShelfItem(@RequestBody ShelfItem shelfItem){
        return shelfItemService.addShelfItem(shelfItem);
    }

    @RequestMapping("/api/shelf_item_update")
    @CrossOrigin
    public Result updateShelfItem(@RequestBody ShelfItem shelfItem){
        return shelfItemService.updateShelfItem(shelfItem);
    }
}