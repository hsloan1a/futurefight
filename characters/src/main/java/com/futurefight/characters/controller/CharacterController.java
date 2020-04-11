package com.futurefight.characters.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.futurefight.characters.exception.MarvelCharacterNotFound;
import com.futurefight.characters.model.MarvelCharacter;
import com.futurefight.characters.repository.MarvelCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class CharacterController {

    private final MarvelCharacterRepository marvelCharacterRepository;

    @Autowired
    public CharacterController(MarvelCharacterRepository marvelCharacterRepository) {
        this.marvelCharacterRepository = marvelCharacterRepository;
    }

    @GetMapping("/characters")
    ResponseEntity<CollectionModel<EntityModel<MarvelCharacter>>> findAll() {
        List<EntityModel<MarvelCharacter>> characters = StreamSupport.stream(marvelCharacterRepository.findAll().spliterator(), false)
                .map(character -> new EntityModel<>(character,
                        linkTo(methodOn(this.getClass()).getCharacter(character.getId())).withSelfRel(),
                        linkTo(methodOn(this.getClass()).findAll()).withRel("characters")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new CollectionModel<>(characters, linkTo(methodOn(this.getClass()).findAll()).withSelfRel()));
    }

    @GetMapping("/character/{id}")
    public EntityModel<MarvelCharacter> getCharacter(@PathVariable Integer id){
        Optional<MarvelCharacter> findCharacter = marvelCharacterRepository.findById(id);
        if (!findCharacter.isPresent())
            throw new MarvelCharacterNotFound("Character with id=" + id);

        EntityModel<MarvelCharacter> resource = new EntityModel<>(findCharacter.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/character")
    public ResponseEntity<?> createCharacter(@RequestBody MarvelCharacter marvelCharacter){
        try {
            MarvelCharacter savedCharacter = marvelCharacterRepository.save(marvelCharacter);

            EntityModel<MarvelCharacter> characterResource = new EntityModel<>(savedCharacter,
                    linkTo(methodOn(this.getClass()).getCharacter(savedCharacter.getId())).withSelfRel());


            return ResponseEntity
                    .created(new URI(characterResource.getRequiredLink(IanaLinkRelations.SELF).getHref()))
                    .body(characterResource);
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body("Unable to create " + marvelCharacter);
        }
    }
}
