package Model;

import java.util.Arrays;

public class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;
    private DifficultyLevel difficulty;

    public Question(String questionText) {
        this.questionText = questionText;
        this.options = new String[4]; // Assuming there are 4 answer choices
        this.correctOptionIndex = -1; // Set to -1 initially
        this.difficulty = difficulty;
    }
    
    public Question(String questionText, String[] options, int correctOptionIndex, DifficultyLevel difficulty) {
		super();
		this.questionText = questionText;
		this.options = options;
		this.correctOptionIndex = correctOptionIndex;
		this.difficulty = difficulty;
	}

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getAnswer(int index) {
        if (index >= 0 && index < options.length) {
            return options[index];
        } else {
            return null; // Handle invalid index
        }
    }

    public void setAnswer(int index, String answer) {
        if (index >= 0 && index < options.length) {
            options[index] = answer;
        } else {
            // Handle invalid index
        }
    }

	public DifficultyLevel getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}
	
	
	public String getOptionsAsString() {
	    StringBuilder optionsString = new StringBuilder();
	    optionsString.append("[");
	    for (int i = 0; i < options.length; i++) {
	        optionsString.append("\"").append(options[i]).append("\"");
	        if (i < options.length - 1) {
	            optionsString.append(", ");
	        }
	    }
	    optionsString.append("]");
	    return optionsString.toString();
	}

	
	
	@Override
	public String toString() {
	    return "Question: " + questionText + "\n" +
	           "Options: " + Arrays.toString(options) + "\n" +
	           "Correct Answer Index: " + correctOptionIndex + "\n" +
	           "Difficulty: " + difficulty;
	}
	
	
	
	



    
    
}


