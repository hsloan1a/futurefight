package com.futurefight.shadowland.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.futurefight.shadowland.model.ShadowlandCharacter;

import java.util.List;

public class CharacterToStringConverter extends StdConverter<List<ShadowlandCharacter>, String> {

    @Override
    public String convert(List<ShadowlandCharacter> shadowlandCharacters) {
        String returnString = "";
        for (ShadowlandCharacter shadowlandCharacter : shadowlandCharacters){
            if (returnString == ""){
                returnString += shadowlandCharacter.getCharacterId().toString();

            }
            else{
                returnString += ";" + shadowlandCharacter.getCharacterId().toString();
            }
        }
        returnString += ";";
        return returnString;
    }
}
