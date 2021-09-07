package com.ironhack.controller;

import com.ironhack.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OpportunityController {

    @Autowired
    OpportunityRepository opportunityRepository;
}
