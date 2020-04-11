package com.futurefight.characters.repository;

import com.futurefight.characters.model.MarvelCharacter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarvelCharacterRepository  extends JpaRepository<MarvelCharacter, Integer> {
}
