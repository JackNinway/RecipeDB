package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeForm;

import java.util.List;
import java.util.Set;

public interface RecipeService {

   RecipeDto create (RecipeForm form);
   boolean delete(Integer id);
   RecipeDto update(Integer id, RecipeForm updateForm);
   RecipeDto findById(Integer id);
   List<RecipeDto> findAll();

   RecipeDto  assignRInstrToR(Integer rId, Integer rInstrId);
   RecipeDto removeRInstrFromR (Integer rId, Integer rInstrId);
   RecipeDto assignRIngrToR(Integer rId, Integer rIngrId);
   RecipeDto removeRIngrFromR(Integer rId, Integer rIngrId);
   RecipeDto assignRCatToR (Integer rId, Integer rCatId);
   RecipeDto removeRCatFromR (Integer rId, Integer rCatId);

}
