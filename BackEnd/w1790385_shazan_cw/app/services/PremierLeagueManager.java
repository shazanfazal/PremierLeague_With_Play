package services;

import models.DateAndTime;
import models.FootballClub;
import models.Match;
import utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class PremierLeagueManager implements LeagueManager{

    private ArrayList<FootballClub> leagueAddition = new ArrayList<>();   //to add only the clubs who will be eligible for the premier league Team
    private ArrayList<Match> leaguePlayedMatches = new ArrayList<>();    //to add all the matches played by the team
    private final File toSaveAllLeagueDetails = new File("leagueDetails.txt"); //to save all the league games
    private final File fileToStoreMatchDetails = new File("matchDetails.txt"); //to save all the Matches played
    private final int MAX_ALLOCATION_OF_TEAM = 20; //maximum team that can be added to the game

    //doing the synchronization so that the object will not be created once its already created in the jvm and doing with the multi thread allowance.
    //creating an instance variable
    private static PremierLeagueManager instanceOfPremierLeague = null;

    //making the constructor private so that the object cant be created
    private PremierLeagueManager() {}

    //creating the method to create this class obj
    public static PremierLeagueManager getInstanceOfPremierLeagueManage(){
        if(instanceOfPremierLeague == null){
            synchronized (PremierLeagueManager.class){  //locking the process and making the thread to wait if 2 people are running at the same time
                if(instanceOfPremierLeague == null){ //if the obj is not created creating the obj for once
                    instanceOfPremierLeague = new PremierLeagueManager();
                }
            }
        }
        return instanceOfPremierLeague;
    }

    /**
     * This method will help to add a new team to the premier league
     * @param nameOfNewClub type of football team that will be added to the arrayList
     * @return the string value or the message that will be printed will be returned from this method
     */
    @Override
    public String addingANewClubToTheLeague(FootballClub nameOfNewClub) {

        String messageDeliver = "";  //to return the value from the method.
        for (FootballClub checkingForClub : leagueAddition) {
            //checking if the reg id is the same
            if (checkingForClub.getRegNoOfClub() == (nameOfNewClub.getRegNoOfClub())) {
                return  messageDeliver + " The Registration Id is already taken :) ";
            }
            //checking if the club name already exists
            if (checkingForClub.getClubName().equals(nameOfNewClub.getClubName())) {
                return messageDeliver + " Oops better check your table, The Team is already there :) ";
            }
        }
            //if above both conditions are passed then checking if there r spaces in the premier league
            if(leagueAddition.size() == MAX_ALLOCATION_OF_TEAM){
                return  messageDeliver + " Sorry you already have 20 clubs in the Premier League cant add more";

            }else{
                //if all the conditions r passed then the club is added
                leagueAddition.add(nameOfNewClub);
                System.out.printf(" You can add %s more clubs into the League\n ", (MAX_ALLOCATION_OF_TEAM - leagueAddition.size()));
                return messageDeliver + "SuccessFully added your club: " +nameOfNewClub.getClubName();
            }
        }

    /**
     * This method will help to delete a premier league club
     * @param delegatedTeam checks if the team is in the premier league
     * @return a boolean value, if its exists it will return true, else it will return false.
     */
    @Override
    public boolean deletingAClubFromTheLeague(String delegatedTeam){
        for (FootballClub clubsInLeague: leagueAddition){
            if (clubsInLeague.getClubName().equals(delegatedTeam)){
                leagueAddition.remove(clubsInLeague);
                System.out.printf(" %s more spaces available to add clubs to the premier League\n ", (MAX_ALLOCATION_OF_TEAM - leagueAddition.size()));
                return true;
            }
        }
        return false;
    }

    /**
     * This method will return the statistics for a Team only in the premier League
     * @param checkStatistics to check if the particular club exist in the Premier league
     */
    @Override
    public void displayStatisticsOfTheClub(String checkStatistics) {
        boolean checkStat = false;
        if (!(leagueAddition.isEmpty())) {
            for (FootballClub checkingForLeagueStats : leagueAddition) {
                if (checkingForLeagueStats.getClubName().equals(checkStatistics)) {
                    checkStat = true;
                    PrintTablesFormat.headingToViewStats(checkStatistics); //calling the header of the table format
                    PrintTablesFormat.mainFormatTable(); //displaying the table
                    checkingForLeagueStats.getStatistics(); //statistics is shown for the particular team selected
                    break;
                }
            }
        }else{
            System.out.println(" The Premier League Table is empty");
        }
        if(!checkStat){
            System.out.println( "Sorry The club your searching is not available");
        }
    }

    /**
     * This method will return the table for the whole Premier League
     * @return the arrayList where all the Premier League are stored with its statistics
     */
    @Override
    public ArrayList<FootballClub> displayThePremierLeagueTable() {
        if(leagueAddition.isEmpty()){
            System.out.println(" Sorry their are no Teams in the Premier League");

        }else{
            //displaying the points table in the descending order
            SortingObj.sortingInDescendingOrder(leagueAddition);
//            //printing the sorted data
//            PrintTablesFormat.headingForViewPointsTable();
//            PrintTablesFormat.mainFormatTable();
        }
        return leagueAddition;
    }

    /**
     * This method will help to play a match based on the teams the user selected
     * @param addingAMatch match object class that is made as a param which will allow to make the match created
     * @return boolean value if both the teams are thier the way the user selected then it will return true else false message will be printed for the user
     */
    @Override
    public boolean addAPlayMatch(Match addingAMatch) {
        boolean checkingHomeTeamAvailability = false;
        boolean checkingAwayTeamAvailability = false;

        //assigning the football clubs homeTeam and the awayTeam
        FootballClub homeTeamAssigning = null;
        FootballClub awayTeamAssigning = null;

        if (leagueAddition.isEmpty()){
            System.out.println(" There are no Premier League Team");
        }else if (leagueAddition.size() == 1){
            System.out.println(" There is only 1 team in the Premier League add 1 more team to play a Match");
        }else{
            //checking for the home team
            for(FootballClub homeTeamCheck: leagueAddition){
                if(homeTeamCheck.getClubName().equals(addingAMatch.getHomeTeamMatch())){
                    checkingHomeTeamAvailability = true;
                    homeTeamAssigning = homeTeamCheck; //assigning to the particular club
                    break;
                }
            }
            //checking for the awayTeam
            for(FootballClub awayTeamCheck: leagueAddition){
                if(awayTeamCheck.getClubName().equals(addingAMatch.getAwayTeamMatch())){
                    checkingAwayTeamAvailability = true;
                    awayTeamAssigning = awayTeamCheck;
                    break;
                }
            }
            //checking if both the teams are not nul so that we can assign the statistics according to the score.
            if(homeTeamAssigning != null && awayTeamAssigning != null){
                //according to the score the winner is selected
                if(addingAMatch.getHomeGoalScored() > addingAMatch.getAwayGoalScored()){
                    homeTeamAssigning.setStatistics(1,0,0,addingAMatch.getAwayGoalScored(),addingAMatch.getHomeGoalScored(),3);
                    awayTeamAssigning.setStatistics(0,1,0,addingAMatch.getHomeGoalScored(),addingAMatch.getAwayGoalScored(),0);
                    System.out.printf("%s won against %s\n",homeTeamAssigning.getClubName(),awayTeamAssigning.getClubName());

                }else if (addingAMatch.getHomeGoalScored() < addingAMatch.getAwayGoalScored()){
                    awayTeamAssigning.setStatistics(1,0,0,addingAMatch.getHomeGoalScored(),addingAMatch.getAwayGoalScored(),3);
                    homeTeamAssigning.setStatistics(0,1,0,addingAMatch.getAwayGoalScored(),addingAMatch.getHomeGoalScored(),0);
                    System.out.printf("%s won against %s\n",awayTeamAssigning.getClubName(),homeTeamAssigning.getClubName());
                }else{
                    homeTeamAssigning.setStatistics(0,0,1,addingAMatch.getAwayGoalScored(),addingAMatch.getHomeGoalScored(),1);
                    awayTeamAssigning.setStatistics(0,0,1,addingAMatch.getHomeGoalScored(),addingAMatch.getAwayGoalScored(),1);
                    System.out.printf("The Match was Tied %s vs %s\n",homeTeamAssigning.getClubName(),awayTeamAssigning.getClubName());
                }
                leaguePlayedMatches.add(addingAMatch); //adding the match to the array
            }else{
                System.out.println(" Re-Check the Team You have entered the particular team is not in the League");
            }
        }
        return checkingHomeTeamAvailability && checkingAwayTeamAvailability;
    }

    /**
     * this method will help to know what are the matches Played by the user and also the random matches Played
     * @return the match played arrayList
     */
    @Override
    public ArrayList<Match> viewTheMatchesPlayed() {
        //viewing the matches played for the user
        if(leaguePlayedMatches.isEmpty()){
            System.out.println(" Sorry no matches have been played in the Premier League");
        }
        return leaguePlayedMatches;
    }

    /**
     * This method will call the filHandling class which will help to save the data to the text file
     */
    //saving the all the data into a binary stream file using the generic method created
    @Override
    public void savingToAFile() {
        FileHandling.writingToAFile(toSaveAllLeagueDetails,leagueAddition);   //writing the league team to a different file
        FileHandling.writingToAFile(fileToStoreMatchDetails,leaguePlayedMatches); //writing the Match played for each team to a different file
    }

    /**
     * The will help to read the data that is stored from the file back to the arrayList (Data Persistence)
     */
    //reading the all the data that is stored in the file when the main thread starts
    @Override
    public void readingFromAFile() {
        FileInputStream addingBack = null;
        ObjectInputStream addingBackObj = null;
        FileInputStream addingBackSecond = null;
        ObjectInputStream addingBackSecondObj = null;

        try{
            addingBack = new FileInputStream(toSaveAllLeagueDetails);  //file not found exception will be given
            addingBackObj = new ObjectInputStream (addingBack);   //class not found exception
            leagueAddition = (ArrayList<FootballClub>)addingBackObj.readObject();

            //second file to add the matches.
            addingBackSecond = new FileInputStream(fileToStoreMatchDetails);
            addingBackSecondObj = new ObjectInputStream(addingBackSecond);
            leaguePlayedMatches = (ArrayList<Match>)addingBackSecondObj.readObject();


        }catch(FileNotFoundException fileMissed){
            System.out.println(" File is not available");

        }catch(ClassNotFoundException e){
            System.out.println(" Object class is not found");
        }catch(IOException missing){
            System.out.println(" Object has not be serialized, maybe due to not creation of object or serialized");

        }finally{
            try{
                addingBack.close();
                addingBackObj.close();
                addingBackSecond.close();
                addingBackSecondObj.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This Method is made to make the random match which will be called once the button is triggered in the UI
     * @return a sample Stack which will store the random Matches Played
     */
    //random match is creating, when the user wants in the front end
    public Stack<Match> randomFootballMatchPlay(){
        Stack<Match> allRandomMatch = new Stack<>();

        for(;;){ //the reason for infinite loop is because if the same team are selected it will loop until a random is found
            //checking if the arrayList is empty else cant start a match
            if(leagueAddition.isEmpty()){
                System.out.println(" Sorry you cant add any Match because there are no team in the Premier League");
                break;

            }else if(leagueAddition.size() == 1){
                System.out.println(" Sorry you cant add any Match because only 1 Team is in the Premier League");
                break;
            }else{
                //date random created
                int minYear = 15;
                int maxYear = 21;
                int yearGainResult = (int) Math.floor(Math.random() * (maxYear - minYear)) + 2015;
                int monthGainResult = (int) Math.floor(Math.random() * 11) + 1;
                int dayGainResult = (int) Math.floor(Math.random() * 29) + 1;
                int hoursGainResult = (int) Math.floor(Math.random() * 23) + 1;
                int minutesHourGain = (int) Math.floor(Math.random() * 58) + 1;

                //randomly picking up the home Team
                int pickingTheHomeTeam = (int) (Math.floor(Math.random() * leagueAddition.size()));

                //randomly assigning the away
                int pickingTheAwayTeam = (int) (Math.floor(Math.random() * leagueAddition.size()));

                //making sure that the same team is not selected
                if(pickingTheHomeTeam != pickingTheAwayTeam){

                    //maximum score that a team can play
                    int MAX_RANDOM_GOAL_THAT_CAN_BE_SCORED = 5;

                    //making goal for home team.
                    int homeTeamGoalValue = (int) (Math.random() * MAX_RANDOM_GOAL_THAT_CAN_BE_SCORED); //random total goal scored
                    FootballClub homeTeamAssigning = leagueAddition.get(pickingTheHomeTeam); //assigning the home team with the index

                    System.out.println(" Selecting HOME Team.............");
                    System.out.println(" HOME Team: " + homeTeamAssigning.getClubName());

                    //making goals for the away team
                    int awayTeamGoalValue = (int) (Math.random() * MAX_RANDOM_GOAL_THAT_CAN_BE_SCORED);  //random total goal scored
                    FootballClub awayTeamAssigning =  leagueAddition.get(pickingTheAwayTeam); //assigning the home team with the index

                    System.out.println(" Selecting AWAY Team.............");
                    System.out.println(" HOME Team: " + awayTeamAssigning.getClubName());

                    //making sure who won and lost to add their statistics.
                    if(homeTeamGoalValue > awayTeamGoalValue){
                        //stats if home team scores high
                        homeTeamAssigning.setStatistics(1, 0, 0, awayTeamGoalValue, homeTeamGoalValue, 3);
                        awayTeamAssigning.setStatistics(0, 1, 0, homeTeamGoalValue, awayTeamGoalValue, 0);
                        System.out.printf(" %s won against %s\n",homeTeamAssigning.getClubName(),awayTeamAssigning.getClubName());

                    }else if(awayTeamGoalValue > homeTeamGoalValue){
                        //stats if away team scores high
                        awayTeamAssigning.setStatistics(1, 0, 0, homeTeamGoalValue, awayTeamGoalValue, 3);
                        homeTeamAssigning.setStatistics(0, 1, 0, awayTeamGoalValue, homeTeamGoalValue, 0);
                        System.out.printf(" %s won against %s\n",awayTeamAssigning.getClubName(),homeTeamAssigning.getClubName());

                    }else{
                        //stats if its draw
                        awayTeamAssigning.setStatistics(0, 0, 1, homeTeamGoalValue, awayTeamGoalValue, 1);
                        homeTeamAssigning.setStatistics(0, 0, 1, awayTeamGoalValue, homeTeamGoalValue, 1);
                        System.out.printf(" The Match was Tied %s vs %s\n",homeTeamAssigning.getClubName(),awayTeamAssigning.getClubName());
                    }

                    //creating an automated date
                    DateAndTime matchDateOfPlay = new DateAndTime(dayGainResult,monthGainResult,yearGainResult,hoursGainResult,minutesHourGain);

                    //adding the match to the arrayList and showing who won the game
                    Match playedMatchOfTheTeams = new Match(homeTeamAssigning.getClubName(), awayTeamAssigning.getClubName(),homeTeamGoalValue,awayTeamGoalValue,matchDateOfPlay);
                    leaguePlayedMatches.add(playedMatchOfTheTeams);
                    System.out.printf(" \nMatch played between %s and %s\n", homeTeamAssigning.getClubName(), awayTeamAssigning.getClubName());
                    System.out.printf(" %s score is %d  %s score is %d ", homeTeamAssigning.getClubName(),homeTeamGoalValue, awayTeamAssigning.getClubName(),awayTeamGoalValue);
                    System.out.println("\n" + matchDateOfPlay.toString());
                    allRandomMatch.add(playedMatchOfTheTeams); //adding to the sample Stack Array
                    PremierLeagueManager.getInstanceOfPremierLeagueManage().savingToAFile(); //saving the file again so that the data wont be lost in the ui                    break;
                    break;

                }else{
                    System.out.println(" Sorry the auto-generated random has selected the same Team.");
                    System.out.println(" Making a new Match.............\n\n");
                }
            }
        }
        return allRandomMatch;
    }
}
//    //to compare the teams with win count (DSC)
//    public ArrayList<FootballClub> sortByWinCount(){
//        leagueAddition.sort(new WinCountComparator().reversed());
//        return leagueAddition;
//    }
//
//    //to compare th teams with goal scored (DSC)
//    public ArrayList<FootballClub> sortByGoalScored(){
//        leagueAddition.sort(new GoalScoredComparator().reversed());
//        return leagueAddition;
//    }
//
//    //comparing using date and time (ASC)
//    public ArrayList<Match> sortByDateAndTime(){
//        leaguePlayedMatches.sort(new DateAndTimeComparator());
//        return leaguePlayedMatches;
//    }

