package com.example.recipedb.Entity;

public enum Measurement {
    TBSP(50),
    TSP(25),
    G(1),
    HG(100),
    KG(1000),
    ML(1),
    CL(10),
    DL(100);
    private int value;

    private  Measurement(int a){
        this.value = a;
    }
    public int getValue() {
        return value;
    }
}

//        (Measurement.TSP.getValue());