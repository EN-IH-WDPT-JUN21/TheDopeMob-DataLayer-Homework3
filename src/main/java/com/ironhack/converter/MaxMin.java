package com.ironhack.converter;

public class MaxMin {
    private Integer maxMin;
    private String name;

    public MaxMin(Integer maxMin, String name) {
        this.maxMin = maxMin;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Value: " + maxMin + "\nCompany: " + name;
    }
}
