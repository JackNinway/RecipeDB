package com.example.recipedb.model.service;

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
   boolean delete(Integer id);
   IngredientDto update(Integer id, IngredientForm updateForm);
   IngredientDto findById(Integer id);
   List<IngredientDto> findAll();

}
