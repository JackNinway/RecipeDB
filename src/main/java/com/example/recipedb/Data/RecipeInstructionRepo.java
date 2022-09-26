package com.example.recipedb.Data;

import com.example.recipedb.Entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, Integer> {

}
