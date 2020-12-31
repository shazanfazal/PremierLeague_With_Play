package utils;


import models.DateAndTime;

public class PrintTablesFormat {

	/**
	 * to print the table header
	 */
	public static void headingForViewPointsTable(){
		System.out.println("================================================ Points Table ============================================================");
	}

	/**
	 * to print the name of the specific teams header
	 * @param clubName the club name that statistics will be showed
	 */
	public static void headingToViewStats(String clubName){
	System.out.println("======================================= Statistics for "+ clubName +" ========================================================");
	
	}

	/**
	 * main heading for the column
	 */
	public static void mainFormatTable(){
		System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
		System.out.printf("|\t%-20s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-7s|\t%-6s\n","Club Name","MP","Won","Lost","Draw","GS","GR","GD","Points   |");
		System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
	}

	/**
	 * this is to print th match view table heading
	 */
	public static void headingForViewMatch(){
		System.out.println("=============================================== Match Preview ==============================================================");
	}

	/**
	 * this is to print the match table heading
	 */
	public static void  mainMatchTableFormat(){
		System.out.println("*---------------------------------------------------------------------------------------------------------------------------*");
		System.out.printf("|\t%-20s|\t%-20s|\t%-7s\t\t|\t%-7s\t\t|\t%-40s\t\t\t\t\n","Home Team","Away Team","Home GS","Away Gs","\t\t\tDate      \t\t\t\t\t|");
		System.out.println("*---------------------------------------------------------------------------------------------------------------------------*");
	}

	/**
	 * This will print the data to the match table preview or the data to the body
	 * @param homeTeam The home team which played
	 * @param awayTeam the away team which played
	 * @param homeGs the goal count that the home team scored
	 * @param awayGs the goal count that thw away team scored
	 * @param datePlayed the date when tha match was played
	 */
	public static void printValuesForMatchPreview(String homeTeam, String awayTeam, int homeGs, int awayGs, DateAndTime datePlayed){
		System.out.printf("|\t%-20s|\t%-20s|\t%-7s\t\t|\t%-7s\t\t|\t\t%-40s\t\n",homeTeam,awayTeam,homeGs,awayGs,datePlayed + "      \t|");

	}
}
