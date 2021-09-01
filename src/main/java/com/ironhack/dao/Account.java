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
    private String city;

    @NotBlank(message = "Must supply Country")
    private String country;

    @OneToMany(mappedBy = "account_id")
    @Column(name = "contact_list")
    private ArrayList<Contact> contactList;

    @OneToMany(mappedBy = "account_id")
    @Column(name = "opportunity_list")
    private ArrayList<Opportunity> opportunityList;

    public Account(Long industry, int employeeCount, String city, String country) {
    }

    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    public void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    public ArrayList<Opportunity> getOpportunityList() {
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

