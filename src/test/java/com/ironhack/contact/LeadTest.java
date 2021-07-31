package com.ironhack.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeadTest {

    private Lead leadUnderTest;

    @BeforeEach
    void setUp() {
        leadUnderTest = new Lead("name", "phoneNumber", "email", "companyName");
    }

}
