package com.example.recipedb.model.dto;

import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.entity.Measurement;
import com.example.recipedb.model.entity.Recipe;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeIngredientDto {
   private int id;
   private double amount;
   @Enumerated(EnumType.STRING)
   private Measurement measurement;
   private Ingredient ingredient;
   private RecipeDtoMini recipeDtoMini;
}
