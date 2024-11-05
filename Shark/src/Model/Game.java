package Model;

import java.util.ArrayList;



public class Game {
	
    private int gameID;
    //private String startTime; i will use them later , I will do starttime - end time to calcualte duraitioon
   // private String endTime;
    private String duration;
    private String gamedate;
	private DifficultyLevel level;
    private int num_of_players;
    private ArrayList<Player> players;
    private String winner;
    
    
	public Game(int gameID, DifficultyLevel level, String winner,String duration,String gamedate) { ////// used for game history screen only /////
		super();
		this.gameID = gameID;
		this.gamedate = gamedate;
		this.level = level;
		System.out.println(gameID);
		this.winner = winner;
		this.duration = duration;
		this.gamedate = gamedate;
		
	}



	public int getGameID() {
		return gameID;
	}





	public void setGameID(int gameID) {
		this.gameID = gameID;
	}





	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getGamedate() {
		return gamedate;
	}


	public void setGamedate(String gamedate) {
		this.gamedate = gamedate;
	}



	public DifficultyLevel getLevel() {
		return level;
	}

	public void setLevel(DifficultyLevel level) {
		this.level = level;
	}


	public int getNum_of_players() {
		return num_of_players;
	}


	public void setNum_of_players(int num_of_players) {
		this.num_of_players = num_of_players;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}


	public String getWinner() {
		return winner;
	}


	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String toCSVString() {
        return gameID + "," + level.toString() + "," + winner + "," + duration + "," + gamedate;
    }
	

}
