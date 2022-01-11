package com.test.botscrew.service;

import com.test.botscrew.dto.DepartmentStatisticDto;
import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorDegree;
import com.test.botscrew.entity.LectorEntity;
import com.test.botscrew.repository.DepartmentRepository;
import com.test.botscrew.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.test.botscrew.common.Constants.DIDNT_FIND_DEPARTMENT;

@Repository
@RequiredArgsConstructor
public class UniversityStructureServiceImpl implements UniversityStructureService {

    private static final String GLOBAL_SEARCH_DELIMITER = ", ";

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
        return departmentRepository
                .findByName(departmentName)
                .map(departmentEntity -> departmentEntity.getHead().getName())
                .orElse(DIDNT_FIND_DEPARTMENT);
    }

    @Override
    public DepartmentStatisticDto getDepartmentDegreeStatistic(String departmentName) {
        DepartmentStatisticDto resultObject = new DepartmentStatisticDto();
        departmentRepository.getDepartmentDegreeStatistic(departmentName).forEach(result -> {
            if (LectorDegree.ASSISTANT.toString().equals(result.getDegree())) {
                resultObject.setCountAssistant(result.getCount());
            }
            if (LectorDegree.PROFESSOR.toString().equals(result.getDegree())) {
                resultObject.setCountProfessor(result.getCount());
            }
            if (LectorDegree.ASSOCIATE_PROFESSOR.toString().equals(result.getDegree())) {
                resultObject.setCountAssociateProfessor(result.getCount());
            }
        });
        return resultObject;
    }

    @Override
    @Transactional
    public String getAverageDepartmentSalary(String departmentName) {
        List<LectorEntity> lectors = departmentRepository.findByName(departmentName).map(DepartmentEntity::getLectorsList).orElse(new ArrayList<>());
        return decimalFormat.format(lectors.stream().mapToDouble(LectorEntity::getSalary).average().orElse(0.0));
    }

    @Override
    @Transactional
    public int getCountDepartmentEmployee(String departmentName) {
        return departmentRepository
                .findByName(departmentName)
                .map(result -> result.getLectorsList().size())
                .orElse(0);
    }

    @Override
    public String getResultByGlobalSearch(String searchTemplate) {
        return Stream.concat(getDepartments(searchTemplate), getLectors(searchTemplate))
                .collect(Collectors.joining(GLOBAL_SEARCH_DELIMITER));
    }

    private Stream<String> getLectors(String searchTemplate) {
        return departmentRepository
                .findAllByNameContaining(searchTemplate)
                .stream()
                .map(DepartmentEntity::getName);
    }

    private Stream<String> getDepartments(String searchTemplate) {
        return lectorRepository
                .findAllByNameContaining(searchTemplate)
                .stream()
                .map(LectorEntity::getName);
    }

}
