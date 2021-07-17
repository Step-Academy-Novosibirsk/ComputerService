package ru.ipgolenischev.computerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ComputerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputerServiceApplication.class, args);
    }

}
