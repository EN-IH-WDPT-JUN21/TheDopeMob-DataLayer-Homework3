package com.ironhack.dao;


import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opportunity_id")
    private Long opportunityId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Product productType;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountId;

    public Opportunity(SalesRep salesRep, Contact decisionMaker, Product productType, int quantity, Status status, Account accountId) {
        this.salesRep = salesRep;
        this.decisionMaker = decisionMaker;
        this.productType = productType;
        this.quantity = quantity;
        this.status = status;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "opportunityId=" + opportunityId +
                ", salesRep=" + salesRep +
                ", decisionMaker=" + decisionMaker +
                ", productType=" + productType +
                ", quantity=" + quantity +
                ", status=" + status +
                ", accountId=" + accountId +
                '}';
    }
}
