package com.ironhack.converter;

import com.ironhack.dao.Opportunity;
import com.ironhack.dao.SalesRep;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpportunityCountBySalesRep {
    private Long count;
    private SalesRep salesRep;

    public OpportunityCountBySalesRep(SalesRep salesRep, Long count) {
        this.count = count;
        this.salesRep = salesRep;
    }

    @Override
    public String toString() {
        return salesRep.getName() + ": " + count;
    }
}
