package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedianOpportunity {
    private Long accountId;
    private Long median;

    @Override
    public String toString() {
        return "Median: " + median;
    }
}
