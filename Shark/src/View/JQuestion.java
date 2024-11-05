package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.QuestionsShowController;
import Model.DifficultyLevel;
import Model.Game;
import Model.Question;
import Model.QuestionFactory;
import Model.SysData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JQuestion extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable questionTable;
    private DefaultTableModel tableModel;
    private JButton logout;
    private JMenuItem AddQ;
    private JMenuItem RemoveQ;
    private JMenuItem AllBestsGamers;
    private JMenuItem questions;
    private JMenuItem games;
    private JMenuItem EditQ;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_1;
    private JButton deleteButton;
    private JButton editButton;
    private JButton addQuestionButton;
    private JLabel lblNewLabel;
    private int   index_2;
    private List<Question> Lquestions = new ArrayList<>();
    public static List<Question> questions_list = new ArrayList<>();
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JQuestion frame = new JQuestion();
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            		frame.setBounds(100, 100, 1920, 1080);
            		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    private QuestionsShowController controller;

    public JQuestion() {
    	
    	
    	controller = new QuestionsShowController(this);
    	setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to maximize
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 772, 516);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(176, 224, 230));
        setJMenuBar(menuBar);

        JMenu AddMenu = new JMenu("Questions Menu");
        menuBar.add(AddMenu);

        AddQ = new JMenuItem("Add Question");
        AddMenu.add(AddQ);
        AddQ.addActionListener(this);

        RemoveQ = new JMenuItem("Remove Question");
        AddMenu.add(RemoveQ);
        RemoveQ.addActionListener(this);

        EditQ = new JMenuItem("Edit Question");
        AddMenu.add(EditQ);
        EditQ.addActionListener(this);

        JMenu QueryMenu = new JMenu("Query Menu");
        menuBar.add(QueryMenu);

        AllBestsGamers = new JMenuItem("AllBestsGamers");
        QueryMenu.add(AllBestsGamers);
        AllBestsGamers.addActionListener(this);

        JMenu mnNewMenu_3 = new JMenu("History Menu");
        menuBar.add(mnNewMenu_3);

        questions = new JMenuItem("Show Questions");
        mnNewMenu_3.add(questions);
        questions.addActionListener(this);

        games = new JMenuItem("Show Games");
        mnNewMenu_3.add(games);
        games.addActionListener(this);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(254, 251, 144));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.setBackground(Color.ORANGE);
        addQuestionButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        addQuestionButton.setBounds(550, 30, 200, 40);
        contentPane.add(addQuestionButton);
        addQuestionButton.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(90, 90, 1100, 187);
     // Set maximum width for the scroll pane
        scrollPane.setPreferredSize(new Dimension(1250, 187));
        contentPane.add(scrollPane);

        // Create the table model with column names and set it to the table
        String[] columnNames = {"Question", "Edit", "Remove"};
        tableModel = new DefaultTableModel(null, columnNames) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        questionTable = new JTable(tableModel);
        scrollPane.setViewportView(questionTable);

        // Add edit button renderer and editor to the table
        questionTable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        questionTable.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox()));

        // Add remove button renderer and editor to the table
        questionTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRendererRe());
        questionTable.getColumnModel().getColumn(2).setCellEditor(new ButtonRemover(new JCheckBox()));

        // Set the button column width to a fixed size
        questionTable.getColumnModel().getColumn(1).setMinWidth(80);
        questionTable.getColumnModel().getColumn(1).setMaxWidth(80);
        questionTable.getColumnModel().getColumn(2).setMinWidth(90);
        questionTable.getColumnModel().getColumn(2).setMaxWidth(90);

        // Populate the table with question data
        populateTable();

        logout = new JButton("Back");
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.ORANGE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 13));
        logout.setBounds(1160, 570, 89, 23);
        contentPane.add(logout);
        logout.addActionListener(this);


        lblNewLabel = new JLabel("Write a question here to add it:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 6, 400, 14);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/q.png")));
		lblNewLabel_1.setBounds(550, 350, 450, 200);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/q2.png")));
		lblNewLabel_2.setBounds(30, 530, 100, 100);
		contentPane.add(lblNewLabel_2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQuestionButton) {
            onAddQuestionButtonClick();
        } else if (e.getSource() == logout) {
            onLogoutButtonClick();
        } else {
            ////////////////////////////edit/////////////////////////////////////////// Handle row click event
            int selectedRow = questionTable.getSelectedRow();
            if (selectedRow != -1) {
                String questionText = (String) tableModel.getValueAt(selectedRow, 0);
                Question question_edit_this = findQuestion(questionText);  
                // Create and show the details page
                JQuestionDetails detailsPage = new JQuestionDetails(question_edit_this, this);
                detailsPage.setVisible(true);
                // Wait for the details page to close
                detailsPage.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        populateTable();
                    }
                });
            }
        }
    }


    public void populateTable() {
    	tableModel.setRowCount(0);
    	questions_list = controller.getQuestions();

        for (Question question : questions_list) {
        
            JButton editButton = createEditButton(question);
            JButton removeButton = createRemoveButton(question);
            Object[] rowData = {question.getQuestionText(), editButton, removeButton};
            tableModel.addRow(rowData);
            
        }

        // Add mouse listener to handle row removal and edit
        questionTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = questionTable.rowAtPoint(e.getPoint());
                int col = questionTable.columnAtPoint(e.getPoint());
                if (col == 1) { // Check if the "Edit" button was clicked
                    // Handle edit button click here
                    // For example, show a dialog for editing the question
                	String questionText = (String) tableModel.getValueAt(row, 0);
                	Question question = findQuestion(questionText);
                    System.out.println("Edit button clicked for question: " + questionText);
                    //Question selectedQuestion = new Question(questionText);
                    //JQuestionDetails detailsPage = new JQuestionDetails(selectedQuestion);
                    //detailsPage.setVisible(true);

                    actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, ""));
                    
                } else if (col == 2) { // Check if the "Remove" button was clicked
                	String questionText_2 = (String) tableModel.getValueAt(row, 0);
                	 Question question_remove_this = findQuestion(questionText_2); 
                	 
                     for (int i = 0; i < questions_list.size(); i++) {
                         Question q = questions_list.get(i);
                         if (q.getQuestionText().equals(question_remove_this.getQuestionText())) {
                        	 index_2 = i; // Found the matching object based on question text
                             break; // No need to continue searching
                         }
                     }
                     
                     questions_list.remove(index_2);
                     controller.updateQuestion(JQuestion.questions_list);
                     System.out.println("list after remove: " + JQuestion.questions_list);
                     // Create and show the details page
                    tableModel.removeRow(row); // Remove the clicked row
                    System.out.println("Remove button clicked for question: " + questionText_2);
                }
            }
        });

        // Disable cell selection
        questionTable.setCellSelectionEnabled(false);
    }
    
    private void populateQuestion(Question q) {
        JButton editButton = createEditButton(q);
        JButton removeButton = createRemoveButton(q);
        Object[] rowData = {q.getQuestionText(), editButton, removeButton};
        tableModel.addRow(rowData);
    }




    private JButton createEditButton(Question question) {
        JButton editButton = new JButton();
        editButton.setText("Edit");
        editButton.addActionListener(e -> onEditButtonClick(question));
        return editButton;
    }

    private void onEditButtonClick(Question question) {
    	
        // Handle edit button click
        // You can open a dialog or perform any action here
        JOptionPane.showMessageDialog(this, "Edit button clicked for: " + question.getQuestionText());
        JQuestionDetails detailsPage = new JQuestionDetails(question,this);
        detailsPage.setVisible(true);
    }

    private JButton createRemoveButton(Question question) {
        JButton removeButton = new JButton();
        removeButton.setText("Delete");
        removeButton.addActionListener(e -> onRemoveButtonClick(question));
        return removeButton;
    }

    
    
    ///////////******removeeeeeee********************/////////////////
    void onRemoveButtonClick(Question question) {
        // Remove the question from the list of questions
        List<Question> questions_list = getQuestions();
        questions_list.remove(question);

        // Find the index of the question in the table and remove the corresponding row
        int rowIndex = findQuestionRowIndex(question);
        if (rowIndex != -1) {
            tableModel.removeRow(rowIndex);
        }
    }


    private int findQuestionRowIndex(Question question) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (question.getQuestionText().equals(tableModel.getValueAt(i, 0))) {
                return i;
            }
        }
        return -1;
    }

    public void onAddQuestionButtonClick() {
        // Create an array of text fields for the options
        JTextField[] optionFields = new JTextField[4];
        for (int i = 0; i < optionFields.length; i++) {
            optionFields[i] = new JTextField();
        }
        
        // Create a combo box for the difficulty level
        JComboBox<DifficultyLevel> difficultyComboBox = new JComboBox<>(DifficultyLevel.values());
        Integer[] numbers = {1, 2, 3, 4};
        JComboBox<Integer> correctindex_como = new JComboBox<>(numbers);
        
        // Create an array of labels for the options
        String[] optionLabels = {"Option 1:", "Option 2:", "Option 3:", "Option 4:"};
        
        
        // Create a panel to hold the components
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("New Question:"));
        JTextField questionField = new JTextField();
        panel.add(questionField);
        for (int i = 0; i < optionFields.length; i++) {
            panel.add(new JLabel(optionLabels[i]));
            panel.add(optionFields[i]);
        }
        panel.add(new JLabel("Difficulty Level:"));
        panel.add(new JLabel("correct answer:"));
        panel.add(difficultyComboBox);
        panel.add(correctindex_como);
        
        // Show the option pane and get the user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Question Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Retrieve the user input
            String newQuestion = questionField.getText().trim();
            String[] options = new String[4];
            for (int i = 0; i < options.length; i++) {
                options[i] = optionFields[i].getText().trim();
            }
            int correctAnswerIndex = correctindex_como.getSelectedIndex() + 1;
            DifficultyLevel difficulty = (DifficultyLevel) difficultyComboBox.getSelectedItem();
            
            // Validate input
            if (newQuestion.isEmpty() || Arrays.stream(options).anyMatch(String::isEmpty)) {
                JOptionPane.showMessageDialog(this, "Please enter all question details.");
                return; // Exit method if any field is empty
            }
            
            // Create the Question object and add it
          /*  Question q = new Question(newQuestion, options, correctAnswerIndex, difficulty);*/
            Question q = QuestionFactory.createQuestion(newQuestion, options, correctAnswerIndex, difficulty);
            controller.addQuestion(q);
            JButton editButton = createEditButton(q);
            JButton removeButton = createRemoveButton(q);
            Object[] rowData = {newQuestion, editButton, removeButton};
            tableModel.addRow(rowData);
        }
    }

    
    

    private void onLogoutButtonClick() {
        this.dispose();
        JAdmin a = new JAdmin();
		a.setVisible(true);
    }

    public List<Question> getQuestions() {
    	
    	
        
        // Example: Adding some sample questions
        /*Lquestions.add(new Question("Question 1"));
        Lquestions.add(new Question("Question 2"));
        Lquestions.add(new Question("Question 3"));*/
        return Lquestions;
    }

    public void updateQuestion(Question questionToUpdate) {
       
    	Lquestions.add(questionToUpdate);
    	populateQuestion(questionToUpdate);
    	
    }


    private Question findQuestion(String questionText) {
        List<Question> questions_list = controller.getQuestions();
        for (Question question : questions_list) {
            if (question.getQuestionText().equals(questionText)) {
                return question;
            }
        }
        return null; // Return null if the question is not found
    }
    
    int findQuestionIndex(Question question) {
       
    	
        for (int i = 0; i < questions_list.size(); i++) {
    
            if (questions_list.get(i).equals(question)) {
                return i;
            }
        }
        return -1; // Return -1 if the question is not found
    }
}
