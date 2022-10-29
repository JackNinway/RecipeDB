package com.example.recipedb.controller;

import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.entity.Recipe;
import com.example.recipedb.model.forms.RecipeForm;
import com.example.recipedb.repo.RecipeRepo;
import com.example.recipedb.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/recipe")

public class RecipeCtrl {

    private final RecipeRepo recipeRepo;
    private final RecipeService recipeService;
    private final ModelMapper modelMapper;
    @Autowired
    public RecipeCtrl(RecipeRepo recipeRepo, ModelMapper modelMapper, RecipeService recipeService){
        this.recipeRepo = recipeRepo;
        this.modelMapper = modelMapper;
        this.recipeService =recipeService;
    }
   @PostMapping
   public ResponseEntity<RecipeDto> create(@RequestBody @Valid RecipeForm recipeForm) {
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.create(recipeForm));
   }
   @DeleteMapping(path = "/{id}")
   public ResponseEntity<String> deleteRecipe(@PathVariable("id") Integer rId) {

      boolean delete = recipeService.delete(rId);
      return ResponseEntity.ok(delete ? "Recipe with id " + rId + " was deleted" : "Recipe Not Deleted");
   }
   @PutMapping(path = "/{id}")
   public ResponseEntity<RecipeDto> update(@PathVariable("id") Integer personId, @RequestBody @Valid RecipeForm updateForm) {
      return ResponseEntity.ok(recipeService.update(personId,updateForm));
   }

   @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer id){
         return ResponseEntity.ok(recipeService.findById(id));
    }

}
//         Recipe foundRecipe = recipeRepo.findById(id).get();
//         return ResponseEntity.ok(modelMapper.map(foundRecipe, RecipeDTO.class));

