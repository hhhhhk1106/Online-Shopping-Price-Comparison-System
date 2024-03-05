package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

import java.util.Date;

@Getter
@TableName(value = "message")
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer shelf_item_id;
    private Integer merchant_id;
    private Integer platform_id;
    private Float now_price;
    private Date time;



    public Message(Integer user_id, Integer shelf_item_id, Integer merchant_id, Integer platform_id,Float now_price, Date time) {
        this.user_id=user_id;
        this.shelf_item_id=shelf_item_id;
        this.now_price=now_price;
        this.merchant_id=merchant_id;
        this.platform_id=platform_id;
        this.time=time;
    }
    public Message() {}

    public void setUser_id(Integer user_id){this.user_id=user_id;}
    public void setShelf_item_id(Integer shelf_item_id){this.shelf_item_id=shelf_item_id;}
    public void setNow_Price(Float now_price){this.now_price=now_price;}
    public void setMerchant_id(Integer merchant_id){this.merchant_id=merchant_id;}
    public void setPlatform_id(Integer platform_id){this.platform_id=platform_id;}
    public void setNow_price(Float now_price){this.now_price=now_price;}
    public void setTime(Date time){this.time=time;}
}
