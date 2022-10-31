package com.example.recipedb.controller;

import com.example.recipedb.model.dto.RecipeDto;
import com.example.recipedb.model.forms.RecipeForm;
import com.example.recipedb.repo.RecipeRepo;
import com.example.recipedb.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
   public ResponseEntity<RecipeDto> update(@PathVariable("id") Integer id, @RequestBody @Valid RecipeForm updateForm) {
      return ResponseEntity.ok(recipeService.update(id,updateForm));
   }

   @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer id){
         return ResponseEntity.ok(recipeService.findById(id));
    }
   @GetMapping
   public ResponseEntity<List<RecipeDto>> findAll(){
      return ResponseEntity.ok(recipeService.findAll());
   }



   @PutMapping("/{id}/instr/assignRInstrToR")   /** assign RecipeInstruction to Recipe */
   public ResponseEntity<RecipeDto> assignRInstrToR(@PathVariable("id") Integer rId,
                                                    @RequestParam ("rInstrId") @Valid Integer rInstrId) {
      return ResponseEntity.ok(recipeService.assignRInstrToR(rId, rInstrId));
   }
   @PutMapping("/{id}/instr/removeRInstrFromR")   /** remove RecipeInstruction to Recipe */
   public ResponseEntity<RecipeDto> removeRInstrFromR(@PathVariable("id") Integer rId,
                                                    @RequestParam ("rInstrId") @Valid Integer rInstrId) {
      return ResponseEntity.ok(recipeService.removeRInstrFromR(rId, rInstrId));
   }


   @PutMapping("/{id}/ingr/assignRIngrToR")   /** assign RecipeIngredient to Recipe*/
   public ResponseEntity<RecipeDto> assignRIngrToR(@PathVariable("id") Integer rId,
                                                @RequestParam("rIngrId") @Valid Integer rIngrId) {
      return ResponseEntity.ok(recipeService.assignRIngrToR(rId, rIngrId));
   }
   @PutMapping("/{id}/ingr/removeRIngrFromR")   /** assign RecipeIngredient to Recipe */
   public ResponseEntity<RecipeDto> removeRIngrFromR(@PathVariable("id") Integer rId,
                                                    @RequestParam ("rIngrId") @Valid Integer rIngrId) {
      return ResponseEntity.ok(recipeService.removeRIngrFromR(rId, rIngrId));
   }
   @PutMapping("/{id}/cat/assignRCatToR")   /** assign RecipeCategory to Recipe*/
   public ResponseEntity<RecipeDto> assignRCatToR(@PathVariable("id") Integer rId,
                                                  @RequestParam("rCatId") @Valid Integer rCatId) {
      return ResponseEntity.ok(recipeService.assignRCatToR(rId, rCatId));
   }
   @PutMapping("/{id}/cat/removeRCatFromR")   /** assign RecipeCategory to Recipe*/
   public ResponseEntity<RecipeDto> removeRCatFromRR(@PathVariable("id") Integer rId,
                                                  @RequestParam("rCatId") @Valid Integer rCatId) {
      return ResponseEntity.ok(recipeService.removeRCatFromR(rId, rCatId));
   }

}
//         Recipe foundRecipe = recipeRepo.findById(id).get();
//         return ResponseEntity.ok(modelMapper.map(foundRecipe, RecipeDTO.class));

