package com.example.recipedb.model.service;

import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.dto.RecipeIngredientDto;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeCategoryForm;
import com.example.recipedb.model.forms.RecipeIngredientForm;

import java.util.List;

public interface RecipeIngredientService {

   RecipeIngredientDto create (RecipeIngredientForm form);
   boolean delete(Integer id);
   RecipeIngredientDto update(Integer id, RecipeIngredientForm updateForm);
   RecipeIngredientDto findById(Integer id);

   List<RecipeIngredientDto> findAll();

   RecipeIngredientDto assignIngrToRI(Integer rId, Integer rInstrId);
   RecipeIngredientDto removeIngrFromRI (Integer rId, Integer rInstrId);
}
