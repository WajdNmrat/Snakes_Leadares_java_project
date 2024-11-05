package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.QuestionsShowController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import Model.DifficultyLevel;
import Model.Question;

public class JQuestionDetails extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JLabel questionTextLabel;
    private JLabel lblNewLabel_0;
    private JLabel lblNewLabel_1;
    private JLabel  lblNewLabel_4;
    private JTextField questionTextField;
    private JTextField answer1TextField;
    private JTextField answer2TextField;
    private JTextField answer3TextField;
    private JTextField answer4TextField;
    private JButton saveButton;
    private Question question;
    private JButton rButton;
	private JQuestion parentFrame;
	private JComboBox comboBox;
	private JLabel lblDifficulty;
	private DifficultyLevel difficulty;
	private Integer correctAnswerIndex;
	private JComboBox<Integer> correctindex_como;
	private JComboBox difficultyComboBox;
	private QuestionsShowController controller;
	private  int question_index_update;
	private int   index;
    public JQuestionDetails(Question question, JQuestion parentFrame) {
        this.question = question;
        this.parentFrame = parentFrame;
        
        controller = new QuestionsShowController(this);
        index = -1; // Initialize index to -1 indicating not found
        for (int i = 0; i < parentFrame.questions_list.size(); i++) {
            Question q = parentFrame.questions_list.get(i);
            if (q.getQuestionText().equals(question.getQuestionText())) {
                index = i; // Found the matching object based on question text
                break; // No need to continue searching
            }
        }


        
        

        question_index_update = parentFrame.findQuestionIndex(question);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to maximize
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 785, 505);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(254, 251, 144));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Display the original question text
        questionTextLabel = new JLabel("Question: ");
        questionTextLabel.setFont(new Font("David", Font.BOLD, 11));
        questionTextLabel.setBounds(5, 40, 60, 43);
        contentPane.add(questionTextLabel);
        JLabel originalQuestionLabel = new JLabel(question.getQuestionText());
        originalQuestionLabel.setBounds(76, 40, 334, 31);
        contentPane.add(originalQuestionLabel);

        // Create editable fields for the question and answers
        JLabel questionLabel = new JLabel("Edit Question:");
        questionLabel.setFont(new Font("David", Font.BOLD, 11));
        questionLabel.setBounds(5, 80, 115, 30);
        contentPane.add(questionLabel);
        questionTextField = new JTextField(question.getQuestionText());
        questionTextField.setBounds(110, 80, 407, 31);
        contentPane.add(questionTextField);
        lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/hi_8800714.png")));
		lblNewLabel_4.setBounds(750, 80, 500, 700);
		contentPane.add(lblNewLabel_4);
        JLabel answer1Label = new JLabel("Answer 1: ");
        answer1Label.setFont(new Font("David", Font.BOLD, 11));
        answer1Label.setBounds(5, 120, 60, 43);
        contentPane.add(answer1Label);
        answer1TextField = new JTextField(question.getOptions()[0]);
        System.out.println(question.getOptions()[0]);
        answer1TextField.setBounds(86, 120, 202, 31);
        contentPane.add(answer1TextField);

        JLabel answer2Label = new JLabel("Answer 2: ");
        answer2Label.setFont(new Font("David", Font.BOLD, 11));
        answer2Label.setBounds(5, 160, 71, 43);
        contentPane.add(answer2Label);
        answer2TextField = new JTextField(question.getOptions()[1]);
        answer2TextField.setBounds(86, 160, 202, 31);
        contentPane.add(answer2TextField);

        JLabel answer3Label = new JLabel("Answer 3: ");
        answer3Label.setFont(new Font("David", Font.BOLD, 11));
        answer3Label.setBounds(5, 200, 71, 49);
        contentPane.add(answer3Label);
        answer3TextField = new JTextField(question.getOptions()[2]);
        answer3TextField.setBounds(86, 200, 202, 31);
        contentPane.add(answer3TextField);

        JLabel answer4Label = new JLabel("Answer 4: ");
        answer4Label.setFont(new Font("David", Font.BOLD, 11));
        answer4Label.setBounds(5, 240, 71, 49);
        contentPane.add(answer4Label);
        answer4TextField = new JTextField(question.getOptions()[3]);
        answer4TextField.setBounds(86, 240, 202, 31);
        contentPane.add(answer4TextField);

        // Add a button to save changes
        saveButton = new JButton("Save Changes");
        saveButton.setFont(new Font("David", Font.BOLD, 14));
        saveButton.setBackground(Color.ORANGE);
        saveButton.setBounds(1110, 570, 144, 31);
        contentPane.add(saveButton);
        saveButton.addActionListener(e -> onSaveButtonClick());


        lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/q2.png")));
		lblNewLabel_1.setBounds(30, 530, 100, 100);
		contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Edit Question");
        lblNewLabel.setFont(new Font("David", Font.BOLD, 19));
        lblNewLabel.setBounds(10, 11, 234, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNumberOfCorrect = new JLabel("Number of correct answer:");
        lblNumberOfCorrect.setFont(new Font("David", Font.BOLD, 11));
        lblNumberOfCorrect.setBounds(5, 280, 185, 49);
        contentPane.add(lblNumberOfCorrect);
        
        rButton = new JButton("");
        rButton.setBackground(Color.RED);
        rButton.setIcon(new ImageIcon(getClass().getResource("/return.png")));
        rButton.setBounds(1210, 14, 46, 29);
        contentPane.add(rButton);
        rButton.addActionListener(this);
        
        Integer[] numbers = {1, 2, 3, 4};
        correctindex_como = new JComboBox<>(numbers);
        correctindex_como.setBounds(160, 297, 96, 22);
        contentPane.add(correctindex_como);
        
        
         difficultyComboBox = new JComboBox<>(DifficultyLevel.values());
        difficultyComboBox.setBounds(160, 340, 96, 22);
        contentPane.add(difficultyComboBox);
        
             
        lblDifficulty = new JLabel("Difficulty");
        lblDifficulty.setFont(new Font("David", Font.BOLD, 11));
        lblDifficulty.setBounds(5, 327, 185, 49);
        contentPane.add(lblDifficulty);
 

    }


    private void onSaveButtonClick() {
        // Update the question and answers with the new values

    	correctAnswerIndex = correctindex_como.getSelectedIndex()+1;
    	
        difficulty = (DifficultyLevel) difficultyComboBox.getSelectedItem();
        System.out.println("why? " + correctAnswerIndex);
    	question.setQuestionText(questionTextField.getText());
    	question.setAnswer(0, answer1TextField.getText());
    	question.setAnswer(1, answer2TextField.getText());
    	question.setAnswer(2, answer3TextField.getText());
    	question.setAnswer(3, answer4TextField.getText());
    	question.setDifficulty(difficulty);
    	question.setCorrectOptionIndex(correctAnswerIndex);
        System.out.println("new edited question:" + question);
        
       
       JQuestion.questions_list.set(index, question);
       System.out.println(JQuestion.questions_list);
       controller.updateQuestion(JQuestion.questions_list);
       
       
        // Update the question in the parent frame
        parentFrame.updateQuestion(this.question);
        
        parentFrame.onRemoveButtonClick(question);
        // Close the editing window
        JQuestionDetails.this.dispose();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==rButton)
		{
			this.dispose();
		}
		
    }
}
