package com.test.botscrew;

import com.test.botscrew.handler.UniversityStructureCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class BotscrewApplication implements CommandLineRunner {

    private final UniversityStructureCommandHandler handler;

    public static void main(String[] args) {
        SpringApplication.run(BotscrewApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String inputText;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter your command: ");
                inputText = scanner.nextLine();
                if ("finish".equals(inputText)) return;
                System.out.println(handler.handleInputCommand(inputText));
            }
        }
    }
}
