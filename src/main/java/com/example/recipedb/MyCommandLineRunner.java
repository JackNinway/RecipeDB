package com.example.recipedb;

import com.example.recipedb.Data.*;
import com.example.recipedb.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.recipedb.Entity.Measurement.*;
import static com.example.recipedb.Entity.Measurement.G;

@Profile("dev")
@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    public MyCommandLineRunner(EntityManager entityManager,
                               IngredientRepo           ingredientRepo,
                               RecipeCategoryRepo       recipeCategoryRepo,
                               RecipeIngredientRepo     recipeIngredientRepo,
                               RecipeInstructionRepo    recipeInstructionRepo,
                               RecipeRepo               recipeRepo
                              ) {
        this.entityManager = entityManager;
        this.ingredientRepo = ingredientRepo;
        this.recipeCategoryRepo = recipeCategoryRepo;
        this.recipeIngredientRepo = recipeIngredientRepo;
        this.recipeInstructionRepo = recipeInstructionRepo;
        this.recipeRepo = recipeRepo;
    }
    private final EntityManager entityManager;
    private  final IngredientRepo ingredientRepo;
    private final RecipeCategoryRepo recipeCategoryRepo;
    private final RecipeIngredientRepo recipeIngredientRepo;
    private final RecipeInstructionRepo recipeInstructionRepo;
    private final RecipeRepo recipeRepo;

    public List<Ingredient> lIngredients(){
        return Arrays.asList(
                new Ingredient("Rice"),
                new Ingredient("Water")
        );
    }
    public List<RecipeCategory> lRecipeCategory(){
        return Arrays.asList(
                new RecipeCategory("Vegan"),
                new RecipeCategory("Chicken")
        );
    }
    public List<RecipeInstruction> lRecipeInstruction(){
        return Arrays.asList(
                new RecipeInstruction("Melt butter in a pan, add rice and salt and fry it for some minutes"),
                new RecipeInstruction("Add water and boil")
        );
    }
    public List<RecipeIngredient> lRecipesIngredient(List<Ingredient> lIngredients, List<Recipe> lRecipes){
        return Arrays.asList(
                new RecipeIngredient(2, HG, lIngredients().get(0), lRecipes(lRecipeInstruction()).get(0)),
                new RecipeIngredient(4, HG, lIngredients().get(1), lRecipes(lRecipeInstruction()).get(1))
                );
    }
    public List<Recipe> lRecipes(List<RecipeInstruction> lRecipeInstruction){
        return Arrays.asList(
                new Recipe("Bread", lRecipeInstruction().get(0)),
                new Recipe("Rice", lRecipeInstruction().get(1))
                );
    }

    @Override
    public void run(String... args) throws Exception {
        addDataToMyDB();
        List<Recipe> found = recipeRepo.findRecipesByRecipeNameContaining("ice");
        System.out.println("\n" +found +
                "\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n" );
        found = recipeRepo.findAllByRecipeIngredientsIngredientIngredientName("Water");
        System.out.println("\n"    +found +
                "\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n" );
        found = recipeRepo.findAllByCategoriesCategory("Vegan");
        System.out.println("\n"    +found +
                "\n_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_-~'´`'~-_\n" );
    }
    public  void addDataToMyDB(){

//        ingredientRepo.saveAll(lIngredients());
        recipeCategoryRepo.saveAll(lRecipeCategory());
//        recipeInstructionRepo.saveAll(lRecipeInstruction());
//        recipeRepo.saveAll(lRecipes(lRecipeInstruction()));
        recipeIngredientRepo.saveAll(lRecipesIngredient(lIngredients(), lRecipes(lRecipeInstruction())));
        lRecipeCategory().get(0).addRecipe(lRecipes().get(0));

    }
}

