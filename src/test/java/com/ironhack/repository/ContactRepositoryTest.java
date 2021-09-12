package com.ironhack.repository;

import com.ironhack.CRMApplication;
import com.ironhack.dao.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @MockBean
    private CRMApplication crmApplication;

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
        Contact contact = new Contact("Narciso Soles", "999999999", "narciso@hola.com", "Flores Hernandez");
        contactRepository.save(contact);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByEmailTest() {
        Optional<Contact> foundContact = contactRepository.findByEmail("narciso@hola.com");
        assertEquals("Narciso Soles", foundContact.get().getName());
    }

}