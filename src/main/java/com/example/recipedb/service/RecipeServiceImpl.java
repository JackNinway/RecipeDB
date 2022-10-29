package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.entity.Recipe;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeForm;
import com.example.recipedb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{

   private final RecipeRepo recipeRepo;
   private final RecipeCategoryRepo rCRepo;
   private final ConversionService convert;
   private final RecipeIngredientRepo rIRepo;
   private final RecipeInstructionRepo rInstrRepo;
   private  final IngredientRepo ingrRepo;

   @Autowired
   public RecipeServiceImpl(RecipeRepo recipeRepo, RecipeCategoryRepo rCRepo, RecipeInstructionRepo rInstrRepo,
                            RecipeIngredientRepo rIRepo, ConversionService convert, IngredientRepo ingrRepo){
      this.recipeRepo = recipeRepo;
      this.rCRepo = rCRepo;
      this.convert = convert;
      this.rIRepo =rIRepo;
      this.rInstrRepo = rInstrRepo;
      this.ingrRepo = ingrRepo;
   }

   @Override
   @Transactional
   public RecipeDto create(RecipeForm form) {
      Recipe entity = convert.toRecipe(form);
//      if(entity.getInstruction() !=null){
//         if(rInstrRepo.findById(entity.getInstruction().getId()))
//      }
      Recipe savedRecipe = recipeRepo.save(entity);
      return convert.toRecipeDto(entity);
   }

   @Override
   @Transactional
   public boolean delete(Integer rId) {
      recipeRepo.deleteById(rId);
      return !recipeRepo.findById(rId).isPresent();
   }

   @Override
   @Transactional
   public RecipeDto update(Integer rId, RecipeForm form) {
      Optional<Recipe> foundRecipe = recipeRepo.findById(rId);

      if (foundRecipe.isPresent()){
         foundRecipe.get().setRecipeName(form.getRecipeName());
      }

      if (foundRecipe.isPresent()){
         return convert.toRecipeDto(foundRecipe.get());
      } else {
         throw new IllegalArgumentException("Could not find By Id");
      }
   }

   @Override
   @Transactional
   public RecipeDto findById(Integer recipeID) {
      Optional<Recipe> foundById = recipeRepo.findById(recipeID);
      Recipe recipe = foundById.orElseThrow(()
                        -> new IllegalArgumentException ("Could not find Recipe by Id " + recipeID));
      return convert.toRecipeDto(recipe);
   }

   @Override
   @Transactional
   public List<RecipeDto> findAll() {
      return null;
   }

   @Transactional
   public RecipeDto addRecIngr(List<RecipeIngredient> ri) {
      return null;
   }

   @Transactional
   public RecipeDto addRecipeCategory(Set<RecipeCategory> rc) {
      return null;
   }
}
