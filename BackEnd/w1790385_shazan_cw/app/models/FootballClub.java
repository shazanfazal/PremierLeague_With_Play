package models;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable <FootballClub>, Serializable {
    private int noOfMatchesPlayed;
    private int noOfMatchesWon;
    private int noOfMatchesLost;
    private int noOfMatchesDraw;
    private int noOwnGoalReceived;
    private int noOfGoalScored;
    private int noOfPoints;
    private int goalDiff; //made to get the goal differences
    protected String errorMessage = " The input cant be below 0";

    //Default Constructor
    public FootballClub(){

    }

    //this constructor is made to create the club
    public FootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet){
        super(regNoOfClub,coachName,clubName, streetOfTheClub,  cityOfTheClub, postCodeOfTheStreet);

    }

    //parameterized Constructor to add stats
    public FootballClub(int regNoOfClub,String coachName, String clubName, String streetOfTheClub, String cityOfTheClub, int postCodeOfTheStreet, int noOfMatchesPlayed,  int noOfMatchesWon, int noOfMatchesLost, int noOfMatchesDraw,int noOwnGoalReceived, int noOfGoalScored, int noOfPoints){

        super(regNoOfClub,coachName,clubName, streetOfTheClub,  cityOfTheClub, postCodeOfTheStreet);
        setNoOfMatchesPlayed(noOfMatchesPlayed);
        setNoOfMatchesWon(noOfMatchesWon);
        setNoOfMatchesLost(noOfMatchesLost);
        setNoOfMatchesDraw(noOfMatchesDraw);
        setNoOwnGoalReceived(noOwnGoalReceived);
        setNoOfGoalScored(noOfGoalScored);
        setNoOfPoints(noOfPoints);

    }


    //getters of the above instance variables
    public int getNoOfMatchesWon(){
        return this.noOfMatchesWon;
    }

    public int getNoOfMatchesLost(){
        return this.noOfMatchesLost;
    }

    public int getNoOfMatchesDraw(){
        return this.noOfMatchesDraw;
    }

    public int getNoOfMatchesPlayed(){
        return this.noOfMatchesPlayed;
    }

    public int getNoOwnGoalReceived(){
        return this.noOwnGoalReceived;
    }

    public int getNoOfGoalScored(){
        return this.noOfGoalScored;
    }

    public int getNoOfPoints(){
        return this.noOfPoints;
    }

    //setters of the above instance variables
    public void setNoOfMatchesPlayed(int noOfMatchesPlayed){
        if(noOfMatchesPlayed < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.noOfMatchesPlayed = noOfMatchesPlayed;
        }
    }

    public void setNoOfMatchesWon(int noOfMatchesWon){
        if(noOfMatchesWon < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.noOfMatchesWon = noOfMatchesWon;
        }
    }

    public void setNoOfMatchesLost(int noOfMatchesLost){
        if(noOfMatchesLost < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.noOfMatchesLost = noOfMatchesLost;
        }
    }

    public void setNoOfMatchesDraw(int noOfMatchesDraw){
        if(noOfMatchesDraw < 0){
            throw new IllegalArgumentException(errorMessage);
        }else {
            this.noOfMatchesDraw = noOfMatchesDraw;
        }
    }

    public void setNoOwnGoalReceived(int noOwnGoalReceived){
        if(noOwnGoalReceived < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.noOwnGoalReceived = noOwnGoalReceived;
        }
    }

    public void setNoOfGoalScored(int noOfGoalScored){
        if(noOfGoalScored < 0){
            throw new IllegalArgumentException(errorMessage);
        }else{
            this.noOfGoalScored = noOfGoalScored;
        }
    }

    public void setNoOfPoints(int noOfPoints){
        if(this.noOfPoints <= -1){
            this.noOfPoints = 0;
        }else{
            this.noOfPoints = noOfPoints;
        }
    }
    public int getGoalDiff(){
        return (this.getNoOfGoalScored() - this.getNoOwnGoalReceived());
    }
    //this method will help to display the each stats of the a particular club selected.
    public void getStatistics(){
        System.out.printf("|\t%-20s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s\n",this.getClubName(),
                this.getNoOfMatchesPlayed(),this.getNoOfMatchesWon(),this.getNoOfMatchesLost(),this.getNoOfMatchesDraw(),
                this.getNoOfGoalScored(),this.getNoOwnGoalReceived(),this.getGoalDiff(),getNoOfPoints() + "       |");
    }
    //this method is to assign the new values to the statistics of the team.
    public void setStatistics(int wonValue, int lostValue, int drawValue, int goalGained, int goalScored,int pointValue){

        this.setNoOfPoints(this.getNoOfPoints() + pointValue);
        this.setNoOfMatchesPlayed(this.getNoOfMatchesPlayed() + 1);
        this.setNoOfMatchesWon(this.getNoOfMatchesWon() + wonValue);
        this.setNoOfMatchesLost(this.getNoOfMatchesLost() + lostValue);
        this.setNoOfMatchesDraw(this.getNoOfMatchesDraw() + drawValue);
        this.setNoOfGoalScored(this.getNoOfGoalScored() + goalScored);
        this.setNoOwnGoalReceived(this.getNoOwnGoalReceived() + goalGained);
    }

    //compare to method
    @Override
    public int compareTo(FootballClub otherClub){
        if (this.getNoOfPoints() == otherClub.getNoOfPoints()){
            return ((this.getNoOfGoalScored() - this.getNoOwnGoalReceived()) - (otherClub.getNoOfGoalScored() - otherClub.getNoOwnGoalReceived()));
        }
        return (this.getNoOfPoints() - otherClub.getNoOfPoints());
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        if (!super.equals(otherObj)) return false;

        FootballClub thatFootballClub = (FootballClub) otherObj;

        if (noOfMatchesPlayed != thatFootballClub.noOfMatchesPlayed) return false;
        if (noOfMatchesWon != thatFootballClub.noOfMatchesWon) return false;
        if (noOfMatchesLost != thatFootballClub.noOfMatchesLost) return false;
        if (noOfMatchesDraw != thatFootballClub.noOfMatchesDraw) return false;
        if (noOwnGoalReceived != thatFootballClub.noOwnGoalReceived) return false;
        if (noOfGoalScored != thatFootballClub.noOfGoalScored) return false;
        if (noOfPoints != thatFootballClub.noOfPoints) return false;
        return goalDiff == thatFootballClub.goalDiff;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + noOfMatchesPlayed;
        result = 31 * result + noOfMatchesWon;
        result = 31 * result + noOfMatchesLost;
        result = 31 * result + noOfMatchesDraw;
        result = 31 * result + noOwnGoalReceived;
        result = 31 * result + noOfGoalScored;
        result = 31 * result + noOfPoints;
        result = 31 * result + goalDiff;
        return result;
    }

    //to string method
    @Override
    public String toString(){
        return super.toString() + ", Matches Played: " + this.noOfMatchesPlayed + ", Won: " + noOfMatchesWon + ", Lost: " + this.noOfMatchesLost + ", Draw: " + noOfMatchesDraw + ", Goal Score: " + noOfGoalScored + ", Goal received: " + noOwnGoalReceived + " Total points: " +noOfPoints;
    }
}
