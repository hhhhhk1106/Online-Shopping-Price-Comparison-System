package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

@Getter
@TableName(value = "price")
public class Price {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer shelfItem_id;//上架商品id
    private Integer item_id;
    private Integer merchant_id;
    private Integer platform_id;
    private Float price;
    private Long timestamp;

    public Price(Integer shelfItem_id,Integer item_id, Integer merchant_id, Integer platform_id, Float price, Long timestamp) {
        this.shelfItem_id=shelfItem_id;
        this.item_id=item_id;
        this.merchant_id=merchant_id;
        this.platform_id=platform_id;
        this.price=price;
        this.timestamp=timestamp;
    }
    public Price() {}

    public void setItem_id(Integer item_id){this.item_id=item_id;}
    public void setMerchant_id(Integer merchant_id){this.merchant_id=merchant_id;}
    public void setPlatform_id(Integer platform_id){this.platform_id=platform_id;}
    public void setPrice(Float price){this.price=price;}
    public void setTimestamp(Long timestamp){this.timestamp=timestamp;}

}
