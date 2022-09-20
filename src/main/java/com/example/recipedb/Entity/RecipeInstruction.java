package com.example.recipedb.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructions_id")
    private int id;
//    @Column(length = 1500)
    private String instructions;

    public RecipeInstruction() {    }

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return id == that.id && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id=" + id +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
