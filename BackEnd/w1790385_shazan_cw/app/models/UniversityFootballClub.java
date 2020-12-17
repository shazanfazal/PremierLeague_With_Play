package models;

public class UniversityFootballClub extends FootballClub{
    private String jerseyColor;
    private String homeGroundName;

    //default Constructor
    public UniversityFootballClub(){

    }

    //parameterized constructor to create the uni football club
    public UniversityFootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet, String jerseyColor, String homeGroundName){
        super(regNoOfClub,coachName,clubName, streetOfTheClub,  cityOfTheClub, postCodeOfTheStreet);
        setJerseyColor(jerseyColor);
        setHomeGroundName(homeGroundName);

    }

    //parameterized constructor with the statistics
    public UniversityFootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet, int noOfMatchesPlayed, int noOfMatchesWon, int noOfMatchesLost, int noOfMatchesDraw, int noOwnGoalReceived, int noOfGoalScored, int noOfPoints, String jerseyColor, String homeGroundName) {
        super(regNoOfClub,coachName, clubName, streetOfTheClub, cityOfTheClub, postCodeOfTheStreet, noOfMatchesPlayed, noOfMatchesWon, noOfMatchesLost, noOfMatchesDraw, noOwnGoalReceived, noOfGoalScored, noOfPoints);
        setJerseyColor(jerseyColor);
        setHomeGroundName(homeGroundName);
    }

    //getters of instance variables

    public String getJerseyColor(){
        return this.jerseyColor;

    }

    public String getHomeGroundName(){
        return this.homeGroundName;
    }

    //Setters of instance variables

    public void setJerseyColor(String jerseyColor){
        if(jerseyColor.length() <= 2){
            throw new IllegalArgumentException(errorMessageOFLength);
        }
        this.jerseyColor = jerseyColor;

    }

    public void setHomeGroundName(String homeGroundName){
        if(homeGroundName.length() <= 2){
            throw new IllegalArgumentException(errorMessageOFLength);
        }else{
            this.homeGroundName = homeGroundName;
        }
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + " Jersey Color: " + this.jerseyColor + ", Ground name: " + homeGroundName;
    }

}
