package com.example.recipedb.repo;

import com.example.recipedb.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {
Ingredient findByIngredientName(String ingredient );
List<Ingredient> findIngredientByIngredientNameContaining(String ingContaining );

}
