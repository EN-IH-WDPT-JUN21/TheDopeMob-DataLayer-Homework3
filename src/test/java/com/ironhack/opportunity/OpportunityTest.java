//package com.ironhack.opportunity;
//
//import com.ironhack.dao.Contact;
//import com.ironhack.dao.Opportunity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//class OpportunityTest {
//
//    @Mock
//    private Contact mockContact;
//
//    private Opportunity opportunityUnderTest;
//
//    @BeforeEach
//    void setUp() {
//        initMocks(this);
//        opportunityUnderTest = new Opportunity(1, 0, mockContact);
//    }
//
//    @Test
//    void testOpportunityLost() {
//        // Setup
//
//        // Run the test
//        opportunityUnderTest.opportunityLost();
//
//        // Verify the results
//    }
//
//    @Test
//    void testOpportunityWon() {
//        // Setup
//
//        // Run the test
//        opportunityUnderTest.opportunityWon();
//
//        // Verify the results
//    }
//
//    @Test
//    void testToString() {
//        // Setup
//
//        // Run the test
//        final String result = opportunityUnderTest.toString();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//}
