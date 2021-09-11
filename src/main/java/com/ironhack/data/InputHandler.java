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

        while (true) {
            System.out.println("\nPlease enter a command:");
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
                    if(fullCommand.matches("report lead by salesrep")) searcher.helper.leadController.findLeadsBySalesRep();
                    else if(fullCommand.matches("report opportunity by salesrep")) searcher.helper.opportunityController.findOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report closed-won by salesrep"))searcher.helper.opportunityController.findWonOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report closed-lost by salesrep"))searcher.helper.opportunityController.findLostOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report open by salesrep")) searcher.helper.opportunityController.findOpenOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report opportunity by product")) searcher.helper.opportunityController.countByProduct();
                    else if(fullCommand.matches("report closed-won by product")) searcher.helper.opportunityController.countWonByProduct();
                    else if(fullCommand.matches("report closed-lost by product")) searcher.helper.opportunityController.countLostByProduct();
                    else if(fullCommand.matches("report open by product")) searcher.helper.opportunityController.countOpenByProduct();
                    else if(fullCommand.matches("report opportunity by country")) searcher.helper.opportunityController.countByCountry();
                    else if(fullCommand.matches("report closed-won by country")) searcher.helper.opportunityController.countWonByCountry();
                    else if(fullCommand.matches("report closed-lost by country")) searcher.helper.opportunityController.countLostByCountry();
                    else if(fullCommand.matches("report open by country")) searcher.helper.opportunityController.countOpenByCountry();
                    else if(fullCommand.matches("report opportunity by city")) searcher.helper.opportunityController.countByCity();
                    else if(fullCommand.matches("report closed-won by city")) searcher.helper.opportunityController.countWonByCity();
                    else if(fullCommand.matches("report closed-lost by city")) searcher.helper.opportunityController.countLostByCity();
                    else if(fullCommand.matches("report open by city")) searcher.helper.opportunityController.countOpenByCity();
                    else if(fullCommand.matches("report opportunity by industry")) searcher.helper.opportunityController.countByIndustry();
                    else if(fullCommand.matches("report closed-won by industry")) searcher.helper.opportunityController.countWonByIndustry();
                    else if(fullCommand.matches("report closed-lost by industry")) searcher.helper.opportunityController.countLostByIndustry();
                    else if(fullCommand.matches("report open by industry")) searcher.helper.opportunityController.countOpenByIndustry();
                    else System.out.println(notValidCommand);

                    break;
                case ("mean"):
                case("median"):
                case ("max"):
                case("min"):
                    if(fullCommand.matches("mean employeecount")) searcher.helper.opportunityController.meanEmployeeCount();
                    else if(fullCommand.matches("median employeecount")) searcher.helper.opportunityController.medianEmployeeCount();
                    else if(fullCommand.matches("max employeecount")) searcher.helper.opportunityController.maxEmployeeCount();
                    else if(fullCommand.matches("min employeecount")) searcher.helper.opportunityController.minEmployeeCount();
                    else if(fullCommand.matches("mean quantity")) searcher.helper.opportunityController.meanQuantity();
                    else if(fullCommand.matches("median quantity")) searcher.helper.opportunityController.medianQuantity();
                    else if(fullCommand.matches("max quantity")) searcher.helper.opportunityController.maxQuantity();
                    else if(fullCommand.matches("min quantity")) searcher.helper.opportunityController.minQuantity();
                    else if(fullCommand.matches("mean opps per account")) searcher.helper.opportunityController.meanOpportunityByAccount();
                    else if(fullCommand.matches("median opps per account")) searcher.helper.opportunityController.medianOpportunityByAccount();
                    else if(fullCommand.matches("max opps per account")) searcher.helper.opportunityController.maxOppsByAccount();
                    else if(fullCommand.matches("min opps per account")) searcher.helper.opportunityController.minOppsByAccount();
                    else System.out.println(notValidCommand);

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
