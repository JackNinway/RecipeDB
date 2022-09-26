package com.example.recipedb.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST)
    private List<RecipeIngredient> recipeIngredients;
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH},
            mappedBy = "recipes")
    private Set<RecipeCategory> categories;

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

    public Recipe(String recipeName, RecipeInstruction instruction, List<RecipeIngredient> recipeIngredients, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.instruction = instruction;
        this.recipeIngredients = recipeIngredients;
        this.categories = categories;
    }
    public void addCategory(RecipeCategory rc) {

        if (rc == null) throw new IllegalArgumentException("RecipeCategory was null");
        if (categories == null) setCategories(new HashSet<>());

        if (!categories.contains(rc)) {
            rc.getRecipe().add(this);
            categories.add(rc);
        }
    }
    public void removeBook(RecipeCategory rc) {
        if (rc == null) throw new IllegalArgumentException("Parameter Book was null");
        if (categories == null) setCategories(new HashSet<>());

        if (categories.contains(rc)) {
            rc.getRecipe().remove(this);
            categories.remove(rc);
        }
    }

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
