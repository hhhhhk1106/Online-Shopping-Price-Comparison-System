package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

@Getter
@TableName(value = "platform")
public class Platform {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;

    public Platform(String name) {
        this.name = name;
    }
    public Platform() {}

    public void setName(String name) {
        this.name = name;
    }
}
