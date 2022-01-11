package com.test.botscrew.repository;

import com.test.botscrew.dto.DepartmentStatisticData;
import com.test.botscrew.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByName(String departmentName);

    List<DepartmentEntity> findAllByNameContaining(String template);

    @Query("SELECT l.degree as degree, count(d.id) as count FROM DepartmentEntity d INNER JOIN d.lectorsList l where d.name = :departmentName GROUP BY l.degree")
    List<DepartmentStatisticData> getDepartmentDegreeStatistic(@Param("departmentName") String departmentName);

}
