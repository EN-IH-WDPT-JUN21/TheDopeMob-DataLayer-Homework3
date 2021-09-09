package com.ironhack.data;

import com.ironhack.controller.LeadController;
import com.ironhack.controller.SalesRepController;
import com.ironhack.dao.LeadContact;
import com.ironhack.dao.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Register {

    @Autowired
    Helper helper;

    @Autowired
    SalesRepController salesRepController;

    @Autowired
    LeadController leadController;
    public void newSalesRep() {
        String tempName = helper.setName();
        SalesRep tempSalesRep = new SalesRep(tempName);
        salesRepController.createSalesRep(tempSalesRep);
    }

    public void newLead() {

        String tempName = helper.setName();
        String tempPhoneNumber = helper.setPhone();
        String tempEmail = helper.setEmail();
        String tempCompanyName = helper.setCompanyName();
        SalesRep tempSalesRep;

        if(salesRepController.findAll().isEmpty()) {
            System.out.println("\nThere is no sales rep in the database\nPlease create one");
            newSalesRep();
        }
        tempSalesRep = helper.setSalesRep();

        LeadContact tempLead = new LeadContact(tempSalesRep, tempName, tempPhoneNumber, tempEmail, tempCompanyName);

        leadController.createLead(tempLead);
    }
}
