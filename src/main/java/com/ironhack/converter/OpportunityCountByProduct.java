package com.ironhack.converter;

import com.ironhack.enums.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
