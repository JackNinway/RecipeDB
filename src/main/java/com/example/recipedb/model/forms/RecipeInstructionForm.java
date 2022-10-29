package com.example.recipedb.model.forms;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RecipeInstructionForm {
   private int id;
   @NotBlank(message = "This field is required")
   @Size(min = 3, message = "Need to contain at least 3 letters")
   private String instructions;

}
