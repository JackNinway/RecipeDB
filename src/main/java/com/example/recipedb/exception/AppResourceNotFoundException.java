package com.example.recipedb.exception;

public class AppResourceNotFoundException extends RuntimeException{
   public AppResourceNotFoundException(String message) {
      super(message);
   }
}