package Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONWriter {


 		public void exportQuestionsToJSON(List<Question> questionslist) {
	    	   try {
	    		   
	    		   //ArrayList<Question> questionslist = new ArrayList<>(SysData.ImportQuestionsFromJson());
	    		   
	    	        JsonArray data = new JsonArray();

	    	        
	                for(int i=0; i<questionslist.size(); i++) {
	                	JsonObject question = new JsonObject();
	                	question.put("question", questionslist.get(i).getQuestionText().toString()); 
	                	question.put("correct_ans", String.valueOf(questionslist.get(i).getCorrectOptionIndex()));
	                	int difficultyNumtoINT = convertDifficultyLevelToInt(questionslist.get(i).getDifficulty());
	                	String difficultyINTtoString = String.valueOf(difficultyNumtoINT);
	                	question.put("difficulty", difficultyINTtoString);
	                	
	                	
	                	
	                	String[] answersArray = questionslist.get(i).getOptions();
	                	JsonArray answers = new JsonArray();
	                    for (String answer : answersArray) {
	                        answers.add(answer);
	                    }
	                	
	                    question.put("answers", answers);
	                	data.add(question);
	                 }
	                
	                
	            	 JsonObject doc = new JsonObject();
	    		   	 doc.put("questions", data);
	    		   	 
	                 File file = new File("src/questions.json");
	                 file.getParentFile().mkdir();
	                   
	                 try (FileWriter writer = new FileWriter(file)) {
	                	  writer.write(Jsoner.prettyPrint(doc.toJson()));
	                	  writer.flush();
	                 } catch (IOException e) {
	                	   e.printStackTrace();
	                 }
	           } catch (Exception e) {
	               e.printStackTrace();
	           }	
	    }

    

    private static int convertDifficultyLevelToInt(DifficultyLevel difficulty) {
        switch (difficulty) {
            case EASY:
                return 1;
            case MEDIUM:
                return 2;
            case HARD:
                return 3;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        }
    }
}
