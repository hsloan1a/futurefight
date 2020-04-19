package com.futurefight.shadowland.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShadowlandLevel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "shadowlandLevel")
    private Set<ShadowlandLevelWinDetails> previously_won;

    private FloorType floor_type;

    private Integer level;

    public ShadowlandLevel() {
    }

    public ShadowlandLevel(@Nullable Set<ShadowlandLevelWinDetails> previously_won, FloorType floor_type, Integer level) {
        this.previously_won = previously_won;
        this.floor_type = floor_type;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Set<ShadowlandLevelWinDetails> getPreviously_won() {
        return previously_won;
    }

    public void setPreviously_won(@Nullable Set<ShadowlandLevelWinDetails> previously_won) {
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
}
