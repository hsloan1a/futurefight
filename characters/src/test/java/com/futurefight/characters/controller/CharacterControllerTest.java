package com.futurefight.characters.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurefight.characters.model.Affinity;
import com.futurefight.characters.model.MarvelCharacter;
import com.futurefight.characters.repository.MarvelCharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class CharacterControllerTest {

    @Autowired
    CharacterController characterController;

    MockMvc mockMvc;

    @MockBean
    private MarvelCharacterRepository marvelCharacterRepository;

    @BeforeEach
    public void setup() {
        this.mockMvc = standaloneSetup(this.characterController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        List<MarvelCharacter> marvelCharacterList = new ArrayList<>();
        marvelCharacterList.add(new MarvelCharacter(
                1,
                "Wasp",
                Affinity.blast));
        marvelCharacterList.add(new MarvelCharacter(
                2,
                "Ant Man",
                Affinity.speed));
        marvelCharacterList.add(new MarvelCharacter(
                3,
                "Thanos",
                Affinity.universal));

        when(marvelCharacterRepository.findAll()).thenReturn(marvelCharacterList);
        mockMvc.perform(get("/characters").contentType(MediaType.APPLICATION_JSON).accept(
                MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("links[0].rel").value("self"))
                .andExpect(MockMvcResultMatchers.jsonPath("content").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("content.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].name").value(marvelCharacterList.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].name").value(marvelCharacterList.get(1).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[2].name").value(marvelCharacterList.get(2).getName()));

    }

    @Test
    public void testGetCharacter() throws Exception {
        Integer marvelCharacterKey = 4;
        MarvelCharacter marvelCharacter = new MarvelCharacter(
                marvelCharacterKey,
                "Black Panther",
                Affinity.combat);


        when(marvelCharacterRepository.findById(marvelCharacterKey)).thenReturn(Optional.of(marvelCharacter));
        mockMvc.perform(get("/character/" + marvelCharacterKey).contentType(MediaType.APPLICATION_JSON).accept(
                MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("links[0].rel").value("all-users"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(marvelCharacter.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(marvelCharacterKey))
                .andExpect(MockMvcResultMatchers.jsonPath("$.affinity").value(Affinity.combat.toString()));

    }

    @Test
    public void testCreateCharacter() throws Exception {
        MarvelCharacter marvelCharacter = new MarvelCharacter(
                5,
                "Iron Man",
                Affinity.blast);

        String marvelCharacterAsString = new ObjectMapper().writeValueAsString(marvelCharacter);
        when(marvelCharacterRepository.save(Mockito.any(MarvelCharacter.class))).thenReturn(marvelCharacter);
        mockMvc.perform(post("/character").contentType(MediaType.APPLICATION_JSON)
                .content(marvelCharacterAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("links[0].rel").value("self"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(marvelCharacter.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.affinity").value(Affinity.blast.toString()));

    }
}
