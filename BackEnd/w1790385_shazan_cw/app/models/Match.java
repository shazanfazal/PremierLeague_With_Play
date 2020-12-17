package models;

import java.io.Serializable;

public class Match implements Serializable {
    private String homeTeamMatch;
    private String awayTeamMatch;
    private DateAndTime matchDatePlayed;
    private int homeGoalScored;
    private int awayGoalScored;


    //default constructor
    public Match(){

    }
    public Match(String homeTeamMatch, String awayTeamMatch,int homeGoalScored,int awayGoalScored, DateAndTime matchDatePlayed){
        this.homeTeamMatch = homeTeamMatch;
        this.awayTeamMatch = awayTeamMatch;
        this.homeGoalScored = homeGoalScored;
        this.awayGoalScored = awayGoalScored;
        this.matchDatePlayed = matchDatePlayed;
    }

    //getters for instance variables
    public String getHomeTeamMatch(){
        return this.homeTeamMatch;
    }

    public String getAwayTeamMatch(){
        return this.awayTeamMatch;
    }

    public DateAndTime getMatchDatePlayed(){
        return this.matchDatePlayed;
    }

    public int getHomeGoalScored(){
        return this.homeGoalScored;
    }

    public int getAwayGoalScored(){
        return this.awayGoalScored;
    }

    //setters for instance variables
    public void setHomeTeamMatch(String homeTeamMatch){
        this.homeTeamMatch = homeTeamMatch;
    }

    public void setAwayTeamMatch(String awayTeamMatch){
        this.awayTeamMatch = awayTeamMatch;
    }

    public void setDateAndTime(DateAndTime matchDatePlayed){
        this.matchDatePlayed = matchDatePlayed;
    }

    public void setHomeGoalScored(int homeGoalScored){
        this.homeGoalScored = homeGoalScored;
    }

    public void setAwayGoalScored(int awayGoalScored){
        this.awayGoalScored = awayGoalScored;
    }

    @Override
    public String toString(){
        return " Home Team: " + this.homeTeamMatch + ", Away Team: " + this.awayTeamMatch + ", Home Goals: " + this.homeGoalScored + ", Away Goals: " + this.awayGoalScored +", Played on: " + this.matchDatePlayed;
    }
}
