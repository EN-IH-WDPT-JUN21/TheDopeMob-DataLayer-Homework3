package com.ironhack.converter;

import com.ironhack.enums.Product;

public class OpportunityCountByProduct {
    private Product product;
    private Long count;

    public OpportunityCountByProduct(Product product, Long count) {
        this.product = product;
        this.count = count;
    }

    @Override
    public String toString() {
        return product + ": " + count;
    }
}
