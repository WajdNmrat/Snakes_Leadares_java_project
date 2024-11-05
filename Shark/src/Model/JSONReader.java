package Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
	
	public static List<Question > questionList;

    public static List<Question> readQuestions(String filePath) {
        questionList = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON file
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            // Get questions array
            JSONArray questions = (JSONArray) jsonObject.get("questions");

            // Iterate through each question
            for (Object questionObj : questions) {
                JSONObject questionJson = (JSONObject) questionObj;

                // Extract question details
                String questionText = (String) questionJson.get("question");
                JSONArray answersAsarray = (JSONArray) questionJson.get("answers");
                int correctAnswerIndex = Integer.parseInt((String) questionJson.get("correct_ans"));
                int difficultyValue = Integer.parseInt((String) questionJson.get("difficulty"));     
                // Convert integer difficulty value to enum DifficultyLevel
                DifficultyLevel difficulty = convertToDifficultyLevel(difficultyValue);

                // Create a new Question object
                
                String [] answers = convertJSONArrayToStringArray(answersAsarray);
             /*****   Question question = new Question(questionText, answers,correctAnswerIndex,difficulty);****************/
                Question question = QuestionFactory.createQuestion(questionText, answers, correctAnswerIndex, difficulty);
                // Add the Question object to the list
                questionList.add(question);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    private static DifficultyLevel convertToDifficultyLevel(int value) {
        switch (value) {
            case 1:
                return DifficultyLevel.EASY;
            case 2:
                return DifficultyLevel.MEDIUM;
            case 3:
                return DifficultyLevel.HARD;
            default:
                throw new IllegalArgumentException("Invalid difficulty value: " + value);
        }
    }

    private static String[] convertJSONArrayToStringArray(JSONArray jsonArray) {
        String[] stringArray = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            stringArray[i] = (String) jsonArray.get(i);
        }
        return stringArray;
    }
}
