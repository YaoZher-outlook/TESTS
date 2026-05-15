package com.yaozher.springdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yaozher")
public class Springdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo2Application.class, args);
    }

}
