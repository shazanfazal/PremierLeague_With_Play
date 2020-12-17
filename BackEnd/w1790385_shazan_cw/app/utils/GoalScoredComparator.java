package utils;

import models.FootballClub;
import java.util.Comparator;

public class GoalScoredComparator implements Comparator<FootballClub>{
	
	//to compare the teams that scored the most goals
	@Override
	public int compare(FootballClub firstObjSCount, FootballClub secondObjSCount){
		return (firstObjSCount.getNoOfGoalScored() - secondObjSCount.getNoOfGoalScored());
		
	}
}
