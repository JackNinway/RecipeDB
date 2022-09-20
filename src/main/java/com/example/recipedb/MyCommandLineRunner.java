package com.example.recipedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Component
@Profile("dev")
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    public MyCommandLineRunner(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    private final EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {

    }
}
