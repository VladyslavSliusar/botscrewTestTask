package com.test.botscrew.dao;

import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UniversityStructureDaoImpl implements UniversityStructureDao {

    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    @Transactional
    public void createDepartment() {
        List<LectorEntity> lectorEntities = new ArrayList<>();
        LectorEntity lectorEntity1 = new LectorEntity("Lector 1", new ArrayList<>());
        LectorEntity lectorEntity2 = new LectorEntity("Lector 2", new ArrayList<>());
        LectorEntity lectorEntity3 = new LectorEntity("Lector 3", new ArrayList<>());
        LectorEntity lectorEntity4 = new LectorEntity("Lector 4", new ArrayList<>());
        lectorEntities.add(lectorEntity1);
        lectorEntities.add(lectorEntity2);
        lectorEntities.add(lectorEntity3);
        lectorEntities.add(lectorEntity4);
        DepartmentEntity departmentEntity = new DepartmentEntity("DepartmentEntity 1", lectorEntities, lectorEntity1);
        departmentRepository.save(departmentEntity);
        lectorRepository.save(lectorEntity1);
        lectorRepository.save(lectorEntity2);
        lectorRepository.save(lectorEntity3);
        lectorRepository.save(lectorEntity4);
        System.out.println("SUCCESSS");
    }
}
