package Model;

public class CellinBoard {

	private int position;
    private String type;
    private int i;
    private int j;
    
    public CellinBoard(int i, int j) {
    	this.i = i;
    	this.j = j;
    	this.type = "nothing";
    }
    
    public CellinBoard(int position, String type) {
    	this.position = position;
        this.type = type; 
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int GetI() {
    	return i;
    }
    public void setI(int i) {
    	this.i = i;
    }
    public int GetJ() {
    	return j;
    }
    public void setJ(int j) {
    	this.j = j;
    }
}
