package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandLevel;
import com.futurefight.shadowland.model.ShadowlandLevelWinDetail;
import com.futurefight.shadowland.service.LevelWinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelWinDetailController {

    private final LevelWinDetailService levelWinDetailService;

    @Autowired
    LevelWinDetailController(LevelWinDetailService levelWinDetailService){
        this.levelWinDetailService = levelWinDetailService;
    }

    @PostMapping("/level/{levelId}/win_detail")
    public ResponseEntity<Object> addShadowlandLevelWinDetail(@PathVariable Long levelId, @RequestBody ShadowlandLevelWinDetail shadowlandLevel){
        ShadowlandLevelWinDetail addedLevel = levelWinDetailService.addLevel(shadowlandLevel);
        return new ResponseEntity<>(addedLevel, HttpStatus.CREATED);
    }


}
