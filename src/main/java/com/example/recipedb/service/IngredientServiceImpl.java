package com.example.recipedb.service;

import com.example.recipedb.model.dto.IngredientDto;
import com.example.recipedb.model.forms.IngredientForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
   @Override
   public IngredientDto create(IngredientForm form) {
      return null;
   }

   @Override
   @Transactional
   public boolean delete(Integer personId) {
      return false;
   }

   @Override
   @Transactional
   public IngredientDto update(Integer personId, IngredientForm updateForm) {
      return null;
   }

   @Override
   @Transactional
   public IngredientDto findById(Integer personId) {
      return null;
   }

   @Override
   @Transactional
   public List<IngredientDto> findAll() {
      return null;
   }
}
