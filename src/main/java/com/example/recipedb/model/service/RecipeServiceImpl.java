package com.example.recipedb.model.service;

import com.example.recipedb.exception.AppResourceNotFoundException;
import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.*;
import com.example.recipedb.model.forms.RecipeForm;
import com.example.recipedb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      return convert.toRecipeDto(savedRecipe);
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
         foundRecipe.get().setInstruction(form.getInstruction());
         foundRecipe.get().setRecipeIngredients(form.getRecipeIngredients());
         foundRecipe.get().setCategories(form.getCategories());
      }

      if (foundRecipe.isPresent()){
         return convert.toRecipeDto(foundRecipe.get());
      } else {
         throw new IllegalArgumentException("Could not find By Id");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public RecipeDto findById(Integer recipeID) {
      Optional<Recipe> foundById = recipeRepo.findById(recipeID);
      Recipe recipe = foundById.orElseThrow(()
                        -> new IllegalArgumentException ("Could not find Recipe by Id " + recipeID));
      return convert.toRecipeDto(recipe);
   }

   @Override
   @Transactional(readOnly = true)
   public List<RecipeDto> findAll() {
      Iterable<Recipe> recipeFound = recipeRepo.findAll();
      List<RecipeDto> recipeDtoList = new ArrayList<>();
      recipeFound.forEach( (recipe) -> recipeDtoList.add(convert.toRecipeDto(recipe)) );
         return recipeDtoList;
   }


   @Override
   @Transactional
   public RecipeDto assignRInstrToR(Integer rId, Integer rInstrId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeInstruction rInstr = rInstrRepo.findById(rInstrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeInstruction Not found"));

      recipe.setInstruction(rInstr);

      return convert.toRecipeDto(recipe);
   }

   @Override
   @Transactional
   public RecipeDto removeRInstrFromR(Integer rId, Integer rInstrId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeInstruction rInstr = rInstrRepo.findById(rInstrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeInstruction Not found"));

      recipe.setInstruction(null);
      return convert.toRecipeDto(recipe);
   }
   @Override
   @Transactional
   public RecipeDto assignRIngrToR(Integer rId, Integer rIngrId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeIngredient rIngr = rIRepo.findById(rIngrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeIngredient Not found"));

      recipe.addRecIngr(rIngr);

      return convert.toRecipeDto(recipe);
   }

   @Override
   @Transactional
   public RecipeDto removeRIngrFromR(Integer rId, Integer rIngrId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeIngredient rIngr = rIRepo.findById(rIngrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeIngredient Not found"));

      recipe.removeRecIngr(rIngr);

      return convert.toRecipeDto(recipe);
   }

   @Override
   @Transactional
   public RecipeDto assignRCatToR(Integer rId, Integer rCatId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeCategory rCat = rCRepo.findById(rCatId).orElseThrow( () -> new AppResourceNotFoundException("RecipeCategory Not found"));
      recipe.addCategory(rCat);
      return convert.toRecipeDto(recipe);
   }
   @Override
   @Transactional
   public RecipeDto removeRCatFromR(Integer rId, Integer rCatId) {
      Recipe recipe = recipeRepo.findById(rId).orElseThrow( () -> new AppResourceNotFoundException("Recipe not found"));
      RecipeCategory rCat = rCRepo.findById(rCatId).orElseThrow( () -> new AppResourceNotFoundException("RecipeCategory Not found"));
      recipe.removeCategory(rCat);
      return convert.toRecipeDto(recipe);
   }

}
