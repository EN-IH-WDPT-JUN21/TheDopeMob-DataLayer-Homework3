package com.ironhack.contact;

import com.ironhack.dao.LeadContact;
import org.junit.jupiter.api.BeforeEach;

class LeadContactTest {

    private LeadContact leadUnderTest;

    @BeforeEach
    void setUp() {
        leadUnderTest = new LeadContact("name", "phoneNumber", "email", "companyName");
    }

}
