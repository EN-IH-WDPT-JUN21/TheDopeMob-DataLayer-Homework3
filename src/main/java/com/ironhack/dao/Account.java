package com.ironhack.dao;

import com.ironhack.enums.Industry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "company_name", unique = true)
    private String companyName;

    @Column(name = "employee_count")
    private int employeeCount;

    @Enumerated
    @Column(name = "industry_type")
    private Industry industryType;

    @NotBlank(message = "Must supply City")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Must supply Country")
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "accountId")
    private List<Opportunity> opportunityList;

    public Account(String companyName, int employeeCount, Industry industryType, String city, String country) {
        this.companyName = companyName;
        this.employeeCount = employeeCount;
        this.industryType = industryType;
        this.city = city;
        this.country = country;
    }

}

