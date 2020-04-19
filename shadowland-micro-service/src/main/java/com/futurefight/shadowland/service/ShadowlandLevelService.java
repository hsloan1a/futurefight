package com.futurefight.shadowland.service;

import com.futurefight.shadowland.model.ShadowlandLevel;
import com.futurefight.shadowland.repository.ShadowlandLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShadowlandLevelService {

    @Autowired
    private ShadowlandLevelRepository shadowlandLevelRepository;


    public ShadowlandLevel addLevel(ShadowlandLevel shadowlandLevel) {return shadowlandLevelRepository.save(shadowlandLevel);}
}
