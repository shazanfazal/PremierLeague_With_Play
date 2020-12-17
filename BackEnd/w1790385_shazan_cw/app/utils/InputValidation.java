package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    /*
  this method will help to change if only alphabets are being inserted, else it will loop through and request for a name
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

    /*this to accept only int values and it will loop through again if there is any other string element is inserted*/
    public static void intCheckerValidation(Scanner scan, String message){
        do{
            if(!(scan.hasNextInt())){
                System.out.print(message);
                scan.next();
            }

        }while(!(scan.hasNextInt()));
    }
}
