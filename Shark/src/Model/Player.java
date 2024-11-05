package Model;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Player {
	
    private int playerID;
    private String name;
	private String playerColor;
    private JLabel object;
    private int currentPosition;
    
 
    public JLabel getObject() {
		return object;
	}
	public void setObject(JLabel object) {
		this.object = object;
	}
	public Player(int playerID, String name, String playerColor, JLabel object, int currentPosition) {
		super();
		this.playerID = playerID;
		this.name = name;
		this.playerColor = playerColor;
		this.object = object;
		this.currentPosition = currentPosition;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	  public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
	
	public String getPlayerColor() {
		return playerColor;
	}
	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

}
