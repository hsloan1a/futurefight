package com.futurefight.shadowland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
public class ShadowlandCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer character_id;

    @Transient
    @JsonDeserialize
    @JsonProperty("name")
    private String character_name;

    @Transient
    @JsonDeserialize
    private String affinity;

    @Transient
    @JsonDeserialize
    private String gender;

    @Transient
    @JsonDeserialize
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

    public void copyFromCharacterProxy(ShadowlandCharacter fromProxy){
        this.setCharacter_id(fromProxy.getId().intValue());
        this.setAffinity(fromProxy.getAffinity());
        this.setCharacter_name(fromProxy.getCharacter_name());
        this.setGender(fromProxy.getGender());
        this.setSide(fromProxy.getSide());

    }
}
