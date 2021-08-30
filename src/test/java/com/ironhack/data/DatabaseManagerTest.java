package com.ironhack.data;

import com.ironhack.dao.Contact;
import com.ironhack.dao.Lead;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {
    @BeforeAll
    public static void setUp(){
        DatabaseManager.setContactsDbPath("src/test/java/com/ironhack/databases/test_contacts.json");
        DatabaseManager.setLeadsDbPath("src/test/java/com/ironhack/databases/test_leads.json");
        DatabaseManager.setOpportunitiesDbPath("src/test/java/com/ironhack/databases/test_opportunities.json");
        DatabaseManager.setAccountsDbPath("src/test/java/com/ironhack/databases/test_accounts.json");

    }
    @AfterAll
    public static void tearDown(){
        DatabaseManager.reset();
        DatabaseManager.setContactsDbPath("src/main/java/com/ironhack/databases/contacts.json");
        DatabaseManager.setLeadsDbPath("src/main/java/com/ironhack/databases/leads.json");
        DatabaseManager.setOpportunitiesDbPath("src/main/java/com/ironhack/databases/opportunities.json");
        DatabaseManager.setAccountsDbPath("src/main/java/com/ironhack/databases/accounts.json");
    }

    @Test
    public void reset_method_insert_sample_data_assert_database_is_rested(){
        //Create test data to be saved in leads db file
        Lead l1 = new Lead("Adam Test","1234-555", "A.Test@Example.com", "Example");
        Lead l2 = new Lead("Adam Test","5555555", "A.Test@Example.com", "Example");
        Lead l3 = new Lead("Adam Test","33334343", "A.Test@Example.com", "Example");
        //Adds the data to the Leads List throughout a getter.
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l2);
        DatabaseManager.getLeads().add(l3);
        DatabaseManager.reset();
        assertEquals(0,DatabaseManager.getLeads().size());
    }
    @Test
    public void reset_method_empty_data_assert_database_is_rested(){
        //Set up test env. check if List of Leads is empty
        DatabaseManager.reset();
        assertEquals(0,DatabaseManager.getLeads().size());
        //Reset empty database, assert it wont break and is still empty
        DatabaseManager.reset();
        assertEquals(0,DatabaseManager.getLeads().size());
    }
    @Test
    public void save_method_insert_sample_data_then_assert_its_saved() throws IOException {
        //Create test data to be saved in leads db file
        DatabaseManager.reset();
        Lead l1 = new Lead("Adam Test","1234-555", "A.Test@Example.com", "Example");
        Lead l2 = new Lead("Adam Test","5555555", "A.Test@Example.com", "Example");
        Lead l3 = new Lead("Adam Test","33334343", "A.Test@Example.com", "Example");
        //Adds the data to the Leads List throughout a getter.
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l2);
        DatabaseManager.getLeads().add(l3);
        //Saves the db to a file, if the file exists then it appends it, if it doesn't exists if creates the file and then appends it
        DatabaseManager.save();
        //Getting ready to read lines from the file
        File file = new File(DatabaseManager.getLeadsDbPath());
        if (!file.exists()) {
            throw new FileNotFoundException("no db file!");
        }
        Scanner scn = new Scanner(file);
        StringBuilder loadedContent= new StringBuilder();
        //Reading the file content in a loop, the content should be a json file format
        while (scn.hasNext()) {
            loadedContent.append(scn.nextLine());
        }
        scn.close();
        //Creating a reference object that after parsing it to json should have the same data
        ArrayList<Lead> referenceObject = new ArrayList<Lead>();
        referenceObject.add(l1);
        referenceObject.add(l2);
        referenceObject.add(l3);
        Gson gson = new Gson();
        //Checking if reference object parsed to json is the same string as the content read from the file
        assertEquals(gson.toJson(referenceObject),loadedContent.toString());
    }
    @Test
    public void save_method_saves_to_non_existing_file_assert_file_was_created() throws IOException {
        //Setting up test env, the db files should not exists
        File file = new File(DatabaseManager.getLeadsDbPath());
        if (file.exists() && !file.delete())
            throw new IOException("Can't delete file");
        //First assertion should show that the file doesn't exist, after the save method the file should exist
        assertFalse(file.exists());
        DatabaseManager.save();
        assertTrue(file.exists());
    }
    @Test
    public void save_method_saves_empty_list_assert_saved_file_is_empty() throws IOException {
        //Saves the empty list to a file, if the file exists then it appends it, if it doesn't exists if creates the file and then appends it
        DatabaseManager.reset();
        DatabaseManager.save();
        //Getting ready to read lines from the file, the file should be empty but we will act like some content was written
        File file = new File(DatabaseManager.getLeadsDbPath());
        if (!file.exists()) {
            throw new FileNotFoundException("no db file!");
        }
        Scanner scn = new Scanner(file);
        StringBuilder loadedContent= new StringBuilder();
        //Reading the file content in a loop, the content should be empty
        while (scn.hasNext()) {
            loadedContent.append(scn.nextLine());
        }
        scn.close();
        //Checking if the content read for the file is empty
        assertEquals("[]",loadedContent.toString());
    }
    @Test
    public void save_method_insert_sample_for_leads_and_contacts_save_assert_data_saved() throws IOException {
        //Setting the env. Deleting leads and contacts files.
        DatabaseManager.reset();
        File leadsFile = new File(DatabaseManager.getLeadsDbPath());
        File contactsFile = new File(DatabaseManager.getContactsDbPath());
        if (leadsFile.exists() && !leadsFile.delete())
            throw new IOException("Can't delete db file!");
        if (contactsFile.exists() && !contactsFile.delete())
            throw new IOException("Can't delete db file!");
        //Creating sample data
        Lead l1 = new Lead("Adam Test","1234-555", "A.Test@Example.com", "Example");
        Lead l2 = new Lead("Adam Test","5555555", "A.Test@Example.com", "Example");
        Lead l3 = new Lead("Adam Test","33334343", "A.Test@Example.com", "Example");
        Contact c1 = new Contact("Adam Contact","555434554","A.Con@Ex.com", "Ex1");
        Contact c2 = new Contact("Anna Contact","555434dfv554","A1.Con@Ex.com", "Ex2");
        Contact c3 = new Contact("Mark Contact","5554345fdg54","A2.Con@Ex.com", "Ex3");
        //Adding sample data to DatabaseManager
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l2);
        DatabaseManager.getLeads().add(l3);
        DatabaseManager.getContacts().add(c1);
        DatabaseManager.getContacts().add(c2);
        DatabaseManager.getContacts().add(c3);
        //Saving the data
        assertTrue(!leadsFile.exists() && !contactsFile.exists());
        DatabaseManager.save();
        //Reading from files
        Scanner scn = new Scanner(leadsFile);
        StringBuilder leadSB = new StringBuilder();
        while (scn.hasNext()) {
            leadSB.append(scn.nextLine());
        }
        scn.close();
        scn = new Scanner(contactsFile);
        StringBuilder contactSB = new StringBuilder();
        while (scn.hasNext()) {
            contactSB.append(scn.nextLine());
        }
        scn.close();
        //Creating reference Lists of Leads and Contacts
        Gson gson = new Gson();
        ArrayList<Lead> leadRef = new ArrayList<Lead>();
        ArrayList<Contact> contactRef = new ArrayList<Contact>();
        leadRef.add(l1);
        leadRef.add(l2);
        leadRef.add(l3);
        contactRef.add(c1);
        contactRef.add(c2);
        contactRef.add(c3);
        //Assert read data and reference data are same
        assertEquals(leadSB.toString(),gson.toJson(leadRef));
        assertEquals(contactSB.toString(),gson.toJson(contactRef));
    }
    @Test
    public void load_method_insert_sample_data_save_then_reset_then_load_assert_it_loaded() throws IOException {
        //Setting up test env. Reset data, delete files
        File file = new File(DatabaseManager.getLeadsDbPath());
        if (file.exists() && !file.delete())
            throw new IOException("Can't delete db file!");
        DatabaseManager.reset();
        //Creating sample data
        Lead l1 = new Lead("Adam Test","1234-555", "A.Test@Example.com", "Example1");
        Lead l2 = new Lead("Anna Test","5555555", "An.Test@Example.com", "Example2");
        Lead l3 = new Lead("Julia Test","33334343", "J.Test@Example.com", "Example3");
        Lead l4 = new Lead("Daniel Test","1234-555", "D.Test@Example.com", "Example4");
        Lead l5 = new Lead("Martin Test","5555555", "M.Test@Example.com", "Example5");
        Lead l6 = new Lead("Adrian Test","33334343", "Ad.Test@Example.com", "Example6");
        //Inserting sample data
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l2);
        DatabaseManager.getLeads().add(l3);
        DatabaseManager.getLeads().add(l4);
        DatabaseManager.getLeads().add(l5);
        DatabaseManager.getLeads().add(l6);
        //Saving state
        assertFalse(file.exists());
        DatabaseManager.save();
        assertTrue(file.exists());
        //Resetting DatabaseManager
        DatabaseManager.reset();
        assertEquals(0,DatabaseManager.getLeads().size());
        //Loading data from file
        DatabaseManager.load();
        //Creating reference List for equal assertion
        ArrayList<Lead> referenceObject = new ArrayList<>();
        referenceObject.add(l1);
        referenceObject.add(l2);
        referenceObject.add(l3);
        referenceObject.add(l4);
        referenceObject.add(l5);
        referenceObject.add(l6);
        //Asserting loaded data is the same as the sample one
        assertEquals(referenceObject,DatabaseManager.getLeads());
    }
    @Test
    public void UseCase_add_and_save_data_few_times_reset_and_load_each_save_assert_manage_data_properly() throws IOException {
        //Setting the test env. Resetting the db, deleting files
        DatabaseManager.reset();
        File leadsFile = new File(DatabaseManager.getLeadsDbPath());
        File contactsFile = new File(DatabaseManager.getContactsDbPath());
        if (leadsFile.exists() && !leadsFile.delete())
            throw new IOException("Can't delete db file!");
        if (contactsFile.exists() && !contactsFile.delete())
            throw new IOException("Can't delete db file!");
        //Create and add sample data
        Lead l1 = new Lead("Use Case Test","10000","U.Case@Test.com","UCase1");
        DatabaseManager.getLeads().add(l1);
        //Save 1 object
        assertFalse(leadsFile.exists());
        DatabaseManager.save();
        assertTrue(leadsFile.exists());
        //Reset
        DatabaseManager.reset();
        //Load 1 object
        DatabaseManager.load();
        assertEquals(1,DatabaseManager.getLeads().size());
        //Add another object
        Lead l2 = new Lead("Need Sleep","10000-no","Sleep.Me@Test.com","UCase2");
        DatabaseManager.getLeads().add(l2);
        //save
        assertTrue(leadsFile.exists());
        DatabaseManager.save();
        //Add another without reset
        assertEquals(2,DatabaseManager.getLeads().size());
        //load 2 objects
        DatabaseManager.load();
        //Add 3rd object
        Lead l3 = new Lead("Last lead","10000-no","Last.lead@Test.com","UCase3");
        DatabaseManager.getLeads().add(l3);
        assertEquals(3,DatabaseManager.getLeads().size());
        //save
        DatabaseManager.save();
        //reset
        DatabaseManager.reset();
        //Add items that will be gone after load method
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l2);
        DatabaseManager.getLeads().add(l1);
        DatabaseManager.getLeads().add(l3);
        DatabaseManager.getLeads().add(l3);
        //load without saving the previous step
        DatabaseManager.load();
        //Creating reference object
        ArrayList<Lead> reference = new ArrayList<>();
        reference.add(l1);
        reference.add(l2);
        reference.add(l3);
        //Assert Database loads 3 objects from file and is equal to reference objects are equal
        assertEquals(reference,DatabaseManager.getLeads());
    }

}