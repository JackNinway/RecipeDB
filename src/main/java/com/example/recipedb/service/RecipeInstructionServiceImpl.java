package com.example.recipedb.service;

import com.example.recipedb.model.dto.RecipeInstructionDto;
import com.example.recipedb.model.entity.RecipeInstruction;
import com.example.recipedb.model.forms.RecipeInstructionForm;
import com.example.recipedb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {
   private final ConversionService convert;
   private final RecipeInstructionRepo rInstrRepo;

   @Autowired
   public RecipeInstructionServiceImpl(RecipeInstructionRepo rInstrRepo, ConversionService convert){
      this.convert = convert;
      this.rInstrRepo = rInstrRepo;
   }
   @Override
   public RecipeInstructionDto create(RecipeInstructionForm form) {
      RecipeInstruction entity = convert.toRInstr(form);
      RecipeInstruction savedRInstr = rInstrRepo.save(entity);
      return convert.toRInstrDto(savedRInstr);
   }

   @Override
   @Transactional
   public boolean delete(Integer id) {
      rInstrRepo.deleteById(id);
      return !rInstrRepo.findById(id).isPresent();
   }

   @Override
   @Transactional
   public RecipeInstructionDto update(Integer id, RecipeInstructionForm form) {
      Optional<RecipeInstruction> foundRInstr = rInstrRepo.findById(id);

      if (foundRInstr.isPresent()){
         foundRInstr.get().setInstructions(form.getInstructions());
      }

      if (foundRInstr.isPresent()){
         return convert.toRInstrDto(foundRInstr.get());
      } else {
         throw new IllegalArgumentException("Could not find RecipeInstruction By Id");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public RecipeInstructionDto findById(Integer id) {
      Optional<RecipeInstruction> foundById = rInstrRepo.findById(id);
      RecipeInstruction rInstr = foundById.orElseThrow(()
              -> new IllegalArgumentException ("Could not find RecipeInstruction by Id " + id));
      return convert.toRInstrDto(rInstr);
   }

   @Override
   @Transactional(readOnly = true)
   public List<RecipeInstructionDto> findAll() {
      Iterable<RecipeInstruction> recipeFound = rInstrRepo.findAll();
      List<RecipeInstructionDto> rInstrDtoList = new ArrayList<>();
      recipeFound.forEach( (recipeInstruction) -> rInstrDtoList.add(convert.toRInstrDto(recipeInstruction)) );
      return rInstrDtoList;
   }
}
