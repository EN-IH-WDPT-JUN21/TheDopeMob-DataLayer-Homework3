package com.ironhack.account;

import com.ironhack.contact.Contact;
import com.ironhack.data.DatabaseManager;
import com.ironhack.opportunity.Opportunity;

import java.util.ArrayList;

public class Account {
    int id;
    int employeeCount;
    IndustryEnum type;
    String city;
    String Country;
    ArrayList<Contact> contactList;
    ArrayList<Opportunity> opportunityList;

//Constructor
    public Account(int industryType, int employeeCount, String city, String country) {
        setId(DatabaseManager.findLastAccountId());
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setType(industryType);
        contactList = new ArrayList<>();
        opportunityList = new ArrayList<>();
    }
//Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setType(int industryType) {
        if(industryType == 1) this.type = IndustryEnum.PRODUCE;
        if(industryType == 2) this.type = IndustryEnum.ECOMMERCE;
        if(industryType == 3) this.type = IndustryEnum.MANUFACTURING;
        if(industryType == 4) this.type = IndustryEnum.MEDICAL;
        if(industryType == 5) this.type = IndustryEnum.OTHER;
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

