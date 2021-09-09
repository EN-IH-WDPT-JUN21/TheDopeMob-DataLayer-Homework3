package com.ironhack.data;

import com.ironhack.controller.AccountController;
import com.ironhack.controller.ContactController;
import com.ironhack.controller.LeadController;
import com.ironhack.dao.Account;
import com.ironhack.dao.Contact;
import com.ironhack.dao.LeadContact;
import com.ironhack.dao.Opportunity;
import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Operator {

    @Autowired
    Helper helper;

    public void convertLead(String leadId) {
        // Find lead by id and create Contact from it
        LeadContact leadToConvert = helper.leadController.findById(Long.parseLong(leadId));
        if(leadToConvert == null) System.out.println("There is no lead with that id");
        else {
            Contact contactFromLead = new Contact(
                    leadToConvert.getName(),
                    leadToConvert.getPhoneNumber(),
                    leadToConvert.getEmail(),
                    leadToConvert.getCompanyName());

            // Gather arguments to create new Opportunity
            Contact contactForOpportunity = helper.contactController.createContact(contactFromLead);
            Product tempProduct = helper.setProduct();
            int quantityOfProduct = helper.setQuantity();

            // Gather arguments to create new Account
            String companyName = leadToConvert.getCompanyName();
            int employeeCount = helper.setEmployeeCount();
            Industry industryType = helper.setIndustryType();
            String city = helper.setCity();
            String country = helper.setCountry();

            // Create new Account
            Account newAccount = new Account(
                    companyName,
                    employeeCount,
                    industryType,
                    city,
                    country);
            Account accountForOpportunity = helper.accountController.createAccount(newAccount);

            // Create new Opportunity
            Opportunity newOpportunity = new Opportunity(
                    leadToConvert.getSalesRep(),
                    contactForOpportunity,
                    tempProduct,
                    quantityOfProduct,
                    Status.OPEN,
                    accountForOpportunity);

            helper.opportunityController.createOpportunity(newOpportunity);

            // Delete the converted lead
            helper.leadController.deleteLead(Long.parseLong(leadId));
        }

    }

    public void closeWon(String opportunityId) {
        helper.opportunityController.updateCloseWon(Long.parseLong(opportunityId));
    }

    public void closeLost(String opportunityId) {
        helper.opportunityController.updateCloseLost(Long.parseLong(opportunityId));
    }
}
