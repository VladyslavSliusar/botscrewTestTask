package com.test.botscrew.repository;

import com.test.botscrew.entity.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<LectorEntity, Long> {
}