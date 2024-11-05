package Controller;

import java.util.List;
import Model.Game;
import Model.SysData;
import View.HistoryScreen;

public class GameHistoryController {
	
	private SysData sysData;
	private HistoryScreen historyScreen;
    public GameHistoryController(SysData sysData, HistoryScreen historyScreen) {
        this.sysData = sysData;
        this.historyScreen = historyScreen;

    }
    
    public GameHistoryController(SysData sysData) {
        this.sysData = sysData;

    }
    
    public void SendGameHistory() {
        List<Game> gameHistory = sysData.loadGameHistory();
        // Print the game history to the console
        for (Game entry : gameHistory) {
            System.out.println("GameID: " + entry.getGameID() +
                    ", Level: " + entry.getLevel() +
                    ", Winner: " + entry.getWinner() +
                    ", Duration: " + entry.getDuration() +
                    ", Date: " + entry.getGamedate());
            
        }
        
        historyScreen.displayGameHistory(gameHistory);
        
        
        //historyScreen.displayGameHistory(gameHistory);
       // historyScreen.show();
    }
	

	
	
	
	
	
	
	
	//////////////////////should be a function to add new game details for example "GameHistoryController.addGame "  should be a command in t he main when creating game////////////////////////////////////////
}