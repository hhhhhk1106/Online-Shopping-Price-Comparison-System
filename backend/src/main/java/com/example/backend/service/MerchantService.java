package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant searchByID(int id);

    Result addMerchant(Merchant merchant);

    List<Merchant> getAllMerchants();

    int deleteByID(Integer id);

    Result updateMerchant(Merchant merchant);
}
