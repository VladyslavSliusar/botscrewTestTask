package com.test.botscrew.dao;

import com.test.botscrew.dto.DepartmentStatisticDto;
import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;
import com.test.botscrew.metadata.LectorDegree;
import com.test.botscrew.repository.DepartmentRepository;
import com.test.botscrew.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.*;

import static com.test.botscrew.metadata.Constants.DIDNT_FIND_DEPARTMENT;
import static com.test.botscrew.metadata.Constants.DIDNT_FIND_INFO;

@Repository
@RequiredArgsConstructor
public class UniversityStructureDaoImpl implements UniversityStructureDao {

    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");


    @Override
    @Transactional
    public void initDefaultData(List<DepartmentEntity> departmentEntityList, List<LectorEntity> lectorEntityList) {
        departmentRepository.saveAll(departmentEntityList);
        lectorRepository.saveAll(lectorEntityList);
    }

    @Override
    @Transactional
    public String getDepartmentHeadName(String departmentName) {
        return departmentRepository.findByName(departmentName).map(departmentEntity -> departmentEntity.getHead().getName())
                .orElse(DIDNT_FIND_DEPARTMENT);
    }

    @Override
    @Transactional
    public DepartmentStatisticDto  getDepartmentDegreeStatistic(String departmentName) {
        return departmentRepository.getDepartmentDegreeStatistic(departmentName).map(result -> {
            DepartmentStatisticDto  resultObject = new DepartmentStatisticDto();
            result.forEach(item -> {
                if(item.getDegree().equals(LectorDegree.ASSISTANT.toString())){
                    resultObject.setCountAssistant(item.getCount());
                }
                if(item.getDegree().equals(LectorDegree.PROFESSOR.toString())){
                    resultObject.setCountProfessor(item.getCount());
                }
                if(item.getDegree().equals(LectorDegree.ASSOCIATE_PROFESSOR.toString())){
                    resultObject.setCountAssociateProfessor(item.getCount());
                }
            });
            return resultObject;
        }).orElse(new DepartmentStatisticDto());
    }

    @Override
    @Transactional
    public String getAverageDepartmentSalary(String departmentName) {
        return departmentRepository.getDepartmentAverageSalary(departmentName).map(decimalFormat::format).orElse(DIDNT_FIND_INFO);
    }

    @Override
    @Transactional
    public String getCountDepartmentEmployee(String departmentName) {
        return departmentRepository.getDepartmentEmployeeCount(departmentName).map(Object::toString).orElse(DIDNT_FIND_INFO);
    }

    @Override
    @Transactional
    public String getResultByGlobalSearch(String globalSearchTemplate) {
        List<String> result = new ArrayList<>();
        departmentRepository.findAll().forEach(departmentEntity -> {
            if(departmentEntity.getName().contains(globalSearchTemplate)){
                result.add(departmentEntity.getName());
            }
        });
        lectorRepository.findAll().forEach(lectorEntity -> {
            if(lectorEntity.getName().contains(globalSearchTemplate)){
                result.add(lectorEntity.getName());
            }
        });
        return String.join(", ", result);
    }

}
