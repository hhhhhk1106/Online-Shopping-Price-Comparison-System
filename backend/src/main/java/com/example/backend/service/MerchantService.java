package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Merchant;

public interface MerchantService {
    Merchant searchByID(int id);

    Result addMerchant(Merchant merchant);
}
