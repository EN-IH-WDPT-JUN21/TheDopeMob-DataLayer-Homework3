package com.ironhack.contact;

import com.ironhack.dao.Lead;
import org.junit.jupiter.api.BeforeEach;

class LeadTest {

    private Lead leadUnderTest;

    @BeforeEach
    void setUp() {
        leadUnderTest = new Lead("name", "phoneNumber", "email", "companyName");
    }

}
