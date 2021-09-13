package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityCountByCountry {
    private String country;
    private Long count;

    @Override
    public String toString() {
        return country + ": " + count;
    }
}
