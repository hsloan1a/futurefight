package com.futurefight.shadowland.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.futurefight.shadowland.model.ShadowlandCharacter;
import com.futurefight.shadowland.service.ShadowlandCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.ArrayList;
import java.util.List;

public class StringToCharacterConverter extends StdConverter<String, List<ShadowlandCharacter>> {

    @Autowired
    ShadowlandCharacterService shadowlandCharacterService;

    public StringToCharacterConverter() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    @Override
    public List<ShadowlandCharacter> convert(String stringOfCharacterIds) {
        List<ShadowlandCharacter> shadowlandCharacters = new ArrayList<>();
        if (stringOfCharacterIds == null)
            return null;
        for (String stingOfCharacterId : stringOfCharacterIds.split(";")){
            ShadowlandCharacter shadowlandCharacter = shadowlandCharacterService.getShadowlandCharacter(Integer.parseInt(stingOfCharacterId));
            shadowlandCharacters.add(shadowlandCharacter);
        }
        return shadowlandCharacters;
    }
}
