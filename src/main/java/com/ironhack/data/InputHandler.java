package com.ironhack.data;

import com.ironhack.contact.Lead;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class InputHandler {

    // Login message and instructions after successful login
    public static void welcome() {
        String command;

        try {
            int animationFrames = 0;
            while (animationFrames < 3) {
                System.out.print("\r.");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r :");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r  0");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r   :");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r    .");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r   :");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r  0");
                System.out.flush();
                Thread.sleep(200);
                System.out.print("\r :");
                System.out.flush();
                Thread.sleep(200);
                animationFrames++;
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread was interrupted");
        }
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

        // Command loop: asks for valid input
        while(true) {
            System.out.println("\nEnter command:");
            command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "new lead":
                    newLead();
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

    // Create a new lead
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
            }else if (!email.matches("^(.+)@(.+)$")){
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
    //---------------------------------------//
}
