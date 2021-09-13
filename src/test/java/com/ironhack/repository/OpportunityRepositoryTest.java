package com.ironhack.repository;

import com.ironhack.CRMApplication;
import com.ironhack.converter.*;
import com.ironhack.dao.*;
import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityRepositoryTest {

    @MockBean
    private CRMApplication crmApplication;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
        SalesRep salesRep1 = new SalesRep("Hugo Carvajal");
        SalesRep salesRep2 = new SalesRep("Alfredo Kraus");
        SalesRep salesRep3 = new SalesRep("Alberto Fujimori");
        Contact contact1 = new Contact("Lina Ronaldo", "111111111", "hugo@adelante.io", "King Burger");
        Contact contact2 = new Contact("Maria Menez", "222222222", "maria@adelante.io", "Royal Burger");
        Contact contact3 = new Contact("Checa Bolivar", "333333333", "checa@adelante.io", "Master Burger");
        Account account1 = new Account("King Burger", 100, Industry.ECOMMERCE, "Las Vegas", "USA");
        Account account2 = new Account("Royal Burger", 200, Industry.OTHER, "Rome", "Italy");
        Account account3 = new Account("Master Burger", 3000, Industry.ECOMMERCE, "Caracas", "Venezuela");
        Opportunity opportunity1 = new Opportunity(salesRep1, contact1, Product.BOX, 5999, Status.OPEN, account1);
        Opportunity opportunity2 = new Opportunity(salesRep1, contact2, Product.BOX, 150, Status.CLOSED_WON, account2);
        Opportunity opportunity3 = new Opportunity(salesRep2, contact3, Product.FLATBED, 20000, Status.CLOSED_LOST, account3);
        salesRepRepository.saveAll(List.of(salesRep1, salesRep2, salesRep3));
        contactRepository.saveAll(List.of(contact1, contact2, contact3));
        accountRepository.saveAll(List.of(account1, account2, account3));
        opportunityRepository.saveAll(List.of(opportunity1, opportunity2, opportunity3));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    void countBySalesRepTest() {
    List<OpportunityCountBySalesRep> oppsBySalesRep = opportunityRepository.countBySalesRep();
    Long count = 0L;
    for(OpportunityCountBySalesRep opp : oppsBySalesRep) {
        if(opp.getSalesRep().getName().equals("Hugo Carvajal")) {
            count = opp.getCount();
        }
    }
        assertEquals(2L, (long) count);
    }

    @Test
    void countCloseWonBySalesRep() {
        List<OpportunityCountBySalesRep> closeWonBySalesRep = opportunityRepository.countCloseWonBySalesRep();
        Long count = 0L;
        for(OpportunityCountBySalesRep opp : closeWonBySalesRep) {
            if(opp.getSalesRep().getName().equals("Hugo Carvajal")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countCloseLostBySalesRep() {
        List<OpportunityCountBySalesRep> closeLostBySalesRep = opportunityRepository.countCloseLostBySalesRep();
        Long count = 0L;
        for(OpportunityCountBySalesRep opp : closeLostBySalesRep) {
            if(opp.getSalesRep().getName().equals("Alfredo Kraus")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countOpenBySalesRep() {
        List<OpportunityCountBySalesRep> openBySalesRep = opportunityRepository.countOpenBySalesRep();
        Long count = 0L;
        for(OpportunityCountBySalesRep opp : openBySalesRep) {
            if(opp.getSalesRep().getName().equals("Hugo Carvajal")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countByProduct() {
        List<OpportunityCountByProduct> countByProduct = opportunityRepository.countByProduct();
        Long count = 0L;
        for(OpportunityCountByProduct opp : countByProduct) {
            if(opp.getProduct().equals(Product.BOX)) {
                count = opp.getCount();
            }
        }
        assertEquals(2L, count);
    }

    @Test
    void countClosedWonByProduct() {
        List<OpportunityCountByProduct> closedWonByProduct = opportunityRepository.countClosedWonByProduct();
        Long count = 0L;
        for(OpportunityCountByProduct opp : closedWonByProduct) {
            if(opp.getProduct().equals(Product.BOX)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedLostByProduct() {
        List<OpportunityCountByProduct> closedLostByProduct = opportunityRepository.countClosedLostByProduct();
        Long count = 0L;
        for(OpportunityCountByProduct opp : closedLostByProduct) {
            if(opp.getProduct().equals(Product.FLATBED)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countOpenByProduct() {
        List<OpportunityCountByProduct> openByProduct = opportunityRepository.countOpenByProduct();
        Long count = 0L;
        for(OpportunityCountByProduct opp : openByProduct) {
            if(opp.getProduct().equals(Product.BOX)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countByCountry() {
        List<OpportunityCountByCountry> countByCountry = opportunityRepository.countByCountry();
        Long count = 0L;
        for(OpportunityCountByCountry opp : countByCountry) {
            if(opp.getCountry().equals("Italy")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedWonByCountry() {
        List<OpportunityCountByCountry> closedWonByCountry = opportunityRepository.countClosedWonByCountry();
        Long count = 0L;
        for(OpportunityCountByCountry opp : closedWonByCountry) {
            if(opp.getCountry().equals("Italy")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedLostByCountry() {
        List<OpportunityCountByCountry> closedLostByCountry = opportunityRepository.countClosedLostByCountry();
        Long count = 0L;
        for(OpportunityCountByCountry opp : closedLostByCountry) {
            if(opp.getCountry().equals("Venezuela")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countOpenByCountry() {
        List<OpportunityCountByCountry> openByCountry = opportunityRepository.countOpenByCountry();
        Long count = 0L;
        for(OpportunityCountByCountry opp : openByCountry) {
            if(opp.getCountry().equals("USA")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countByCity() {
        List<OpportunityCountByCity> countByCity = opportunityRepository.countByCity();
        Long count = 0L;
        for(OpportunityCountByCity opp : countByCity) {
            if(opp.getCity().equals("Caracas")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedWonByCity() {
        List<OpportunityCountByCity> closedWonByCity = opportunityRepository.countClosedWonByCity();
        Long count = 0L;
        for(OpportunityCountByCity opp : closedWonByCity) {
            if(opp.getCity().equals("Rome")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedLostByCity() {
        List<OpportunityCountByCity> closedLostByCity = opportunityRepository.countClosedLostByCity();
        Long count = 0L;
        for(OpportunityCountByCity opp : closedLostByCity) {
            if(opp.getCity().equals("Caracas")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countOpenByCity() {
        List<OpportunityCountByCity> openByCity = opportunityRepository.countOpenByCity();
        Long count = 0L;
        for(OpportunityCountByCity opp : openByCity) {
            if(opp.getCity().equals("Las Vegas")) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countByIndustry() {
        List<OpportunityCountByIndustry> countByIndustry = opportunityRepository.countByIndustry();
        Long count = 0L;
        for(OpportunityCountByIndustry opp : countByIndustry) {
            if(opp.getIndustry().equals(Industry.ECOMMERCE)) {
                count = opp.getCount();
            }
        }
        assertEquals(2L, count);
    }

    @Test
    void countClosedWonByIndustry() {
        List<OpportunityCountByIndustry> closedWonByIndustry = opportunityRepository.countClosedWonByIndustry();
        Long count = 0L;
        for(OpportunityCountByIndustry opp : closedWonByIndustry) {
            if(opp.getIndustry().equals(Industry.OTHER)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countClosedLostByIndustry() {
        List<OpportunityCountByIndustry> closedLostByIndustry = opportunityRepository.countClosedLostByIndustry();
        Long count = 0L;
        for(OpportunityCountByIndustry opp : closedLostByIndustry) {
            if(opp.getIndustry().equals(Industry.ECOMMERCE)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void countOpenByIndustry() {
        List<OpportunityCountByIndustry> openByIndustry = opportunityRepository.countOpenByIndustry();
        Long count = 0L;
        for(OpportunityCountByIndustry opp : openByIndustry) {
            if(opp.getIndustry().equals(Industry.ECOMMERCE)) {
                count = opp.getCount();
            }
        }
        assertEquals(1L, count);
    }

    @Test
    void meanEmployee() {
        MeanEmployeeCount meanEmployeeCount = opportunityRepository.meanEmployee();

        assertEquals(1100, meanEmployeeCount.getMeanEmployeeCount());
    }

    @Test
    void medianEmployee() {
        List<Median> medianEmployeeCount = opportunityRepository.medianEmployee();

        assertEquals(200, medianEmployeeCount.get(1).getMedian());
    }

    @Test
    void maxEmployee() {
        List<MaxMin> maxEmployeeCount = opportunityRepository.maxEmployee();

        assertEquals(3000, maxEmployeeCount.get(0).getMaxMin());
    }

    @Test
    void minEmployee() {
        List<MaxMin> minEmployeeCount = opportunityRepository.minEmployee();

        assertEquals(100, minEmployeeCount.get(0).getMaxMin());
    }

    @Test
    void meanQuantity() {
        MeanQuantity meanQuantity = opportunityRepository.meanQuantity();

        assertEquals(8716.3333, meanQuantity.getMeanQuantity());
    }

    @Test
    void medianQuantity() {
        List<Median> medianQuantity = opportunityRepository.medianQuantity();

        assertEquals(5999, medianQuantity.get(1).getMedian());
    }

    @Test
    void maxQuantity() {
        List<MaxMin> maxQuantity = opportunityRepository.maxQuantity();

        assertEquals(20000, maxQuantity.get(0).getMaxMin());
    }

    @Test
    void minQuantity() {
        List<MaxMin> minQuantity = opportunityRepository.minQuantity();

        assertEquals(150, minQuantity.get(0).getMaxMin());
    }

    @Test
    void meanOpportunity() {
        MeanOpportunity meanOpportunity = opportunityRepository.meanOpportunity();

        assertEquals(1, meanOpportunity.getMeanOpportunity().doubleValue() /
                                        meanOpportunity.getAccounts());
    }

    @Test
    void medianOpportunity() {
        List<MedianOpportunity> medianOpportunity = opportunityRepository.medianOpportunity();

        assertEquals(1, medianOpportunity.get(1).getMedian());
    }

    @Test
    void maxOpportunity() {
        List<MaxMinOpportunity> maxOpportunity = opportunityRepository.maxOpportunity();

        assertEquals(1, maxOpportunity.get(0).getMaxMin());
    }

    @Test
    void minOpportunity() {
        List<MaxMinOpportunity> minOpportunity = opportunityRepository.minOpportunity();

        assertEquals(1, minOpportunity.get(0).getMaxMin());
    }
}