package com.example.backend.service;

import com.example.backend.Result;
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

    @Override
    public Platform searchByID(Integer id) {
        return platformMapper.selectById(id);
    }

    @Override
    public Result addPlatform(Platform platform) {
        platformMapper.insert(platform);
        return new Result(200, "", platform);
    }

    @Override
    public int deleteByID(Integer id) {
        return platformMapper.deleteById(id);
    }

    @Override
    public Result updatePlatform(Platform platform) {
        int line = platformMapper.updateById(platform);
        if(line > 0) {
            return new Result(200, "", platform);
        } else {
            return new Result(400,"更新失败",platform);
        }
    }
}
