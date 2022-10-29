package com.example.recipedb.model.dto;

import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.entity.Measurement;
import com.example.recipedb.model.entity.Recipe;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecipeIngredientDtoSmall {
   private int id;
   private double amount;
   @Enumerated(EnumType.STRING)
   private Measurement measurement;
   private Ingredient ingredient;
}
