package com.example.recipedb.repo;

import com.example.recipedb.model.entity.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepo extends CrudRepository<RecipeCategory,Integer> {

}
