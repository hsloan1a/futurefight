package com.futurefight.characters.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "marvel_character")
public class MarvelCharacter {

    @Id
    private Integer id;

    @Column(name = "character_name", unique = true)
    private String name;

    private Affinity affinity;

    private String gender;

    private String side;

    public MarvelCharacter() {
    }


    public MarvelCharacter(Integer id, String name, Affinity affinity, String gender, String side) {
        this.affinity = affinity;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.side = side;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
