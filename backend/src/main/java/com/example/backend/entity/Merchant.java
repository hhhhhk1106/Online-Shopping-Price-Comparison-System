package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

@Getter
@TableName(value = "merchant")
public class Merchant {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String address;

    public Merchant(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Merchant() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
