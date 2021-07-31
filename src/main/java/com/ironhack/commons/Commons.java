package com.ironhack.commons;

import java.io.IOException;
import java.util.Scanner;

public class Commons {
    public static int GetNumericInputFromUser(String message){
        Scanner scn = new Scanner(System.in);
        Integer numericInput = null;
        boolean validInput = false;
        do {
            System.out.println(message);
            String input = scn.nextLine();
            try {
                numericInput = Integer.parseInt(input);
                validInput = true;
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }while(!validInput);
        return numericInput;
    }
    public static int GetNumericInputFromUserInRange(String message,int minIncluded,int maxIncluded){
        Scanner scn = new Scanner(System.in);
        Integer numericInput = null;
        boolean validInput = false;
        do {
            System.out.println(message);
            String input = scn.nextLine();
            try {
                numericInput = Integer.parseInt(input);
                if (numericInput < minIncluded || numericInput > maxIncluded)
                    throw new IOException("Input not in range");
                validInput = true;
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }while(!validInput);
        return numericInput;
    }
}
