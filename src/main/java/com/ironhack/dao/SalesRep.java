package com.ironhack.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_rep_id")
    private Long salesRepId;

    private String name;

    public SalesRep(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SalesRep{" +
                "salesRepId=" + salesRepId +
                ", name='" + name + '\'' +
                '}';
    }
}
