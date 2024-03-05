package com.example.backend;

import com.example.backend.entity.*;
import com.example.backend.mapper.*;
import com.example.backend.service.PriceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@MapperScan("com.example.backend.mapper")
class BackendApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    ShelfItemMapper shelfItemMapper;
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    PriceService priceService;
    @Autowired
    StarMapper starMapper;

    @Test
    @DisplayName("插入user")
    void insertUsers() {
        User user = new User("a",18,"m","12345");
        Integer i = userMapper.insert(user);
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    @DisplayName("调整价格")
    void insertPrice(){
        Price price1=new Price(6, (float) 9.66, new Date(2022-1900,0,1));
        Price price2=new Price(6, (float) 10.66, new Date(2023-1900,0,1));
        Price price3=new Price(6, (float) 11.66, new Date(2023-1900,1,1));
        Price price4=new Price(6, (float) 12.66, new Date(2023-1900,2,1));
        Price price5=new Price(6, (float) 8.66, new Date(2024-1900,0,1));
        Integer i=priceMapper.insert(price1);
        i=priceMapper.insert(price2);
        i=priceMapper.insert(price3);
        i=priceMapper.insert(price4);
        i=priceMapper.insert(price5);
    }

    @Test
    @DisplayName("查询一段时间的价格")
    void searchPrice(){
        Date startTime=new Date(2023-1900,0,1);
        Date endTime=new Date(2024-1900,0,1);
        List<Object> priceChanges=priceService.PriceChanges(6,startTime,endTime);
        //List<Map<Float,Date>> change=priceService.PriceChanges(6,startTime,endTime,true);
        Float minPrice = Float.MAX_VALUE;
        for (Object obj : priceChanges) {
            if (obj instanceof Price) {
                Price priceObject = (Price) obj;
                Float price = priceObject.getPrice();
                System.out.println(price);
                System.out.println(priceObject.getTimestamp());

                if (price != null && price < minPrice) {
                    minPrice = price;
                }
            }
        }
        System.out.println(minPrice);
    }

    @Test
    @DisplayName("收藏商品")
    void insertStar(){
        Star star=new Star(3,2,6,(float)10);
        Integer i=starMapper.insert(star);
    }
}