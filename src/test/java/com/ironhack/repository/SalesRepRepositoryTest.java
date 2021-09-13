package com.ironhack.repository;

import com.ironhack.CRMApplication;
import com.ironhack.dao.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesRepRepositoryTest {

    @MockBean
    CRMApplication crmApplication;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        salesRepRepository.deleteAll();
        SalesRep salesRep1 = new SalesRep("Hugo Carvajal");
        SalesRep salesRep2 = new SalesRep("Alfredo Kraus");
        SalesRep salesRep3 = new SalesRep("Alberto Fujimori");
        salesRepRepository.saveAll(List.of(salesRep1, salesRep2, salesRep3));
    }

    @AfterEach
    void tearDown() {
        salesRepRepository.deleteAll();
    }

    @Test
    void findByNameTest() {
        Optional<SalesRep> foundSalesRep = salesRepRepository.findByName("Alfredo Kraus");

        assertEquals("Alfredo Kraus", foundSalesRep.get().getName());
    }
}