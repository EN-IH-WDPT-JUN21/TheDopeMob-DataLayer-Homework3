package com.ironhack.converter;

public class MeanEmployeeCount {
    final private Double meanEmployeeCount;
    final private Long count;

    public MeanEmployeeCount(Double meanEmployeeCount, Long count) {
        this.meanEmployeeCount = meanEmployeeCount;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Mean: " + meanEmployeeCount + "\nCount: " + count;
    }
}
