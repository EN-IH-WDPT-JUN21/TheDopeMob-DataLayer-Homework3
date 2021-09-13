package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MeanQuantity {
    final private Double meanQuantity;
    final private Long count;

    @Override
    public String toString() {
        return "Mean: " + meanQuantity + "\nCount: " + count;
    }
}
