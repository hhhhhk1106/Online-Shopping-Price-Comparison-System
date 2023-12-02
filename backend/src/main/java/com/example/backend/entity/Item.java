package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

@Getter
@TableName(value = "item")
public class Item {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String category;

    public Item(String name, String category) {
        this.name = name;
        this.category = category;
    }
    public Item() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
