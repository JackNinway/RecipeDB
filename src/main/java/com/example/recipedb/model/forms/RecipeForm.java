package com.example.recipedb.model.forms;

import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.entity.RecipeInstruction;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecipeForm {
   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private String recipeName;

   private RecipeInstruction instruction;

   private List<RecipeIngredient> recipeIngredients;

   private Set<RecipeCategory> categories;
}
