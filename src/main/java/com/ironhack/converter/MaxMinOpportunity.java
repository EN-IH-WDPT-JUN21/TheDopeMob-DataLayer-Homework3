package com.ironhack.converter;

public class MaxMinOpportunity {
    private Long maxMin;
    private String name;

    public MaxMinOpportunity(String name, Long maxMin) {
        this.maxMin = maxMin;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Value: " + maxMin + "\nCompany: " + name;
    }
}
