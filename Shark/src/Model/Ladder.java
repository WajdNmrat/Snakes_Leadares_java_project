package Model;

public class Ladder {
	
	private String ladderId;
	private int stairsNum;
	private int DownPosition;
	private int TopPosition;
	
	
	
	public Ladder(String ladderId, int stairsNum, int downPosition, int topPosition) {
		super();
		this.ladderId = ladderId;
		this.stairsNum = stairsNum;
		DownPosition = downPosition;
		TopPosition = topPosition;
	}

	public String getLadderId() {
		return ladderId;
	}

	public void setLadderId(String ladderId) {
		this.ladderId = ladderId;
	}

	public int getStairsNum() {
		return stairsNum;
	}

	public void setStairsNum(int stairsNum) {
		this.stairsNum = stairsNum;
	}

	public void setDownPosition(int downPosition) {
		DownPosition = downPosition;
	}

	public void setTopPosition(int topPosition) {
		TopPosition = topPosition;
	}
	

	public int getDownPosition() {
		return DownPosition;
	}

	public int getTopPosition() {
		return TopPosition;
	}

	public int getLength() {
		
		return stairsNum;	
		
	}

	@Override
	public String toString() {
		return "Ladder [ladderId=" + ladderId + ", stairsNum=" + stairsNum + ", DownPosition=" + DownPosition
				+ ", TopPosition=" + TopPosition + "]";
	}
	
	
	
}
