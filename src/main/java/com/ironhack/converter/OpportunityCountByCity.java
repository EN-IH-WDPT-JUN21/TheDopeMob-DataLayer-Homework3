package com.ironhack.converter;

public class OpportunityCountByCity {
    private String city;
    private Long count;

    public OpportunityCountByCity(String city, Long count) {
        this.city = city;
        this.count = count;
    }

    @Override
    public String toString() {
        return city + ": " + count;
    }
}
