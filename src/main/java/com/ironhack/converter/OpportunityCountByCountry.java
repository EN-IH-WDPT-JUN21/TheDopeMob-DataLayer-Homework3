package com.ironhack.converter;

public class OpportunityCountByCountry {
    private String country;
    private Long count;

    public OpportunityCountByCountry(String country, Long count) {
        this.country = country;
        this.count = count;
    }

    @Override
    public String toString() {
        return country + ": " + count;
    }
}
