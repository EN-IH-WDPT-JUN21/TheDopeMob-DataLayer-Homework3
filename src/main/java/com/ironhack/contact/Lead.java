package com.ironhack.contact;

public class Lead extends ContactInfo {

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    // Methods
    // Must be TESTED
    public void convertLead(Lead lead){
        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(),lead.getEmail(), lead.getCompanyName());
// Method to add Contact to ArrayList<Contact> contactList
        System.out.println("Enter " + contact.getName() + "'s product of interest: Hybrid Truck, Flatbed Truck, or Box Truck");
    }

}