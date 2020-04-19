package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandCharacter;
import com.futurefight.shadowland.proxy.CharacterProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShadowlandController {

    private final CharacterProxy characterProxy;

    @Autowired
    ShadowlandController(CharacterProxy characterProxy) {
        this.characterProxy = characterProxy;
    }

    @RequestMapping("/")
    public String index() throws Exception {
        ResponseEntity<CollectionModel<EntityModel<ShadowlandCharacter>>> shadowlandCharacter = characterProxy.findAll();
        if (shadowlandCharacter.getStatusCode() != HttpStatus.OK)
            throw new Exception("place holder");
        shadowlandCharacter.getBody().getContent().toString();
        return shadowlandCharacter.getBody().getContent().toString();
    }

}
