package com.example.backend.controller;

import com.example.backend.Result;
import com.example.backend.entity.Platform;
import com.example.backend.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatformController {
    @Autowired
    private PlatformService platformService;

    @RequestMapping("/api/get_all_platforms")
    @CrossOrigin
    public List<Platform> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }

    @RequestMapping("/api/platform_info_by_id")
    @CrossOrigin
    public Platform getPlatformInfoByID(@RequestParam(value = "id")Integer id) {
        return platformService.searchByID(id);
    }

    @RequestMapping("/api/platform_register")
    @CrossOrigin
    public Result addPlatform(@RequestBody Platform platform){
        return platformService.addPlatform(platform);
    }

    @RequestMapping("/api/platform_delete_by_id")
    @CrossOrigin
    public int deletePlatformInfoByID(@RequestParam(value = "id")Integer id) {
        return platformService.deleteByID(id);
    }

    @RequestMapping("/api/platform_update")
    @CrossOrigin
    public Result updatePlatform(@RequestBody Platform platform){
        return platformService.updatePlatform(platform);
    }
}