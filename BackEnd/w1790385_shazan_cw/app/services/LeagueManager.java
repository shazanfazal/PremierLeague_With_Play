package services;

import models.FootballClub;
import models.Match;

import java.util.ArrayList;

public interface LeagueManager {
    String addingANewClubToTheLeague(FootballClub nameOfNewClub);  //adding a new football club
    boolean deletingAClubFromTheLeague(String delegatedTeam); //deleting a football club
    void displayStatisticsOfTheClub(String checkStatistics); //statics of the relevant Premier League
    ArrayList<FootballClub> displayThePremierLeagueTable(); //viewing the premier league table
    boolean addAPlayMatch(Match addingAMatch); //to add a match
    ArrayList<Match> viewTheMatchesPlayed(); //to view the matches played
    void savingToAFile(); //saving to the file serialisation
    void readingFromAFile(); //reading from the file de serialisation
}
