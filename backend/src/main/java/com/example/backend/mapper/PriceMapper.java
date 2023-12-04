package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Price;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PriceMapper extends BaseMapper<Price> {
    IPage<Price> selectPricePage(Page<Price> page);
    List<Price> selectPricePageByID(Integer id);
    List<Price> selectPricePageByShelfItemID(Integer shelfItem_id);
}
