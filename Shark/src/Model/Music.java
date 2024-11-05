package Model;

public class Music {
 	private int id;
 	private String fileName;
 	private String description;
 	//private boolean needToContinue;
 	
 	
	public Music(int id, String fileName, String description) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.description = description;
	}


	public Music(int id, String fileName) {
		super();
		this.id = id;
		this.fileName = fileName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
}