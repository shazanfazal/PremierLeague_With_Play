package services;

import models.DateAndTime;
import models.FootballClub;
import models.Match;
import models.SportsClub;
import utils.InputValidation;
import utils.PrintTablesFormat;

import java.util.ArrayList;
import java.util.Scanner;

public class RequestLogic {
    private PremierLeagueManager managersDecisions = PremierLeagueManager.getInstanceOfPremierLeagueManage();
    private final Scanner scan = new Scanner(System.in);
    private final String errorMessage = " Please check your spellings, Re-enter: ";
    private final String errorMessageTwo = " Only Numbers Allowed,Re-enter:  ";

    /**
     * adding a new club to the league with user input
     */
    public void additionOfAnewClub() {

        //for the registration number
        System.out.print(" Enter the registration Id: ");
        InputValidation.intCheckerValidation(scan, errorMessageTwo);  //validation method is being called
        int regIdOfClub = scan.nextInt();
        scan.nextLine(); //to over come the problem with scan.nextLine()

        System.out.print(" Enter the clubs' coach: ");
        String coachName = InputValidation.alphabetChecker(scan, errorMessage);

        System.out.print(" Enter the Name for the FootballClub: ");
        String clubName = InputValidation.alphabetChecker(scan, errorMessage);
        clubName = clubName.toUpperCase();  //converting so that it will be easy to deleting when user enter capital or simple letter

        System.out.print(" Enter the Country: ");
        String countryName = InputValidation.alphabetChecker(scan, errorMessage);

        System.out.print(" Enter the City: ");
        String cityName = InputValidation.alphabetChecker(scan, errorMessage);

        System.out.print(" Enter the PostCode: ");
        InputValidation.intCheckerValidation(scan, errorMessageTwo);
        int postCode = scan.nextInt();
        scan.nextLine();

        SportsClub premierLeagueClub = new FootballClub(regIdOfClub, coachName, clubName, countryName, cityName, postCode); //polymorphism
        String theClubAdded = managersDecisions.addingANewClubToTheLeague((FootballClub) premierLeagueClub);
        System.out.println(theClubAdded);
        //the above creation is polymorphism but in is type casted because to add in to the array<which has the data type football>.
        //why FootballClub? so that i will be able to access the won,draw statistics when creating the match and updating it
    }

    /**
     * This will help to delegate a team from the club with user inputs
     */
    public void delegatingATeamFromTheLeague() {

        System.out.print(" Enter The club name to be delegated: ");
        String delegatedTeam = InputValidation.alphabetChecker(scan, errorMessage);
        delegatedTeam = delegatedTeam.toUpperCase();  //since the arrayList is added with uppercase the use entered is also converted hence it will be equal
        boolean value =  managersDecisions.deletingAClubFromTheLeague(delegatedTeam);
        if (value){
            System.out.println("Successfully deleted the club: " + delegatedTeam);
        }else {
            System.out.println("Sorry the club is not available");
        }
    }

    /**
     * to view the premier league table
     */
    public void showPremierLeagueTable(){
        //printing the sorted data
        PrintTablesFormat.headingForViewPointsTable();
        PrintTablesFormat.mainFormatTable();
        ArrayList<FootballClub> allTeamAvailable = managersDecisions.displayThePremierLeagueTable();
        for(FootballClub sortedDetails: allTeamAvailable){
            sortedDetails.getStatistics();
            System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
        }
    }

    /**
     * to show the matches played
     */
    public void matchesPlayedDetails(){
        ArrayList<Match> allMatchesPlayed =  managersDecisions.viewTheMatchesPlayed();
            for(Match matchesDetails: allMatchesPlayed){
                System.out.println("--------------------------------------------------------------");
                System.out.printf("Home Team %s \n",matchesDetails.getHomeTeamMatch());
                System.out.printf("Away Team %s \n",matchesDetails.getAwayTeamMatch());
                System.out.printf("Home Team Goal %s \n",matchesDetails.getHomeGoalScored());
                System.out.printf("Away Team Goal %s \n",matchesDetails.getAwayGoalScored());
                System.out.printf("%s \n\n",matchesDetails.getMatchDatePlayed());
                System.out.println("-------------------------------------------------------------\n");
            }
    }

    /**
     * this is used to create the match and request relevant information from the user.
     */
    public void creatingAMatch(){
        System.out.print(" Enter the match Day(1-31): ");
        InputValidation.intCheckerValidation(scan, " Only numbers allowed between 1-31, re-enter: ");
        int matchDay = scan.nextInt();
        scan.nextLine();

        System.out.print(" Enter the match Month(1-12): ");
        InputValidation.intCheckerValidation(scan, " Only numbers allowed between 1-12, re-enter: ");
        int matchMonth = scan.nextInt();
        scan.nextLine();

        System.out.print(" Enter the match Year(above 2013): ");
        InputValidation.intCheckerValidation(scan, " Only numbers allowed above 2011, re-enter: ");
        int matchYear = scan.nextInt();
        scan.nextLine();

        System.out.print(" Enter the match Hour: ");
        InputValidation.intCheckerValidation(scan, " Only numbers allowed between 1-24, re-enter: ");
        int matchHour = scan.nextInt();
        scan.nextLine();

        System.out.print(" Enter the match Minutes: ");
        InputValidation.intCheckerValidation(scan, " Only numbers allowed between 1-60, re-enter: ");
        int matchMinutes = scan.nextInt();
        scan.nextLine();

        //creating the date class
        DateAndTime matchDatePlayed = new DateAndTime(matchDay,matchMonth,matchYear,matchHour,matchMinutes);

        while(true){
            //request of which team playing the matches
            System.out.print(" Enter the Home Team: ");
            String homePlayingTeam = InputValidation.alphabetChecker(scan,errorMessage);
            homePlayingTeam = homePlayingTeam.toUpperCase();

            System.out.print(" Enter the Away Team: ");
            String awayPlayingTeam = InputValidation.alphabetChecker(scan,errorMessage);
            awayPlayingTeam = awayPlayingTeam.toUpperCase();

            if(homePlayingTeam.equals(awayPlayingTeam)){
                System.out.println(" Selected both the same team, enter different Team");

            }else{
                //request of number of goal scored from each team
                System.out.print(" Enter the Home Team goal count: ");
                InputValidation.intCheckerValidation(scan, errorMessageTwo);
                int homeGoalCount = scan.nextInt();
                scan.nextLine();

                System.out.print(" Enter the Away Team goal count: ");
                InputValidation.intCheckerValidation(scan, errorMessageTwo);
                int awayGoalCount = scan.nextInt();
                scan.nextLine();

                Match matchPlaying = new Match(homePlayingTeam,awayPlayingTeam,homeGoalCount,awayGoalCount,matchDatePlayed);
                boolean addAMatchChecking = managersDecisions.addAPlayMatch(matchPlaying);
                if (addAMatchChecking){
                    System.out.printf(" %s score is %d  %s score is %d ",homePlayingTeam,homeGoalCount,awayPlayingTeam,awayGoalCount);
                    System.out.println("\n" + matchDatePlayed.toString());
                }
                break;
            }
        }
    }

    /**
     * this will help to display te stats of the particular team.
     */
    public void displayStat(){
        System.out.print(" Enter a Premier League team: ");
        String premierLeagueTeam = InputValidation.alphabetChecker(scan,errorMessage);
        premierLeagueTeam = premierLeagueTeam.toUpperCase();
        managersDecisions.displayStatisticsOfTheClub(premierLeagueTeam);
    }

    /**
     * saving everything to the file.
     */
    public void saveToTheFile(){
        managersDecisions.savingToAFile();
    }

    /**
     * reading from the file back to the arraylist
     */
    public void readFromTheFile(){
        managersDecisions.readingFromAFile();
    }
}
