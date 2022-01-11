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

    @Query(value = "SELECT l.degree, count(*) from department as dep " +
            "join department_lector dl USING(department_id) " +
            "join lector l on l.lector_id = dl.lector_id " +
            "WHERE dep.name = :departmentName " +
            "GROUP BY l.degree", nativeQuery = true)
    Optional<List<DepartmentStatisticData>> getDepartmentDegreeStatistic(@Param("departmentName") String departmentName);

    @Query(value = "SELECT avg(l.salary) from department as dep " +
            "join department_lector dl USING(department_id) " +
            "join lector l on l.lector_id = dl.lector_id " +
            "WHERE dep.name = :departmentName " +
            "GROUP BY dep.department_id", nativeQuery = true)
    Optional<Float> getDepartmentAverageSalary(@Param("departmentName") String departmentName);

    @Query(value = "SELECT count(*) from department as dep " +
            "join department_lector dl USING(department_id) " +
            "join lector l on l.lector_id = dl.lector_id " +
            "WHERE dep.name = :departmentName ", nativeQuery = true)
    Optional<Integer> getDepartmentEmployeeCount(@Param("departmentName") String departmentName);

}
