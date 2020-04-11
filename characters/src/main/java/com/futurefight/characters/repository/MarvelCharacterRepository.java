package com.futurefight.characters.repository;

import com.futurefight.characters.model.MarvelCharacter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarvelCharacterRepository  extends MongoRepository<MarvelCharacter, ObjectId> {
}
