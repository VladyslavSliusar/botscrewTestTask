package com.test.botscrew.handler;

import com.test.botscrew.service.UniversityStructureService;
import com.test.botscrew.dto.DepartmentStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static com.test.botscrew.common.Constants.DIDNT_FIND_DEPARTMENT;
import static com.test.botscrew.common.Constants.DIDNT_FIND_INFO;

@Service
@RequiredArgsConstructor
public class UniversityStructureCommandHandlerImpl implements UniversityStructureCommandHandler {

    private final UniversityStructureService structureService;

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
        String result = structureService.getDepartmentHeadName(enteredValue);
        if (!DIDNT_FIND_DEPARTMENT.equals(result)) {
            return "Head of " + enteredValue + " department is " + result;
        }
        return result;
    }

    private String handleShowStatisticCase(String enteredText) {
        String startText = "show ";
        String endText = "statistics";
        String enteredValue = getInputValue(enteredText, startText, endText);
        DepartmentStatisticDto result = structureService.getDepartmentDegreeStatistic(enteredValue);
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
        String result = structureService.getAverageDepartmentSalary(enteredValue);
        if (!DIDNT_FIND_INFO.equals(result)) {
            return "The average salary of " + enteredValue + " is " + result;
        }
        return result;
    }

    private String handleCountEmployeeCase(String enteredText) {
        String startText = "show count of employee for ";
        String enteredValue = getInputValue(enteredText, startText, "");
        int result = structureService.getCountDepartmentEmployee(enteredValue);
        if(result == 0){
            return DIDNT_FIND_INFO;
        }
        return Integer.toString(result);
    }

    private String handleGlobalSearchCase(String enteredText) {
        String startText = "global search by ";
        String enteredValue = getInputValue(enteredText, startText, "");
        String result = structureService.getResultByGlobalSearch(enteredValue);
        if (result.isBlank()) {
            return "Didn't find any matches by template.";
        }
        return structureService.getResultByGlobalSearch(enteredValue);
    }

    private String handleHelpCase() {
        return new StringBuilder()
                .append("This application contains next commands:" )
                .append("\n- Who is head of department {department_name}")
                .append("\n- Show {department_name} statistics.")
                .append("\n- Show the average salary for the department {department_name}.")
                .append("\n- Show count of employee for {department_name}.")
                .append("\n- Global search by {template}.")
                .append("\n- finish (close application)")
                .append("\nUse them to get information about university")
                .toString();
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
