package com.example.recipedb.controller;

import com.example.recipedb.model.dto.*;
import com.example.recipedb.model.forms.*;
import com.example.recipedb.model.*;
import com.example.recipedb.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/misc")

public class MiscCtrl {

    private final IngredientService ingrService;
   private final RecipeService recipeService;
   private final RecipeIngredientService rIngrService;
   private final RecipeInstructionService rInstrService;
   private final RecipeCategoryService rCatService;
//   private final ModelMapper modelMapper;
    @Autowired
    public MiscCtrl(IngredientService ingrService, ModelMapper modelMapper,
                    RecipeService recipeService, RecipeIngredientService rIngrService,
                    RecipeInstructionService rInstrService, RecipeCategoryService rCatService){
        this.ingrService = ingrService;
//        this.modelMapper = modelMapper;
        this.recipeService = recipeService;
        this.rIngrService = rIngrService;
        this.rInstrService = rInstrService;
        this.rCatService = rCatService;
    }
/** :=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= Mapping RecipeIngredient :=:=:=:=:=:=:=:=:=:=:=:=:=:=:= */
   @PostMapping("/recingr")
   public ResponseEntity<RecipeIngredientDto> createRIngr(@RequestBody RecipeIngredientForm rIngrForm) {
      return ResponseEntity.status(HttpStatus.CREATED).body(rIngrService.create(rIngrForm));
   }
   @DeleteMapping(path = "/recingr/{id}")
   public ResponseEntity<String> deleteRIngr(@PathVariable("id") Integer id) {

      boolean delete = rIngrService.delete(id);
      return ResponseEntity.ok(delete ? "RecipeIngredient with id " + id + " was deleted" : "RecipeIngredient Not Deleted");
   }
   @PutMapping(path = "/recingr/{id}")
   public ResponseEntity<RecipeIngredientDto> updateRIngr(@PathVariable("id") Integer id,
                                                     @RequestBody @Valid RecipeIngredientForm updateForm) {
      return ResponseEntity.ok(rIngrService.update(id,updateForm));
   }

   @GetMapping("/recingr/{id}")
    public ResponseEntity<RecipeIngredientDto> findByIdRIngr(@PathVariable("id") Integer id){
         return ResponseEntity.ok(rIngrService.findById(id));
    }
   @GetMapping("/recingr")
   public ResponseEntity<List<RecipeIngredientDto>> findAllRIngr(){

      return ResponseEntity.ok(rIngrService.findAll());
   }

/** :=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= Mapping RecipeInstruction =:=:=:=:=:=:=:=:=:=:=:=:=:=:= */
   @PostMapping("/recinstr")
   public ResponseEntity<RecipeInstructionDto> createInstr(@RequestBody @Valid RecipeInstructionForm rInstrForm) {
      return ResponseEntity.status(HttpStatus.CREATED).body(rInstrService.create(rInstrForm));
   }
   @DeleteMapping(path = "/recinstr/{id}")
   public ResponseEntity<String> deleteInstr(@PathVariable("id") Integer id) {

      boolean delete = rInstrService.delete(id);
      return ResponseEntity.ok(delete ? "RecipeInstruction with id " + id + " was deleted" : "RecipeInstruction Not Deleted");
   }
   @PutMapping(path = "/recinstr/{id}")
   public ResponseEntity<RecipeInstructionDto> updateInstr(@PathVariable("id") Integer id,
                                                     @RequestBody @Valid RecipeInstructionForm updateForm) {
      return ResponseEntity.ok(rInstrService.update(id,updateForm));
   }

   @GetMapping("/recinstr/{id}")
   public ResponseEntity<RecipeInstructionDto> findByIdInstr(@PathVariable("id") Integer id){
      return ResponseEntity.ok(rInstrService.findById(id));
   }
   @GetMapping("/recinstr")
   public ResponseEntity<List<RecipeInstructionDto>> findAllInstr(){
      return ResponseEntity.ok(rInstrService.findAll());
   }

/** :=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=: Mapping Ingredient =:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= */
   @PostMapping("/ingr")
   public ResponseEntity<IngredientDto> createIngr(@RequestBody @Valid IngredientForm ingrForm) {
   return ResponseEntity.status(HttpStatus.CREATED).body(ingrService.create(ingrForm));
}
   @DeleteMapping(path = "/ingr/{id}")
   public ResponseEntity<String> deleteIngr(@PathVariable("id") Integer id) {

      boolean delete = ingrService.delete(id);
      return ResponseEntity.ok(delete ? "Ingredient with id " + id + " was deleted" : "Ingredient Not Deleted");
   }
   @PutMapping(path = "/ingr/{id}")
   public ResponseEntity<IngredientDto> updateIngr(@PathVariable("id") Integer id,
                                                     @RequestBody @Valid IngredientForm updateForm) {
      return ResponseEntity.ok(ingrService.update(id,updateForm));
   }

   @GetMapping("/ingr/{id}")
   public ResponseEntity<IngredientDto> findByIdIngr(@PathVariable("id") Integer id){
      return ResponseEntity.ok(ingrService.findById(id));
   }
   @GetMapping("/ingr")
   public ResponseEntity<List<IngredientDto>> findAllIngr(){

      return ResponseEntity.ok(ingrService.findAll());
   }
/** :=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= Mapping RecipeCategory =:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= */
   @PostMapping("/cat")
   public ResponseEntity<RecipeCategoryDto> createCat(@RequestBody @Valid RecipeCategoryForm ingrForm) {
      return ResponseEntity.status(HttpStatus.CREATED).body(rCatService.create(ingrForm));
   }
   @DeleteMapping("/cat/{id}")
   public ResponseEntity<String> deleteCat(@PathVariable("id") Integer id) {

      boolean delete = rCatService.delete(id);
      return ResponseEntity.ok(delete ? "RecipeCategory with id " + id + " was deleted" : "RecipeCategory NOT Deleted");
   }
   @PutMapping("/cat/{id}")
   public ResponseEntity<RecipeCategoryDto> updateCat(@PathVariable("id") Integer id,
                                                   @RequestBody @Valid RecipeCategoryForm updateForm) {
      return ResponseEntity.ok(rCatService.update(id,updateForm));
   }

   @GetMapping("/cat/{id}")
   public ResponseEntity<RecipeCategoryDto> findByIdCat(@PathVariable("id") Integer id){
      return ResponseEntity.ok(rCatService.findById(id));
   }
   @GetMapping("/cat")
   public ResponseEntity<List<RecipeCategoryDto>> findAllCat(){
      return ResponseEntity.ok(rCatService.findAll());
   }

/** :=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:= Assign Ingredient to RecipeIngredient =:=:=:=:=:=:=:=:=:=:=:=:=:= */

   @PutMapping("/{id}/recingr/assignIngrToRI")   /** assign RecipeInstruction to Recipe */
   public ResponseEntity<RecipeIngredientDto> assignIngrToRI(@PathVariable("id") Integer rId,
                                                    @RequestParam ("rInstrId") @Valid Integer rIngrId) {
      return ResponseEntity.ok(rIngrService.assignIngrToRI(rId, rIngrId));
   }
   @PutMapping("/{id}/recingr/removeIngrFromRI")   /** remove RecipeInstruction to Recipe */
   public ResponseEntity<RecipeIngredientDto> removeIngrFromRI(@PathVariable("id") Integer rId,
                                                    @RequestParam ("rInstrId") @Valid Integer rIngrId) {
      return ResponseEntity.ok(rIngrService.removeIngrFromRI(rId, rIngrId));
   }



}
//         Recipe foundRecipe = recipeRepo.findById(id).get();
//         return ResponseEntity.ok(modelMapper.map(foundRecipe, RecipeDTO.class));

