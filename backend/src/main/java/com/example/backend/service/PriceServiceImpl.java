package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Price;
import com.example.backend.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    private PriceMapper priceMapper;
    @Override
    public Price searchByID(Integer id) {
        return priceMapper.selectPricePageByID(id);
    }

    @Override
    public List<Price> getItemPrice(Integer shelfItem_id) {
        return priceMapper.selectPricePageByShelfItemID(shelfItem_id);
    }

    @Override
    public int deleteByID(Integer id) {
        return priceMapper.deleteById(id);
    }

    @Override
    public Result updatePrice(Price price) {
        int line = priceMapper.updateById(price);
        if(line > 0) {
            return new Result(200, "", price);
        } else {
            return new Result(400,"更新失败",price);
        }
    }

    @Override
    public Result addPrice(Price price){
        priceMapper.insert(price);
        return new Result(200, "", price);
    }

    @Override
    public List<Object> PriceChanges(Integer shelfItem_id, Date startTime, Date endTime) {
        return priceMapper.findPriceChanges(shelfItem_id, startTime, endTime);
    }
}
