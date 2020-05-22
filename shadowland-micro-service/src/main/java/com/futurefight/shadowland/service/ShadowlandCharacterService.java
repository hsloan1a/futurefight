package com.futurefight.shadowland.service;

import com.futurefight.shadowland.converter.StringToCharacterConverter;
import com.futurefight.shadowland.model.ShadowlandCharacter;
import com.futurefight.shadowland.proxy.CharacterProxy;
import com.futurefight.shadowland.repository.ShadowlandCharacterRepository;
import com.futurefight.shadowland.repository.ShadowlandLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
            EntityModel<ShadowlandCharacter> pullFromCharacterService = characterProxy.getCharacter(shadowlandCharacter.getCharacterId());
            if (pullFromCharacterService != null) {
                shadowlandCharacter.copyFromCharacterProxy(pullFromCharacterService.getContent());
            }
        }
        return shadowlandCharacters;
    }

    public ShadowlandCharacter getShadowlandCharacter(Integer characterId){
        ShadowlandCharacter foundCharacter = shadowlandCharacterRepository.findByCharacterId(characterId);
        if (foundCharacter == null){
            EntityModel<ShadowlandCharacter> pullFromCharacterService = characterProxy.getCharacter(characterId);
            if (pullFromCharacterService != null) {
                ShadowlandCharacter shadowlandCharacter = new ShadowlandCharacter();
                shadowlandCharacter.copyFromCharacterProxy(pullFromCharacterService.getContent());
                foundCharacter = shadowlandCharacterRepository.save(shadowlandCharacter);
            }
        }
        else {
            EntityModel<ShadowlandCharacter> pullFromCharacterService = characterProxy.getCharacter(characterId);
            if (pullFromCharacterService != null) {
                foundCharacter.copyFromCharacterProxy(pullFromCharacterService.getContent());
            }

        }

        return foundCharacter;
    }

    public void createCharacters(String winning_characters) {
//        StringToCharacterConverter stringToCharacterConverter = new StringToCharacterConverter();
//        for (ShadowlandCharacter shadowlandCharacter : stringToCharacterConverter.convert(winning_characters)){
//
//            if (shadowlandCharacterRepository.findByCharacterId(shadowlandCharacter.getCharacterId()) == null) {
//                EntityModel<ShadowlandCharacter> pullFromCharacterService = characterProxy.getCharacter(shadowlandCharacter.getCharacterId());
//                if (pullFromCharacterService != null) {
//                    shadowlandCharacter.copyFromCharacterProxy(pullFromCharacterService.getContent());
//                    shadowlandCharacterRepository.save(shadowlandCharacter);
//                }
//            }
//        }

    }
}
