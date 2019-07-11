package com.example.theym_leaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TheymLeafApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheymLeafApplication.class, args);
    }

}
