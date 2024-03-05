package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Price;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface PriceMapper extends BaseMapper<Price> {
    IPage<Price> selectPricePage(Page<Price> page);
    Price selectPricePageByID(Integer id);
    List<Price> selectPricePageByShelfItemID(Integer shelfItem_id);

    //查询一段时间的结果趋势
    List<Object> findPriceChanges(@Param("shelfItem_id")Integer shelfItem_id, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}

