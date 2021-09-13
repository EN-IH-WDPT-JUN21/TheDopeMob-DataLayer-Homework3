package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MeanOpportunity {

    final private Long meanOpportunity;
    final private Long accounts;

    @Override
    public String toString() {
        return "Opps per account: " + meanOpportunity.doubleValue() / accounts.doubleValue();
    }
}
