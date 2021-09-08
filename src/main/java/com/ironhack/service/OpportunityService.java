package com.ironhack.service;

import com.ironhack.dao.Opportunity;
import com.ironhack.enums.Status;
import com.ironhack.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void updateCloseWon(Long id) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);
        if(optionalOpportunity.isPresent()) {
            optionalOpportunity.get().setStatus(Status.CLOSED_WON);
            opportunityRepository.save(optionalOpportunity.get());
        } else {
            System.out.println("\nNo opportunity with that id");
        }
    }

    public void updateCloseLost(Long id) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(id);
        if(optionalOpportunity.isPresent()) {
            optionalOpportunity.get().setStatus(Status.CLOSED_LOST);
            opportunityRepository.save(optionalOpportunity.get());
        } else {
            System.out.println("\nNo opportunity with that id");
        }
    }
}
