package com.example.recipedb.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.CascadeType.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredient_id" )
    private int id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Measurement measurement;

    @ManyToOne( cascade  = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(cascade  = {MERGE, DETACH, REFRESH})
    @JoinColumn(name = "recipe_id")
        private Recipe recipe;

    public RecipeIngredient() {    }

    public RecipeIngredient(double amount, Measurement measurement, Ingredient ingredient) {
        this.amount = amount;
        this.measurement = measurement;
        this.ingredient = ingredient;
    }

    public RecipeIngredient(double amount, Measurement measurement, Ingredient ingredient, Recipe recipe) {
        this.amount = amount;
        this.measurement = measurement;
        this.ingredient = ingredient;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

//    @JsonBackReference
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return id == that.id && Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", ingredient=" + ingredient +
                ", recipe_id=" + recipe.getId() +
                '}';
    }
}
