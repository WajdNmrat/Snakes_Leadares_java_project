package Model;

public class QuestionCell {
	private int id;
	private int position;
	Question q;
	private String type;
	
	
	
	public QuestionCell(Question q, String type) {
		super();
		this.q = q;
		this.type = type;
	}
	
	public QuestionCell(int id, int position) {
		super();
		this.id = id;
		this.position = position;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	public Question getQ() {
		return q;
	}
	public void setQ(Question q) {
		this.q = q;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean check_answer(Question q) {
		
		//return false or true;
		return false;
		
	}


}
