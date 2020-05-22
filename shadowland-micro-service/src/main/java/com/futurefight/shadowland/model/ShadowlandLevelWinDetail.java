package com.futurefight.shadowland.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurefight.shadowland.converter.CharacterToStringConverter;
import com.futurefight.shadowland.converter.StringToCharacterConverter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class ShadowlandLevelWinDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    @JsonSerialize(converter = StringToCharacterConverter.class)
    @JsonDeserialize(converter = CharacterToStringConverter.class)
//    @JsonSerialize(converter = CharacterToStringConverter.class)
//    @JsonDeserialize(converter = StringToCharacterConverter.class)
    private String winning_characters;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "shadowlandLevel_id", nullable = true)
    private ShadowlandLevel shadowlandLevel;

    @Basic
    private Date won_date;

    private String notes;

    public ShadowlandLevelWinDetail() {
    }

    public ShadowlandLevelWinDetail(Long id,
                                     ShadowlandLevel shadowlandLevel,
                                     Date won_date,
                                     String notes,
                                     String winning_characters)
    {
        this.id = id;
        this.shadowlandLevel = shadowlandLevel;
        this.won_date = won_date;
        this.notes = notes;
        this.winning_characters = winning_characters;
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

    @Nullable
    public String getWinning_characters() {
        return winning_characters;
    }

    public void setWinning_characters(@Nullable String winning_characters) {
        this.winning_characters = winning_characters;
    }
}
