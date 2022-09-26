package com.example.recipedb.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_category_id")
    private int id;
    private String category;
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "recipe_recipe_category",
               joinColumns =@JoinColumn(name = "recipe_category_id"),
               inverseJoinColumns = @JoinColumn(name = "recipe_id")  )
    private Set<Recipe> recipes ;

    public RecipeCategory() {    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(String category, Set<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }
    public void addRecipe(Recipe r) {

        if (r == null) throw new IllegalArgumentException("Recipe was null");
        if (recipes == null)
            setRecipe(new HashSet<>());

        if (!recipes.contains(r)) {
            r.getCategories().add(this);
            recipes.add(r);
        }
    }
    public void removeRecipe(Recipe r) {
        if (recipes == null) throw new IllegalArgumentException("Parameter Book was null");
        if (recipes == null) setRecipe(new HashSet<>());

        if (recipes.contains(r)) {
            r.getCategories().remove(this);
            recipes.remove(r);
        }
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipe() {
        return recipes;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipes = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipe=" + recipes +
                '}';
    }
}
