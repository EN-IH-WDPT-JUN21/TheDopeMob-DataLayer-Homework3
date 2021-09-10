package com.ironhack.controller;

import com.ironhack.converter.*;
import com.ironhack.dao.Opportunity;
import com.ironhack.enums.Status;
import com.ironhack.repository.OpportunityRepository;
import com.ironhack.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
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

    public void findOpportunitiesBySalesRep() {
        List<OpportunityCountBySalesRep> opportunityList = opportunityRepository.countBySalesRep();
        if(opportunityList.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            for(OpportunityCountBySalesRep opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void findWonOpportunitiesBySalesRep() {
        List<OpportunityCountBySalesRep> opportunityList = opportunityRepository.countCloseWonBySalesRep();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountBySalesRep opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void findLostOpportunitiesBySalesRep() {
        List<OpportunityCountBySalesRep> opportunityList = opportunityRepository.countCloseLostBySalesRep();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountBySalesRep opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void findOpenOpportunitiesBySalesRep() {
        List<OpportunityCountBySalesRep> opportunityList = opportunityRepository.countOpenBySalesRep();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountBySalesRep opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countByProduct() {
        List<OpportunityCountByProduct> opportunityList = opportunityRepository.countByProduct();
        if(opportunityList.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            for(OpportunityCountByProduct opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countWonByProduct() {
        List<OpportunityCountByProduct> opportunityList = opportunityRepository.countClosedWonByProduct();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountByProduct opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countLostByProduct() {
        List<OpportunityCountByProduct> opportunityList = opportunityRepository.countClosedLostByProduct();
        if(opportunityList.isEmpty()) System.out.println("There are no close-lost opportunities in the database");
        else{
            for(OpportunityCountByProduct opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countOpenByProduct() {
        List<OpportunityCountByProduct> opportunityList = opportunityRepository.countOpenByProduct();
        if(opportunityList.isEmpty()) System.out.println("There are no open opportunities in the database");
        else{
            for(OpportunityCountByProduct opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countByCountry() {
        List<OpportunityCountByCountry> opportunityList = opportunityRepository.countByCountry();
        if(opportunityList.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            for(OpportunityCountByCountry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countWonByCountry() {
        List<OpportunityCountByCountry> opportunityList = opportunityRepository.countClosedWonByCountry();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountByCountry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countLostByCountry() {
        List<OpportunityCountByCountry> opportunityList = opportunityRepository.countClosedLostByCountry();
        if(opportunityList.isEmpty()) System.out.println("There are no close-lost opportunities in the database");
        else{
            for(OpportunityCountByCountry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countOpenByCountry() {
        List<OpportunityCountByCountry> opportunityList = opportunityRepository.countOpenByCountry();
        if(opportunityList.isEmpty()) System.out.println("There are no open opportunities in the database");
        else{
            for(OpportunityCountByCountry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countByCity() {
        List<OpportunityCountByCity> opportunityList = opportunityRepository.countByCity();
        if(opportunityList.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            for(OpportunityCountByCity opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countWonByCity() {
        List<OpportunityCountByCity> opportunityList = opportunityRepository.countClosedWonByCity();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountByCity opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countLostByCity() {
        List<OpportunityCountByCity> opportunityList = opportunityRepository.countClosedLostByCity();
        if(opportunityList.isEmpty()) System.out.println("There are no close-lost opportunities in the database");
        else{
            for(OpportunityCountByCity opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countOpenByCity() {
        List<OpportunityCountByCity> opportunityList = opportunityRepository.countOpenByCity();
        if(opportunityList.isEmpty()) System.out.println("There are no open opportunities in the database");
        else{
            for(OpportunityCountByCity opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countByIndustry() {
        List<OpportunityCountByIndustry> opportunityList = opportunityRepository.countByIndustry();
        if(opportunityList.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            for(OpportunityCountByIndustry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countWonByIndustry() {
        List<OpportunityCountByIndustry> opportunityList = opportunityRepository.countClosedWonByIndustry();
        if(opportunityList.isEmpty()) System.out.println("There are no close-won opportunities in the database");
        else{
            for(OpportunityCountByIndustry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countLostByIndustry() {
        List<OpportunityCountByIndustry> opportunityList = opportunityRepository.countClosedLostByIndustry();
        if(opportunityList.isEmpty()) System.out.println("There are no close-lost opportunities in the database");
        else{
            for(OpportunityCountByIndustry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void countOpenByIndustry() {
        List<OpportunityCountByIndustry> opportunityList = opportunityRepository.countOpenByIndustry();
        if(opportunityList.isEmpty()) System.out.println("There are no open opportunities in the database");
        else{
            for(OpportunityCountByIndustry opportunity : opportunityList) {
                System.out.println(opportunity);
            }
        }
    }

    public void updateCloseWon(Long id) {
        opportunityService.updateCloseWon(id);
    }

    public void updateCloseLost(Long id) {
        opportunityService.updateCloseLost(id);

    }
}
