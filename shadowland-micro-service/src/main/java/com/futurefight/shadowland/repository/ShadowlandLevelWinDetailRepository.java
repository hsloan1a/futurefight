package com.futurefight.shadowland.repository;

import com.futurefight.shadowland.model.ShadowlandLevelWinDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShadowlandLevelWinDetailRepository  extends JpaRepository<ShadowlandLevelWinDetail, Long> {
}
