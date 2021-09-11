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

import java.util.ArrayList;
import java.util.List;

@Component
public class Operator {

    @Autowired
    Helper helper;

    public void convertLead(String leadIdToConvert) {
        final Long leadId = Long.parseLong(leadIdToConvert);
        // Find lead by id and create Contact from it
        LeadContact leadToConvert = helper.leadController.findById(leadId);
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
            //Req 12,13,14 linking account with Opportunity or creating a new account
            String pickedOptionForCreatingNewAccount;
            //If there's no account available there's no need to ask if you want to link to the existing one, since you would have nothing to pick from
            if (helper.accountController.findAllAccounts().size() == 0)
            //"Y" is for creating a new account
            {System.out.println("There's no accounts available!");
                pickedOptionForCreatingNewAccount="Y";}
            else
            //this guarantees that the user will input only from the available options
            {pickedOptionForCreatingNewAccount = Commons.GetStringFromUserFromAvailable("Would you like to create a new Account? (Y/N)",new String[]{"Y","N"});}
            Account accountForOpportunity;
            //Here the code splits for the option you picked earlier
            if(pickedOptionForCreatingNewAccount.equals("N")){
                //Link with the existing account
                List<Account> accounts =  helper.accountController.findAllAccounts();
                System.out.println("Please associate an account with the contact and opportunity!");
                List<Long> accountIDs = new ArrayList<>();
                for (Account account: accounts) {
                    System.out.println(account.getAccountId()+". "+account.getCompanyName());
                    accountIDs.add(account.getAccountId());
                }
                //Commons class method guarantee that a correct input is picked.
                Long pickedAccountID = Commons.GetLongFromUserFromAvailableOptions("Pick one of the existing accounts!",accountIDs);
                accountForOpportunity = helper.accountController.findById(pickedAccountID);
            }
            else {
                //This code executes if the user selected that he wants to create a new account or there's no account available
                // Gather arguments to create new Account
                System.out.println("Creating new account!");
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
                accountForOpportunity = helper.accountController.createAccount(newAccount);
            }
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
            helper.leadController.deleteLead(leadId);
        }

    }

    public void closeWon(String opportunityId) {
        helper.opportunityController.updateCloseWon(Long.parseLong(opportunityId));
    }

    public void closeLost(String opportunityId) {
        helper.opportunityController.updateCloseLost(Long.parseLong(opportunityId));
    }
}
