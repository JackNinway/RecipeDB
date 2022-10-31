package com.example.recipedb.repo;

import com.example.recipedb.model.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Integer> {

}
