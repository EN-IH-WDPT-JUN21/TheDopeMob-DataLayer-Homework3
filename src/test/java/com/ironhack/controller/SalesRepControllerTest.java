package com.ironhack.controller;

import com.ironhack.dao.LeadContact;
import com.ironhack.dao.SalesRep;
import com.ironhack.repository.SalesRepRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SalesRepControllerTest {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    SalesRepController salesRepController;

    @BeforeEach
    void setUp() {
        salesRepRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
    }

    @Test
    void createSalesRep_positive_salesRepCreated() {
        SalesRep salesRep = new SalesRep("Test One");
        salesRepController.createSalesRep(salesRep);
        assertEquals(1,salesRepRepository.findAll().size());
    }
    @Test
    void createSalesRep_negative_salesRepAlreadyCreated() {
        SalesRep salesRep = new SalesRep("Test One");
        salesRepController.createSalesRep(salesRep);
        SalesRep salesRepDupl = new SalesRep("Test One");
        salesRepController.createSalesRep(salesRepDupl);
        assertEquals(1,salesRepRepository.findAll().size());
    }

    @Test
    void findById_positive_salesRepFound() {
        SalesRep salesRep = new SalesRep("Test One");
        salesRepRepository.save(salesRep);
        Long id = salesRepRepository.findAll().get(0).getSalesRepId();
        SalesRep foundSalesRep = salesRepController.findById(id);
        assertEquals(salesRep.getName(),foundSalesRep.getName());
    }
    @Test
    void findById_negative_salesRepNotFound() {
        assertNull(salesRepController.findById(88888L));
    }

    @Test
    void printAll_positive_correctlyPrinted() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        SalesRep salesRep1 = new SalesRep("Test One");
        SalesRep salesRep2 = new SalesRep("Test Two");
        salesRepRepository.save(salesRep1);
        salesRepRepository.save(salesRep2);
        salesRepController.printAll();
        assertEquals(salesRep1.toString()+"\n"+salesRep2.toString(),outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
    @Test
    void printAll_negative_printEmpty() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        salesRepController.printAll();
        assertEquals("",outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
}