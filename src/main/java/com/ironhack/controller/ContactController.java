package com.ironhack.controller;

import com.ironhack.dao.Contact;
import com.ironhack.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    public Contact createContact(Contact contact) {
        Optional<Contact> foundContact = contactRepository.findByEmail(contact.getEmail());
        return foundContact.isPresent() ?
                foundContact.get() :
                contactRepository.save(contact);
    }

    public Contact findByEmail(String email) {
        Optional<Contact> foundContact = contactRepository.findByEmail(email);
        return foundContact.orElse(null);
    }
}
