package views;
import services.RequestLogic;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMainMenu {
    public static void main(String[] args) {
        RequestLogic requestLogics = new RequestLogic();
        requestLogics.readFromTheFile(); //retrieving all the data from the file (Data persistence)

        Scanner scan = new Scanner(System.in);
        while (true){
            try{
                //the below are the messages that will be displayed to the user Menu list

                System.out.println("\n\n\t\t==========\tWelcome to the World Of Football\t==========\n\n");
                System.out.println("  Please select the relevant task that you need to do.\n");
                System.out.println("  Insert 'A' to add a new Club");
                System.out.println("  Insert 'D' to delete an  existing Club");
                System.out.println("  Insert 'S' to display the Statistics");
                System.out.println("  Insert 'T' to display the Premier League Table");
                System.out.println("  Insert 'M' to play a match");
                System.out.println("  Insert 'V' to View the matches Played");
                System.out.println("  Insert 'F' to save the details to the file");
                System.out.println("  Insert 'Q' to Quit the program.\n\n");

                System.out.println("  Rules to REMEMBER (the values cant be below zero, the word limit cant be below 3).\n");

                //asking the user request
                System.out.print("\n\n Enter your option: ");
                String selectionOfUser = scan.next();

                //converting the option entered to lowerCase
                selectionOfUser = selectionOfUser.toLowerCase();

                //making the switchStatement
                switch(selectionOfUser){
                    case "a":
                        requestLogics.additionOfAnewClub();
                        break;

                    case "d":
                        requestLogics.delegatingATeamFromTheLeague();
                        break;
                    case "s":
                        requestLogics.displayStat();
                        break;

                    case "t":
                        requestLogics.showPremierLeagueTable();
                        break;

                    case "m":
                        requestLogics.creatingAMatch();
                        break;

                    case "f":
                        System.out.println(" Saving.........Please wait");
                        Thread.sleep(2000); //delaying the process for 2 seconds to make it realistic :)
                        System.out.println(" Successfully saved :)");
                        requestLogics.saveToTheFile();
                        break;

                    case "v":
                        requestLogics.matchesPlayedDetails();
                        break;

                    case "q":
                        break;

                    default:
                        System.out.println(" Please check the input before entering, INPUT NOT FOUND! :( ");

                }

                //to end the infinite loop
                if(selectionOfUser.equals("q")){
                    requestLogics.saveToTheFile(); //writing back to the file once the program is closed
                    System.out.println(" Thanks for being with us");
                    break;

                }

                //this catches all the invalid input which is made inside setter methods of the object
            }catch(IllegalArgumentException errorDisplay){
                System.out.println(" Check all your entries if it empty or meaningLess");
                //if a higher value bit is entered this try catch will be displayed.
            }catch(InputMismatchException overLimitInput){
                System.out.println(" THE INPUT IS OVER THE LIMIT");

            }catch(InterruptedException toCatchThread){
                System.out.println(" Something went wrong with the THREAD");
            }
        }
    }
}
