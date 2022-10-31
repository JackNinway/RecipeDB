package com.example.recipedb.repo;

import com.example.recipedb.model.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepo extends JpaRepository<RecipeCategory,Integer> {

}
