package com.futurefight.characters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarvelCharacterNotFound extends RuntimeException {
    public MarvelCharacterNotFound(String s) {
        super(s);
    }

}
