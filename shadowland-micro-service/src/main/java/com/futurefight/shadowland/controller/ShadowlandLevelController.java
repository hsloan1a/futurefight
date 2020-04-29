package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandLevel;
import com.futurefight.shadowland.service.ShadowlandLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/")
    public List<ShadowlandLevel> getAllShadowlandLevels() {
        return shadowlandLevelService.getAllLevels();
    }

    @DeleteMapping("/{id}")
    public void deleteShadowlandLevelById(@PathVariable Long id){
        shadowlandLevelService.deleteLevelById(id);
    }
}
