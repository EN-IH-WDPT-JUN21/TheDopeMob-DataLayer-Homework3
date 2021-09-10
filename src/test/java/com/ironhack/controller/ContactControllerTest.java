package com.ironhack.controller;

import com.ironhack.dao.Contact;
import com.ironhack.repository.ContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactControllerTest {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactController contactController;

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        contactRepository.deleteAll();
    }

    @Test
    void createContact_positive_contactCreated() {
        Contact contact = new Contact("testName1", "123456789", "test@data.com", "compName");
        Contact createdContact = contactController.createContact(contact);
        assertEquals(contact.getEmail(), createdContact.getEmail());
        assertEquals(1, contactRepository.findAll().size());
    }

    @Test
    void createContact_positive_contactAlredyInDB() {
        Contact contact1 = new Contact("testName1", "123456789", "test@data.com", "compName");
        Contact contact2 = new Contact("testName2", "123456789", "test@data.com", "compName2");
        contactController.createContact(contact1);
        //contact2 should not be created, because it shares the same email as contact1, therefore return from this method should be contact1
        Contact foundContact = contactController.createContact(contact2);
        assertEquals(contact1.getName(), foundContact.getName());
        //contact2 was not created, so only one should exist in the db
        assertEquals(1, contactRepository.findAll().size());
    }

    @Test
    void createContact_negative_passingNull() {
        assertThrows(NullPointerException.class, () -> {
            contactController.createContact(null);
        });
        assertEquals(0, contactRepository.findAll().size());
    }

    @Test
    void findByEmail_positive_contactFound() {
        Contact contact1 = new Contact("testName1", "123456789", "test@data.com", "compName");
        contactRepository.save(contact1);
        Contact foundContact = contactController.findByEmail("test@data.com");
        assertEquals(contact1.getName(), foundContact.getName());
    }

    @Test
    void findByEmail_positive_nullFound() {
        Contact contact1 = new Contact("testName1", "123456789", "test@data.com", "compName");
        contactRepository.save(contact1);
        Contact foundContact = contactController.findByEmail("testBADDATA@data.com");
        assertNull(foundContact);
    }
    @Test
    void findByEmail_negative_passNullToFind() {
        Contact contact1 = new Contact("testName1", "123456789", "test@data.com", "compName");
        contactRepository.save(contact1);
        Contact foundContact = contactController.findByEmail(null);
        assertNull(foundContact);
    }
}