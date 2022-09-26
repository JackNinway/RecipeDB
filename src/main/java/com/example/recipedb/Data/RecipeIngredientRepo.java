package com.example.recipedb.Data;

import com.example.recipedb.Entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, Integer> {

}
