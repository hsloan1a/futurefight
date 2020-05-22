package com.futurefight.shadowland.repository;

import com.futurefight.shadowland.model.ShadowlandCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShadowlandCharacterRepository extends JpaRepository<ShadowlandCharacter, Integer> {
    ShadowlandCharacter findByCharacterId(Integer id);
}
