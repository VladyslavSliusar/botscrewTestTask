package com.test.botscrew;

import com.test.botscrew.service.UniversityStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class BotscrewApplication implements CommandLineRunner {

    private final UniversityStructureService service;

    public static void main(String[] args) {
        SpringApplication.run(BotscrewApplication.class, args);
    }

    @Override
    public void run(String... args){
        String inputText;
        service.initDefaultData();
        try( Scanner scanner = new Scanner(System.in)){
            while (true){
                System.out.print("Enter your command: ");
                inputText = scanner.nextLine();
                if(inputText.equals("finish")) return;
                System.out.println(service.handleInputCommand(inputText));
            }
        }
    }
}
