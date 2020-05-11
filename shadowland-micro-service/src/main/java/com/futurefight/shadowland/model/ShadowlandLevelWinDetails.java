package com.futurefight.shadowland.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class ShadowlandLevelWinDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Set<ShadowlandCharacter> winning_characters;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shadowlandLevel_id", nullable = true)
    private ShadowlandLevel shadowlandLevel;

    @Basic
    private Date won_date;

    private String notes;

    public ShadowlandLevelWinDetails() {
    }

    public ShadowlandLevelWinDetails(Long id,
                                     ShadowlandLevel shadowlandLevel,
                                     Date won_date,
                                     String notes)
    {
        this.id = id;
        this.shadowlandLevel = shadowlandLevel;
        this.won_date = won_date;
        this.notes = notes;
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

    public Date getWon_date() {
        return won_date;
    }

    public void setWon_date(Date won_date) {
        this.won_date = won_date;
    }
}
