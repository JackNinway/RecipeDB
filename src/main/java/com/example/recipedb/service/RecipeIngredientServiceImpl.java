package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeIngredientDto;
import com.example.recipedb.model.forms.RecipeIngredientForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
   @Override
   public RecipeIngredientDto create(RecipeIngredientForm form) {
      return null;
   }

   @Override
   @Transactional
   public boolean delete(Integer personId) {
      return false;
   }

   @Override
   @Transactional
   public RecipeIngredientDto update(Integer personId, RecipeIngredientForm updateForm) {
      return null;
   }

   @Override
   @Transactional
   public RecipeIngredientDto findById(Integer personId) {
      return null;
   }

   @Override
   @Transactional
   public List<RecipeIngredientDto> findAll() {
      return null;
   }
}
