package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Merchant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantMapper extends BaseMapper<Merchant> {
    IPage<Merchant> selectMerchantPage(Page<Merchant> page);

    List<Merchant> selectMerchantsAll();
}
