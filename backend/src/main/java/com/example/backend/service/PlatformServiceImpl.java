package com.example.backend.service;

import com.example.backend.entity.Platform;
import com.example.backend.mapper.PlatformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService{
    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public List<Platform> getAllPlatforms() {
        return platformMapper.selectAllPlatforms();
    }
}
