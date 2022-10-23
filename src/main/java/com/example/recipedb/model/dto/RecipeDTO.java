package com.example.recipedb.model.dto;

import com.example.recipedb.model.entity.RecipeCategory;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.entity.RecipeInstruction;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RecipeDTO {
    private int id;
    private String recipeName;
    private RecipeInstruction instruction;
    private List<RecipeIngredient> recipeIngredients;
    private Set<RecipeCategory> categories;
}
