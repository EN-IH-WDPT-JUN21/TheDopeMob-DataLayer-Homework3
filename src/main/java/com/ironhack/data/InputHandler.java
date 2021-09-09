package com.ironhack.data;

import com.ironhack.commons.Commons;
import com.ironhack.controller.*;
import com.ironhack.dao.*;
import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.repository.LeadContactRepository;
import com.ironhack.repository.SalesRepRepository;

import com.ironhack.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class InputHandler {

    @Autowired
    private SalesRepController salesRepController;

    @Autowired
    private LeadController leadController;

    @Autowired
    private ContactController contactController;

    @Autowired
    private OpportunityController opportunityController;

    @Autowired
    private AccountController accountController;

    // Initialize scanner for user input
    public void start() {
        String fullCommand;
        String actionCommand;
        Long commandId = 0L;
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

        System.out.println("***LBL Trucking CRM***");

        Scanner scanner = new Scanner(System.in);

        // Command loop: asks for valid input and passes id if necessary
        while (true) {
            System.out.println("\nEnter command:");
            fullCommand = scanner.nextLine().toLowerCase();

            if (fullCommand.matches(".*\\d.*")) { // check for {id} number in command
                if (fullCommand.split(" ").length == 3) {
                    actionCommand = fullCommand.split(" ")[0] + " " + fullCommand.split(" ")[1];
                    commandId = Long.parseLong(fullCommand.split(" ")[2]);
                } else if(fullCommand.split(" ").length ==2) {
                    actionCommand = fullCommand.split(" ")[0];
                    commandId = Long.parseLong(fullCommand.split(" ")[1]);
                } else {
                    actionCommand = "not valid";
                }
            } else {
                actionCommand = fullCommand;
            }

            switch (actionCommand) {
                case "new lead":
                    newLead();
                    break;
                case "new salesrep":
                    newSalesRep();
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
                    } catch (IllegalArgumentException e) {
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
    // ---USER OPERATION--- //
    public void newSalesRep() {
        String tempName = setName();
        SalesRep tempSalesRep = new SalesRep(tempName);
        salesRepController.createSalesRep(tempSalesRep);
    }

    public void newLead() {

        String tempName = setName();
        String tempPhoneNumber = setPhone();
        String tempEmail = setEmail();
        String tempCompanyName = setCompanyName();
        SalesRep tempSalesRep = setSalesRep();

        LeadContact tempLead = new LeadContact(tempSalesRep, tempName, tempPhoneNumber, tempEmail, tempCompanyName);

        leadController.createLead(tempLead);
    }

        // ---HELPER METHODS USED BY newLead()--- //
        public String setName() {
            String name;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter name and lastname:");
                name = scanner.nextLine();
                boolean isThereFirstAndLastname = (name.split(" ").length == 2);
                if (name.length() < 3) System.out.println("Name must have at least 3 characters");
                else if (name.matches(".*\\d.*") || name.matches(".*\\p{Punct}.*")) System.out.println("Name cannot contain numbers" +
                                                                                                                    "or especial characters");
                else if (!isThereFirstAndLastname) System.out.println("Please enter name and lastname separated by a space");
                else {
                    System.out.println("The registered name is: " + name + "\n");
                    return name;
                }
            }
        }

        public String setPhone() {
            String phone;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter lead's phone number, should be 9 digits long:");
                phone = scanner.nextLine();
                if (phone.length() != 9) System.out.println("Phone must be 9 digits long");
                else if (phone.matches("\\d+")) {
                    System.out.println("The registered phone is: " + phone + "\n");
                    return phone;
                }

            }
        }

        public String setEmail() {
            String email;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter lead's email address:");
                email = scanner.nextLine();

                if (email.length() < 5) System.out.println("Email must be more than 5 characters long");
                else if (!email.matches("^(.+)@(.+)\\.(.+)$")) System.out.println("Please enter a email like: example@hello.io");
                else {
                    System.out.println("The registered email is: " + email + "\n");
                    return email;
                }
            }
        }

        public String setCompanyName() {
            String companyName;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter company's name:");
                companyName = scanner.nextLine();
                if (companyName.length() < 3) System.out.println("Company name must have at least 3 characters");
                else {
                    System.out.println("The registered company name is: " + companyName + "\n");
                    return companyName;
                }
            }
        }

        public SalesRep setSalesRep() {
            String selectedSalesRep;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nSelect a sales rep. Enter the id:");
                salesRepController.printAll();
                selectedSalesRep = scanner.nextLine();

                if(selectedSalesRep.matches("[0-9]+")) {
                    SalesRep salesRep = salesRepController.findById(Long.parseLong(selectedSalesRep));
                    if (salesRep == null) System.out.println("There is no sales rep with that id\n");
                    else {
                        System.out.println("The selected sales rep is: " + salesRep);
                        return salesRep;
                    }

                }
            }
        }

    //---USER OPERATION---//
    public void showLeads() {
        leadController.printAll();
    }

    public void lookupLeads(Long commandId) {
        LeadContact foundLead = leadController.findById(commandId);
        if(foundLead == null) System.out.println("There is no lead with that id");
        else System.out.println(foundLead);

    }

    public void convertId(Long commandId) {
        // Find lead by id and create Contact from it
        LeadContact leadToConvert = leadController.findById(commandId);
        if(leadToConvert == null) System.out.println("There is no lead with that id");
        else {
            Contact contactFromLead = new Contact(
                    leadToConvert.getName(),
                    leadToConvert.getPhoneNumber(),
                    leadToConvert.getEmail(),
                    leadToConvert.getCompanyName());
            // Gather arguments to create new Opportunity
            Contact contactForOpportunity = contactController.createContact(contactFromLead);
            Product tempProduct = setProduct();
            int quantityOfProduct = setQuantity();
            //Req 12,13,14 linking account with Opportunity or creating a new account
            String pickedOptionForCreatingNewAccount;
            //If there's no account available there's no need to ask if you want to link to the existing one, since you would have nothing to pick from
            if (accountController.findAllAccounts().size() == 0)
                //"Y" is for creating a new account
                {System.out.println("There's no accounts available!");
                pickedOptionForCreatingNewAccount="Y";}
            else
                //this guarantees that the user will input only from the available options
                {pickedOptionForCreatingNewAccount = Commons.GetStringFromUserFromAvailable("Would you like to create a new Account? (Y/N)",new String[]{"Y","N"});}
            Account accountForOpportunity;
            //Here the code splits for the option you picked earlier
            if(pickedOptionForCreatingNewAccount.equals("N")){
                //Link with the existing account
                List<Account> accounts =  accountController.findAllAccounts();
                System.out.println("Please associate an account with the contact and opportunity!");
                List<Long> accountIDs = new ArrayList<>();
                for (Account account: accounts) {
                    System.out.println(account.getAccountId()+". "+account.getCompanyName());
                    accountIDs.add(account.getAccountId());
                }
                //Commons class method guarantee that a correct input is picked.
                Long pickedAccountID = Commons.GetLongFromUserFromAvailableOptions("Pick one of the existing accounts!",accountIDs);
                accountForOpportunity = accountController.findById(pickedAccountID);
            }
            else {
                //This code executes if the user selected that he wants to create a new account or there's no account available
                // Gather arguments to create new Account
                System.out.println("Creating new account!");
                String companyName = leadToConvert.getCompanyName();
                int employeeCount = setEmployeeCount();
                Industry industryType = setIndustryType();
                String city = setCity();
                String country = setCountry();

                // Create new Account
                Account newAccount = new Account(
                        companyName,
                        employeeCount,
                        industryType,
                        city,
                        country);
                accountForOpportunity = accountController.createAccount(newAccount);
            }
            // Create new Opportunity
            Opportunity newOpportunity = new Opportunity(
                    leadToConvert.getSalesRep(),
                    contactForOpportunity,
                    tempProduct,
                    quantityOfProduct,
                    Status.OPEN,
                    accountForOpportunity);

            opportunityController.createOpportunity(newOpportunity);

            // Delete the converted lead
            leadController.deleteLead(commandId);
        }

    }

        // ---HELPER METHODS USED BY convertId()--- //

        public Product setProduct() {
            String productSelection = "";
            Product product = null;
            Scanner scanner = new Scanner(System.in);
            while(!productSelection.matches("[0-9]+")) {
                System.out.println("Select product:\n1. HYBRID\n2. FLATBED\n3. BOX");
                productSelection = scanner.nextLine();
                switch (productSelection) {
                    case ("1"):
                        product = Product.valueOf("HYBRID");
                        break;
                    case ("2"):
                        product = Product.valueOf("FLATBED");
                        break;
                    case ("3"):
                        product = Product.valueOf("BOX");
                        break;
                    default:
                        System.out.println("Please select a valid product");
                }
            }
            return product;
        }

        public int setQuantity() {
            String quantity = "";
            Scanner scanner = new Scanner(System.in);
            while (!quantity.matches("[0-9]+")) {
                System.out.println("Enter quantity of product:");
                quantity = scanner.nextLine();
            }
            return Integer.parseInt(quantity);
        }

        public int setEmployeeCount() {
            String employeeCount = "";
            Scanner scanner = new Scanner(System.in);
            while (!employeeCount.matches("[0-9]+")) {
                System.out.println("Enter number of employees:");
                employeeCount = scanner.nextLine();
            }
            return Integer.parseInt(employeeCount);
        }

        public Industry setIndustryType() {
            String industry;
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("\nSelect industry:\n1. PRODUCE\n2. ECOMMERCE\n3. MANUFACTURING\n4. MEDICAL\n5. OTHER");
                industry = scanner.nextLine();
                switch (industry) {
                    case ("1"):
                        return Industry.valueOf("PRODUCE");
                    case ("2"):
                        return Industry.valueOf("ECOMMERCE");
                    case ("3"):
                        return Industry.valueOf("MANUFACTURING");
                    case ("4"):
                        return Industry.valueOf("MEDICAL");
                    case ("5"):
                        return Industry.valueOf("OTHER");
                    default:
                        System.out.println("Please select a valid industry\n");
                }
            }
        }

        public String setCity() {
            String city = "";
            Scanner scanner = new Scanner(System.in);
            while (city.equals("")) {
                System.out.println("\nEnter the company's city:");
                city = scanner.nextLine();
            }
            return city;
        }

        public String setCountry() {
            String country = "";
            Scanner scanner = new Scanner(System.in);
            while (country.equals("")) {
                System.out.println("\nEnter the company's country:");
                country = scanner.nextLine();
            }
            return country;
        }


    public void lookupOpportunity(Long commandId) {
        Opportunity foundOpportunity = opportunityController.findById(commandId);
        if(foundOpportunity == null) System.out.println("There is no opportunity with that id");
        else System.out.println(foundOpportunity);
    }

    public void closeWon(Long commandId) {
        opportunityController.updateCloseWon(commandId);
    }

    public void closeLost(Long commandId) {
        opportunityController.updateCloseLost(commandId);
    }
}
