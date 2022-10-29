package com.example.recipedb.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RecipeInstructionDto {
   private int id;
   private String instructions;
}
