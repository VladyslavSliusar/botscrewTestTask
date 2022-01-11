package com.test.botscrew.repository;

import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectorRepository extends JpaRepository<LectorEntity, Long> {
    List<LectorEntity> findAllByNameContaining(String template);
}
