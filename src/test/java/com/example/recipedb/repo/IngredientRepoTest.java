package com.example.recipedb.repo;

import com.example.recipedb.model.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepoTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IngredientRepo testRepo;

    Ingredient tIngredient;
    public List<Ingredient> lIngredients(){
        return Arrays.asList(
                new Ingredient("Salt"),
                new Ingredient("Water"),
                new Ingredient("Sugar"),
                new Ingredient("Flour")
        );
    }
    @BeforeEach
    void setUp() {
        List<Ingredient> persistedIngredient = lIngredients().stream()
                .map(entityManager::persist)
                .collect(Collectors.toList());

        tIngredient = persistedIngredient.get(0);
    }

    @Test
    void findExactIngredient(){
        List<Ingredient> found = testRepo.findIngredientByIngredientNameContaining("Salt");
        assertEquals(1, found.size());
        System.out.println("\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n"
                +found +
                "\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n" );

    }
    @Test
    void finIngredientsContaining(){
        Ingredient found = testRepo.findByIngredientName("al");
        assertEquals(tIngredient.getIngredientName(), found.getIngredientName());
        System.out.println("\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n"
                +found +
                "\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n" );

    }
}