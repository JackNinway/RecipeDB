package com.example.recipedb.Data;

import com.example.recipedb.Entity.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepo extends CrudRepository<RecipeCategory,Integer> {

}
