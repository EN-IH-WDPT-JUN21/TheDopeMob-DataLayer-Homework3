package com.ironhack.converter;

import com.ironhack.dao.SalesRep;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadCountBySalesRep {
    private Long count;
    private SalesRep salesRep;

    public LeadCountBySalesRep(SalesRep salesRep, Long count) {
        this.count = count;
        this.salesRep = salesRep;
    }

    @Override
    public String toString() {
        return salesRep.getName() + ": " + count;
    }
}
