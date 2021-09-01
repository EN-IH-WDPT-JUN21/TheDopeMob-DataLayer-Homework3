package com.ironhack.contact;

import com.ironhack.dao.Contact;
import org.junit.jupiter.api.BeforeEach;

class ContactTest {

    private Contact contactUnderTest;

    @BeforeEach
    void setUp() {
        contactUnderTest = new Contact("name", "phoneNumber", "email", "companyName");
    }
}
