package com.ironhack.converter;

public class MedianOpportunity {
    private Long accountId;
    private Long median;

    public MedianOpportunity(Long accountId, Long median) {
        this.accountId = accountId;
        this.median = median;
    }

    @Override
    public String toString() {
        return "Median: " + median;
    }
}
