package com.ironhack.data;

import com.ironhack.contact.Contact;
import com.ironhack.contact.ContactInfo;
import com.ironhack.contact.Lead;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class DatabaseManager {
    private static final String LEADS_DB_PATH = "leads.json";
    private static final String CONTACTS_DB_PATH = "contacts.json";

    private static final ArrayList<Lead> leads = new ArrayList<>();
    private static final ArrayList<ContactInfo> contacts = new ArrayList<>();

    public static ArrayList<Lead> getLeads() {
        return leads;
    }
    public static ArrayList<ContactInfo> getContacts() {
        return contacts;
    }

    public static String getLeadsDbPath() {
        return LEADS_DB_PATH;
    }

    public static String getContactsDbPath() {
        return CONTACTS_DB_PATH;
    }



    public static void save() throws IOException {
        saveDB(LEADS_DB_PATH, leads);
        saveDB(CONTACTS_DB_PATH, contacts);
    }
    public static void reset(){
        leads.clear();
        contacts.clear();
    }
    private static void appendFile(File file, Object content) throws IOException {
            Gson gson = new Gson();
            FileWriter fw = new FileWriter(file);
            fw.append(gson.toJson(content));
            fw.close();
    }
    private static void saveDB(String filePath, Object content) throws IOException {
        File file = new File(filePath);
        if (file.exists()){ appendFile(file, content); }
        else{
            if (!file.createNewFile()) {throw new IOException("Can't create DB file!");}
            else {
                appendFile(file, content);}
        }
    }

    public static void load() throws IOException {
        loadDB(LEADS_DB_PATH, leads, new Lead[]{});
        loadDB(CONTACTS_DB_PATH, contacts, new Contact[]{});
    }
    private static void loadDB(String filePath, ArrayList destination, Object[] tmpType) throws IOException {
        File leadsDBFile = new File(filePath);
        if (leadsDBFile.exists()){
            Scanner scn = new Scanner(leadsDBFile);
            StringBuilder content = new StringBuilder();
            while (scn.hasNext()){
                content.append(scn.nextLine());
            }
            Gson gson = new Gson();
            tmpType = gson.fromJson(content.toString(),tmpType.getClass());
            destination.clear();
            destination.addAll(Arrays.asList(tmpType));
        }
        else{if (!leadsDBFile.createNewFile()){throw new IOException("Can't create DB file!");}}
    }

    // InputHandler uses this method to add lead to lead array
    public static void addLead(Lead lead) {
        leads.add(lead);
    }
}