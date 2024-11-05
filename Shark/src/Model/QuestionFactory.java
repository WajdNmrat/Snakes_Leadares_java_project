package Model;

public class QuestionFactory {

    public static Question createQuestion(String questionText, String[] options, int correctAnswerIndex, DifficultyLevel difficulty) {
        // Create and return a new Question object
        return new Question(questionText, options, correctAnswerIndex, difficulty);
    }
}
