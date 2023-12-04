package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Star;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StarMapper extends BaseMapper<Star> {
    IPage<Star> selectStarPage(Page<Star> page);
    List<Star> selectStarPageByID(Integer id);
    List<Star> selectStarPageByUserID(Integer user_id);
    int countStarPageByShelfItemID(Integer shelf_item_id);
}
