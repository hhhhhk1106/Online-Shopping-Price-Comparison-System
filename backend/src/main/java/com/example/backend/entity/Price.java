package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

import java.util.Date;

@Getter
@TableName(value = "price")
public class Price {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer shelfItem_id;//上架商品id
    private Float price;
    private Date timestamp;

    public Price(Integer shelfItem_id, Float price, Date timestamp) {
        this.shelfItem_id=shelfItem_id;
        this.price=price;
        this.timestamp=timestamp;
    }
    public void setPrice(Float price){this.price=price;}
    public void setTimestamp(Date timestamp){this.timestamp=timestamp;}

}
