package com.ironhack.controller;

import com.ironhack.dao.Contact;
import com.ironhack.dao.Opportunity;
import com.ironhack.dao.SalesRep;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.repository.ContactRepository;
import com.ironhack.repository.OpportunityRepository;
import com.ironhack.repository.SalesRepRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpportunityControllerTest {

    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    OpportunityController opportunityController;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SalesRepRepository salesRepRepository;

    private SalesRep salesRep;
    private Contact contact;

    @BeforeEach
    void setUp() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();

        salesRep = new SalesRep("TestSalesRep");
        salesRepRepository.save(salesRep);
        contact = new Contact("testName1", "123456789", "test@data.com", "compName");
        contactRepository.save(contact);

    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
    }

    @Test
    void createOpportunity_positive_opportunityCreated() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.CLOSED_LOST,null);
        opportunityController.createOpportunity(opp1);
        assertEquals(1,opportunityRepository.findAll().size());
    }
    @Test
    void createOpportunity_negative_nullPassed() {
        assertThrows(IllegalArgumentException.class, ()->{opportunityController.createOpportunity(null);});
    }

    @Test
    void findById_positive_opportunityFound() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.CLOSED_LOST,null);
        opportunityController.createOpportunity(opp1);
        Long id = opportunityRepository.findAll().get(0).getOpportunityId();
        assertEquals(opp1.getOpportunityId(),id);
    }
    @Test
    void findById_negative_notFound() {
        assertNull(opportunityController.findById(99999L));
    }

    @Test
    void updateCloseWon_positive_statusUpdated() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.CLOSED_LOST,null);
        opportunityController.createOpportunity(opp1);
        assertEquals(Status.CLOSED_LOST,opportunityRepository.findAll().get(0).getStatus(),"Error adding opportunity to db");
        Long id = opportunityRepository.findAll().get(0).getOpportunityId();
        opportunityController.updateCloseWon(id);
        assertEquals(Status.CLOSED_WON,opportunityRepository.findAll().get(0).getStatus());
    }
    @Test
    void updateCloseWon_negative_idNotFound() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.CLOSED_LOST,null);
        opportunityController.createOpportunity(opp1);
        assertEquals(Status.CLOSED_LOST,opportunityRepository.findAll().get(0).getStatus(),"Error adding opportunity to db");
        opportunityController.updateCloseWon(77777L);
        assertEquals(Status.CLOSED_LOST,opportunityRepository.findAll().get(0).getStatus());
    }

    @Test
    void updateCloseLost_positive_statusUpdated() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.OPEN,null);
        opportunityController.createOpportunity(opp1);
        assertEquals(Status.OPEN,opportunityRepository.findAll().get(0).getStatus(),"Error adding opportunity to db");
        Long id = opportunityRepository.findAll().get(0).getOpportunityId();
        opportunityController.updateCloseLost(id);
        assertEquals(Status.CLOSED_LOST,opportunityRepository.findAll().get(0).getStatus());
    }
    @Test
    void updateCloseLost_negative_idNotFound() {
        Opportunity opp1 = new Opportunity(salesRep,contact, Product.BOX,100, Status.OPEN,null);
        opportunityController.createOpportunity(opp1);
        assertEquals(Status.OPEN,opportunityRepository.findAll().get(0).getStatus(),"Error adding opportunity to db");
        opportunityController.updateCloseLost(77777L);
        assertEquals(Status.OPEN,opportunityRepository.findAll().get(0).getStatus());
    }
}