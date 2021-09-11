package com.ironhack.converter;

public class MeanQuantity {
    final private Double meanQuantity;
    final private Long count;

    public MeanQuantity(Double meanQuantity, Long count) {
        this.meanQuantity = meanQuantity;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Mean: " + meanQuantity + "\nCount: " + count;
    }
}
