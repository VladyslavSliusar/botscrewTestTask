package com.test.botscrew.service;

import com.test.botscrew.dto.DepartmentStatisticDto;
import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;

import java.util.List;

public interface UniversityStructureService {
     void initDefaultData(List<DepartmentEntity> departmentEntityList, List<LectorEntity> lectorEntityList);
     String getDepartmentHeadName(String departmentName);
     DepartmentStatisticDto getDepartmentDegreeStatistic(String departmentName);
     String getAverageDepartmentSalary(String departmentName);
     int getCountDepartmentEmployee(String departmentName);
     String getResultByGlobalSearch(String globalSearchTemplate);

}
