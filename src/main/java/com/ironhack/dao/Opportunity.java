package com.ironhack.dao;

import com.ironhack.data.DatabaseManager;
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
    private int id;

    @Enumerated(EnumType.STRING)
    private Product product;

    @NotBlank
    private int quantity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountOpportunity;

    public Opportunity(int product, int quantity, Contact contact) {
        setId(DatabaseManager.findLastOpportunityId());
        setProduct(product);
        setQuantity(quantity);
        setContact(contact);
        this.status = Status.OPEN;
    }

    public void setProduct(int product) {
        if(product == 1) this.product = Product.HYBRID;
        if(product == 2) this.product = Product.FLATBED;
        if(product == 3) this.product = Product.BOX;
    }

    //Methods
    public void opportunityLost(){
    setStatus(Status.CLOSED_LOST);
    }

    public void opportunityWon(){
        setStatus(Status.CLOSED_WON);
    }
}
