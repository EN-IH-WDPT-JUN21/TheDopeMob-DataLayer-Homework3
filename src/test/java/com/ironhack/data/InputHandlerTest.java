package com.ironhack.data;

import com.ironhack.dao.LeadContact;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @BeforeAll
    static void setForAll() {
        // Set test databases and their state
        DatabaseManager.setLeadsDbPath("src/test/java/com/ironhack/databases/test_accounts.json");
        DatabaseManager.setContactsDbPath("src/test/java/com/ironhack/databases/test_contacts.json");
        DatabaseManager.setOpportunitiesDbPath("src/test/java/com/ironhack/databases/test_opportunities.json");
        DatabaseManager.setAccountsDbPath("src/test/java/com/ironhack/databases/test_accounts.json");
        DatabaseManager.load();
        DatabaseManager.reset();
        DatabaseManager.save();


    }

    @AfterAll
    static void restoreDefaultState() {
        // Restore default state and databases
        DatabaseManager.setContactsDbPath("src/main/java/com/ironhack/databases/contacts.json");
        DatabaseManager.setLeadsDbPath("src/main/java/com/ironhack/databases/leads.json");
        DatabaseManager.setOpportunitiesDbPath("src/main/java/com/ironhack/databases/opportunities.json");
        DatabaseManager.setAccountsDbPath("src/main/java/com/ironhack/databases/accounts.json");
    }

    @BeforeEach
    void setUp() {
        DatabaseManager.addLead(new LeadContact("Test Lead", "123456789", "hola@something.io", "The Dope Mob" ));
        DatabaseManager.save();
    }

    @AfterEach
    void tearDown() {
        // Restore standard input and output to default after each test
        DatabaseManager.reset();
        DatabaseManager.save();
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
    void convertLeadToOpportunityTest() {
        System.setIn(new ByteArrayInputStream("1\n50\n".getBytes()));
        InputHandler.convertId("1");
        assertTrue(DatabaseManager.getOpportunities().size() == 1);
    }

    @Test
    @DisplayName("Should display selected opportunity")
    void lookupOpportunityTest() {
        System.setIn(new ByteArrayInputStream("1\n50\n".getBytes()));
        InputHandler.convertId("1");
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        InputHandler.lookupOpportunity("1");
        assertEquals("Opportunity{id=1, product=HYBRID, quantity=50, contact={id=2, name='Test Lead', phoneNumber='123456789', email='hola@something.io', companyName='The Dope Mob'}, status=OPEN}", outputStreamCaptor.toString().trim());
    }

}