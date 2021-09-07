package com.ironhack.controller;

import com.ironhack.dao.LeadContact;
import com.ironhack.dao.SalesRep;
import com.ironhack.repository.LeadContactRepository;
import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;


@Controller
public class LeadController {

    @Autowired
    LeadContactRepository leadContactRepository;

    public void createLead(LeadContact leadContact) {leadContactRepository.save(leadContact);}

    public LeadContact findById(Long id) {
        Optional<LeadContact> optionalLeadContact = leadContactRepository.findById(id);
        return optionalLeadContact.orElse(null);
    }

    public void printAll() {
        List<LeadContact> leadContacts = leadContactRepository.findAll();
        for (LeadContact leadContact:
                leadContacts) {
            System.out.println(leadContact);
        }
    }


}
