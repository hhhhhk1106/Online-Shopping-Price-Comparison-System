package com.example.backend.service;

import java.util.List;

public interface ShelfItemService {
    List<Object> searchByKeyword(String keyword);
}
