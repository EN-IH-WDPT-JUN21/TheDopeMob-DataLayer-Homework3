package com.ironhack.controller;

import com.ironhack.converter.*;
import com.ironhack.dao.Opportunity;
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

    public void meanEmployeeCount() {
        MeanEmployeeCount meanAndCount = opportunityRepository.meanEmployee();
        if(meanAndCount == null) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(meanAndCount);
        }
    }

    public void medianEmployeeCount(){
        List<Median> medianAndCount = opportunityRepository.medianEmployee();
        if(medianAndCount == null) System.out.println("There are no opportunities in the database");
        else{
            Integer medianEmployeeCountIndex = Math.round(medianAndCount.size() / 2);
            System.out.println(medianAndCount.get(medianEmployeeCountIndex));
        }
    }

    public void maxEmployeeCount(){
        List<MaxMin> maxEmployeeCount = opportunityRepository.maxEmployee();
        if(maxEmployeeCount.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(maxEmployeeCount.get(0));
        }
    }

    public void minEmployeeCount(){
        List<MaxMin> minEmployeeCount = opportunityRepository.minEmployee();
        if(minEmployeeCount.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(minEmployeeCount.get(0));
        }
    }

    public void meanQuantity() {
        MeanQuantity meanAndCount = opportunityRepository.meanQuantity();
        if(meanAndCount == null) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(meanAndCount);
        }
    }

    public void medianQuantity(){
        List<Median> medianAndCount = opportunityRepository.medianQuantity();
        if(medianAndCount.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            Integer medianEmployeeCountIndex = Math.round(medianAndCount.size() / 2);
            System.out.println(medianAndCount.get(medianEmployeeCountIndex));
        }
    }

    public void maxQuantity(){
        List<MaxMin> maxQuantity = opportunityRepository.maxQuantity();
        if(maxQuantity.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(maxQuantity.get(0));
        }
    }

    public void minQuantity(){
        List<MaxMin> minQuantity = opportunityRepository.minQuantity();
        if(minQuantity.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(minQuantity.get(0));
        }
    }

    public void meanOpportunityByAccount(){
        MeanOpportunity meanOpportunity = opportunityRepository.meanOpportunity();
        if(meanOpportunity == null) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(meanOpportunity);
        }
    }

    public void medianOpportunityByAccount(){
        List<MedianOpportunity> medianAndCount = opportunityRepository.medianOpportunity();
        if(medianAndCount.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            Integer medianOpportunityIndex = Math.round(medianAndCount.size() / 2);
            System.out.println(medianAndCount.get(medianOpportunityIndex));
        }
    }

    public void maxOppsByAccount(){
        List<MaxMinOpportunity> maxOpportunity = opportunityRepository.maxOpportunity();
        if(maxOpportunity.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(maxOpportunity.get(0));
        }
    }
    public void minOppsByAccount(){
        List<MaxMinOpportunity> minOpportunity = opportunityRepository.minOpportunity();
        if(minOpportunity.isEmpty()) System.out.println("There are no opportunities in the database");
        else{
            System.out.println(minOpportunity.get(0));
        }
    }


    public void updateCloseWon(Long id) {
        opportunityService.updateCloseWon(id);
    }

    public void updateCloseLost(Long id) {
        opportunityService.updateCloseLost(id);

    }
}
