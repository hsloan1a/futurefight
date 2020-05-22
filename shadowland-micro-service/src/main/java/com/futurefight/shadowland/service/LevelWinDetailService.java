package com.futurefight.shadowland.service;

import com.futurefight.shadowland.model.ShadowlandLevelWinDetail;
import com.futurefight.shadowland.repository.ShadowlandCharacterRepository;
import com.futurefight.shadowland.repository.ShadowlandLevelRepository;
import com.futurefight.shadowland.repository.ShadowlandLevelWinDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelWinDetailService {

    private final ShadowlandLevelRepository shadowlandLevelRepository;
    private final ShadowlandLevelWinDetailRepository shadowlandLevelWinDetailRepository;
    private final ShadowlandCharacterService shadowlandCharacterService;

    @Autowired
    LevelWinDetailService(ShadowlandLevelRepository shadowlandLevelRepository,
                          ShadowlandLevelWinDetailRepository shadowlandLevelWinDetailRepository,
                          ShadowlandCharacterService shadowlandCharacterService){
        this.shadowlandLevelRepository = shadowlandLevelRepository;
        this.shadowlandLevelWinDetailRepository = shadowlandLevelWinDetailRepository;
        this.shadowlandCharacterService = shadowlandCharacterService;
    }

    public ShadowlandLevelWinDetail addLevel(ShadowlandLevelWinDetail shadowlandLevelWinDetail) {
        //shadowlandCharacterService.createCharacters(shadowlandLevelWinDetail.getWinning_characters());
        return shadowlandLevelWinDetailRepository.save(shadowlandLevelWinDetail);
    }

}
