package com.futurefight.shadowland.model;


import javax.persistence.*;

@Entity
public class ShadowlandLevelWinDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Set<ShadowlandCharacter> winning_characters;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shadowlandLevel_id", nullable = true)
    private ShadowlandLevel shadowlandLevel;

    private String notes;

    public ShadowlandLevelWinDetails() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ShadowlandLevel getShadowlandLevel() {
        return shadowlandLevel;
    }

    public void setShadowlandLevel(ShadowlandLevel shadowlandLevel) {
        this.shadowlandLevel = shadowlandLevel;
    }
}
