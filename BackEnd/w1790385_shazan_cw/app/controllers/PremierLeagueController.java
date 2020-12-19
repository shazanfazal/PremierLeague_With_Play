package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FootballClub;
import models.Match;
import play.mvc.Controller;
import play.mvc.Result;
import services.PremierLeagueManager;
import utils.ApplicationUtil;
import utils.SortingObj;

import java.util.ArrayList;

/**
 *
 * @author Shaazan
 * @version 1.0
 */
public class PremierLeagueController extends Controller {

    /**
     * @param
     * @return {}
     */
    public Result getTeams(){
        System.out.println("[GET TEAMS]");
        //reading all the data from the file
        PremierLeagueManager.getInstanceOfPremierLeagueManage().readingFromAFile();
        ArrayList<FootballClub> teamsOfTheLeague = PremierLeagueManager.getInstanceOfPremierLeagueManage().displayThePremierLeagueTable();
        SortingObj.sortingInDescendingOrder(teamsOfTheLeague);

        ObjectMapper mappingOfTeams = new ObjectMapper();
        JsonNode jsonNode = mappingOfTeams.convertValue(teamsOfTheLeague,JsonNode.class);
        return ok(jsonNode);
    }

    public Result getMatches(){
        System.out.println("[GET MATCHES PLAYED]");
        PremierLeagueManager.getInstanceOfPremierLeagueManage().readingFromAFile();
        ArrayList<Match> matchesPlayedByTeams = PremierLeagueManager.getInstanceOfPremierLeagueManage().viewTheMatchesPlayed();

        ObjectMapper mappingMatches = new ObjectMapper();
        JsonNode transferToJsonData = mappingMatches.convertValue(matchesPlayedByTeams,JsonNode.class);
        return ok(transferToJsonData);
    }

    public Result sortByWins(){
        System.out.println("[Sort By Win Count]");
        PremierLeagueManager.getInstanceOfPremierLeagueManage().readingFromAFile();
        ArrayList<FootballClub> sortingWithWins = PremierLeagueManager.getInstanceOfPremierLeagueManage().sortByWinCount();

        ObjectMapper mappingWins = new ObjectMapper();
        JsonNode transferWins = mappingWins.convertValue(sortingWithWins,JsonNode.class);
        return ok(transferWins);
    }
}
