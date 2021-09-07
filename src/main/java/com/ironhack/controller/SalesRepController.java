package com.ironhack.controller;

import com.ironhack.dao.SalesRep;
import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SalesRepController {

    @Autowired
    SalesRepRepository salesRepRepository;

    public SalesRep createSalesRep(SalesRep salesRep) {
        Optional<SalesRep> foundSalesRep= salesRepRepository.findByName(salesRep.getName());
        return  foundSalesRep.isPresent() ?
                foundSalesRep.get() :
                salesRepRepository.save(salesRep);
    }

    public SalesRep findById(Long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        return optionalSalesRep.orElse(null);
    }

    public void printAll() {
        List<SalesRep> salesReps = salesRepRepository.findAll();
        for (SalesRep salesRep:
             salesReps) {
            System.out.println(salesRep);
        }
    }
}
