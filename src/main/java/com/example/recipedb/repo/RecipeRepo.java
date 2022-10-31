package com.example.recipedb.repo;

import com.example.recipedb.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
    List<Recipe> findRecipesByRecipeNameContaining(String containedString );
    List<Recipe> findAllByRecipeIngredientsIngredientIngredientName(String ingredient );

    List<Recipe> findAllByCategoriesCategory(String category);

    List<Recipe> findDistinctByCategoriesCategoryIn(Collection<String> categoryList);
}
//findAllByRecipeNameContainingIgnoreCase
