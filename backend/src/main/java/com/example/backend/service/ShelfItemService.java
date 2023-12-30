package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.ShelfItem;

import java.util.List;

public interface ShelfItemService {
    List<Object> searchByKeyword(String keyword);
    List<Object> searchByID(Integer id);
    List<Object> searchByMerchantID(Integer id);
    List<Object> getAllShelfItems();

    Result addShelfItem(ShelfItem shelfItem);

    Result updateShelfItem(ShelfItem shelfItem);


}
