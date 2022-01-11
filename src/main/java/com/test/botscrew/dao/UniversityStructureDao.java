package com.test.botscrew.dao;

import com.test.botscrew.dto.DepartmentStatisticDto;
import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;

import java.util.List;

public interface UniversityStructureDao {
     void initDefaultData(List<DepartmentEntity> departmentEntityList, List<LectorEntity> lectorEntityList);
     String getDepartmentHeadName(String departmentName);
     DepartmentStatisticDto getDepartmentDegreeStatistic(String departmentName);
     String getAverageDepartmentSalary(String departmentName);
     String getCountDepartmentEmployee(String departmentName);
     String getResultByGlobalSearch(String globalSearchTemplate);

}
