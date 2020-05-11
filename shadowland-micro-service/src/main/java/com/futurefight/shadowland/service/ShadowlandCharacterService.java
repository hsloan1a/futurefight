package com.futurefight.shadowland.service;

import com.futurefight.shadowland.model.ShadowlandCharacter;
import com.futurefight.shadowland.proxy.CharacterProxy;
import com.futurefight.shadowland.repository.ShadowlandCharacterRepository;
import com.futurefight.shadowland.repository.ShadowlandLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShadowlandCharacterService {

    private final ShadowlandCharacterRepository shadowlandCharacterRepository;
    private final ShadowlandLevelRepository shadowlandLevelRepository;
    private final CharacterProxy characterProxy;

    @Autowired
    ShadowlandCharacterService(CharacterProxy characterProxy,
                               ShadowlandCharacterRepository shadowlandCharacterRepository,
                               ShadowlandLevelRepository shadowlandLevelRepository){
        this.shadowlandCharacterRepository = shadowlandCharacterRepository;
        this.shadowlandLevelRepository = shadowlandLevelRepository;
        this.characterProxy = characterProxy;
    }

    public List<ShadowlandCharacter> getShadowlandCharacters() {
        List<ShadowlandCharacter> shadowlandCharacters = shadowlandCharacterRepository.findAll();
        for (ShadowlandCharacter shadowlandCharacter : shadowlandCharacters){
            EntityModel<ShadowlandCharacter> pullFromCharacterService = characterProxy.getCharacter(shadowlandCharacter.getCharacter_id());
            if (pullFromCharacterService != null) {
                shadowlandCharacter.copyFromCharacterProxy(pullFromCharacterService.getContent());
            }
        }
        return shadowlandCharacters;
    }
}
