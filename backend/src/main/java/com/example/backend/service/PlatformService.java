package com.example.backend.service;

import com.example.backend.Result;
import com.example.backend.entity.Platform;

import java.util.List;

public interface PlatformService {
    List<Platform> getAllPlatforms();

    Platform searchByID(Integer id);

    Result addPlatform(Platform platform);

    int deleteByID(Integer id);

    Result updatePlatform(Platform platform);
}
