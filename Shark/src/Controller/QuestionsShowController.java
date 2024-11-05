package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Game;
import Model.JSONReader;
import Model.JSONWriter;
import Model.Question;
import Model.SysData;
import View.HistoryScreen;
import View.JQuestion;
import View.JQuestionDetails;

public class QuestionsShowController {
	
	private JQuestion Jquestions;
	private JQuestionDetails JquestionDetails;
	private List<Question> questions;
	
    public QuestionsShowController(JQuestion Jquestions) {
        
    	 this.Jquestions = Jquestions;

    }
    
    public QuestionsShowController(JQuestionDetails jQuestionDetails) {
    	this.Jquestions = Jquestions;
	}

	public List<Question> getQuestions() {
    	questions = SysData.ImportQuestionsFromJson();
    	
        return questions;
        
        //historyScreen.displayGameHistory(gameHistory);
       // historyScreen.show();
    }
    
    public void addQuestion(Question newquestion) {
        // Create a new Question object
    	
        questions.add(newquestion);
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.exportQuestionsToJSON(questions);
        // Add the question to the model or perform any other necessary operations
        // For example, update the view
       // Jquestions.populateTable();
        
    }
    
    public void updateQuestion(List<Question> questions) {
        // Create a new Question object
    	
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.exportQuestionsToJSON(questions);
        // Add the question to the model or perform any other necessary operations
        // For example, update the view
       // Jquestions.populateTable();
        
    }
    
   

}
