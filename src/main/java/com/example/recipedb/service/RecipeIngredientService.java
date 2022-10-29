package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.dto.RecipeIngredientDto;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeCategoryForm;
import com.example.recipedb.model.forms.RecipeIngredientForm;

import java.util.List;

public interface RecipeIngredientService {

   RecipeIngredientDto create (RecipeIngredientForm form);
   boolean delete(Integer personId);
   RecipeIngredientDto update(Integer personId, RecipeIngredientForm updateForm);
   RecipeIngredientDto findById(Integer personId);

   List<RecipeIngredientDto> findAll();
}
