package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Star;

import java.util.List;
import java.util.Map;

public interface StarService {
    //用户查看自己的收藏
    List<Star> searchByuser(Integer userid);
    //用户新收藏一个商品
    Result addStar(Star star);
    //用户取消一个收藏
    int deleteStar(Integer id);
}