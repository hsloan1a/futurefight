package com.futurefight.shadowland.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShadowlandLevel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "shadowlandLevel")
    private Set<ShadowlandLevelWinDetail> previously_won;

    private FloorType floor_type;

    private String character_portrait;

    private Integer level;

    private FloorAdvantageType floor_advantage;



    public ShadowlandLevel() {
    }

    public ShadowlandLevel(@Nullable Set<ShadowlandLevelWinDetail> previously_won,
                           FloorType floor_type,
                           Integer level,
                           String character_portrait,
                           FloorAdvantageType floor_advantage) {
        this.previously_won = previously_won;
        this.floor_type = floor_type;
        this.level = level;
        this.character_portrait = character_portrait;
        this.floor_advantage = floor_advantage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Set<ShadowlandLevelWinDetail> getPreviously_won() {
        return previously_won;
    }

    public void setPreviously_won(@Nullable Set<ShadowlandLevelWinDetail> previously_won) {
        this.previously_won = previously_won;
    }

    public FloorType getFloor_type() {
        return floor_type;
    }

    public void setFloor_type(FloorType floor_type) {
        this.floor_type = floor_type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCharacter_portrait() {
        return character_portrait;
    }

    public void setCharacter_portrait(String character_portrait) {
        this.character_portrait = character_portrait;
    }

    public FloorAdvantageType getFloor_advantage() {
        return floor_advantage;
    }

    public void setFloor_advantage(FloorAdvantageType floor_advantage) {
        this.floor_advantage = floor_advantage;
    }
}
