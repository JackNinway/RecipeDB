package com.example.recipedb.model.forms;

import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.entity.Measurement;
import com.example.recipedb.model.entity.Recipe;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecipeIngredientForm {
   private int id;
   @NotBlank(message = "This field is required")
   @Size(min = 1, message = "Need to contain at least 1 number")
   private double amount;
   @Enumerated(EnumType.STRING)
   private Measurement measurement;

   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private Ingredient ingredient;

   private Recipe recipe;
}
