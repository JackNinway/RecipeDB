package com.example.recipedb.Data;

import com.example.recipedb.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {
Ingredient findByIngredientName(String ingredient );
List<Ingredient> findIngredientByIngredientNameContaining(String ingContaining );

}
