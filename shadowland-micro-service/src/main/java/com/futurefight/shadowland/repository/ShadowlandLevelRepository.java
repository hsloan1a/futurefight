package com.futurefight.shadowland.repository;

import com.futurefight.shadowland.model.ShadowlandLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShadowlandLevelRepository extends JpaRepository<ShadowlandLevel, Long> {
}
