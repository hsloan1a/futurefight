package com.futurefight.shadowland.service;

import com.futurefight.shadowland.model.FloorType;
import com.futurefight.shadowland.repository.ShadowlandCharacterRepository;
import com.futurefight.shadowland.repository.ShadowlandLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShadowlandService {

    private final ShadowlandCharacterRepository shadowlandCharacterRepository;
    private final ShadowlandLevelRepository shadowlandLevelRepository;

    @Autowired
    ShadowlandService(ShadowlandCharacterRepository shadowlandCharacterRepository,
                      ShadowlandLevelRepository shadowlandLevelRepository){
        this.shadowlandCharacterRepository = shadowlandCharacterRepository;
        this.shadowlandLevelRepository = shadowlandLevelRepository;
    }

    public void AddLevel(Integer level, FloorType floorType){

    }
}
