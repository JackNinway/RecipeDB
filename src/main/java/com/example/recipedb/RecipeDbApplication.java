package com.example.recipedb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class RecipeDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeDbApplication.class, args);
    }

}

