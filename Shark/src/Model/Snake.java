package Model;

import Model.Player;
import Model.Color;

public class Snake {
	
	private String snakeId;
	private Color color;
	private int length;
	private int headPosition;
	private int tailPosition;
	
	
	public Snake(String snakeId, Color color, int length, int headPosition, int tailPosition) {
		super();
		this.snakeId = snakeId;
		this.color = color;
		this.length = length;
		this.headPosition = headPosition;
		this.tailPosition = tailPosition;
	}
	
	public String getSnakeId() {
		return snakeId;
	}
	public void setSnakeId(String snakeId) {
		this.snakeId = snakeId;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeadPosition() {
		return headPosition;
	}
	public void setHeadPosition(int headPosition) {
		this.headPosition = headPosition;
	}
	public int getTailPosition() {
		return tailPosition;
	}
	public void setTailPosition(int tailPosition) {
		this.tailPosition = tailPosition;
	}
	
	@Override
	public String toString() {
		return "Snake [snakeId=" + snakeId + ", color=" + color + ", length=" + length + ", headPosition="
				+ headPosition + ", tailPosition=" + tailPosition + "]";
	}
	
	 // פונקציה ליצירת צבע רנדומלי
	   /* public static Color getRandomColor() {
	        Random rand = new Random();
	        float r = rand.nextFloat();
	        float g = rand.nextFloat();
	        float b = rand.nextFloat();
	        return new Color(r, g, b);
	    }

	    // פונקציה ליצירת אורך רנדומלי לנחש
	    public static int getRandomLength() {
	        Random rand = new Random();
	        return rand.nextInt(5) + 1; // בהנחה שאורך הנחש בין 1 ל-5
	    }

	    // בדיקה שהמרחק בין ראש הנחש לזנבו תקין
	    public static boolean isValidDistance(int head, int tail, int length) {
	        return (head - tail) == length - 1;
	    }
	    */
	public void movePlayer(Player player, Color color, int length) {
        int moveBy = 0;
        switch (color) {
            case YELLOW:
                moveBy = -1 * length;
                break;
            case GREEN:
                moveBy = -2 * length;
                break;
            case BLUE:
                moveBy = -3 * length;
                break;
            case RED:
                // המשתמש מחזיר לנקודת ההתחלה, נניח שהיא במשבצת 0
                //player.setPosition(0);
                return; // סיום הפעולה, לא צריך להמשיך לבדוק את שאר הצבעים
            default:
                // אם צבע לא נתמך, אין פעולה מיוחדת
                break;
        }
       // player.movePosition(moveBy);
    }
	

}
