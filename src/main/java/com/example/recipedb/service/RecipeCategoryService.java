package com.example.recipedb.service;

import com.example.recipedb.model.dto.IngredientDto;
import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.forms.IngredientForm;
import com.example.recipedb.model.forms.RecipeCategoryForm;

import java.util.List;

public interface RecipeCategoryService {

   RecipeCategoryDto create (RecipeCategoryForm form);
   boolean delete(Integer personId);
   RecipeCategoryDto update(Integer personId, RecipeCategoryForm updateForm);
   RecipeCategoryDto findById(Integer personId);

   List<RecipeCategoryDto> findAll();
}
