package com.ironhack.dao;

import com.ironhack.data.DatabaseManager;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    @Column(name = "account_id")
    private int id;

    @Enumerated(EnumType.STRING)
    private Product product;

    @NotBlank
    private int quantity;

    @NotNull
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private Status status;

    //Methods
    public void opportunityLost(){
    setStatus(Status.CLOSED_LOST);
    }

    public void opportunityWon(){
        setStatus(Status.CLOSED_WON);
    }

}
