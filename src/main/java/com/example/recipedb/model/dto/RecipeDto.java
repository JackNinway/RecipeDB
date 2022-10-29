package com.example.recipedb.model.dto;

import com.example.recipedb.model.entity.RecipeInstruction;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RecipeDto {
    private int id;
    private String recipeName;
    private RecipeInstruction instruction;
    private List<RecipeIngredientDtoSmall> recipeIngredients;
    private Set<RecipeCategoryDtoSmall> categories;
}
