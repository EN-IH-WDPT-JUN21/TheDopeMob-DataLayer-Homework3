package com.ironhack.data;

import com.ironhack.controller.LeadController;
import com.ironhack.controller.OpportunityController;
import com.ironhack.dao.LeadContact;
import com.ironhack.dao.Opportunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Searcher {

    @Autowired
    LeadController leadController;
    @Autowired
    OpportunityController opportunityController;

    public void findLead(String leadId){
        LeadContact foundLead = leadController.findById(Long.parseLong(leadId));
        if(foundLead == null) System.out.println("There is no lead with that id");
        else System.out.println(foundLead);
    }

    public void findOpportunity(String opportunityId){
        Opportunity foundOpportunity = opportunityController.findById(Long.parseLong(opportunityId));
        if(foundOpportunity == null) System.out.println("There is no opportunity with that id");
        else System.out.println(foundOpportunity);
    }

    public void findAllLeads(){
        leadController.printAll();
    }


}
