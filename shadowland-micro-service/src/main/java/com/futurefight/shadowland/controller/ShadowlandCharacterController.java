package com.futurefight.shadowland.controller;

import com.futurefight.shadowland.model.ShadowlandCharacter;
import com.futurefight.shadowland.proxy.CharacterProxy;
import com.futurefight.shadowland.service.ShadowlandCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/character/")
public class ShadowlandCharacterController {

    private final ShadowlandCharacterService shadowlandCharacterService;

    @Autowired
    ShadowlandCharacterController(ShadowlandCharacterService shadowlandCharacterService) {
        this.shadowlandCharacterService = shadowlandCharacterService;
    }

    @GetMapping("/")
    public List<ShadowlandCharacter> index() throws Exception {
        return shadowlandCharacterService.getShadowlandCharacters();
//        ResponseEntity<CollectionModel<EntityModel<ShadowlandCharacter>>> shadowlandCharacter = characterProxy.findAll();
//        if (shadowlandCharacter.getStatusCode() != HttpStatus.OK)
//            throw new Exception("place holder");
//        List<ShadowlandCharacter> removeHateaos = new ArrayList<>();
//        shadowlandCharacter.getBody().getContent().toString();
//        shadowlandCharacter.getBody().getContent().spliterator().forEachRemaining(s -> removeHateaos.add(s.getContent()));
//        return shadowlandCharacter.getBody().getContent().toString();
    }

}
