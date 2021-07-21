package com.ironhack.databasemanager;

import Lead.Lead;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {
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
}