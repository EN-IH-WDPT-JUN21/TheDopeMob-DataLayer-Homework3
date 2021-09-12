package com.ironhack.repository;

import com.ironhack.CRMApplication;
import com.ironhack.converter.OpportunityCountByProduct;
import com.ironhack.converter.OpportunityCountBySalesRep;
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
    }

    @Test
    void countOpenByProduct() {
    }

    @Test
    void countByCountry() {
    }

    @Test
    void countClosedWonByCountry() {
    }

    @Test
    void countClosedLostByCountry() {
    }

    @Test
    void countOpenByCountry() {
    }

    @Test
    void countByCity() {
    }

    @Test
    void countClosedWonByCity() {
    }

    @Test
    void countClosedLostByCity() {
    }

    @Test
    void countOpenByCity() {
    }

    @Test
    void countByIndustry() {
    }

    @Test
    void countClosedWonByIndustry() {
    }

    @Test
    void countClosedLostByIndustry() {
    }

    @Test
    void countOpenByIndustry() {
    }

    @Test
    void meanEmployee() {
    }

    @Test
    void medianEmployee() {
    }

    @Test
    void maxEmployee() {
    }

    @Test
    void minEmployee() {
    }

    @Test
    void meanQuantity() {
    }

    @Test
    void medianQuantity() {
    }

    @Test
    void maxQuantity() {
    }

    @Test
    void minQuantity() {
    }

    @Test
    void meanOpportunity() {
    }

    @Test
    void medianOpportunity() {
    }

    @Test
    void maxOpportunity() {
    }

    @Test
    void minOpportunity() {
    }
}