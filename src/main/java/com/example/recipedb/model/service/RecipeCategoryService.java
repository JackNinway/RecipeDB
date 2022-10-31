package com.example.recipedb.model.service;

import com.example.recipedb.model.dto.IngredientDto;
import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.forms.IngredientForm;
import com.example.recipedb.model.forms.RecipeCategoryForm;

import java.util.List;

public interface RecipeCategoryService {

   RecipeCategoryDto create (RecipeCategoryForm form);
   boolean delete(Integer id);
   RecipeCategoryDto update(Integer id, RecipeCategoryForm updateForm);
   RecipeCategoryDto findById(Integer id);

   List<RecipeCategoryDto> findAll();
}
