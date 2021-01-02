package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FootballClub;
import models.Match;
import play.mvc.Controller;
import play.mvc.Result;
import services.PremierLeagueManager;
import utils.SortingObj;
import java.util.ArrayList;
import java.util.Stack;


public class PremierLeagueController extends Controller {

    private final PremierLeagueManager managerToUI = PremierLeagueManager.getInstanceOfPremierLeagueManage();
    /**
     * This method will return a json node to the UI which helps to show the Premier League Teams
     * @return the JSon Node Data
     */
    public Result getTeams(){
        System.out.println("[GET TEAMS]");
        //reading all the data from the file
        managerToUI.readingFromAFile();
        ArrayList<FootballClub> teamsOfTheLeague = managerToUI.displayThePremierLeagueTable();
        SortingObj.sortingInDescendingOrder(teamsOfTheLeague);

        ObjectMapper mappingOfTeams = new ObjectMapper();  //creating a Object Mapper so that we cans end it as a object node
        JsonNode jsonNode = mappingOfTeams.convertValue(teamsOfTheLeague,JsonNode.class); //JsonNode is creating to send the response
        return ok(jsonNode);
    }

    /**
     * This method will help to display the League Matches Played between the Premier League Teams
     * @return return the Json Node to the UI
     */
    public Result getMatches(){
        System.out.println("[GET MATCHES PLAYED]");
        managerToUI.readingFromAFile();
        ArrayList<Match> matchesPlayedByTeams = managerToUI.viewTheMatchesPlayed();

        ObjectMapper mappingMatches = new ObjectMapper();
        JsonNode transferToJsonData = mappingMatches.convertValue(matchesPlayedByTeams,JsonNode.class);
        return ok(transferToJsonData);
    }

    /**
     * This method will display the Random Matches Played
     * @return the Random stack List to the Ui to be displayed
     */
    public Result playRandomMatch(){

        System.out.println("[GET RANDOM MATCH]");
        Stack<Match> matchesPlayed = managerToUI.randomFootballMatchPlay();
        ObjectMapper mappingRandomMatches = new ObjectMapper();
        JsonNode jsonData = mappingRandomMatches.convertValue(matchesPlayed,JsonNode.class);

        managerToUI.savingToAFile();   //saving and reading the file so that the data will be stored properly without leakage
        managerToUI.readingFromAFile(); //reading the file again so that it will be update both to the file and the array
        return ok(jsonData);
    }
}
