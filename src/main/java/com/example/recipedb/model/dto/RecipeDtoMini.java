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

public class RecipeDtoMini {
    private int id;
    private String recipeName;
//    private RecipeInstruction instruction;
//    private List<SmallRecipeIngredientDto> recipeIngredients;
//    private Set<SmallRecipeCategoryDto> categories;
}
