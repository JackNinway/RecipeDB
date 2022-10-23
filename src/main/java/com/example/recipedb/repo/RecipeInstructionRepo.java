package com.example.recipedb.repo;

import com.example.recipedb.model.entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, Integer> {

}
