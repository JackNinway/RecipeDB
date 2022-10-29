package com.example.recipedb.service;

import com.example.recipedb.model.dto.IngredientDto;
import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.IngredientForm;
import com.example.recipedb.model.forms.RecipeForm;

import java.util.List;
import java.util.Set;

public interface IngredientService {

   IngredientDto create (IngredientForm form);
   boolean delete(Integer personId);
   IngredientDto update(Integer personId, IngredientForm updateForm);
   IngredientDto findById(Integer personId);
   List<IngredientDto> findAll();

}
