package com.ironhack.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


@Component
public class InputHandler {

    @Autowired
    Register register;
    @Autowired
    Searcher searcher;
    @Autowired
    Operator operator;

    // Initialize scanner for user input
    public void start() {
        ArrayList<String> commandArray = new ArrayList<>();
        final String notValidCommand = "\nPlease enter a valid command";

        //List of all commands
        String[] commands = new String[]{
                "new lead",
                "new salesrep",
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

        while (true) {
            commandArray.clear();
            System.out.println("\nEnter command:");
            commandArray.addAll(Arrays.asList(scanner.nextLine().toLowerCase().trim().split(" ")));
            switch (commandArray.get(0)) {

                case ("new"):
                    // Register
                    try {
                        if (commandArray.get(1).equals("lead")) register.newLead();
                        else if (commandArray.get(1).equals("salesrep")) register.newSalesRep();
                        else System.out.println(notValidCommand);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no register with that id");
                    }
                    break;

                case ("lookup"):
                    // Search single registry
                    try {
                        if (commandArray.get(1).equals("lead")) searcher.findLead(commandArray.get(2));
                        else if (commandArray.get(1).equals("opportunity"))
                            searcher.findOpportunity(commandArray.get(2));
                        else System.out.println(notValidCommand);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There is no register with that id");
                    }
                    break;

                case ("show"):
                    // Search for all registries
                    try {
                        if (commandArray.get(1).equals("leads")) searcher.findAllLeads();
                        else System.out.println(notValidCommand);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(notValidCommand);
                    }
                    break;

                case ("convert"):
                    // Convert
                    try {
                        if (commandArray.get(1).matches("[0-9]+")) operator.convertLead(commandArray.get(1));
                        else System.out.println(notValidCommand);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(notValidCommand);
                    }
                    break;

                case ("close-won"):
                case ("close-lost"):
                    // Close
                    try{
                        if (commandArray.get(1).matches("[0-9]+")) {
                            if(commandArray.get(0).equals("close-won")) operator.closeWon(commandArray.get(1));
                            else operator.closeLost(commandArray.get(1));
                        }else {
                            System.out.println(notValidCommand);
                        }
                    }catch (IndexOutOfBoundsException e) {
                        System.out.println(notValidCommand);
                    }
                    break;

                case ("report"):
                    // Report
                    break;

                case ("help"):
                    // Help
                    System.out.println("\nAvailable commands:");
                    for (String singleCommand : commands) {
                        System.out.println(singleCommand);
                    }
                    break;

                case ("quit"):
                    System.out.println("\nGoodbye!");
                    System.exit(0);

                default:
                    System.out.println(notValidCommand);
            }
        }
    }
}
