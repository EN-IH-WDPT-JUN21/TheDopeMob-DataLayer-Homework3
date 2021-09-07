package com.ironhack.controller;

import com.ironhack.dao.Opportunity;
import com.ironhack.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OpportunityController {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void createOpportunity(Opportunity opportunity) {opportunityRepository.save(opportunity);}
}
