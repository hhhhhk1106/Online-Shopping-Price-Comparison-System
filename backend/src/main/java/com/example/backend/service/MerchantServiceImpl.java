package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;
import com.example.backend.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantMapper.selectMerchantsAll();
    }

    @Override
    public int deleteByID(Integer id) {
        return merchantMapper.deleteById(id);
    }

    @Override
    public Result updateMerchant(Merchant merchant) {
        int line = merchantMapper.updateById(merchant);
        if(line > 0) {
            return new Result(200, "", merchant);
        } else {
            return new Result(400,"更新失败",merchant);
        }
    }
}
