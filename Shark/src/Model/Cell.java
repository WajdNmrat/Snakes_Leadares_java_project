package Model;

public class Cell {
	
	private Number id;
	private String type;
	
	public Cell(Number id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Cell [id=" + id + ", type=" + type + "]";
	}
	

}
