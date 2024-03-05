package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Price;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PriceService {
    Price searchByID(Integer id);//管理员操作
    List<Price> getItemPrice(Integer shelfItem_id);//管理员操作
    int deleteByID(Integer id);//管理员操作
    Result updatePrice(Price price);//管理员操作
    Result addPrice(Price price);

    List<Object> PriceChanges(Integer shelfItem_id, Date startTime, Date endTime);//用户操作
}