package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.forms.RecipeCategoryForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {
   @Override
   public RecipeCategoryDto create(RecipeCategoryForm form) {
      return null;
   }

   @Override
   @Transactional
   public boolean delete(Integer personId) {
      return false;
   }

   @Override
   @Transactional
   public RecipeCategoryDto update(Integer personId, RecipeCategoryForm updateForm) {
      return null;
   }

   @Override
   @Transactional
   public RecipeCategoryDto findById(Integer personId) {
      return null;
   }

   @Override
   @Transactional
   public List<RecipeCategoryDto> findAll() {
      return null;
   }
}
