package com.ironhack.data;

import com.ironhack.contact.Contact;
import com.ironhack.contact.Lead;
import com.ironhack.opportunity.Status;

import java.util.Scanner;

public abstract class InputHandler {

    // Scanner for commands, login message and instructions
    public static void start() {
        String fullCommand;
        String actionCommand;
        String commandId;
        //List of all commands
        String[] commands = new String[]{
                "new lead",
                "show leads",
                "lookup lead {Id}",
                "convert {Id}",
                "lookup opportunity {Id}",
                "close-won {Id}",
                "close-lost {Id}",
                "help",
                "quit"
        };

        // Load database leads.json and contacts.json
        DatabaseManager.load();

        try {
            System.out.println("\r***Log in successful***");
            Thread.sleep(1000);
            System.out.println("\nWelcome to LBL Trucking CRM");
            Thread.sleep(1000);
            System.out.println("\nType HELP to print all available commands.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread was interrupted");
        }


        Scanner scanner = new Scanner(System.in);

        // Command loop: asks for valid input and assigns id to variable if necessary
        while (true) {
            System.out.println("\nEnter command:");
            fullCommand = scanner.nextLine().toLowerCase();

            if (fullCommand.matches(".*\\d.*")) {
                if (fullCommand.split(" ").length == 3) {
                    actionCommand = fullCommand.split(" ")[0] + " " + fullCommand.split(" ")[1];
                    commandId = fullCommand.split(" ")[2];
                } else {
                    actionCommand = fullCommand.split(" ")[0];
                    commandId = fullCommand.split(" ")[1];
                }
            } else {
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
                    try {
                        lookupLeads(commandId);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no lead with that id, enter a valid id.\nUse 'show leads' to check all leads");
                    }
                    break;
                case "convert":
                    try {
                        convertId(commandId);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no lead with that id, enter a valid id.\nUse 'show leads' to check all leads");
                    }
                    break;
                case "lookup opportunity":
                    try {
                        lookupOpportunity(commandId);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no opportunity with that id, enter a valid id");
                    }
                    break;
                case "close-won":
                    try {
                        closeWon(commandId);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no opportunity with that id, enter a valid id");
                    }
                    break;
                case "close-lost":
                    try {
                        closeLost(commandId);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no opportunity with that id, enter a valid id");
                    }
                    break;
                case "help":
                    System.out.println("Available commands:");
                    for (String command : commands) {
                        System.out.println(command);
                    }
                    break;
                case "quit":
                    try {
                        System.out.println("Goodbye!");
                        Thread.sleep(1000);
                        System.exit(0);
                    } catch (InterruptedException e) {
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

        while (true) {
            name = scanner.nextLine();
            isThereFirstAndLastname = (name.split(" ").length == 2);

            if (name.length() < 3) {
                System.out.println("Name must have at least 3 characters");
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Name cannot contain numbers");
                ;
            } else if (!isThereFirstAndLastname) {
                System.out.println("Please enter name and lastname separated by a space");
            } else {
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

        while (true) {
            phone = scanner.nextLine();

            if (phone.length() != 9) {
                System.out.println("Phone must be 9 digits long");
            } else if (phone.charAt(0) == '0') {
                System.out.println("Phone cannot start with zero");
            } else if (phone.matches(".*[a-z|A-Z].*")) {
                System.out.println("Phone cannot have letters");
            } else {
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

        while (true) {
            email = scanner.nextLine();

            if (email.length() < 4) {
                System.out.println("Email must be more than 4 characters long");
            } else if (!email.matches("^(.+)@(.+)\\.(.+)$")) {
                System.out.println("Please enter a valid email address");
                ;
            } else {
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

        while (true) {
            companyName = scanner.nextLine();

            if (companyName.length() < 3) {
                System.out.println("Company name must have at least 3 characters");
            } else {
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
        try {
            System.out.println(DatabaseManager.findLeadById(Integer.parseInt(commandId)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void convertId(String commandId) {
        // Logic to create opportunity and contact
        String product = "0";
        String numberOfProduct = "0";
        Lead currentLead = DatabaseManager.findLeadById(Integer.parseInt(commandId));
        Contact decisionMaker = new Contact(currentLead.getName(), currentLead.getPhoneNumber(), currentLead.getEmail(), currentLead.getCompanyName());
        Scanner scanner = new Scanner(System.in);
        while (!(product.equals("1") || product.equals("2") || product.equals("3"))) {
            System.out.println("Select product:\n1. HYBRID\n2. FLATBED\n3. BOX");
            product = scanner.nextLine();
        }
        while (numberOfProduct.equals("0")) {
            System.out.println("Enter quantity of product");
            numberOfProduct = scanner.nextLine();
        }

        DatabaseManager.convertLead(Integer.parseInt(product), Integer.parseInt(numberOfProduct), decisionMaker);
        DatabaseManager.getLeads().remove(currentLead);

        // Logic to create account
        String industry = "0";
        String employeeCount = "0";
        String city = "";
        String country = "";
        while (!(industry.equals("1") || industry.equals("2") || industry.equals("3") || industry.equals("4") || industry.equals("5"))) {
            System.out.println("Select industry:\n1. PRODUCE\n2. ECOMMERCE\n3. MANUFACTURING\n4. MEDICAL\n5. OTHER");
            industry = scanner.nextLine();
        }
        while (employeeCount.equals("0")) {
            System.out.println("Enter number of employees:");
            employeeCount = scanner.nextLine();
        }
        while (city.equals("")) {
            System.out.println("Enter city:");
            city = scanner.nextLine();
        }
        while (country.equals("")) {
            System.out.println("Enter country:");
            country = scanner.nextLine();
        }

        DatabaseManager.createAccount(Integer.parseInt(industry), Integer.parseInt(employeeCount), city, country);
    }

    public static void lookupOpportunity(String commandId) {
        System.out.println(DatabaseManager.findOpportunityById(Integer.parseInt(commandId)));
    }

    public static void closeWon(String commandId) {
        int id = Integer.parseInt(commandId);
        try {
            DatabaseManager.findOpportunityById(id).setStatus(Status.CLOSED_WON);
            DatabaseManager.findAccountByOpportunityId(id).findOpportunityById(id).setStatus(Status.CLOSED_WON);
            DatabaseManager.save();
            System.out.println("Congratulations on a job well done!!!");
        } catch (IllegalArgumentException e) {
            System.out.println("There is no opportunity with that id");
        }
    }

    public static void closeLost(String commandId) {
        int id = Integer.parseInt(commandId);
        try {
            DatabaseManager.findOpportunityById(id).setStatus(Status.CLOSED_LOST);
            DatabaseManager.findAccountByOpportunityId(id).findOpportunityById(id).setStatus(Status.CLOSED_LOST);
            DatabaseManager.save();
            System.out.println("That's a bummer, be a little pushy next time...");
        } catch (IllegalArgumentException e) {
            System.out.println("There is no opportunity with that id");
        }
    }
}
