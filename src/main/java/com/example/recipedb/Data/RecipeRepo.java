package com.example.recipedb.Data;

import com.example.recipedb.Entity.Ingredient;
import com.example.recipedb.Entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface RecipeRepo extends CrudRepository<Recipe, Integer> {
    List<Recipe> findRecipesByRecipeNameContaining(String containedString );
    List<Recipe> findAllByRecipeIngredientsIngredientIngredientName(String ingredient );

    List<Recipe> findAllByCategoriesCategory(String category);

    List<Recipe> findDistinctByCategoriesCategoryIn(Collection<String> categoryList);
}
//findAllByRecipeNameContainingIgnoreCase
