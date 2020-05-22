package com.futurefight.shadowland.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class ShadowlandCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "character_id")
    private Integer characterId;

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

    public ShadowlandCharacter(Integer id,
                               Integer characterId,
                               String character_name,
                               String affinity,
                               String gender,
                               String side,
                               Integer suggested_level,
                               Integer lowest_level,
                               Integer highest_level) {
        this.id = id;
        this.characterId = characterId;
        this.character_name = character_name;
        this.affinity = affinity;
        this.gender = gender;
        this.side = side;
        this.suggested_level = suggested_level;
        this.lowest_level = lowest_level;
        this.highest_level = highest_level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
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

    public Integer getSuggested_level() {
        return suggested_level;
    }

    public void setSuggested_level(Integer suggested_level) {
        this.suggested_level = suggested_level;
    }

    public Integer getLowest_level() {
        return lowest_level;
    }

    public void setLowest_level(Integer lowest_level) {
        this.lowest_level = lowest_level;
    }

    public Integer getHighest_level() {
        return highest_level;
    }

    public void setHighest_level(Integer highest_level) {
        this.highest_level = highest_level;
    }

    public void copyFromCharacterProxy(ShadowlandCharacter fromProxy){
        this.setCharacterId(fromProxy.getId().intValue());
        this.setAffinity(fromProxy.getAffinity());
        this.setCharacter_name(fromProxy.getCharacter_name());
        this.setGender(fromProxy.getGender());
        this.setSide(fromProxy.getSide());

    }
}
