package com.ironhack.data;

import com.ironhack.contact.Lead;

import java.util.Scanner;

public abstract class InputHandler {

    // Scanner for commands, login message and instructions
    public static void start() {
        String fullCommand;
        String actionCommand;
        String commandId;

        // Load database leads.json and contacts.json
        DatabaseManager.load();

        try {
            System.out.println("\r***Log in successful***");
            Thread.sleep(1000);
            System.out.println("\nWelcome Gustavo");
            Thread.sleep(1000);
            System.out.println("\nInstructions");
        }catch(InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread was interrupted");
        }



        Scanner scanner = new Scanner(System.in);

        // Command loop: asks for valid input and assigns id to variable if necessary
        while(true) {
            System.out.println("\nEnter command:");
            fullCommand = scanner.nextLine().toLowerCase();

            if(fullCommand.matches(".*\\d.*")) {
                if (fullCommand.split(" ").length == 3) {
                    actionCommand = fullCommand.split(" ")[0] + " " + fullCommand.split(" ")[1];
                    commandId = fullCommand.split(" ")[2];
                } else {
                    actionCommand = fullCommand.split(" ")[0];
                    commandId = fullCommand.split(" ")[1];
                }
            }else{
                actionCommand = fullCommand;
                commandId = "0";
            }

            switch (actionCommand) {
                case "new lead":
                    newLead();
                    break;
                case "show leads":
                    showLeads();
                    break;
                case "lookup lead":
                    try{
                        lookupLeads(commandId);
                    }catch(IndexOutOfBoundsException e) {
                        System.out.println("There is no lead with that id, enter a valid id.\nUse 'show leads' to check all leads");
                    }
                    break;
                case "convert":
                    try{
                        convertId(commandId);
                    }catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no lead with that id, enter a valid id.\nUse 'show leads' to check all leads");
                    }
                    break;
                case "lookup com.ironhack.opportunity":
                    try{
                        lookupOpportunity(commandId);
                    }catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no com.ironhack.opportunity with that id, enter a valid id");
                    }
                    break;
                case "close-won":
                    try{
                        closeWon(commandId);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("There is no com.ironhack.opportunity with that id, enter a valid id");
                    }
                    break;
                case "close-lost":
                    try{
                        closeLost(commandId);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("There is no com.ironhack.opportunity with that id, enter a valid id");
                    }
                    break;
                case "quit":
                    try {
                        System.out.println("Goodbye!");
                        Thread.sleep(1000);
                        System.exit(0);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Please enter a valid command");
            }
        }
    }

    //----METHODS FOR COMMANDS AVAILABLE TO USER----//
    // Creates a new lead, called by welcome()
    public static void newLead() {
        String tempName;
        String tempPhoneNumber;
        String tempEmail;
        String tempCompanyName;
        Lead tempLead;

        tempName = setName();
        tempPhoneNumber = setPhone();
        tempEmail = setEmail();
        tempCompanyName = setCompanyName();

        tempLead = new Lead(tempName, tempPhoneNumber, tempEmail, tempCompanyName);

        DatabaseManager.addLead(tempLead);
        DatabaseManager.save();
    }

    // ---HELPER FUNCTION USED BY newLead()---//
    // newLead() helper method with name input validation
    public static String setName() {
        String name;
        boolean isThereFirstAndLastname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead's name and lastname:");

        while(true) {
            name = scanner.nextLine();
            isThereFirstAndLastname = (name.split(" ").length == 2 );

            if(name.length() < 3) {
                System.out.println("Name must have at least 3 characters");
            }else if (name.matches(".*\\d.*")){
                System.out.println("Name cannot contain numbers");;
            }else if (!isThereFirstAndLastname){
                System.out.println("Please enter name and lastname separated by a space");
            }else{
                break;
            }
        }
        System.out.println("The registered name is: " + name + "\n");
        return name;
    }
    // newLead() helper method with phone input validation
    public static String setPhone() {
        String phone;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead's phone number, should be 9 digits long:");

        while(true) {
            phone = scanner.nextLine();

            if(phone.length() != 9) {
                System.out.println("Phone must be 9 digits long");
            }else if (phone.charAt(0) == '0'){
                System.out.println("Phone cannot start with zero");
            }else if(phone.matches(".*[a-z|A-Z].*")){
                System.out.println("Phone cannot have letters");
            }else{
                break;
            }
        }
        System.out.println("The registered phone is: " + phone + "\n");
        return phone;
    }
    // newLead() helper method with email input validation
    public static String setEmail() {
        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead's email address:");

        while(true) {
            email = scanner.nextLine();

            if(email.length() < 4) {
                System.out.println("Email must be more than 4 characters long");
            }else if (!email.matches("^(.+)@(.+)\\.(.+)$")){
                System.out.println("Please enter a valid email address");;
            }else{
                break;
            }
        }
        System.out.println("The registered email is: " + email + "\n");
        return email;
    }
    // newLead() helper method with companyName input validation
    public static String setCompanyName() {
        String companyName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lead's company name:");

        while(true) {
            companyName = scanner.nextLine();

            if(companyName.length() < 3) {
                System.out.println("Company name must have at least 3 characters");
            }else{
                break;
            }
        }
        System.out.println("The registered company name is: " + companyName + "\n");
        return companyName;
    }

    //---METHODS FOR COMMANDS AVAILABLE TO USER----//
    public static void showLeads() {
        System.out.println(DatabaseManager.getLeads());
    }

    public static void lookupLeads(String commandId) {
        try{
            System.out.println(DatabaseManager.findLeadById(Integer.parseInt(commandId)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void convertId(String commandId) {
        DatabaseManager.convertLeadToOpportunity(Integer.parseInt(commandId));
    }

    public static void lookupOpportunity(String commandId){
        System.out.println("Retrieved " + commandId + "com/ironhack/opportunity");
    }
    public static void closeWon(String commandId) {
        System.out.println("Closed won com.ironhack.opportunity with id: " + commandId);
    }
    public static void closeLost(String commandId) {
        System.out.println("Closed lost com.ironhack.opportunity with id: " + commandId);
    }
}
