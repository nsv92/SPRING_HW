package ru.gb.lesson_7_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.gb.lesson_7_security")
public class Lesson7Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson7Application.class, args);
    }

}
