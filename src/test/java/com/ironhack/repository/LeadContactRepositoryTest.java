package com.ironhack.repository;

import com.ironhack.CRMApplication;
import com.ironhack.dao.LeadContact;
import com.ironhack.dao.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class LeadContactRepositoryTest {

    @MockBean
    private CRMApplication crmApplication;

    @Autowired
    private LeadContactRepository leadContactRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        leadContactRepository.deleteAll();
        salesRepRepository.deleteAll();
        SalesRep salesRep = new SalesRep("Hugo Carvajal");
        salesRepRepository.save(salesRep);
        LeadContact contact = new LeadContact(salesRep, "Lorena Varga", "999999999", "lorena@abogaos.com", "Varga Abogados");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void countBySalesRepTest() {
        Long count = 1L;
        assertEquals(count, leadContactRepository.countBySalesRep().get(0).getCount());
    }
}