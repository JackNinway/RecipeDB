package com.example.recipedb.model.service;

import com.example.recipedb.model.dto.*;
import com.example.recipedb.model.entity.*;
import com.example.recipedb.model.forms.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ConversionService {
   public Ingredient toIngredient(@NotNull IngredientForm form){
      return new Ingredient(form.getIngredientName());
   }
   public IngredientDto toIngredientDto(@NotNull Ingredient ingr){
      return new IngredientDto(ingr.getId(), ingr.getIngredientName());
   }
   //:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
   public RecipeInstruction toRInstr(@NotNull RecipeInstructionForm form){
      return new RecipeInstruction(form.getInstructions());
   }
   public RecipeInstructionDto toRInstrDto(@NotNull RecipeInstruction instr){
      return new RecipeInstructionDto(instr.getId(), instr.getInstructions());
   }
   public RecipeCategory toRCat(@NotNull RecipeCategoryForm rCatForm){
      return new RecipeCategory(rCatForm.getCategory(), rCatForm.getRecipes());
   }
   public RecipeIngredient toRIngr(@NotNull RecipeIngredientForm rIngrForm){
      return new RecipeIngredient(rIngrForm.getAmount(), rIngrForm.getMeasurement(),
                                rIngrForm.getIngredient(), rIngrForm.getRecipe());
   }
   //:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

   public Recipe toRecipe(@NotNull RecipeForm form){
      return new Recipe(form.getRecipeName(), null, new ArrayList<>(), new HashSet<>());
   }
   public RecipeDto toRecipeDto (Recipe recipe) {

      List<RecipeIngredientDtoSmall> rIlist = new ArrayList<>();
      Set<RecipeCategoryDtoSmall> rCSet = new HashSet<RecipeCategoryDtoSmall>();

      for (RecipeIngredient rI : recipe.getRecipeIngredients()) {
         rIlist.add(new RecipeIngredientDtoSmall(rI.getId(), rI.getAmount(),
                    rI.getMeasurement(), rI.getIngredient()));
      }

      for (RecipeCategory rC : recipe.getCategories()) {
         rCSet.add(new RecipeCategoryDtoSmall(rC.getId(), rC.getCategory()));
      }
      return new RecipeDto(recipe.getId(), recipe.getRecipeName(), recipe.getInstruction(), rIlist, rCSet);
   }

/** return RecipeIngredientDto with rDtoMini = a Recipe reference containing only Id and name*/
   public RecipeIngredientDto toRIngrDto(@NotNull RecipeIngredient rI) {
      RecipeDtoMini rDtoMini = null;
      if(rI.getRecipe() != null){
         Recipe recipe = rI.getRecipe();
         rDtoMini = new RecipeDtoMini(recipe.getId(), recipe.getRecipeName());
      }
      return new RecipeIngredientDto(rI.getId(), rI.getAmount(),
                                    rI.getMeasurement(), rI.getIngredient(), rDtoMini);
   }
   /** return RecipeCategoryDto with rDtoMini = a Recipe reference containing only Id and name*/
   public RecipeCategoryDto toRCatDto(@NotNull RecipeCategory rC) {
      Set<RecipeDtoMini> rDtoMiniSet= new HashSet<>();
      if(rC.getRecipe() != null){
         for(Recipe r : rC.getRecipe()){
            rDtoMiniSet.add(new RecipeDtoMini(r.getId(), r.getRecipeName()));
         }
      }
      return new RecipeCategoryDto(rC.getId(), rC.getCategory(), rDtoMiniSet);
   }
}

