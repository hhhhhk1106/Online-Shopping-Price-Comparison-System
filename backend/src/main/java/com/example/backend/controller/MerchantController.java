package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;
import com.example.backend.entity.User;
import com.example.backend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/api/merchant_info_by_id")
    @CrossOrigin
    public Merchant getMerchantInfoByID(@RequestParam(value = "id")Integer id) {
        return merchantService.searchByID(id);
    }

    @RequestMapping("/api/merchant_register")
    @CrossOrigin
    public Result addMerchant(@RequestBody Merchant merchant){
        return merchantService.addMerchant(merchant);
    }
}
