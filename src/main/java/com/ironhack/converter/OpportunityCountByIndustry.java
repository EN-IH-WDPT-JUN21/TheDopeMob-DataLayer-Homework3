package com.ironhack.converter;

import com.ironhack.enums.Industry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OpportunityCountByIndustry {
    private Industry industry;
    private Long count;

    @Override
    public String toString() {
        return industry + ": " + count;
    }
}
