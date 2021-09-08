package com.ironhack.dao;

//import com.ironhack.data.DatabaseManager;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountId;

    // ENTITY UP UNTIL HERE

    public void setProduct(int product) {
        if(product == 1) this.productType = Product.HYBRID;
        if(product == 2) this.productType = Product.FLATBED;
        if(product == 3) this.productType = Product.BOX;
    }

    //Methods
    public void opportunityLost(){
    setStatus(Status.CLOSED_LOST);
    }

    public void opportunityWon(){
        setStatus(Status.CLOSED_WON);
    }

}
