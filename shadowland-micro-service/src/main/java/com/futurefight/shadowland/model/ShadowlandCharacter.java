package com.futurefight.shadowland.model;

import javax.persistence.*;

@Entity
public class ShadowlandCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer character_id;

    @Transient
    private String character_name;

    private String affinity;

    private String gender;

    private String side;

    private Integer suggested_level;
    private Integer lowest_level;
    private Integer highest_level;

    public ShadowlandCharacter() {
    }

    public ShadowlandCharacter(Long id, Integer character_id, String character_name, String affinity, String gender, String side) {
        this.id = id;
        this.character_id = character_id;
        this.character_name = character_name;
        this.affinity = affinity;
        this.gender = gender;
        this.side = side;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Integer character_id) {
        this.character_id = character_id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public String getAffinity() {
        return affinity;
    }

    public void setAffinity(String affinity) {
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
