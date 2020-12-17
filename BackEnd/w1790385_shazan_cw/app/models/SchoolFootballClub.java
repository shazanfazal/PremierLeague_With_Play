package models;

public class SchoolFootballClub extends FootballClub {

    private int initialNoOfPlayers;
    private double sponsorShipAmountReceived;

    //default constructor
    public SchoolFootballClub(){

    }

    //parameterized constructor
    public SchoolFootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet, int initialNoOfPlayers, double sponserShipAmountReceived){
        super(regNoOfClub,coachName,clubName, streetOfTheClub,  cityOfTheClub, postCodeOfTheStreet);
        this.initialNoOfPlayers = initialNoOfPlayers;
        this.sponsorShipAmountReceived = sponserShipAmountReceived;

    }

    //parameterized constructor with the statistics
    public SchoolFootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet, int noOfMatchesPlayed, int noOfMatchesWon, int noOfMatchesLost, int noOfMatchesDraw, int noOwnGoalReceived, int noOfGoalScored, int noOfPoints, int initialNoOfPlayers, double sponsorShipAmountReceived) {
        super(regNoOfClub,coachName, clubName, streetOfTheClub, cityOfTheClub, postCodeOfTheStreet, noOfMatchesPlayed, noOfMatchesWon, noOfMatchesLost, noOfMatchesDraw, noOwnGoalReceived, noOfGoalScored, noOfPoints);
        setInitialNoOfPlayers(initialNoOfPlayers);
        setSponsorShipAmountReceived(sponsorShipAmountReceived);
    }

    //getters for the instance variable
    public int getInitialNoOfPlayers(){
        return initialNoOfPlayers;
    }

    public double GetSponsorShipAmountReceived(){
        return this.sponsorShipAmountReceived;
    }

    //setters for instance variables

    public void setInitialNoOfPlayers(int initialNoOfPlayers){
        if(initialNoOfPlayers < 0){
            throw new IllegalArgumentException(errorMessage);

        }else{
            this.initialNoOfPlayers = initialNoOfPlayers;
        }
    }

    public void setSponsorShipAmountReceived(double sponsorShipAmountReceived){
        if(sponsorShipAmountReceived < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.sponsorShipAmountReceived = sponsorShipAmountReceived;
        }
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + ", Number of available Players: " + this.initialNoOfPlayers + " Sponsorship received: " + sponsorShipAmountReceived;
    }
}
