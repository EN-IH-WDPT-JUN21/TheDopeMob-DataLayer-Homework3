package com.ironhack.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactInfoTest {

    private ContactInfo contactInfoUnderTest;

    @BeforeEach
    void setUp() {
        contactInfoUnderTest = new ContactInfo("name", "phoneNumber", "email", "companyName") {
        };
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = contactInfoUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    void testEquals() {
        // Setup

        // Run the test
        final boolean result = contactInfoUnderTest.equals("o");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testHashCode() {
        // Setup

        // Run the test
        final int result = contactInfoUnderTest.hashCode();

        // Verify the results
        assertEquals(0, result);
    }
}
