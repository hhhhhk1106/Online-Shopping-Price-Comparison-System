package com.example.backend;

import com.example.backend.entity.Merchant;
import com.example.backend.entity.ShelfItem;
import com.example.backend.entity.User;
import com.example.backend.mapper.MerchantMapper;
import com.example.backend.mapper.ShelfItemMapper;
import com.example.backend.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    @DisplayName("插入user")
    void insertUsers() {
        User user = new User("a",18,"m","12345");
        Integer i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    @DisplayName("打印user表条目数")
    void showUserSize() {
        List<User> userList= userMapper.selectList(null);
        System.out.println(userList.size());
    }

    @Test
    @DisplayName("根据id查找user")
    public void testSelectUserById(){
        User user=userMapper.selectById(1);
        String name = user.getName();
        System.out.println(name);
        assertEquals("admin", name);
    }

    @Test
    @DisplayName("插入上架商品")
    void insertShelfItem() {
        ShelfItem shelfItem = new ShelfItem(1,1,1,"item-test",null,null,null);
        Integer i = shelfItemMapper.insert(shelfItem);
        System.out.println(i);
    }

    @Test
    @DisplayName("根据id查找具体商品信息")
    public void testSelectShelfItemById(){
        // TODO: 多表查询？
        ShelfItem shelfItem = shelfItemMapper.selectById(1);
        String name = shelfItem.getName();
        Integer merchant_id = shelfItem.getMerchant_id();
        Merchant merchant = merchantMapper.selectById(merchant_id);
        System.out.println(name +" "+ merchant.getName());
    }
    @Test
    @DisplayName("根据关键词查找商品列表")
    public void testSelectShelfItemsByKeyword(){
        List<ShelfItem> shelfItems = shelfItemMapper.selectShelfItemPageByKeyword("test");
        for(ShelfItem s : shelfItems) {
            System.out.println(s.getId() +" "+ s.getName());
        }
    }

    @Test
    @DisplayName("根据商户id查找拥有的所有商品列表")
    public void testSelectShelfItemsByMerchant(){
        List<ShelfItem> shelfItems = shelfItemMapper.selectShelfItemPageByMerchantID(1);
        for(ShelfItem s : shelfItems) {
            System.out.println(s.getId() +" "+ s.getName());
        }
    }
}
