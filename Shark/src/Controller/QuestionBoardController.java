package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.DifficultyLevel;
import Model.Question;
import Model.SysData;


public class QuestionBoardController {
	
	public static List<Question> easyQuestions = new ArrayList<>();
	public static List<Question> meduimQuestions = new ArrayList<>();
	public static List<Question> hardQuestions = new ArrayList<>();
	
	
	
	
	public static void importquestions() {

	    
	    // Iterate through the questions list and categorize questions based on difficulty level
	    for (Question question : SysData.questions_list) {
	        if (question.getDifficulty() == DifficultyLevel.EASY) {
	            easyQuestions.add(question);
	        } else if (question.getDifficulty() == DifficultyLevel.MEDIUM) {
	        	meduimQuestions.add(question);
	        } else if (question.getDifficulty() == DifficultyLevel.HARD) {
	            hardQuestions.add(question);
	        }
	    }
	    
	    // Print or use the categorized questions
	    //System.out.println("Easy Questions:");
	    if (!easyQuestions.isEmpty()) {
	       // System.out.println(easyQuestions);
	    } else {
	        System.out.println("No easy questions available.");
	    }
	    
	    //System.out.println("Medium Questions:");
	    if (!meduimQuestions.isEmpty()) {
	       // System.out.println(mediumQuestions);
	    } else {
	        System.out.println("No medium questions available.");
	    }
	    
	   // System.out.println("Hard Questions:");
	    if (!hardQuestions.isEmpty()) {
	        //System.out.println(hardQuestions);
	    } else {
	        System.out.println("No hard questions available.");
	    }
	}

	
	
	public static Question get_random_easyquestion()
	{
		
	    // Choose a random question from easyQuestions
	  
		if (!easyQuestions.isEmpty())  
		{

	        Random random = new Random();
	        int randomIndex = random.nextInt(easyQuestions.size());
	        Question selectedQuestion = easyQuestions.get(randomIndex);
	        return selectedQuestion;
				
		} else {
	        // Handle case when no easy questions are available
	        System.out.println("No meduim questions available");
	        return null;
	    }

	}
	
	public static Question get_random_meduimquestion()
	{
		
	    // Choose a random question from easyQuestions
	    if (!meduimQuestions.isEmpty()) {
	        Random random = new Random();
	        int randomIndex = random.nextInt(meduimQuestions.size());
	        Question selectedQuestion = meduimQuestions.get(randomIndex);
	        return selectedQuestion;
	        
	        // Now you have a randomly selected easy question in selectedQuestion
	        // You can proceed to display it or use it as needed
	    } else {
	        // Handle case when no easy questions are available
	        System.out.println("No meduim questions available");
	        return null;
	    }
		
	    
	}
	
	public static Question get_random_hardquestion()
	{
		
		
	    // Choose a random question from easyQuestions
	    if (!hardQuestions.isEmpty()) {
	        Random random = new Random();
	        int randomIndex = random.nextInt(hardQuestions.size());
	        Question selectedQuestion = hardQuestions.get(randomIndex);
	        return selectedQuestion;
	        
	        // Now you have a randomly selected easy question in selectedQuestion
	        // You can proceed to display it or use it as needed
	    } else {
	        // Handle case when no easy questions are available
	        System.out.println("No hard questions available");
	        return null;
	    }
		
	    
	}
	
	public static Question get_random_question()
	{
		
		
	    // Choose a random question from easyQuestions
	    if (! SysData.questions_list.isEmpty()) {
	        Random random = new Random();
	        int randomIndex = random.nextInt( SysData.questions_list.size());
	        Question selectedQuestion =  SysData.questions_list.get(randomIndex);
	        return selectedQuestion;
	        
	        // Now you have a randomly selected easy question in selectedQuestion
	        // You can proceed to display it or use it as needed
	    } else {
	        // Handle case when no easy questions are available
	        System.out.println("No questions available");
	        return null;
	    }
		
	    
	}
	
	
	

	

}
