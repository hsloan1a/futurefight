package com.futurefight.shadowland.proxy;

import com.futurefight.shadowland.model.ShadowlandCharacter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-server") //using api gateway
@RibbonClient(name = "characters")
public interface CharacterProxy {

    @GetMapping("/characters/characters")
    public ResponseEntity<CollectionModel<EntityModel<ShadowlandCharacter>>> findAll();

    @GetMapping("/characters/character/{id}")
    public EntityModel<ShadowlandCharacter> getCharacter(@PathVariable("id") Integer id);

    }