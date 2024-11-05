package Model;

public class Board {

	    private static Board instance;
	    private String level;
	    private int size;
	    private int[][] cells;
	   
	 // Private constructor to prevent instantiation from outside
	    private Board() {
	        
	    }
	    
	    // Static method to get the instance of Board
	    public static Board getInstance() {
	        if (instance == null) {
	            instance = new Board();
	        }
	        return instance;
	    }
	    
	    public int getSize() {
			return size;
		}


		public void setSize(int size) {
			this.size = size;
		}


		public int[][] getCells() {
			return cells;
		}


		public void setCells(int[][] cells) {
			this.cells = cells;
		}

		

		public static void setInstance(Board instance) {
			Board.instance = instance;
		}


		


	

	    
	}


   /* private int boardID;
    private int size;
    private Map<Integer, Snake> snakes; // Data structure to store snake locations
    private Map<Integer, Ladder> ladders; // Data structure to store ladder locations
    private Map<Integer, QuestionSquare> questionSquares; // Data structure to store question locations

    public Board(int boardID, int size) {
        this.boardID = boardID;
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.questionSquares = new HashMap<>();
    }

	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Map<Integer, Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(Map<Integer, Snake> snakes) {
		this.snakes = snakes;
	}

	public Map<Integer, Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(Map<Integer, Ladder> ladders) {
		this.ladders = ladders;
	}

	public Map<Integer, QuestionSquare> getQuestionSquares() {
		return questionSquares;
	}

	public void setQuestionSquares(Map<Integer, QuestionSquare> questionSquares) {
		this.questionSquares = questionSquares;
	}*/
    


