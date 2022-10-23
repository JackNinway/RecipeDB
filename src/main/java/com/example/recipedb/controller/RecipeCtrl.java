package com.example.recipedb.controller;

import com.example.recipedb.model.dto.RecipeDTO;
import com.example.recipedb.model.entity.Recipe;
import com.example.recipedb.repo.IngredientRepo;
import com.example.recipedb.repo.RecipeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RecipeCtrl {

    private final RecipeRepo recipeRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public RecipeCtrl(RecipeRepo recipeRepo, ModelMapper modelMapper){
        this.recipeRepo = recipeRepo;
        this.modelMapper = modelMapper;
    }
   @GetMapping("recipe/find/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable("id") Integer id){
         Recipe foundRecipe = recipeRepo.findById(id).get();
         return ResponseEntity.ok(modelMapper.map(foundRecipe, RecipeDTO.class));
    }
}
