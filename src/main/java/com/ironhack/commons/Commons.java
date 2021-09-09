package com.ironhack.commons;


import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
    public static String GetStringFromUserFromAvailable(String message,String[] options){
        Scanner scn = new Scanner(System.in);
        String input;
        boolean validInput = false;
        do {
            System.out.println(message);
            input = scn.nextLine();
            try {
                if (!isStringValueFromAvailableOptions(input,options)) //input is available in options array
                    throw new IOException("Invalid option!");
                validInput = true;
            }
            catch (Exception e) {}
        }while(!validInput);
        return input.toUpperCase();
    }
    private static boolean isStringValueFromAvailableOptions(String value, String[] options){
        for (String option : options) {
            if (option.toUpperCase().equals(value.toUpperCase()))
                return true;
        }
        return false;
    }
    public static Long GetLongFromUserFromAvailableOptions(String message,List<Long> options){
        Scanner scn = new Scanner(System.in);
        Long input = null;
        boolean validInput = false;
        do {
            System.out.println(message);
            String stringInput = scn.nextLine();
            try {
                input = Long.parseLong(stringInput);
                if (!isLongValueFromAvailableOptions(input,options)) //input is available in options array
                    throw new IOException("Invalid option!");
                validInput = true;
            }
            catch (Exception e) {}
        }while(!validInput);
        return input;
    }
    private static boolean isLongValueFromAvailableOptions(Long value, List<Long> options){
        for (Long option : options) {
            if (Objects.equals(option, value))
                return true;
        }
        return false;
    }

}

