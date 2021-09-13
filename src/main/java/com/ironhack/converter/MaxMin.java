package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MaxMin {
    private Integer maxMin;
    private String name;

    @Override
    public String toString() {
        return "Value: " + maxMin + "\nCompany: " + name;
    }
}
