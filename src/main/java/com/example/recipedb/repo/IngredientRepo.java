package com.example.recipedb.repo;

import com.example.recipedb.model.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {
Ingredient findByIngredientName(String ingredient );
List<Ingredient> findIngredientByIngredientNameContaining(String ingContaining );

}
