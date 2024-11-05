package Controller;

public class LevelController {

	//private static String level;
	public static String gameLevel;
	public static int boardSize;
	public static int questionCellsNum;
	public static int surpriseCellsNum;
	
	public static void setGameLevel(String level) {
		gameLevel = level;
		switch(level) {
		case "easy":
			boardSize = 7;
			questionCellsNum = 3;
			surpriseCellsNum = 0;
			break;
		case "medium":
			boardSize = 10;
			questionCellsNum = 3;
			surpriseCellsNum = 1;
			break;
		case "hard":
			boardSize = 13;
			questionCellsNum = 3;
			surpriseCellsNum = 2;
			break;
		}
	}
	
	public static String getGameLevel() {
		return gameLevel;
	}

	
	
}
