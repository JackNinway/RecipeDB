package com.example.recipedb.service;

import com.example.recipedb.model.dto.*;
import com.example.recipedb.model.entity.Recipe;
import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.entity.RecipeInstruction;
import com.example.recipedb.model.forms.RecipeForm;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ConversionService {
   public Recipe toRecipe(@NotNull RecipeForm form){
      return new Recipe(form.getRecipeName(), new RecipeInstruction(), new ArrayList<>(), new HashSet<>());
//              form.getInstruction(), form.getRecipeIngredients(), form.getCategories());
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

