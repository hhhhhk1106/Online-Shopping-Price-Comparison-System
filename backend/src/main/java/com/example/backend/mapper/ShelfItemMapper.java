package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.ShelfItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShelfItemMapper extends BaseMapper<ShelfItem> {
    IPage<ShelfItem> selectShelfItemPage(Page<ShelfItem> page);
    List<ShelfItem> selectShelfItemPageByKeyword(String keyword);
    List<ShelfItem> selectShelfItemPageByMerchantID(Integer merchant_id);
    List<Object> selectShelfItemInfoByKeyword(String keyword);
}
