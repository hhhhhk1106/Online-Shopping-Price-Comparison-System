package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;
import com.example.backend.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService{
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public Merchant searchByID(int id) {
        return merchantMapper.selectById(id);
    }

    @Override
    public Result addMerchant(Merchant merchant) {
        merchantMapper.insert(merchant);
        return new Result(200, "", merchant);
    }
}
