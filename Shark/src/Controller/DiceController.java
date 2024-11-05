package Controller;

import java.util.Random;

public class DiceController {
	
	
    public static int generateRandomNumber(String level) {
        Random random;
        int rand; 
        switch(level) {
        case "easy":
        	 do{
             	random = new Random();
             	rand = random.nextInt(11);
             }while(rand>5 && rand<8);
             return rand;
        case "medium":
        	random = new Random();
        	// The questions receive a double chance - statistically, every second dice roll is a question.
         	rand = random.nextInt(14);
         	if(rand>10) {
         		return rand-3;
         	}else {
         		return rand;
         	}
        case "hard":
        	random = new Random();
        	rand = random.nextInt(15);
         	if(rand>10&&rand<13) {
         		return rand-2;
         	}else if(rand>12){
         		return 10;
         	}else {
         		return rand;
         	}
         	
        }
        return 0;
    }

	public static String toDo(int diceValue) {
    	switch (diceValue) {
        case 0:
            return "0 - the player does not move";
		case 1:
            return "<html>1 - The player moves one step<br> forward.</html>";
		case 2:
            return "<html>2 - The player moves two steps forward.</html>";
		case 3:
            return "<html>3 - The player moves three steps forward.</html>";
		case 4:
            return "<html>4 - The player moves four steps forward.</html>";
		case 5:
            return "<html>5 - The player moves five steps forward.</html>";
		case 8:
            return "<html>8 - Easy question <br> the player gets a random easy question<br>and he has to answer it.<br> The player moves according to the answer</html>";
		case 9:
            return "<html>9 - Medium question <br> the player receives a random medium <br> question and has to answer it.<br> The player moves according to the answer</html>";
        // case 10
        default:
        	return "<html>10 - hard question <br> the player gets a random hard <br> question and has to answer it.<br>The player moves according to the answer</html>";
    }

    }
}
