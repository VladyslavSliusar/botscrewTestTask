package com.test.botscrew.service;

import com.test.botscrew.dao.UniversityStructureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityStructureImpl implements UniversityStructureService{

    private final UniversityStructureDao structureDao;

    @Override
    public void createTestDate() {
        structureDao.createDepartment();
    }
}
