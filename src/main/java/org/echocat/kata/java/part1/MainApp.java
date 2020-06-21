package org.echocat.kata.java.part1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
