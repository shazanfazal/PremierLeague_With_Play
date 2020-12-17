package utils;

import models.FootballClub;
import java.util.Comparator;

public class WinCountComparator implements Comparator<FootballClub>{
	
	//this comparator is used for th GUI where it will compare according to the team wins
	@Override
	public int compare(FootballClub firstObjWCount, FootballClub secondObjWCount){
		return (firstObjWCount.getNoOfMatchesWon() - secondObjWCount.getNoOfMatchesWon());
	}	
}
