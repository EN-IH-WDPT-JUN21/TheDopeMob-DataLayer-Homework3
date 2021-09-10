package com.ironhack.data;

import com.ironhack.controller.*;
import com.ironhack.dao.SalesRep;
import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Helper {

    final SalesRepController salesRepController;
    final ContactController contactController;
    final LeadController leadController;
    final OpportunityController opportunityController;
    final AccountController accountController;

    @Autowired
    public Helper(SalesRepController salesRepController,
                  ContactController contactController,
                  LeadController leadController,
                  OpportunityController opportunityController,
                  AccountController accountController) {
        this.salesRepController = salesRepController;
        this.contactController = contactController;
        this.leadController = leadController;
        this.opportunityController = opportunityController;
        this.accountController = accountController;
    }

    public String setName() {
        String name;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter name and lastname:");
            name = scanner.nextLine();
            boolean isThereFirstAndLastname = (name.split(" ").length == 2);
            if (name.length() < 3) System.out.println("Name must have at least 3 characters");
            else if (name.matches(".*\\d.*") || name.matches(".*\\p{Punct}.*")) System.out.println("Name cannot contain numbers " +
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

    public Product setProduct() {
        String productSelection = "";
        Product product = null;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Select product:\n1. HYBRID\n2. FLATBED\n3. BOX");
            productSelection = scanner.nextLine();
            switch (productSelection) {
                case ("1"):
                    return Product.valueOf("HYBRID");
                case ("2"):
                    return Product.valueOf("FLATBED");
                case ("3"):
                    return Product.valueOf("BOX");
                default:
                    System.out.println("Please select a valid product\n");
            }
        }
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

    public String setUserChoiceForAccountCreation() {
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine().toUpperCase();
        while(true) {
            switch (selection) {
                case ("Y"):
                    return "Y";
                case ("N"):
                    return "N";
                default:
                    System.out.println("Please enter Y or N");
            }

        }
    }

}
