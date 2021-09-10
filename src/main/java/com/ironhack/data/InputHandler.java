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

    // List of all commandMenu
    private final String[] commandMenu = new String[]{
            "new lead",
            "new salesrep",
            "show leads",
            "lookup lead {Id}",
            "convert {Id}",
            "lookup opportunity {Id}",
            "close-won {Id}",
            "close-lost {Id}",
            "help",
            "quit\n"
    };

    final String notValidCommand = "\nPlease enter a valid command\nType help for all available commands";
    private ArrayList<String> commandArray = new ArrayList<>();
    private String fullCommand;

    // Initialize scanner for user input
    public void start() {

        System.out.println("***LBL Trucking CRM***");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter a command:");

        while (true) {
            commandArray.clear(); // before scanner to clear ArrayList before every new input
            commandArray.addAll(Arrays.asList(scanner.nextLine().toLowerCase().trim().split(" ")));
            fullCommand = String.join(" ", commandArray);

            switch (commandArray.get(0)) {

                case (""):
                    break;

                case ("new"):
                    // Create new lead or new salesRep
                    if(fullCommand.equals("new lead")) register.newLead();
                    else if(fullCommand.equals("new salesrep")) register.newSalesRep();
                    else System.out.println(notValidCommand);
                    break;

                case ("lookup"):
                    // Search single registry
                    if(fullCommand.matches("lookup lead [0-9]+")) searcher.findLead(commandArray.get(2));
                    else if(fullCommand.matches("lookup opportunity [0-9]+")) searcher.findOpportunity(commandArray.get(2));
                    else System.out.println(notValidCommand);
                    break;

                case ("show"):
                    // Search for all registries
                    if(fullCommand.matches("show leads")) searcher.findAllLeads();
                    else System.out.println(notValidCommand);
                    break;

                case ("convert"):
                    // Convert lead to opportunity
                    if(fullCommand.matches("convert [0-9]+")) operator.convertLead(commandArray.get(1));
                    else System.out.println(notValidCommand);
                    break;

                case ("close-won"):
                case ("close-lost"):
                    // Close
                    if(fullCommand.matches("close-won [0-9]+")) operator.closeWon(commandArray.get(1));
                    else if(fullCommand.matches("close-lost [0-9]")) operator.closeLost(commandArray.get(1));
                    else System.out.println(notValidCommand);
                    break;

                case ("report"):
                    // Report
                    break;

                case ("help"):
                    // Help
                    System.out.println("\nAvailable commands:");
                    for (String singleCommand : commandMenu) {
                        System.out.println(singleCommand);
                    }
                    break;

                case ("quit"):
                    scanner.close();
                    System.out.println("\nGoodbye!");
                    System.exit(0);

                default:
                    System.out.println(notValidCommand);
            }
        }
    }
}
