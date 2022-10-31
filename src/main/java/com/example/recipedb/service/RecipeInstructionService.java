package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeIngredientDto;
import com.example.recipedb.model.dto.RecipeInstructionDto;
import com.example.recipedb.model.forms.RecipeIngredientForm;
import com.example.recipedb.model.forms.RecipeInstructionForm;

import java.util.List;

public interface RecipeInstructionService {

   RecipeInstructionDto create (RecipeInstructionForm form);
   boolean delete(Integer id);
   RecipeInstructionDto update(Integer id, RecipeInstructionForm updateForm);
   RecipeInstructionDto findById(Integer id);

   List<RecipeInstructionDto> findAll();
}
