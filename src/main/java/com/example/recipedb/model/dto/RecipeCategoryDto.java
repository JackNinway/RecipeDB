package com.example.recipedb.model.dto;

import com.example.recipedb.model.entity.Recipe;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeCategoryDto {
   private int id;
   private String category;
   private Set<RecipeDtoMini> recipes = new HashSet<RecipeDtoMini>();

}
