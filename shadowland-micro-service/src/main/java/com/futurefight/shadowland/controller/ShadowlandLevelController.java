package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandLevel;
import com.futurefight.shadowland.service.ShadowlandLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/level/")
public class ShadowlandLevelController {

    private final ShadowlandLevelService shadowlandLevelService;

    @Autowired
    public ShadowlandLevelController(ShadowlandLevelService shadowlandLevelService){
        this.shadowlandLevelService = shadowlandLevelService;
    }

    @PostMapping("/")
    public ShadowlandLevel addShadowlandLevel(@Valid @RequestBody ShadowlandLevel shadowlandLevel){
        return shadowlandLevelService.addLevel(shadowlandLevel);
    }
}
