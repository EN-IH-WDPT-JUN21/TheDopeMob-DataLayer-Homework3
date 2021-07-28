package com.ironhack.account;

import com.ironhack.contact.Contact;
import com.ironhack.opportunity.OpportunityNew;

import java.util.ArrayList;

public class Account {
    int id;
    int employeeCount;
    IndustryEnum type;
    String city;
    String Country;
    ArrayList<Contact> contactList;
    ArrayList<OpportunityNew> opportunityList;

//Constructor
    public Account(int id, int employeeCount, String city, String country) {
        this.id = id;
        this.employeeCount = employeeCount;
        this.city = city;
        Country = country;
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


}

