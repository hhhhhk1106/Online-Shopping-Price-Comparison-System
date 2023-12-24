package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import java.util.Date;

@Getter
@TableName(value = "`shelf-item`")
public class ShelfItem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer item_id;
    private Integer merchant_id;
    private Integer platform_id;
    private String name;
    private String description;
    private String origin;  // 产地
    private Date production_date;

    private Platform platform;
    private Merchant merchant;

    public ShelfItem(Integer item_id, Integer merchant_id, Integer platform_id, String name, String description, String origin, Date production_date) {
        this.item_id = item_id;
        this.merchant_id = merchant_id;
        this.platform_id = platform_id;
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.production_date = production_date;
    }


    public ShelfItem() {}

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public void setMerchant_id(Integer merchant_id) {
        this.merchant_id = merchant_id;
    }

    public void setPlatform_id(Integer platform_id) {
        this.platform_id = platform_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }
}
