package com.ironhack.controller;

import com.ironhack.dao.LeadContact;
import com.ironhack.repository.LeadContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LeadControllerTest {
    @Autowired
    LeadContactRepository leadContactRepository;
    @Autowired
    LeadController leadController;

    @BeforeEach
    void setUp() {
        leadContactRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        leadContactRepository.deleteAll();
    }

    @Test
    void createLead_positive_leadCreated() {
        LeadContact lead = new LeadContact(null,"new lead","123456789","me@me.com","none");
        leadController.createLead(lead);
        assertEquals(1,leadContactRepository.findAll().size());
        assertEquals("me@me.com",leadContactRepository.findAll().get(0).getEmail());
    }
    @Test
    void createLead_negative_nullPassed() {
        assertThrows(IllegalArgumentException.class, ()->{leadController.createLead(null);});
    }

    @Test
    void findById_positive_leadFound() {
        LeadContact lead = new LeadContact(null,"new lead","123456789","me@me.com","none");
        leadContactRepository.save(lead);
        Long id = leadContactRepository.findAll().get(0).getLeadId();
        assertEquals("new lead",leadController.findById(id).getName());
    }
    @Test
    void findById_negative_leadNotFound(){
        assertNull(leadController.findById(99999L));
    }

    @Test
    void printAll_positive_correctlyPrinted() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        LeadContact lead1 = new LeadContact(null,"new lead","123456789","me@me.com","none");
        LeadContact lead2 = new LeadContact(null,"new lead2","123456789","me2@me.com","none2");
        leadContactRepository.save(lead1);
        leadContactRepository.save(lead2);
        leadController.printAll();
        assertEquals(lead1.toString()+"\n"+lead2.toString(),outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
    @Test
    void printAll_negative_printedEmpty() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        leadController.printAll();
        assertEquals("",outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
    @Test
    void deleteLead_positive_leadDeleted(){
        LeadContact lead1 = new LeadContact(null,"new lead","123456789","me@me.com","none");
        LeadContact lead2 = new LeadContact(null,"new lead2","123456789","me2@me.com","none2");
        leadContactRepository.save(lead1);
        leadContactRepository.save(lead2);
        assertEquals(2,leadContactRepository.findAll().size(),"Error before method test, problem with saving leads.");
        Long idToDelete = leadContactRepository.findAll().get(0).getLeadId();
        leadController.deleteLead(idToDelete);
        assertEquals(1,leadContactRepository.findAll().size());
    }
}