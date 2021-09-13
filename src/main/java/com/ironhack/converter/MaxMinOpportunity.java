package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MaxMinOpportunity {
    private String name;
    private Long maxMin;

    @Override
    public String toString() {
        return "Value: " + maxMin + "\nCompany: " + name;
    }
}
