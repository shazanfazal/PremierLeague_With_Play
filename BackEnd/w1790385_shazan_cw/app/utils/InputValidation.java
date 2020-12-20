package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    /**
     * this method will help to change if only alphabets are being inserted, else it will loop through and request for a name
     * @param scan the scanner object that will take the user input
     * @param errorMessage the error message that will shown to the user for inappropriate in put
     * @return the message that the user has entered
     */
    public static String alphabetChecker(Scanner scan, String errorMessage){
        Pattern patternOfAlpha = Pattern.compile("[a-z A-Z]*");
        Matcher checkIfMatches;
        String userInput;
        do{
            userInput = scan.nextLine();
            checkIfMatches = patternOfAlpha.matcher(userInput);
            if(!(checkIfMatches.matches())){
                System.out.print( errorMessage);
            }

        }while(!(checkIfMatches.matches()));
        return userInput;
    }

    /**
     * this to accept only int values and it will loop through again if there is any other string element is inserted
     * @param scan the scanner object that will be asked for the user
     * @param message the error message that will be printed to the user
     */
    public static void intCheckerValidation(Scanner scan, String message){
        do{
            if(!(scan.hasNextInt())){
                System.out.print(message);
                scan.next();
            }
        }while(!(scan.hasNextInt()));
    }
}
