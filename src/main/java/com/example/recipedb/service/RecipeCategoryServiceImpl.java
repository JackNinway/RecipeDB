package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeCategoryDto;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.forms.RecipeCategoryForm;
import com.example.recipedb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {
   private final RecipeRepo recipeRepo;
   private final RecipeCategoryRepo rCRepo;
   private final ConversionService convert;

   @Autowired
   public RecipeCategoryServiceImpl(RecipeRepo recipeRepo, RecipeCategoryRepo rCRepo, ConversionService convert){
      this.recipeRepo = recipeRepo;
      this.rCRepo = rCRepo;
      this.convert = convert;
   }
   @Override
   public RecipeCategoryDto create(RecipeCategoryForm form) {
      RecipeCategory entity = convert.toRCat(form);
      RecipeCategory savedRecipe = rCRepo.save(entity);
      return convert.toRCatDto(savedRecipe);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      rCRepo.deleteById(id);
      return !rCRepo.findById(id).isPresent();
   }

   @Override
   @Transactional
   public RecipeCategoryDto update(Integer id, RecipeCategoryForm updateForm) {
      Optional<RecipeCategory> foundCat = rCRepo.findById(id);
      if (foundCat.isPresent()){
         foundCat.get().setCategory(updateForm.getCategory());
         foundCat.get().setRecipe(updateForm.getRecipes());
      }
      if (foundCat.isPresent()){
         return convert.toRCatDto(foundCat.get());
      } else {
         throw new IllegalArgumentException("Could not find RecipeCategoryBy Id");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public RecipeCategoryDto findById(Integer id) {
      Optional<RecipeCategory> foundCat = rCRepo.findById(id);
      RecipeCategory rCat = foundCat.orElseThrow(()
              -> new IllegalArgumentException ("Could not find RecipeCategory by Id " + id));
      return convert.toRCatDto(rCat);
   }

   @Override
   @Transactional(readOnly = true)
   public List<RecipeCategoryDto> findAll() {
      Iterable<RecipeCategory> rCatFound = rCRepo.findAll();
      List<RecipeCategoryDto> rCatDtoList = new ArrayList<>();
      rCatFound.forEach( (category) -> rCatDtoList.add(convert.toRCatDto(category)) );
      return rCatDtoList;
   }
}
