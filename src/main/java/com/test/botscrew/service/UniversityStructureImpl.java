package com.test.botscrew.service;

import com.test.botscrew.dao.UniversityStructureDao;
import com.test.botscrew.dto.DepartmentStatisticDto;
import com.test.botscrew.entity.DepartmentEntity;
import com.test.botscrew.entity.LectorEntity;
import com.test.botscrew.metadata.LectorDegree;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.test.botscrew.metadata.Constants.DIDNT_FIND_DEPARTMENT;
import static com.test.botscrew.metadata.Constants.DIDNT_FIND_INFO;

@Service
@RequiredArgsConstructor
public class UniversityStructureImpl implements UniversityStructureService {

    private final UniversityStructureDao structureDao;

    @Override
    public void initDefaultData() {
        List<LectorEntity> lectorListFirstDepartment = new ArrayList<>();
        List<LectorEntity> lectorListSecondDepartment = new ArrayList<>();
        List<LectorEntity> lectorListThirdDepartment = new ArrayList<>();

        List<DepartmentEntity> departmentListLector1 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector2 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector3 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector4 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector5 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector6 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector7 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector8 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector9 = new ArrayList<>();
        List<DepartmentEntity> departmentListLector10 = new ArrayList<>();

        LectorEntity lectorEntity1 = new LectorEntity("Liam Smith", 8000, LectorDegree.ASSOCIATE_PROFESSOR, new ArrayList<>());
        LectorEntity lectorEntity2 = new LectorEntity("Noah Johnson", 2500, LectorDegree.ASSISTANT, new ArrayList<>());
        LectorEntity lectorEntity3 = new LectorEntity("Oliver Williams", 3500, LectorDegree.ASSISTANT, new ArrayList<>());
        LectorEntity lectorEntity4 = new LectorEntity("Elijah Brown", 3000, LectorDegree.ASSISTANT, new ArrayList<>());
        LectorEntity lectorEntity5 = new LectorEntity("James Jones", 13000, LectorDegree.PROFESSOR, new ArrayList<>());
        LectorEntity lectorEntity6 = new LectorEntity("Olivia Garcia", 7500, LectorDegree.ASSOCIATE_PROFESSOR, new ArrayList<>());
        LectorEntity lectorEntity7 = new LectorEntity("Emma Miller", 6500, LectorDegree.ASSOCIATE_PROFESSOR, new ArrayList<>());
        LectorEntity lectorEntity8 = new LectorEntity("Ava Davis", 5000, LectorDegree.ASSISTANT, new ArrayList<>());
        LectorEntity lectorEntity9 = new LectorEntity("Charlotte Rodriguez", 12000, LectorDegree.PROFESSOR, new ArrayList<>());
        LectorEntity lectorEntity10 = new LectorEntity("Sophia Martinez", 15000, LectorDegree.PROFESSOR, new ArrayList<>());
        DepartmentEntity departmentEntity1 = new DepartmentEntity("Chemistry Department", new ArrayList<>(), lectorEntity5);
        DepartmentEntity departmentEntity2 = new DepartmentEntity("Medicine Department", new ArrayList<>(), lectorEntity9);
        DepartmentEntity departmentEntity3 = new DepartmentEntity("Computer Science Department", new ArrayList<>(), lectorEntity10);

        lectorListFirstDepartment.add(lectorEntity5);
        lectorListFirstDepartment.add(lectorEntity1);
        lectorListFirstDepartment.add(lectorEntity2);
        lectorListFirstDepartment.add(lectorEntity3);
        lectorListFirstDepartment.add(lectorEntity4);
        lectorListFirstDepartment.add(lectorEntity8);
        departmentEntity1.setLectorsList(lectorListFirstDepartment);

        lectorListSecondDepartment.add(lectorEntity9);
        lectorListSecondDepartment.add(lectorEntity6);
        lectorListSecondDepartment.add(lectorEntity3);
        lectorListSecondDepartment.add(lectorEntity7);
        lectorListSecondDepartment.add(lectorEntity8);
        departmentEntity2.setLectorsList(lectorListSecondDepartment);

        lectorListThirdDepartment.add(lectorEntity10);
        lectorListThirdDepartment.add(lectorEntity7);
        lectorListThirdDepartment.add(lectorEntity4);
        lectorListThirdDepartment.add(lectorEntity8);
        lectorListThirdDepartment.add(lectorEntity2);
        lectorListThirdDepartment.add(lectorEntity6);
        departmentEntity3.setLectorsList(lectorListThirdDepartment);

        departmentListLector1.add(departmentEntity1);
        lectorEntity1.setDepartmentsList(departmentListLector1);

        departmentListLector2.add(departmentEntity1);
        departmentListLector2.add(departmentEntity3);
        lectorEntity2.setDepartmentsList(departmentListLector2);

        departmentListLector3.add(departmentEntity1);
        departmentListLector3.add(departmentEntity2);
        lectorEntity3.setDepartmentsList(departmentListLector3);

        departmentListLector4.add(departmentEntity1);
        departmentListLector4.add(departmentEntity3);
        lectorEntity4.setDepartmentsList(departmentListLector4);

        departmentListLector5.add(departmentEntity1);
        lectorEntity5.setDepartmentsList(departmentListLector5);

        departmentListLector6.add(departmentEntity2);
        departmentListLector6.add(departmentEntity3);
        lectorEntity6.setDepartmentsList(departmentListLector6);

        departmentListLector7.add(departmentEntity2);
        departmentListLector7.add(departmentEntity3);
        lectorEntity7.setDepartmentsList(departmentListLector7);

        departmentListLector8.add(departmentEntity1);
        departmentListLector8.add(departmentEntity2);
        departmentListLector8.add(departmentEntity3);
        lectorEntity8.setDepartmentsList(departmentListLector8);

        departmentListLector9.add(departmentEntity2);
        lectorEntity9.setDepartmentsList(departmentListLector9);

        departmentListLector10.add(departmentEntity3);
        lectorEntity10.setDepartmentsList(departmentListLector10);

        List<DepartmentEntity> departmentEntityList = new ArrayList<>();
        departmentEntityList.add(departmentEntity1);
        departmentEntityList.add(departmentEntity2);
        departmentEntityList.add(departmentEntity3);

        List<LectorEntity> lectorEntityList = new ArrayList<>();
        lectorEntityList.add(lectorEntity1);
        lectorEntityList.add(lectorEntity2);
        lectorEntityList.add(lectorEntity3);
        lectorEntityList.add(lectorEntity4);
        lectorEntityList.add(lectorEntity5);
        lectorEntityList.add(lectorEntity6);
        lectorEntityList.add(lectorEntity7);
        lectorEntityList.add(lectorEntity8);
        lectorEntityList.add(lectorEntity9);
        lectorEntityList.add(lectorEntity10);

        structureDao.initDefaultData(departmentEntityList, lectorEntityList);
    }

    @Override
    public String handleInputCommand(String command) {
        String textWithoutSings = command.replaceAll("[-?,.!_]", "").trim();
        String modifiedText = textWithoutSings.toLowerCase(Locale.ROOT);
        if (modifiedText.contains("who is head of department")) {
            return handleHeadDepartmentCase(textWithoutSings);
        }
        if (modifiedText.contains("show") && modifiedText.contains("statistics")) {
            return handleShowStatisticCase(textWithoutSings);
        }
        if (modifiedText.contains("show the average salary for the department")) {
            return handleAverageSalaryCase(textWithoutSings);
        }
        if (modifiedText.contains("show count of employee for")) {
            return handleCountEmployeeCase(textWithoutSings);
        }
        if (modifiedText.contains("global search by")) {
            return handleGlobalSearchCase(textWithoutSings);
        }
        if (modifiedText.contains("help")) {
            return handleHelpCase();
        }
        return "You entered wrong command. Please try again or see all commands by \"help\" command";
    }

    private String handleHeadDepartmentCase(String enteredText) {
        String startText = "who is head of department ";
        String enteredValue = getInputValue(enteredText, startText, "");
        String result = structureDao.getDepartmentHeadName(enteredValue);
        if (!result.equals(DIDNT_FIND_DEPARTMENT)) {
            return "Head of " + enteredValue + " department is " + result;
        }
        return result;
    }

    private String handleShowStatisticCase(String enteredText) {
        String startText = "show ";
        String endText = "statistics";
        String enteredValue = getInputValue(enteredText, startText, endText);
        DepartmentStatisticDto result = structureDao.getDepartmentDegreeStatistic(enteredValue);
        if (result.getCountAssistant() == 0 && result.getCountAssociateProfessor() == 0 && result.getCountProfessor() == 0) {
            return "Didn't find any info. Please try again";
        }
        return "assistans - " + result.getCountAssistant() +
                "\nassociate professors - " + result.getCountAssociateProfessor() +
                "\nprofessors - " + result.getCountProfessor();
    }

    private String handleAverageSalaryCase(String enteredText) {
        String startText = "show the average salary for the department ";
        String enteredValue = getInputValue(enteredText, startText, "");
        String result = structureDao.getAverageDepartmentSalary(enteredValue);
        if(!result.equals(DIDNT_FIND_INFO)){
            return "The average salary of "+ enteredValue + " is " + result;
        }
        return result;
    }

    private String handleCountEmployeeCase(String enteredText) {
        String startText = "show count of employee for ";
        String enteredValue = getInputValue(enteredText, startText, "");
        return structureDao.getCountDepartmentEmployee(enteredValue);
    }

    private String handleGlobalSearchCase(String enteredText) {
        String startText = "global search by ";
        String enteredValue = getInputValue(enteredText, startText, "");
        String result = structureDao.getResultByGlobalSearch(enteredValue);
        if (result.isBlank()){
            return "Didn't find any matches by template.";
        }
        return structureDao.getResultByGlobalSearch(enteredValue);
    }

    private String handleHelpCase() {
        return "This application contains next commands:" +
                "\n- Who is head of department {department_name}"+
                "\n- Show {department_name} statistics."+
                "\n- Show the average salary for the department {department_name}."+
                "\n- Show count of employee for {department_name}."+
                "\n- Global search by {template}."+
                "\n- finish (close application)" +
                "\nUse them to get information about university";
    }

    private String getInputValue(String enteredText, String firstPartCommand, String lastPartCommand) {
        String lowCaseInputValue = enteredText.toLowerCase();
        String inputValue;
        int startIndex = lowCaseInputValue.indexOf(firstPartCommand) + firstPartCommand.length();
        int endIndex = 0;
        if (!lastPartCommand.isBlank()) {
            endIndex = lowCaseInputValue.indexOf(lastPartCommand);
        }
        if (endIndex > 0) {
            inputValue = enteredText.substring(startIndex, endIndex);
        } else {
            inputValue = enteredText.substring(startIndex);
        }
        return inputValue.trim();
    }
}
