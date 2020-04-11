package com.futurefight.characters.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "marvel_character")
public class MarvelCharacter {

    @Id
    private ObjectId id;

    @Column(name = "character_name", unique = true)
    private String name;

    @Enumerated
    private Affinity affinity;

    public MarvelCharacter() {
    }


    public MarvelCharacter(ObjectId id, String name, Affinity affinity) {
        this.affinity = affinity;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Affinity getAffinity() {
        return affinity;
    }

    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }
}
