package com.test.botscrew;

import com.test.botscrew.service.UniversityStructureService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class BotscrewApplication implements CommandLineRunner {

    private final UniversityStructureService service;

    public static void main(String[] args) {
        SpringApplication.run(BotscrewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String inputText = "";
        try( Scanner scanner = new Scanner(System.in)){
            while (true){
                System.out.print("Enter your name: ");
                inputText = scanner.next();
                if(inputText.equals("finish")) return;
                service.createTestDate();
                System.out.println(inputText);
            }
        }
    }
}
