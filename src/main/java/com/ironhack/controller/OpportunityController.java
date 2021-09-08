package com.ironhack.controller;

import com.ironhack.dao.Opportunity;
import com.ironhack.enums.Status;
import com.ironhack.repository.OpportunityRepository;
import com.ironhack.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class OpportunityController {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    OpportunityService opportunityService;

    public void createOpportunity(Opportunity opportunity) {opportunityRepository.save(opportunity);}

    public Opportunity findById(Long id) {
        Optional<Opportunity> foundOpportunity = opportunityRepository.findById(id);
        return foundOpportunity.orElse(null);
    }

    public void updateCloseWon(Long id) {
        opportunityService.updateCloseWon(id);
    }

    public void updateCloseLost(Long id) {
        opportunityService.updateCloseLost(id);

    }
}
