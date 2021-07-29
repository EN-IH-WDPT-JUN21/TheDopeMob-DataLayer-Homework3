package com.ironhack.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeadTest {

    private Lead leadUnderTest;

    @BeforeEach
    void setUp() {
        leadUnderTest = new Lead("name", "phoneNumber", "email", "companyName");
    }

    @Test
    void testConvertLead() {
        // Setup
        final Lead lead = new Lead("name", "phoneNumber", "email", "companyName");

        // Run the test
        leadUnderTest.convertLead(lead);

        // Verify the results
    }
}
