package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandLevel;
import com.futurefight.shadowland.service.ShadowlandLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<Object> addShadowlandLevel(@Valid @RequestBody ShadowlandLevel shadowlandLevel){
        ShadowlandLevel addedLevel = shadowlandLevelService.addLevel(shadowlandLevel);
        return new ResponseEntity<>(addedLevel, HttpStatus.CREATED);
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
