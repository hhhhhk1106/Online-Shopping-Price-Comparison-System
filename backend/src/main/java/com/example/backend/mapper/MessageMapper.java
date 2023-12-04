package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    IPage<Message> selectMessagePage(Page<Message> page);
    List<Message> selectMessagePageByID(Integer id);
    List<Message> selectMessagePageByUserID(Integer user_id);
    int countMessagePageByUserID(Integer user_id);
}
