package com.example.recipedb.model.service;

import com.example.recipedb.exception.AppResourceNotFoundException;
import com.example.recipedb.model.dto.RecipeIngredientDto;
import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.entity.RecipeIngredient;
import com.example.recipedb.model.forms.RecipeIngredientForm;
import com.example.recipedb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
   private final RecipeIngredientRepo rIngrRepo;
   private final IngredientRepo ingrRepo;
   private final ConversionService convert;
   @Autowired
   public RecipeIngredientServiceImpl(RecipeIngredientRepo rIngrRepo, ConversionService convert, IngredientRepo ingrRepo){
      this.convert = convert;
      this.rIngrRepo = rIngrRepo;
      this.ingrRepo = ingrRepo;
   }

   @Override
   public RecipeIngredientDto create(RecipeIngredientForm form) {
      RecipeIngredient entity = convert.toRIngr(form);
      RecipeIngredient savedRIngr = rIngrRepo.save(entity);
      return convert.toRIngrDto(savedRIngr);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      rIngrRepo.deleteById(id);
      return !rIngrRepo.findById(id).isPresent();
   }

   @Override
   @Transactional
   public RecipeIngredientDto update(Integer id, RecipeIngredientForm form) {
      Optional<RecipeIngredient> foundRIngr = rIngrRepo.findById(id);

      if (foundRIngr.isPresent()){
         foundRIngr.get().setAmount(form.getAmount());
         foundRIngr.get().setMeasurement(form.getMeasurement());
//         foundRIngr.get().setIngredient(form.getIngredient());
//         foundRIngr.get().setRecipe(form.getRecipe());
      }

      if (foundRIngr.isPresent()){
         return convert.toRIngrDto(foundRIngr.get());
      } else {
         throw new IllegalArgumentException("Could not find RecipeIngredient By Id");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public RecipeIngredientDto findById(Integer id) {
      Optional<RecipeIngredient> foundRIngr = rIngrRepo.findById(id);
      RecipeIngredient rIngr = foundRIngr.orElseThrow(()
              -> new IllegalArgumentException ("Could not find RecipeIngredient by Id " + id));
      return convert.toRIngrDto(rIngr);
   }

   @Override
   @Transactional(readOnly = true)
   public List<RecipeIngredientDto> findAll() {
      Iterable<RecipeIngredient> foundRIngr = rIngrRepo.findAll();
      List<RecipeIngredientDto> rIngrDtoList = new ArrayList<>();
      foundRIngr.forEach( (recipeIngredient) -> rIngrDtoList.add(convert.toRIngrDto(recipeIngredient)) );
      return rIngrDtoList;
   }

   @Override
   @Transactional
   public RecipeIngredientDto assignIngrToRI(Integer rIingrId, Integer rInstrId) {
      RecipeIngredient rIngr = rIngrRepo.findById(rIingrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeIngredient not found"));
      Ingredient ingredient = ingrRepo.findById(rInstrId).orElseThrow( () -> new AppResourceNotFoundException("Ingredient Not found"));

      rIngr.setIngredient(ingredient);

      return convert.toRIngrDto(rIngr);
   }
   @Override
   @Transactional
   public RecipeIngredientDto removeIngrFromRI(Integer rIingrId, Integer rInstrId) {
      RecipeIngredient rIngr = rIngrRepo.findById(rIingrId).orElseThrow( () -> new AppResourceNotFoundException("RecipeIngredient not found"));
      Ingredient ingredient = ingrRepo.findById(rInstrId).orElseThrow( () -> new AppResourceNotFoundException("Ingredient Not found"));

      rIngr.setIngredient(ingredient);

      return convert.toRIngrDto(rIngr);
   }
}
