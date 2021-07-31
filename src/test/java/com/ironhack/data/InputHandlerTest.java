package com.ironhack.data;

import com.ironhack.contact.Lead;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @BeforeAll
    static void setForAll() {
        // Set test databases and their state
        DatabaseManager.setLeadsDbPath("test_leads.json");
        DatabaseManager.setContactsDbPath("test_contacts.json");
        DatabaseManager.setOpportunitiesDbPath("test_opportunities.json");
        DatabaseManager.load();
        DatabaseManager.reset();
        DatabaseManager.save();
        DatabaseManager.addLead(new Lead("Test Lead", "123456789", "hola@something.io", "The Dope Mob" ));
        DatabaseManager.save();

    }

    @AfterAll
    static void restoreDefaultState() {
        // Restore default state and databases
        DatabaseManager.reset();
        DatabaseManager.save();
        DatabaseManager.setContactsDbPath("contacts.json");
        DatabaseManager.setLeadsDbPath("leads.json");
        DatabaseManager.setOpportunitiesDbPath("opportunities.json");
    }

    @AfterEach
    void tearDown() {
        // Restore standard input and output to default after each test
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Should accept valid name")
    void setNameTest() {
        System.setIn(new ByteArrayInputStream("Mickey Rourke".getBytes()));
        String validName = InputHandler.setName();
        assertEquals("Mickey Rourke", validName);
    }

    @Test
    @DisplayName("Should accept valid phone")
    void setPhoneTest() {
        System.setIn(new ByteArrayInputStream("999999999".getBytes()));
        String validPhone = InputHandler.setPhone();
        assertEquals("999999999", validPhone);
    }

    @Test
    @DisplayName("Should accept valid email")
    void setEmailTest() {
        System.setIn(new ByteArrayInputStream("hola@something.io".getBytes()));
        String validEmail = InputHandler.setEmail();
        assertEquals("hola@something.io", validEmail);
    }

    @Test
    @DisplayName("Should accept valid company name")
    void setCompanyNameTest() {
        System.setIn(new ByteArrayInputStream("Burton Global".getBytes()));
        String validCompanyName = InputHandler.setCompanyName();
        assertEquals("Burton Global", validCompanyName);
    }

    @Test
    @DisplayName("Should print leads")
    void showLeadsTest() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputHandler.showLeads();
        assertEquals("[{id=1, name='Test Lead', phoneNumber='123456789', email='hola@something.io', companyName='The Dope Mob'}]", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Should look up lead")
    void lookupLeadTest() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputHandler.lookupLeads("1");
        assertEquals("{id=1, name='Test Lead', phoneNumber='123456789', email='hola@something.io', companyName='The Dope Mob'}", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Should convert lead to opportunity")
    void convertLeadToOpportunity() {
        InputHandler.convertId("1");
        assertTrue(DatabaseManager.getOpportunities().size() == 1);
    }

}