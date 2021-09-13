package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityCountByCity {
    private String city;
    private Long count;

    @Override
    public String toString() {
        return city + ": " + count;
    }
}
