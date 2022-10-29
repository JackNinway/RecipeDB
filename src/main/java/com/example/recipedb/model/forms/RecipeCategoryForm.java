package com.example.recipedb.model.forms;

import com.example.recipedb.model.entity.Recipe;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecipeCategoryForm {
   private int id;
   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private String category;
   private Set<Recipe> recipes = new HashSet<Recipe>();

}
