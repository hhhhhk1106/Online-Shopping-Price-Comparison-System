package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;
import com.example.backend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("/api/merchant_all")
    @CrossOrigin
    public List<Merchant> getMerchantsAll() {
        return merchantService.getAllMerchants();
    }

    @RequestMapping("/api/merchant_delete_by_id")
    @CrossOrigin
    public int deleteMerchantInfoByID(@RequestParam(value = "id")Integer id) {
        return merchantService.deleteByID(id);
    }

    @RequestMapping("/api/merchant_update")
    @CrossOrigin
    public Result updateMerchant(@RequestBody Merchant merchant){
        return merchantService.updateMerchant(merchant);
    }
}