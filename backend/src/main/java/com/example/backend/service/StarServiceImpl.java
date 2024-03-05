package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Star;
import com.example.backend.mapper.StarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StarServiceImpl implements StarService{
    @Autowired
    private StarMapper starMapper;
    @Override
    public List<Star> searchByuser(Integer userid) {
        return starMapper.selectStarPageByUserID(userid);
    }

    @Override
    public Result addStar(Star star) {
        starMapper.insert(star);
        return new Result(200, "", star);
    }

    @Override
    public int deleteStar(Integer id){
        return starMapper.deleteById(id);
    }
}
