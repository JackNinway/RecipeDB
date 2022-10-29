package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeForm;

import java.util.List;
import java.util.Set;

public interface RecipeService {

   RecipeDto create (RecipeForm form);
   boolean delete(Integer personId);
   RecipeDto update(Integer personId, RecipeForm updateForm);
   RecipeDto findById(Integer personId);

   List<RecipeDto> findAll();

   RecipeDto addRecIngr(List<RecipeIngredient> ri);
   RecipeDto addRecipeCategory(Set<RecipeCategory> rc);

}
