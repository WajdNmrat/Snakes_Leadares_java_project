package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import View.JQuestion;

public class questionAddedCheck {

    private JQuestion jQuestion;

   /* @Before
    public void setUp() {
        jQuestion = new JQuestion();
        jQuestion.newQuestionField.setText("Test Question"); 
    }*/

    @Test
    public void testOnAddQuestionButtonClick() {
        // Get the initial size of the questions list
        int initialSize = jQuestion.getQuestions().size();
        
        // Simulate adding a question
        jQuestion.onAddQuestionButtonClick();
        
        // Check if the size of the questions list increased by 1
        assertEquals(initialSize , jQuestion.getQuestions().size());
    }
}
