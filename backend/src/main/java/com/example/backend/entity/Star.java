package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

@Getter
@TableName(value = "star")
public class Star {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer item_id;
    private Integer shelf_item_id;
    private Float floor_price;


    public Star(Integer user_id, Integer item_id, Integer shelf_item_id, Float floor_price) {
        this.user_id=user_id;
        this.item_id=item_id;
        this.shelf_item_id=shelf_item_id;
        this.floor_price=floor_price;
    }
    public Star() {}

    public void setItem_id(Integer item_id){this.item_id=item_id;}
    public void setUser_id(Integer user_id){this.user_id=user_id;}
    public void setShelf_item_id(Integer shelf_item_id){this.shelf_item_id=shelf_item_id;}
    public void setFloor_price(Float floor_price){this.floor_price=floor_price;}
}
