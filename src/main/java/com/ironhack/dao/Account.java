package com.ironhack.dao;

import com.ironhack.enums.IndustryEnum;
import com.ironhack.data.DatabaseManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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

    @Column(name = "employee_count")
    private int employeeCount;

    @Enumerated
    @Column(name = "industry_type")
    private IndustryEnum type;

    @NotBlank(message = "Must supply City")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Must supply Country")
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "accountContact")
    private List<Contact> contactList;

    @OneToMany(mappedBy = "accountOpportunity")
    private List<Opportunity> opportunityList;

    public Account(Long industry, int employeeCount, String city, String country) {
    }

    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    public void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public Opportunity findOpportunityById(int id) {
        for (Opportunity opportunity : opportunityList) {
            if(opportunity.getId() == id) {
                return opportunity;
            }
        }
        throw new IllegalArgumentException("No opportunity matching provided id");
    }
}

