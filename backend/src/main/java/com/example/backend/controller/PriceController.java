package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Price;
import com.example.backend.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping("/api/price_info_by_id")
    @CrossOrigin
    public Price getPriceInfoByID(@RequestParam(value = "id")Integer id) {
        return priceService.searchByID(id);
    }

    @RequestMapping("/api/price_insert")
    @CrossOrigin
    public Result addPrice(@RequestBody Price price){
        return priceService.addPrice(price);
    }

    @RequestMapping("/api/price_search_by_shelfItem_id")
    @CrossOrigin
    public List<Price> getPriceInfoByShelfItem(@RequestParam(value = "shelfItem_id")Integer shelfItem_id) {
        return priceService.getItemPrice(shelfItem_id);
    }

    @RequestMapping("/api/price_delete_by_id")
    @CrossOrigin
    public int deletePriceByID(@RequestParam(value = "id")Integer id) {
        return priceService.deleteByID(id);
    }

    @RequestMapping("/api/price_update")
    @CrossOrigin
    public Result updatePrice(@RequestBody Price price){
        return priceService.updatePrice(price);
    }

    @RequestMapping("/api/price_period_change")
    @CrossOrigin
    public List<Object> searchPriceChange(
            @RequestParam(value = "shelfItem_id")Integer shelfItem_id,
            @RequestParam(value = "startTime")Date startTime,
            @RequestParam(value = "endTime")Date endTime,
            @RequestParam(value = "highLight")Boolean highLight){
        if(!highLight)
            return priceService.PriceChanges(shelfItem_id,startTime,endTime);
        else {
            List<Object> priceChanges = priceService.PriceChanges(shelfItem_id, startTime, endTime);
            Float minPrice = Float.MAX_VALUE;
            for (Object obj : priceChanges) {
                if (obj instanceof Price) {
                    Price priceObject = (Price) obj;
                    Float price = priceObject.getPrice();

                    if (price != null && price < minPrice) {
                        minPrice = price;
                    }
                }
            }
            priceChanges.add(0,minPrice);
            return priceChanges;
        }
    }
}