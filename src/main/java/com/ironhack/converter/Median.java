package com.ironhack.converter;

import java.util.List;

public class Median {
    private Long accountId;
    private Integer median;

    public Median(Long accountId, Integer median) {
        this.accountId = accountId;
        this.median = median;
    }

    @Override
    public String toString() {
        return "Median: " + median;
    }
}
