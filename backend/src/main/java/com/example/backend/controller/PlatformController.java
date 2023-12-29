package com.example.backend.controller;

import com.example.backend.entity.Platform;
import com.example.backend.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
