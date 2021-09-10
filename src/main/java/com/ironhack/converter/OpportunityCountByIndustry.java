package com.ironhack.converter;

import com.ironhack.enums.Industry;

public class OpportunityCountByIndustry {
    private Industry industry;
    private Long count;

    public OpportunityCountByIndustry(Industry industry, Long count) {
        this.industry = industry;
        this.count = count;
    }

    @Override
    public String toString() {
        return industry + ": " + count;
    }
}
