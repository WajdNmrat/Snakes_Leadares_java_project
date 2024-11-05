package Main;

import Model.DifficultyLevel;
import Model.JSONReader;
import Model.JSONWriter;
import Model.Question;
import Model.SysData;
import View.StartScreen;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Trigger the screen . we should update this to view  when we click on History button in the main menu. 
        // Show the HistoryScreen
    	
    	StartScreen s = new StartScreen();
    	s.show();

    	
 	
   
//***********manually adding question*****************

/*String questionText = "What is the ";
String[] options = {"London", "Paris", "Berlin", "Rome"};
int correctAnswerIndex = 2; // Index of the correct answer (Paris)
DifficultyLevel difficulty = DifficultyLevel.MEDIUM; // 1 = easy, 2=meduim, 3=hard
Question newQuestion = new Question(questionText, options, correctAnswerIndex, difficulty);

System.out.println(" we Will add this question for test, you can change it and it will add and update the current JSON that already has 30 beta sample question");
System.out.println(newQuestion);
//Add the new question to the JSON file
JSONReader.questionList.add(newQuestion);
JSONWriter jsonWriter = new JSONWriter();
jsonWriter.exportQuestionsToJSON();*/
}
    
}
