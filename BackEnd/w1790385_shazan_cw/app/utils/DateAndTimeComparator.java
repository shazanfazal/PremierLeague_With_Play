package utils;

import models.Match;
import java.util.Comparator;


public class DateAndTimeComparator implements Comparator <Match>{
	
	//comparing the date along the matched played, the get change minutes is a method which has converted the day,month,year,hours into minutes
	@Override
	public int compare(Match firstTeamGame, Match secondTeamGame){
		return (firstTeamGame.getMatchDatePlayed(). getChangeToMinutes() - secondTeamGame.getMatchDatePlayed(). getChangeToMinutes());
	}
	
}
