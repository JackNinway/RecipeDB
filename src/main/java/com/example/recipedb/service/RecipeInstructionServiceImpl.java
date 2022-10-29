package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeInstructionDto;
import com.example.recipedb.model.forms.RecipeInstructionForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {
   @Override
   public RecipeInstructionDto create(RecipeInstructionForm form) {
      return null;
   }

   @Override
   @Transactional
   public boolean delete(Integer personId) {
      return false;
   }

   @Override
   @Transactional
   public RecipeInstructionDto update(Integer personId, RecipeInstructionForm updateForm) {
      return null;
   }

   @Override
   @Transactional
   public RecipeInstructionDto findById(Integer personId) {
      return null;
   }

   @Override
   @Transactional
   public List<RecipeInstructionDto> findAll() {
      return null;
   }
}
