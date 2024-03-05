package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Star;
import com.example.backend.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarController {
    @Autowired
    private StarService starService;

    @RequestMapping("/api/star_addStar")
    @CrossOrigin
    public Result addStar(@RequestBody Star star) {
        return starService.addStar(star);
    }

    @RequestMapping("/api/star_by_user_id")
    @CrossOrigin
    public List<Star> getStarByUser(@RequestParam(value = "user_id")Integer user_id) {
        return starService.searchByuser(user_id);
    }

    @RequestMapping("/api/Star_delete_by_id")
    @CrossOrigin
    public int deleteStarInfoByID(@RequestParam(value = "id")Integer id) {
        return starService.deleteStar(id);
    }
}