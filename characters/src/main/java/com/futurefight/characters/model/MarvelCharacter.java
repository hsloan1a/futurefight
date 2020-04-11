package com.futurefight.characters.model;


import javax.persistence.*;

@Entity(name = "marvel_character")
public class MarvelCharacter {

    @Id
    private Integer id;

    @Column(name = "character_name", unique = true)
    private String name;

    private Affinity affinity;

    public MarvelCharacter() {
    }


    public MarvelCharacter(Integer id, String name, Affinity affinity) {
        this.affinity = affinity;
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
