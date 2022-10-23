package com.example.recipedb.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class RecipeRepoTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IngredientRepo testRepo;

//    public List<Ingredient> lIngredients(){
//        return Arrays.asList(
//                new Ingredient("Salt"),
//                new Ingredient("Water"),
//                new Ingredient("Sugar"),
//                new Ingredient("Rice"),
//                new Ingredient("Flour"),
//                new Ingredient("Butter")
//
//        );
//    }
//
//    Ingredient tRecipes;
//    public List<RecipeIngredient> lRecipesIngredient(){
//        return Arrays.asList(
//                new RecipeIngredient("Bread", null,  rec),
//                new RecipeIngredient(1,DL,lIngredients(1),"Bread"),
//                new RecipeIngredient("Sugar"),
//                new RecipeIngredient("Flour")
//        );
//    }
//
//    public List<Recipe> lRecipes(){
//        return Arrays.asList(
//                new Recipe("Bread", null,  rec),
//                new Recipe("Rice"),
//                new Recipe("Pizza"),
//        );
//    }
//    @BeforeEach
//    void setUp() {
//        List<Recipe> persistedRecipes = lRecipes().stream()
//                .map(entityManager::persist)
//                .collect(Collectors.toList());
//
//        tRecipes = persistedIngredient.get(0);
//    }


    @Test
    void findRecipesByRecipeNameContaining() {
    }

    @Test
    void findAllByRecipeIngredientsContainingIgnoreCase() {
    }
}