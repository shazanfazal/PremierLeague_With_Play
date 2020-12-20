package utils;


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
}
