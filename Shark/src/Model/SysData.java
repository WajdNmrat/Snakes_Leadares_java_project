package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SysData {
	
	private static final String GAME_HISTORY_FILE = "/game_history.csv";
	private static final String JSON_FILE = "src/questions.json";
	public static  List<Question> questions_list;
	public static List <Game> gameHistory = new ArrayList<>();
	
	////////////////////////////this code Reading our CSV file that contain the History of the Games and initializing the objects ///////////////////////////////////////////////////////
	public List<Game> loadGameHistory() {
	    boolean isFirstLine = true;

	    try (InputStream is = getClass().getResourceAsStream(GAME_HISTORY_FILE);
	         BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Skip the first line
	            if (isFirstLine) {
	                isFirstLine = false;
	                continue;
	            }

	            String[] parts = line.split(",");
	            if (parts.length == 5) {
	            	String gameIDString = parts[0].trim();
	            	int gameID = Integer.parseInt(gameIDString); //convert string to int
	                String levelString = parts[1].trim();
	                DifficultyLevel level = DifficultyLevel.valueOf(levelString.toUpperCase()); //convert string to enum
	                String winner = parts[2].trim();
	                String duration = parts[3].trim();
	                String gamedate = parts[4].trim();
	                gameHistory.add(new Game(gameID, level, winner, duration, gamedate));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return gameHistory;
	}
	public static void writeGameToCSV(Game game) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(GAME_HISTORY_FILE, true))) {
            // Append game data to the CSV file
            writer.write(game.toCSVString());
            writer.newLine(); // Add a newline after each game entry
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static List<Question> ImportQuestionsFromJson() {  
		
		questions_list = JSONReader.readQuestions(JSON_FILE); //reading from json file and put them in arraylist of Question 
		//System.out.println(questions_list); // printing quesitons that has been read from JSON FILE 
			
		return questions_list;

	}

	
	
	

	
    ///////////////////////////////////////////////////////////////////////////Getter&setter/////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
    ///////////////////////////////////////////////////////////////////////////functions/////////////////////////////////////////////////////////////////////////////////////////////////////
	//public void addGame(Game game) { // this function will be used later initial and save every new game we create . 
		//gameHistoryArray.add(game);// save each new game in arraylist .
		} 
	




