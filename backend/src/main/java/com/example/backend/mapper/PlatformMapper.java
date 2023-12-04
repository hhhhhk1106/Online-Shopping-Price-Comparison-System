package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Platform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlatformMapper extends BaseMapper<Platform> {
    IPage<Platform> selectPlatformPage(Page<Platform> page);
    List<Platform> selectPlatformPageByID(Integer id);
    List<Platform> selectPlatformPageByName(String name);
}
