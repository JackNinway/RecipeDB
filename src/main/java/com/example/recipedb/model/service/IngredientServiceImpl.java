package com.example.recipedb.model.service;

import com.example.recipedb.model.dto.IngredientDto;
import com.example.recipedb.model.entity.Ingredient;
import com.example.recipedb.model.forms.IngredientForm;
import com.example.recipedb.repo.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
   private final IngredientRepo ingrRepo;
   private final ConversionService convert;
   @Autowired
   public IngredientServiceImpl(ConversionService convert, IngredientRepo ingrRepo){
      this.convert = convert;
      this.ingrRepo = ingrRepo;
   }
   @Override
   public IngredientDto create(IngredientForm form) {
      Ingredient entity = convert.toIngredient(form);
      Ingredient savedIngr = ingrRepo.save(entity);
      return convert.toIngredientDto(savedIngr);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      ingrRepo.deleteById(id);
      return !ingrRepo.findById(id).isPresent();
   }

   @Override
   @Transactional
   public IngredientDto update(Integer id, IngredientForm updateForm) {
      Optional<Ingredient> foundIngr = ingrRepo.findById(id);

      if (foundIngr.isPresent()){
         foundIngr.get().setIngredientName(updateForm.getIngredientName());
      }

      if (foundIngr.isPresent()){
         return convert.toIngredientDto(foundIngr.get());
      } else {
         throw new IllegalArgumentException("Could not find Ingredient By Id");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public IngredientDto findById(Integer id) {
      Optional<Ingredient> foundById = ingrRepo.findById(id);
      Ingredient ingr = foundById.orElseThrow(()
              -> new IllegalArgumentException ("Could not find Ingredient by Id " + id));
      return convert.toIngredientDto(ingr);
   }

   @Override
   @Transactional(readOnly = true)
   public List<IngredientDto> findAll() {
      Iterable<Ingredient> ingrFound = ingrRepo.findAll();
      List<IngredientDto> ingrDtoList = new ArrayList<>();
      ingrFound.forEach( (ingredient) -> ingrDtoList.add(convert.toIngredientDto(ingredient)) );
      return ingrDtoList;
   }
}
