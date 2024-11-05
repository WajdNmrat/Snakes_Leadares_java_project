package Model;

public class Dice {
	
	private String diceId;
	private int choiseNum;
	private int totalChoisesNum;
	private int playerId;
	private int gameId;
	

	public Dice(String diceId, int choiseNum, int totalChoisesNum, int playerId, int gameId) {
		super();
		this.diceId = diceId;
		this.choiseNum = choiseNum;
		this.totalChoisesNum = totalChoisesNum;
		this.playerId = playerId;
		this.gameId = gameId;
	}

	public String getDiceId() {
		return diceId;
	}

	public void setDiceId(String diceId) {
		this.diceId = diceId;
	}


	public int getChoiseNum() {
		return choiseNum;
	}

	public void setChoiseNum(int choiseNum) {
		this.choiseNum = choiseNum;
	}

	public int getTotalChoisesNum() {
		return totalChoisesNum;
	}

	public void setTotalChoisesNum(int totalChoisesNum) {
		this.totalChoisesNum = totalChoisesNum;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return "Dice [diceId=" + diceId + ", choiseNum=" + choiseNum + ", totalChoisesNum=" + totalChoisesNum
				+ ", playerId=" + playerId + ", gameId=" + gameId + "]";
	}
	
	public void throwDice() {
		
	}
	

}
