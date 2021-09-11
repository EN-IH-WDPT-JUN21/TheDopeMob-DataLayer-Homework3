package com.ironhack.converter;

import com.ironhack.dao.Account;

public class MeanOpportunity {

    final private Long meanOpportunity;
    final private Long accounts;

    public MeanOpportunity(Long accounts, Long meanOpportunity) {
        this.meanOpportunity = meanOpportunity;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Opps per account: " + meanOpportunity.doubleValue() / accounts.doubleValue();
    }
}
