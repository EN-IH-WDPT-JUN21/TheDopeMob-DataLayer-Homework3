package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MeanEmployeeCount {
    final private Double meanEmployeeCount;
    final private Long count;

    @Override
    public String toString() {
        return "Mean: " + meanEmployeeCount + "\nCount: " + count;
    }
}
