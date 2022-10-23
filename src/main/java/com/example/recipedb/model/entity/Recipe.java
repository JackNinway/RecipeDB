package com.example.recipedb.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int id;
    private String recipeName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;
    @OneToMany(mappedBy = "recipe", cascade = {MERGE, REFRESH, DETACH}, fetch = LAZY)
    private List<RecipeIngredient> recipeIngredients;
    @ManyToMany(cascade = {PERSIST, REFRESH, MERGE}, mappedBy = "recipes")
    private Set<RecipeCategory> categories = new HashSet<RecipeCategory>();

    public Recipe() {    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.instruction = instruction;
    }

    public Recipe(String recipeName, RecipeInstruction instruction, List<RecipeIngredient> recipeIngredients) {
        this.recipeName = recipeName;
        this.instruction = instruction;
        this.recipeIngredients = recipeIngredients;
    }

//    public Recipe(String recipeName, RecipeInstruction instruction, List<RecipeIngredient> recipeIngredients, Set<RecipeCategory> categories) {
//        this.recipeName = recipeName;
//        this.instruction = instruction;
//        this.recipeIngredients = recipeIngredients;
//        this.categories = categories;
//    }

    public void addRecIngr(RecipeIngredient ri) {

        if (ri == null) throw new IllegalArgumentException("recipeIngredients was null");
        if (recipeIngredients == null)
            setRecipeIngredients(new ArrayList<>());

        if (!recipeIngredients.contains(ri)) {
            recipeIngredients.add(ri);
        }
    }
    public void removeRecIngr(RecipeIngredient ri) {
        if (ri == null) throw new IllegalArgumentException(" recipeIngredients was null");
        if (recipeIngredients == null)
            setRecipeIngredients(new ArrayList<>());

        if (recipeIngredients.contains(ri)) {
            recipeIngredients.remove(ri);
        }
    }
//:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
    public void addCategory(RecipeCategory rc) {
        if (rc == null) throw new IllegalArgumentException("category was null");
        if (categories == null)
            setCategories(new HashSet<>());

        if (!categories.contains(rc)) {
            this.categories.add(rc);
            rc.getRecipe().add(this);
        }
    }
    public void removeCategory(RecipeCategory rc) {
        if (rc == null) throw new IllegalArgumentException("category was null");
        if (categories == null) setCategories(new HashSet<>());

        if (categories.contains(rc)) {
            this.categories.remove(rc);
            rc.getRecipe().remove(this);
        }
    }
//:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }
    @JsonManagedReference
    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", instruction=" + instruction +
                ", recipeIngredients=" + recipeIngredients +
                ", categories=" + categories +
                '}';
    }
}
