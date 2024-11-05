package View;

import javax.swing.*;

import Controller.CellController;
import Controller.DiceController;
import Controller.LevelController;
import Controller.MusicController;
import Controller.QuestionBoardController;
import Controller.QuestionsShowController;
//import Controller.ScreenController;
import Controller.SelectPlayer_Names_ColoersController;
import Controller.SurpriseCellController;
import Model.Cell;
import Model.CellinBoard;
import Model.DifficultyLevel;
import Model.Game;
import Model.Ladder;
import Model.Music;
import Model.Player;
import Model.Question;
import Model.Snake;
import Model.SysData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;




public class BoardView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iYellow;
	private Integer  yYellow;
	private Integer iiRed;
	private Integer yyRed;
	private Integer i1Blue;
	private Integer y1Blue;
	private Integer iGreen;
	private Integer yGreen;
	private ArrayList <Ladder> ladders = new ArrayList<>() ;
	private int number_player=0;
	private ArrayList <Snake> snakes = new ArrayList<>() ;
	private JFrame frame;
	private static JPanel boardPanel;
	private static JPanel[][] cellPanels;
	private static JLabel[][] cellNumbers;
	public static int cellSize;
    private JFrame questionFrame;
    private int correctAnswerIndex;
	
	private int flag=0;

	private static final int BOARD_SIZE = 7;

    public static Integer result, position;
	
    //private JPanel board;
    private JLabel timerLabel; // Timer display label
    private Timer timer; // Timer object to update the timer display
    private int secondsElapsed;
   // public JPanel[][] cellPanels;
    //public JLabel[][] cellNumbers;
    private JButton diceButton;
    private JLabel diceValue;
    private JLabel currentPlayerLabel1234;
    private QuestionBoardController controller_question;
    private Question selected_question;
    private int user_answer_result;
    
    public BoardView() {
    	
    	SysData.ImportQuestionsFromJson(); // load the question for the game
    	controller_question.importquestions();
        initializeUI();
        startTimer();
    }
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() { // Update the timer every second
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsElapsed++;
                updateTimerDisplay();
            }
        });
        timer.start(); // Start the timer
    }
    public static DifficultyLevel convertToDifficultyLevel(int value) {
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
    private void updateTimerDisplay() {
        int minutes = secondsElapsed / 60;
        int seconds = secondsElapsed % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds)); // Update the timer display
    }
    // First of all we need a board
    public static JPanel createBoard(int boardSize){
   	 boardPanel = new JPanel();
   	 switch(boardSize) {
   	 case 7:
   		 cellSize = 90;
   		 break;
   	 case 10:
   		 cellSize = 60;
   		 break;
   	 case 13:
   		 cellSize = 45;
   		 break;
   	 }
   	 if(selectLevel.flag_level==1)
   	 {
   	 boardPanel.setBounds(30, 30, 700 ,700);
   	 }
   	if(selectLevel.flag_level==2)
  	 {
  	 boardPanel.setBounds(30, 0, 750 ,750);
  	 }
   	if(selectLevel.flag_level==3)
  	 {
  	 boardPanel.setBounds(30, 0, 750 ,750);
  	 }
    boardPanel.setLayout(new GridLayout(boardSize, boardSize));
        cellPanels = new JPanel[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                    cellPanels[i][j] = new JPanel();
                    cellPanels[i][j].setLayout(null);
                    cellPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    cellPanels[i][j].setBackground(Color.WHITE);  
            }
        }
        // Add cells to the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
           	 CellController.createCell(i,j);
           	 boardPanel.add(cellPanels[i][j]);
            }
        }
        
        numberCells(boardSize, cellSize);
        return boardPanel;
   }
    
   // Second, the cells on the board must be labeled with a sequential number.
    public static void numberCells(int boardSize, int cellSize) {
   	 cellNumbers = new JLabel[boardSize][boardSize];
   	 int counter = boardSize*boardSize;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i % 2 == 0) { // For even rows, fill from right to left
                    cellNumbers[i][j] = new JLabel(Integer.toString(counter--));
                    cellNumbers[i][j].setName(cellNumbers[i][j].getText());
                    cellNumbers[i][j].setBounds(10, cellSize-20, cellSize/2, 13);
                    CellController.setCellPosition(i,j,Integer.parseInt(cellNumbers[i][j].getText()));
                    cellPanels[i][j].add(cellNumbers[i][j]); 
                } else { // For odd rows, fill from left to right
                    cellNumbers[i][j] = new JLabel(Integer.toString(counter--));
                    cellNumbers[i][j].setName(cellNumbers[i][j].getText());
                    cellNumbers[i][j].setBounds(10, cellSize-20, cellSize/2, 13);
                    CellController.setCellPosition(i,j,Integer.parseInt(cellNumbers[i][j].getText()));
                    cellPanels[i][j].add(cellNumbers[i][j]);
                }
            }
        }
   }
    
    public void painLastCell(int boardSize, int cellSize) {
    	JLabel label;
   	 for(CellinBoard cell: CellController.getAllCells()) {
   		 if((cell.getPosition()==boardSize*boardSize)&&(cell.getType()=="nothing")) {
   			label = new JLabel();
   			label.setBounds(10, 20, cellSize-2,cellSize-2);
   		 // Load the image from the resource
            URL imageUrl = this.getClass().getResource("/wincellpic.png");
            if (imageUrl != null) {
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                // Scale the image to fit the JLabel
                Image img = originalIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                
                label.setIcon(scaledIcon);
		 } else {
            System.err.println("Could not load image resource");
        }
            cell.setType("win");
            cellPanels[cell.GetI()][cell.GetJ()].add(label);
   		 }
   	 }
    }
      
    // Third, paint question cells in special color
    public void paintQuestionCells(int boardSize, int questionCellNum, int cellSize) {
   	 JLabel[] label = new JLabel[questionCellNum];
        for (int i = 0; i < questionCellNum; i++) {
            int randPosition = (int) (Math.random() * boardSize*boardSize);
            if((randPosition==0)||(randPosition==1)||(randPosition==boardSize*boardSize)) {
         	   i=i-1;
            }else {
           	 for(CellinBoard cell: CellController.getAllCells()) {
           		 if((cell.getPosition()==randPosition)&&(cell.getType()=="nothing")) {
           			 label[i] = new JLabel();
                        label[i].setBounds(0, 0, cellSize-2,cellSize-2);
                        
                        // Load the image from the resource
                        URL imageUrl = this.getClass().getResource("/Questioncellpic.png");
                        if (imageUrl != null) {
                            ImageIcon originalIcon = new ImageIcon(imageUrl);
                            // Scale the image to fit the JLabel
                            Image img = originalIcon.getImage().getScaledInstance(label[i].getWidth(), label[i].getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon scaledIcon = new ImageIcon(img);
                            
                            label[i].setIcon(scaledIcon);
           		 } else {
                        System.err.println("Could not load image resource");
                    }
                        cell.setType("question");
                        
                        cellPanels[cell.GetI()][cell.GetJ()].add(label[i]);
           	 }
           	 }
            }
        }
	 }
     
     // Forth, paint surprise cells in special color
     public void paintSurpriseCells(int boardSize, int surpriseCellNum, int cellSize) {
    	 JLabel[] label = new JLabel[surpriseCellNum];
         for (int i = 0; i < surpriseCellNum; i++) {
             int randPosition = (int) (Math.random() * boardSize*boardSize);
             if((randPosition==0)||(randPosition==1)||(randPosition==boardSize*boardSize)) {
          	   i = i-1;
             }else {
               	 for(CellinBoard cell: CellController.getAllCells()) {
               		 if((cell.getPosition()==randPosition)&&(cell.getType()=="nothing")) {label[i] = new JLabel();
               		 label[i] = new JLabel();
                     label[i].setBounds(0, 0, cellSize-2,cellSize-2);
             // Load the image from the resource
             URL imageUrl = this.getClass().getResource("/SupriseCellpic.png");
             if (imageUrl != null) {
                 ImageIcon originalIcon = new ImageIcon(imageUrl);
                 // Scale the image to fit the JLabel
                 Image img = originalIcon.getImage().getScaledInstance(label[i].getWidth(), label[i].getHeight(), Image.SCALE_SMOOTH);
                 ImageIcon scaledIcon = new ImageIcon(img);
                 label[i].setIcon(scaledIcon);
             } else {
                 System.err.println("Could not load image resource");
             }
             cell.setType("surprise");
             cellPanels[cell.GetI()][cell.GetJ()].add(label[i]);
             }
         }
             }
         }
     }
     
     
     
     
     
     // Set all players in the first cell
     public void SetPlayerToStart(Player p) {
    	 for(CellinBoard cell:CellController.getAllCells()) {
    		 if(cell.getPosition()==1) {
    			 cellPanels[cell.GetI()][cell.GetJ()].add(p.getObject());
    		     	p.setCurrentPosition(1);
    		 }
    	 }
     	
     }
     
  
         
    private void initializeUI() {
    	timerLabel = new JLabel("00:00");
        timerLabel.setBounds(950, 0, 200, 40);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        timerLabel.setForeground(Color.BLUE); // Set text color
        timerLabel.setBackground(Color.LIGHT_GRAY); // Set background color
        timerLabel.setOpaque(true); // Make background color visible
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
      
        currentPlayerLabel1234 = new JLabel("Player roll is ");
		 currentPlayerLabel1234.setFont(new Font("Arial", Font.BOLD, 20));
	        currentPlayerLabel1234.setForeground(Color.BLUE);
	        currentPlayerLabel1234.setBackground(Color.LIGHT_GRAY); // Set background color
	        currentPlayerLabel1234.setHorizontalAlignment(SwingConstants.CENTER);
	        currentPlayerLabel1234.setOpaque(true); // Make background color visible
	        currentPlayerLabel1234.setBounds(800, 50, 450, 60);
	        currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
    	frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JPanel panel = new JPanel();
        panel.add(timerLabel); // Add the timer display label to the panel
        panel.add(currentPlayerLabel1234);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1920, 1080);
		//contentPane.add(panel);
		frame.getContentPane().add(panel);

		panel.setLayout(null);
		
		JLabel snake = new JLabel("");
		ImageIcon s = new ImageIcon(this.getClass().getResource("/sandglass.gif"));
		panel.add(snake);
		snake.setIcon(s);
		snake.setBounds(780, 150, 900, 400);
		
		JButton exit = new JButton("");
		ImageIcon c = new ImageIcon(this.getClass().getResource("/no.png"));
		exit.setIcon(c);
		exit.setBackground(Color.red);
		exit.setBounds(1250, 11, 44, 39);
		panel.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectLevel level = new selectLevel();
				level.show();
				//home myHome = new home();
				//myHome.show();
				frame.setVisible(false);
			}
		});
		
		JButton soundButton = new JButton("");
		if(!MusicController.isPaused()) {
			ImageIcon v = new ImageIcon(this.getClass().getResource("/voice.png"));
			soundButton.setIcon(v);
			soundButton.setBackground(new Color(220, 177, 223));
		}else {
			ImageIcon v = new ImageIcon(this.getClass().getResource("/voice_off.png"));
			soundButton.setIcon(v);
			soundButton.setBackground(new Color(178, 190, 181));
		}
		
		soundButton.setBounds(1304, 11, 44, 39);
		soundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(!MusicController.isPaused()) {
							MusicController.pauseMusic();
						ImageIcon v = new ImageIcon(this.getClass().getResource("/voice_off.png"));
						soundButton.setIcon(v);
						soundButton.setBackground(new Color(178, 190, 181));
						}
						else {
							MusicController.resumeMusic();
							ImageIcon v = new ImageIcon(this.getClass().getResource("/voice.png"));
							soundButton.setIcon(v);
							soundButton.setBackground(new Color(220, 177, 223));
						}
			}
		});
		panel.add(soundButton);
		
		panel.add(createBoard(LevelController.boardSize));
		painLastCell(LevelController.boardSize,cellSize);
		paintQuestionCells(LevelController.boardSize, LevelController.questionCellsNum,cellSize);
		paintSurpriseCells(LevelController.boardSize, LevelController.surpriseCellsNum, cellSize);
		

		
		 JButton moveButton = new JButton("move");
		 moveButton.setBounds(850, 600, 85, 21);
		 panel.add(moveButton);
			moveButton.setVisible(false);
			diceButton = new JButton("");
			ImageIcon dice = new ImageIcon(this.getClass().getResource("/dice.png"));
			diceButton.setIcon(dice);
			diceButton.setBounds(1000, 560, 100, 100);
			diceButton.setBackground(new Color(190,231,251));
			panel.add(diceButton);

			JLabel role = new JLabel("");
			role.setBounds(950, 217, 180, 60);
			panel.add(role);
				
			
					diceValue = new JLabel("");
					diceValue.setBounds(1100, 500, 220, 200);
					panel.add(diceValue);
			
					Music audio = new Music(2, "resources/diceThrow.wav", "");

					diceButton.addActionListener(new ActionListener() {
					public  void actionPerformed(ActionEvent e) {
							MusicController.addMusic(audio.getFileName());
							result = DiceController.generateRandomNumber(LevelController.getGameLevel());
							diceValue.setText(DiceController.toDo(result));
							if (result>0 && result<6) {
								moveButton.setVisible(true);
							}

							else if (result == 8) {
								if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
							    selected_question =  QuestionBoardController.get_random_easyquestion();

							    // Display questions
							    if (selected_question != null) {
							        displayQuestion(selected_question);
							        
							    } else {
							        // Handle case when no easy questions are available
							        JOptionPane.showMessageDialog(null, "No easy questions available.", "Information", JOptionPane.INFORMATION_MESSAGE);
							    }
								if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
							}
							else if (result==9) {
								if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
							    selected_question =  QuestionBoardController.get_random_meduimquestion();

							    // Display questions
							    if (selected_question != null) {
							        displayQuestion(selected_question);

							    } else {
							        // Handle case when no easy questions are available
							        JOptionPane.showMessageDialog(null, "No meduim questions available.", "Information", JOptionPane.INFORMATION_MESSAGE);
							    }
								
							    if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
								
							}
							else if (result==10) {
								if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
							    selected_question =  QuestionBoardController.get_random_hardquestion();
							    // Display questions
							    if (selected_question != null) {
							        displayQuestion(selected_question);

							    } else {
							        // Handle case when no easy questions are available
							        JOptionPane.showMessageDialog(null, "No hard questions available.", "Information", JOptionPane.INFORMATION_MESSAGE);
							    }
							   
							    if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
							}
							else if (result==0) {
								moveButton.setVisible(false);
								if(flag==0)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());

								}
								if(flag==1)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());

								}
								if(flag==2)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

								}
								if(flag==3)
								{
									currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

								}
							}

						}});

					if(selectLevel.flag_level==1)
					{
					placeSnakes();
					placeLadders();
					}
					if(selectLevel.flag_level==2)
					{
					MplaceSnakes();
					MplaceLadders();
					}
					if(selectLevel.flag_level==3)
					{
					HplaceSnakes();
					HplaceLadders();
					HplaceSnakes();
					}

					

		number_player=SelectPlayer_Names_ColoersController.flag;
		// get all players
		if(number_player==2)
		{
		flag=0;
		ArrayList<Player> players = new ArrayList<Player>();
			players.add(SelectPlayer_Names_ColoersController.p1);
			players.add(SelectPlayer_Names_ColoersController.p2);
			
			for(Player p: players) {
				 SetPlayerToStart(p);
			}

			moveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(flag==0)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p1);
			
			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p1);
				System.out.println("surrrrrrrrr");
				System.out.println(getCellType(position));

				flag=1;
			}
			else if("snake".equals(getCellType(position))) 
			{
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
else if ("win".equals(getCellType(position))) {
	Random randomnumber = new Random();
    Random randomnumbe12r = null;
	// Generate a random number between 1 and 100,000
    
    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
    String Slevel=deficlty.name();
	Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p1.getName(),timerLabel.getText(),"1/2/2020");
    home x=new home();
    SysData.gameHistory.add(win);					
				displayWinner(SelectPlayer_Names_ColoersController.p1.getName());
				

			}
			else {
				//currentPlayerLabel.setText("Current Player: " + p1.getName());    		moveButton.setVisible(false);
				flag=1;
			}
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
			
			}
			else if(flag==1)
			{

			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p2);

			
			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p2);
				flag=0;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=0;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=0;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p2.getName(),timerLabel.getText(),"1/2/2020");
SysData.gameHistory.add(win);					
displayWinner(SelectPlayer_Names_ColoersController.p2.getName());


			}
		
			else {
				flag=0;
				
			}
			
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

			}
		}
		
	});
			}
		if(number_player==3)
		{
		flag=0;
		ArrayList<Player> players = new ArrayList<Player>();
				 players.add(SelectPlayer_Names_ColoersController.p1);
				 players.add(SelectPlayer_Names_ColoersController.p3);
				 players.add(SelectPlayer_Names_ColoersController.p2);
				 for(Player p: players) {
					 SetPlayerToStart(p);
				}
	
			moveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(flag==0)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p1);
			moveButton.setVisible(false);



			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p1);
				flag=1;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p1.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p1.getName());

			}
			else {
				flag=1;
				
			}
			
			 //currentPlayerLabel.setText("Current Player: " + p1.getName());    		moveButton.setVisible(false);
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
			}
			else if(flag==1)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), result);
			move( position, SelectPlayer_Names_ColoersController.p2);
			moveButton.setVisible(false);

			
			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p2);
				flag=2;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=2;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=2;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p2.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p2.getName());

			}
			else {
				flag=2;
				
			}
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());
			// currentPlayerLabel.setText("Current Player: " + p2.getName());    			moveButton.setVisible(false);
			}
			else if(flag==2)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), result);
			move( position, SelectPlayer_Names_ColoersController.p3);

			
			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p3);
				flag=0;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p3);
						flag=0;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p3);
						flag=0;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p3.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p3.getName());

			}
			else {
				
				flag=0;
				
			}
			
			// currentPlayerLabel.setText("Current Player: " + p2.getName());    			moveButton.setVisible(false);
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
			}
		}
	});
			}				
		if(number_player==4)
		{
			flag=0;
				 ArrayList<Player> players = new ArrayList<Player>();
					players.add(SelectPlayer_Names_ColoersController.p1);
					players.add(SelectPlayer_Names_ColoersController.p2);
					players.add(SelectPlayer_Names_ColoersController.p3);
					players.add(SelectPlayer_Names_ColoersController.p4);
					for(Player p: players) {
						 SetPlayerToStart(p);
					}
			moveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(flag==0)
			{

			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p1);
			moveButton.setVisible(false);

			

			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p1);
				flag=1;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p1);
						flag=1;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p1.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p1.getName());
			}
			else {
				flag=1;	
			}
			
			
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
			moveButton.setVisible(false);

			}
			else if(flag==1)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p2);
			moveButton.setVisible(false);

			

			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p2);
				flag=2;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=2;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p2);
						flag=2;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p2.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p2.getName());
			}
			else {
				flag=2;
				
			}
			
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p3.getName());
			moveButton.setVisible(false);

			}
			else if(flag==2)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p3);
			moveButton.setVisible(false);

			

			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p3);
				flag=3;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p3);
						flag=3;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p3);
						flag=3;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p3.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p3.getName());
			}
			else {
				flag=3;
				
			}
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p4.getName());

			moveButton.setVisible(false);

			// currentPlayerLabel.setText("Current Player: " + p3.getName());    			moveButton.setVisible(false);
			}
			else if(flag==3)
			{
			position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), result);
			move(position, SelectPlayer_Names_ColoersController.p4);
			moveButton.setVisible(false);

			

			if("question".equals(getCellType(position))) 
			{
				selected_question =  QuestionBoardController.get_random_question();
				displayQuestion(selected_question);
			}
			else if ("surprise".equals(getCellType(position))) {
				
				position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), 10);
				move(position, SelectPlayer_Names_ColoersController.p4);
				flag=0;
			}
			else if("snake".equals(getCellType(position))) 
			{
				System.out.println("goooooooooooooooooo");
				for(Snake s : snakes)
				{
					if (position.equals(s.getHeadPosition())) {
						System.out.println("you enter ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), s.getLength());
						move(position, SelectPlayer_Names_ColoersController.p4);
						flag=0;
					}
				}
			}
			else if("ladder".equals(getCellType(position))) 
			{
				for(Ladder l : ladders)
				{
					if (position.equals(l.getDownPosition())) {
						System.out.println("laddddddddddddddddddddddddddddddder ");
						position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), l.getStairsNum());
						move(position, SelectPlayer_Names_ColoersController.p4);
						flag=0;
					}
				}
			}
			else if ("win".equals(getCellType(position))) {
				Random randomnumber = new Random();
			    Random randomnumbe12r = null;
				// Generate a random number between 1 and 100,000
			    
			    DifficultyLevel deficlty=convertToDifficultyLevel(selectLevel.flag_level);
			    String Slevel=deficlty.name();
				Game win=new Game(15,deficlty,SelectPlayer_Names_ColoersController.p4.getName(),timerLabel.getText(),"1/2/2020");
			    home x=new home();
			    SysData.gameHistory.add(win);					
							displayWinner(SelectPlayer_Names_ColoersController.p4.getName());
			}
			else {
				flag=0;
				
			}
			moveButton.setVisible(false);
			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());

			// currentPlayerLabel.setText("Current Player: " + p4.getName());    			moveButton.setVisible(false);
			flag=0;
			}
		}
			});
						
		}
				 JLabel sky = new JLabel();
		 sky.setBounds(0, 0,1920, 1080);
		 //sky.setBounds(0, 0, ScreenController.getScreenWidth(), ScreenController.getScreenHeight());

	     // Load the image from the resource
	     URL imageUrl = this.getClass().getResource("/main-image.jpg");
	     if (imageUrl != null) {
	         ImageIcon originalIcon = new ImageIcon(imageUrl);
	         
	         // Scale the image to fit the JLabel
	         Image img = originalIcon.getImage().getScaledInstance(sky.getWidth(), sky.getHeight(), Image.SCALE_SMOOTH);
	         ImageIcon scaledIcon = new ImageIcon(img);
	         
	         sky.setIcon(scaledIcon);
	     } else {
	         System.err.println("Could not load image resource");
	     }
	     panel.add(sky);
				
    }
    public int nextPosition(int lastPosition, int diceValue) {
    	if (lastPosition+diceValue>=(LevelController.boardSize*LevelController.boardSize)) {
    		return LevelController.boardSize*LevelController.boardSize;
    	}else if(lastPosition+diceValue<1) {
    		return 1;
    	}
    	else {
    		return lastPosition+diceValue;
    	}
    }
    
    public Integer[] getCellPosition(int cellNumber){
    	Integer[] position = new Integer[2];
    	for(CellinBoard cell : CellController.getAllCells()) {
    		if(cell.getPosition()==cellNumber) {
            		 position[0]=cell.GetI();
            		 position[1]=cell.GetJ();
            	 }
             }
		return position;
    }
    private void displayWinner(String winner) {
        // Create new JFrame for the winner
        JFrame winnerFrame = new JFrame("Winner");
        winnerFrame.setSize(200, 150);
        winnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allow the window to be closed

        // Create a JPanel to hold all components with custom background
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Paint custom background
                super.paintComponent(g);
                g.setColor(new Color(200, 255, 200)); // Custom background color (light green in this case)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        // Set content pane with custom background
        winnerFrame.setContentPane(contentPane);

        // Create label to display winner's name
        JLabel winnerLabel = new JLabel("Winner: " + winner);
        winnerLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
        contentPane.add(winnerLabel, BorderLayout.CENTER);

        // Create OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the winner frame
                winnerFrame.dispose();
                // Show the main menu frame (startscreen)
                StartScreen x=new StartScreen();
                x.show();
            }
        });
        // Add OK button to the bottom of the frame
        contentPane.add(okButton, BorderLayout.SOUTH);

        // Set the location of the frame to the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - winnerFrame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - winnerFrame.getHeight()) / 2);
        winnerFrame.setLocation(centerX, centerY);

        // Set the JFrame to be visible
        winnerFrame.setVisible(true);
    }
    private void displayQuestion(Question q) {
        // Create new JFrame for the question
        questionFrame = new JFrame("Question");
        questionFrame.setSize(800, 400);
        questionFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Create a JPanel to hold all components with custom background
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Paint custom background
                super.paintComponent(g);
                g.setColor(new Color(255, 255, 200)); // Custom background color (light yellow in this case)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        
        // Set content pane with custom background
        questionFrame.setContentPane(contentPane);

        // Create your question label
        try {
        JLabel questionLabel = new JLabel(q.getQuestionText());
        contentPane.add(questionLabel, BorderLayout.NORTH);

        }
        catch(NullPointerException e)
        {
        	System.out.println("nullpointer");
        }

        // Create buttons for answers
        JButton[] answerButtons = new JButton[4];
        JPanel answerPanel = new JPanel(new GridLayout(4, 1));
        answerPanel.setBackground(new Color(200, 200, 200)); // Set background color
        for (int i = 0; i < 4; i++) {
        	 try {
                 answerButtons[i] = new JButton(q.getAnswer(i));
                 answerButtons[i] = new JButton(q.getAnswer(i));


        	        }
        	        catch(NullPointerException e)
        	        {
        	        	System.out.println("nullpointer");
        	        }
            final int index = i+1; // For action listener
            answerButtons[i].setBackground(new Color(100, 100, 100)); // Set button background color
            answerButtons[i].setForeground(Color.WHITE); // Set button text color
            answerButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Check if the answer is correct
                	user_answer_result=0;
                	System.out.println("user: " + user_answer_result);
                	 try {
                		 if (index == q.getCorrectOptionIndex()) {
                         	user_answer_result = 1;
                         	System.out.println("user: " + user_answer_result);
                             JOptionPane.showMessageDialog(questionFrame, "Correct answer!", "Result", JOptionPane.INFORMATION_MESSAGE);
                         } else {
                             // Save 0 for wrong answer (you can save this to your database)
                             // Show message dialog
                             JOptionPane.showMessageDialog(questionFrame, "Wrong answer!", "Result", JOptionPane.ERROR_MESSAGE);
                         }


                	        }
                	        catch(NullPointerException r12)
                	        {
                	        	System.out.println("nullpointer");
                	        }
                   
                    // Close the question frame
                    questionFrame.dispose();
                    
                    
                    if (user_answer_result == 1) {
                        
                        if(q.getDifficulty()==DifficultyLevel.HARD) {
                        	
                        	if(flag==0)
                        	{
                        		
                    			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), 1);
                    			move(position, SelectPlayer_Names_ColoersController.p1);
                    			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
                    			flag=1;
                    			
                        	}
                        	else if(flag==1)
                        	{
                    			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), 1);
                    			move(position, SelectPlayer_Names_ColoersController.p2);
                    			System.out.println("flag now before: " + flag);
                    			flag=0;
                    			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
                    			System.out.println("flag now after: " + flag);

                        	}
                        	/*else if(flag==2)
                        	{
                    			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), 1);
                    			move(position, SelectPlayer_Names_ColoersController.p3);
                    			flag=3;
                        	}
                        	else if(flag==4)
                        	{
                    			position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), 1);
                    			move(position, SelectPlayer_Names_ColoersController.p4);
                    			flag=0;
                        	}*/
                        	

                        }
                       
                    }
       
                    else {
                        System.out.println("user should back step on easy, 2 steps on meduim, 3 steps on hard");
                        if((q.getDifficulty()==DifficultyLevel.MEDIUM))
                        {
                        	// back 2 steps
                        	if(flag==0)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p1.getCurrentPosition()==0 || SelectPlayer_Names_ColoersController.p1.getCurrentPosition()==1))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), -2);
                        			move(position, SelectPlayer_Names_ColoersController.p1);
                        			flag=1;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
                        		}

                        	}
                        	else if(flag==1)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p2.getCurrentPosition()==0 || SelectPlayer_Names_ColoersController.p2.getCurrentPosition()==1))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), -2);
                        			move(position, SelectPlayer_Names_ColoersController.p2);
                        			flag=0;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
                        		}

                        	}
                        	/*else if(flag==2)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p3.getCurrentPosition()==0 || SelectPlayer_Names_ColoersController.p3.getCurrentPosition()==1))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), -2);
                        			move(position, SelectPlayer_Names_ColoersController.p3);
                        			flag=3;
                        		}

                        	}
                        	else if(flag==3)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p4.getCurrentPosition()==0 || SelectPlayer_Names_ColoersController.p4.getCurrentPosition()==1))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), -2);
                        			move(position, SelectPlayer_Names_ColoersController.p4);
                        			flag=0;
                        		}

                        	}*/
                        }
                        if((q.getDifficulty()==DifficultyLevel.EASY))
                        {
                        	// back 1 steps
                        	// back 2 steps
                        	if(flag==0)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p1.getCurrentPosition()==0))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p1);
                        			flag=1;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
                        		}

                        	}
                        	else if(flag==1)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p2.getCurrentPosition()==0))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p2);
                        			flag=0;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
                        		}

                        	}
                        	/*else if(flag==2)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p3.getCurrentPosition()==0 ))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p3);
                        			flag=3;
                        		}

                        	}
                        	else if(flag==3)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p4.getCurrentPosition()==0 ))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p4);
                        			flag=0;
                        		}

                        	}*/
                        }
                        
                        if((q.getDifficulty()==DifficultyLevel.HARD))
                        {
                        	// back 1 steps
                        	// back 2 steps
                        	if(flag==0)
                        	{
                        		if (!(SelectPlayer_Names_ColoersController.p1.getCurrentPosition() >= 0 && SelectPlayer_Names_ColoersController.p1.getCurrentPosition() <= 3))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p1.getCurrentPosition(), -3);
                        			move(position, SelectPlayer_Names_ColoersController.p1);
                        			flag=1;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p2.getName());
                        		}

                        	}
                        	else if(flag==1)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p2.getCurrentPosition()==0))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p2.getCurrentPosition(), -3);
                        			move(position, SelectPlayer_Names_ColoersController.p2);
                        			flag=0;
                        			currentPlayerLabel1234.setText("Player roll is : "+SelectPlayer_Names_ColoersController.p1.getName());
                        		}

                        	}
                        	/*else if(flag==2)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p3.getCurrentPosition()==0 ))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p3.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p3);
                        			flag=3;
                        		}
                        		

                        	}
                        	else if(flag==3)
                        	{
                        		if(!(SelectPlayer_Names_ColoersController.p4.getCurrentPosition()==0 ))
                        		{
                        			position = nextPosition(SelectPlayer_Names_ColoersController.p4.getCurrentPosition(), -1);
                        			move(position, SelectPlayer_Names_ColoersController.p4);
                        			flag=0;
                        		}

                        	}*/
                        	
	
                        }

                    	
                    }
                }
            });
            answerPanel.add(answerButtons[i]);
        }

        contentPane.add(answerPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        questionFrame.setLocationRelativeTo(null);

        // Make the frame visible
        questionFrame.setVisible(true);
    }




    	

    public void move(int position, Player p) {
    	p.getObject().setVisible(false);
    	int x = getCellPosition(position)[0];
    	int y = getCellPosition(position)[1];
    	cellPanels[x][y].add(p.getObject());
    	p.getObject().setVisible(true);
    	p.setCurrentPosition(position);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                BoardView board = new BoardView();
                board.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    

    public String toDo(int dice) {
    	switch (dice) {
        case 0:
            return "0 - the player does not move";
		case 1:
            return "<html>1 - The player moves one step<br> forward.</html>";
		case 2:
            return "<html>2 - The player moves two steps forward.</html>";
		case 3:
            return "<html>3 - The player moves three steps forward.</html>";
		case 4:
            return "<html>4 - The player moves four steps forward.</html>";
		case 5:
            return "<html>5 - The player moves five steps forward.</html>";
		case 8:
            return "<html>8 - Easy question - the player gets a random easy question and he has to answer it. The player moves according to the answer</html>";
		case 9:
            return "<html>9 - Medium question <br> the player receives a random medium <br> question and has to answer it. The player moves according to the answer</html>";
        // case 10
        default:
        	return "<html>10 - hard question <br> the player gets a random hard <br> question and has to answer it.<br>The player moves according to the answer</html>";
    }
    }
    
    
    public void show() {
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    //checks if the cell is a snake's head if it is return the snake's tail position
    //if not return the cell position
    public int onHeadSnakeCell(Cell c, Snake s){
    	
    	if(c.getType().equals("Snake")) {
    		if(c.getId().equals(s.getHeadPosition())) {
    			
    			return s.getTailPosition();
    		}
    	}
		return (int) c.getId();
    }
    	
		//checks if the cell is a ladder's down if it is return the ladder's top position
	    //if not return the cell position
	    public int onDownLadderCell(Cell c, Ladder l){
	    	
	    	if(c.getType().equals("Ladder")) {
	    		if(c.getId().equals(l.getDownPosition())) {
	    			
	    			return l.getTopPosition();
	    		}
	    	}
			return (int) c.getId();
	    	
	    }
	    
	    /*if the next position equals or more than the board size

	      that mean there is a win and return true if not there is no win return false just for test

	    */

	    public boolean doesWin(int lastPosition, int diceValue) {

	    	if (lastPosition+diceValue>=(BOARD_SIZE*BOARD_SIZE)) {

	    		return true;

	    	}

	    	else {

	    		return false;

	    	}

		
}
	    // after every movement check the type of the cell
	    public void checkCellType(int position, Player p) {
	    	String type="nothing";
	    	for(CellinBoard cell: CellController.getAllCells()) {
	    		if(cell.getPosition()==position) {
	    			type =  cell.getType();
	    		}
	    	}
			switch(type) {
			case "win":
				// Timer must stop
				diceValue.setText("<html>Congratulations!!!<br>"+ p.getName() +"is the winner!</html>");
				break;
			case "surprise":
				if(SurpriseCellController.getSurpriseMove()>0) {
					diceValue.setText("<html>Surprise!!!<br> move 10 steps forward!</html>");
				}else {
					diceValue.setText("<html>Surprise!!!<br> move 10 steps reverse!</html>");
				}
				move(nextPosition(position, SurpriseCellController.getSurpriseMove()), p);
				break;
			case "question":
					// show question and complete the code
					selected_question =  QuestionBoardController.get_random_question();
					displayQuestion(selected_question);

				break;
			}
	    }
	    
	    public String getCellType(int position) {
	        String type = "nothing";
	        for (CellinBoard cell : CellController.getAllCells()) {
	            if (cell.getPosition() == position) {
	                type = cell.getType();
	                break; // No need to continue searching if the cell is found
	            }
	        }
	        System.out.println("this cell type is : " + type);
	        return type;
	    }
	    
	    //for easy level
	    // Main method to place snakes on the board
	    public void placeSnakes() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions
	     // Yellow snake
	        Point yellowPosition = generateRandomPosition(cellPanels, occupiedPositions);
	         iYellow = yellowPosition.x;
	         yYellow = yellowPosition.y;

	        ImageIcon icon8 = new ImageIcon(this.getClass().getResource("/yellowhead.png"));
		     JLabel label8 = new JLabel("");
		     label8.setIcon(icon8);
		     cellPanels[iYellow+3][yYellow].add(label8);
		     label8.setBounds(0,-25, 200, 200);
		     cellPanels[iYellow+3][yYellow].setVisible(true);
				System.out.println(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())+"yellowSnakeEasy1");
		     ImageIcon icon9= new ImageIcon(this.getClass().getResource("/yellowtail.png"));
		     JLabel label9 = new JLabel("");
		     label9.setIcon(icon9);
		     cellPanels[iYellow+4][yYellow].add(label9);
		     label9.setBounds(0, -76, 200, 200);
		     cellPanels[iYellow+4][yYellow].setVisible(true);
		   //create yellowSnakeEasy1 snake for easy
				System.out.println(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())+"yellowSnakeEasy1");

				Snake yellowSnakeEasy1 = new Snake("yellowSnakeEasy1", Model.Color.YELLOW, -(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())-Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText())), Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText()) ,Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {

		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(yellowSnakeEasy1);
	        // Red snake
	 
 
	        Random rand2 = new Random();

			// Generate random y-coordinate within the bounds of your cellPanels array
			 yyRed = rand2.nextInt(cellPanels[0].length);

			// Generate random i-coordinate within the bounds of your cellPanels array
			 iiRed = rand2.nextInt(cellPanels.length);

			// Assign label to the randomly generated coordinates for the red snake
			ImageIcon icon = new ImageIcon(this.getClass().getResource("/sn2.png"));
			JLabel label = new JLabel("");
			label.setIcon(icon);
			cellPanels[iiRed][yyRed].add(label);
			label.setBounds(0, 0, 100, 100);
			cellPanels[iiRed][yyRed].setVisible(true);
			
			System.out.println(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())+"red");
			//create red snake for easy
			Snake redSnakeEasy1 = new Snake("redSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())), Integer.parseInt(cellNumbers[iiRed][yyRed].getText()) ,Integer.parseInt(cellNumbers[0][0].getText()));
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("snake");
	      		 }
	    	}
			snakes.add(redSnakeEasy1);
	        // Blue snake
	     

	        Random rand = new Random();

		     // Generate a random y-coordinate within the bounds of your cellPanels array
		      y1Blue = rand.nextInt(cellPanels[0].length); // Assuming cellPanels is a 2D array

		     // Generate a random i-coordinate within the bounds of your cellPanels array
		     // Ensure that i allows enough space for the tallest icon to fit without going out of bounds
		     int maxIBlue = cellPanels.length - 4; // To accommodate the tallest icon at i+3
		      i1Blue = rand.nextInt(maxIBlue);

		     // Assign labels to the randomly generated coordinates for the blue snake
		     ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/hb.png"));
		     JLabel label1 = new JLabel("");
		     label1.setIcon(icon1);
		     cellPanels[i1Blue][y1Blue].add(label1);
		     label1.setBounds(-100, -25, 200, 200);
		     cellPanels[i1Blue][y1Blue].setVisible(true);
				System.out.println(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())+"blue");

		     ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/bb1.png"));
		     JLabel label2 = new JLabel("");
		     label2.setIcon(icon2);
		     cellPanels[i1Blue+1][y1Blue].add(label2);
		     label2.setBounds(-100,-100, 300, 300);
		     cellPanels[i1Blue+1][y1Blue].setVisible(true);

		     ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/bb2.png"));
		     JLabel label3 = new JLabel("");
		     label3.setIcon(icon3);
		     cellPanels[i1Blue+2][y1Blue].add(label3);
		     label3.setBounds(-100,-50, 200, 200);
		     cellPanels[i1Blue+2][y1Blue].setVisible(true);

		     ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/tb.png"));
		     JLabel label4 = new JLabel("");
		     label4.setIcon(icon4);
		     cellPanels[i1Blue+3][y1Blue].add(label4);
		     label4.setBounds(-100, -76, 200, 200);
		     cellPanels[i1Blue+3][y1Blue].setVisible(true);
	    
	    
		    /* Random randd = new Random();
		     int y = randd.nextInt(cellPanels[0].length); 
		     int maxI = cellPanels.length - 4; 
		     int i = randd.nextInt(maxI);*/
		   //create blue snake for easy
				System.out.println(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())+"blue");

				Snake blueSnakeEasy1 = new Snake("blueSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())-Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText())), Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText()) ,Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {

		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(blueSnakeEasy1);
	        // Green snake
	        Point greenPosition = generateRandomPosition(cellPanels, occupiedPositions);
	         iGreen = greenPosition.x;
	         yGreen = greenPosition.y;

	        ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/greenhead.png"));
		     JLabel label5 = new JLabel("");
		     label5.setIcon(icon5);
		     cellPanels[iGreen][yGreen].add(label5);
		     label5.setBounds(-40, -25, 200, 200);
		     cellPanels[iGreen][yGreen].setVisible(true);
				System.out.println(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())+"green");
		     ImageIcon icon6 = new ImageIcon(this.getClass().getResource("/greenbody.png"));
		     JLabel label6 = new JLabel("");
		     label6.setIcon(icon6);
		     cellPanels[iGreen+1][yGreen].add(label6);
		     label6.setBounds(-40,-50, 200, 200);
		     cellPanels[iGreen+1][yGreen].setVisible(true);

		     ImageIcon icon7= new ImageIcon(this.getClass().getResource("/greentail.png"));
		     JLabel label7 = new JLabel("");
		     label7.setIcon(icon7);
		     cellPanels[iGreen+2][yGreen].add(label7);
		     label7.setBounds(-40, -76, 200, 200);
		     cellPanels[iGreen+2][yGreen].setVisible(true);
		   //create green snake for easy
				System.out.println(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())+"green");
				Snake greenSnakeEasy1 = new Snake("greenSnakeEasy1", Model.Color.GREEN, -(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())-Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText())), Integer.parseInt(cellNumbers[iGreen][yGreen].getText()) ,Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {
		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(greenSnakeEasy1);
	        
	    }
	    
	    private Point generateRandomPosition(JPanel[][] cellPanels, Set<Point> occupiedPositions) {
	        Random rand = new Random();
	        int x, y;
	        Point position;

	        // Keep generating random positions until a non-overlapping position is found
	        do {
	            x = rand.nextInt(cellPanels.length - 4); // Ensure enough space for the tallest snake
	            y = rand.nextInt(cellPanels[0].length);
	            
	            position = new Point(x, y);
	        } while (occupiedPositions.contains(position));

	        // Add the new position to the set of occupied positions
	        occupiedPositions.add(position);
	        return position;
	    }
	    

	    // Main method to place ladders on the board
	    public void placeLadders() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions

	        // Ladder 1
	        Point ladder1Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x1 = ladder1Position.x;
	        int y1 = ladder1Position.y;

	        Random rand4 = new Random();
			
			// Ladder 1
			int x3 = rand4.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y3 = rand4.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			// Place ladder 3 segment 1
			ImageIcon icon26 = new ImageIcon(this.getClass().getResource("/lu.png"));
			JLabel label26 = new JLabel("");
			label26.setIcon(icon26);
			cellPanels[x3][y3].add(label26);
			label26.setBounds(0, -25, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x3][y3].setVisible(true);
			
			// Place ladder 3 segment 2
			ImageIcon icon27 = new ImageIcon(this.getClass().getResource("/ld.png"));
			JLabel label27 = new JLabel("");
			label27.setIcon(icon27);
			cellPanels[x3 + 1][y3].add(label27);  // Assuming the next cell for segment 2
			label27.setBounds(0, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[x3 + 1][y3].setVisible(true);
	        // Ladder 2
	        Point ladder2Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x2 = ladder2Position.x;
	        int y2 = ladder2Position.y;

	        Random rand3 = new Random();
			
			// Ladder 2
			int xx2 = rand3.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int yy2 = rand3.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			// Place ladder 2
			ImageIcon icon23 = new ImageIcon(this.getClass().getResource("/su.png"));
			JLabel label23 = new JLabel("");
			label23.setIcon(icon23);
			cellPanels[xx2][yy2].add(label23);
			label23.setBounds(-50, 0, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2][yy2].setVisible(true);
			
			// Place ladder 2 segments
			ImageIcon icona = new ImageIcon(this.getClass().getResource("/sb.png"));
			JLabel labela = new JLabel("");
			labela.setIcon(icona);
			cellPanels[xx2 + 1][yy2].add(labela);  // Assuming the next cell for segment 2
			labela.setBounds(-50, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[xx2 + 1][yy2].setVisible(true);
			
			ImageIcon icon251 = new ImageIcon(this.getClass().getResource("/sd.png"));
			JLabel icon2511 = new JLabel("");
			icon2511.setIcon(icon251);
			cellPanels[xx2 + 2][yy2].add(icon2511);  // Assuming the next cell for segment 3
			icon2511.setBounds(-50, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2 + 2][yy2].setVisible(true);
			//create ladder2easy
			int stairs2 = (Integer.parseInt(cellNumbers[x3][y3].getText())) - (Integer.parseInt(cellNumbers[x3 + 1][y3].getText()));
			Ladder l2easy = new Ladder("l2easy", stairs2, (Integer.parseInt(cellNumbers[x3 + 1][y3].getText())), (Integer.parseInt(cellNumbers[x3][y3].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x3 + 1][y3].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l2easy);
	        // Ladder 3
	        Point ladder3Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x5 = ladder3Position.x;
	        int y5 = ladder3Position.y;

	        Random randr = new Random();
			
			//Ladder 3
			int x4 = randr.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y4 = randr.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			//Place ladder 3 segment 1
			ImageIcon icon10 = new ImageIcon(this.getClass().getResource("/s1u.png"));
			JLabel label10 = new JLabel("");
			label10.setIcon(icon10);
			cellPanels[x4][y4].add(label10);
			label10.setBounds(-100, -50, 250, 250);  // Setting bounds relative to the cell
			cellPanels[x4][y4].setVisible(true);
			
			//Place ladder 3 segment 2
			ImageIcon icon11 = new ImageIcon(this.getClass().getResource("/s11u.png"));
			JLabel label11 = new JLabel("");
			label11.setIcon(icon11);
			cellPanels[x4 + 1][y4].add(label11);  // Assuming the next cell for segment 2
			label11.setBounds(-100, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 1][y4].setVisible(true);
			
			//Place ladder 3 segment 3
			ImageIcon icon12 = new ImageIcon(this.getClass().getResource("/s11d.png"));
			JLabel label12 = new JLabel("");
			label12.setIcon(icon12);
			cellPanels[x4 + 2][y4].add(label12);  // Assuming the next cell for segment 3
			label12.setBounds(-100, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 2][y4].setVisible(true);
			
			//Place ladder 3 segment 4
			ImageIcon icon13 = new ImageIcon(this.getClass().getResource("/s1d.png"));
			JLabel label13 = new JLabel("");
			label13.setIcon(icon13);
			cellPanels[x4 + 3][y4].add(label13);  // Assuming the next cell for segment 4
			label13.setBounds(-100, -80, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 3][y4].setVisible(true);
			//create ladder3easy
			int stairs3 = (Integer.parseInt(cellNumbers[xx2][yy2].getText())) - (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText()));
			Ladder l3easy = new Ladder("l2easy", stairs3, (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())), (Integer.parseInt(cellNumbers[xx2][yy2].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l3easy);
	        // Ladder 4
	        Point ladder4Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x6 = ladder4Position.x;
	        int y6 = ladder4Position.y;

	        Random rands = new Random();
			
			//Ladder 4
			int x7 = rands.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y7 = rands.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			//Place ladder 4 segment 1
			ImageIcon icon14 = new ImageIcon(this.getClass().getResource("/llu.png"));
			JLabel label14 = new JLabel("");
			label14.setIcon(icon14);
			cellPanels[x7][y7].add(label14);
			label14.setBounds(-150, -75, 250, 300);  // Setting bounds relative to the cell
			cellPanels[x7][y7].setVisible(true);
			
			//Place ladder 4 segment 2
			ImageIcon icon15 = new ImageIcon(this.getClass().getResource("/llu1.png"));
			JLabel label15 = new JLabel("");
			label15.setIcon(icon15);
			cellPanels[x7 + 1][y7].add(label15);  // Assuming the next cell for segment 2
			label15.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 1][y7].setVisible(true);
			
			//Place ladder 4 segment 3
			ImageIcon icon16 = new ImageIcon(this.getClass().getResource("/llu2.png"));
			JLabel label16 = new JLabel("");
			label16.setIcon(icon16);
			cellPanels[x7 + 2][y7].add(label16);  // Assuming the next cell for segment 3
			label16.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 2][y7].setVisible(true);
			
			//Place ladder 4 segment 4
			ImageIcon icon17 = new ImageIcon(this.getClass().getResource("/llu3.png"));
			JLabel label17 = new JLabel("");
			label17.setIcon(icon17);
			cellPanels[x7 + 3][y7].add(label17);  // Assuming the next cell for segment 4
			label17.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 3][y7].setVisible(true);
			
			//Place ladder 4 segment 5
			ImageIcon icon18 = new ImageIcon(this.getClass().getResource("/lld.png"));
			JLabel label18 = new JLabel("");
			label18.setIcon(icon18);
			cellPanels[x7 + 4][y7].add(label18);  // Assuming the next cell for segment 5
			label18.setBounds(-150, -125 , 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 4][y7].setVisible(true);
			//create ladder4easy
			int stairs4 = (Integer.parseInt(cellNumbers[x4][y4].getText())) - (Integer.parseInt(cellNumbers[x4 + 3][y4].getText()));
			Ladder l4easy = new Ladder("l2easy", stairs4, (Integer.parseInt(cellNumbers[x4 + 3][y4].getText())), (Integer.parseInt(cellNumbers[x4][y4].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x4 + 3][y4].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l4easy);
			//create ladder5easy
			int stairs5 = (Integer.parseInt(cellNumbers[x7][y7].getText())) - (Integer.parseInt(cellNumbers[x7 + 4][y7].getText()));
			Ladder l5easy = new Ladder("l2easy", stairs5, (Integer.parseInt(cellNumbers[x7 + 4][y7].getText())), (Integer.parseInt(cellNumbers[x7][y7].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x7 + 4][y7].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l5easy);
	    }
	    
	    
	    
	    //for meduim level
	    // Main method to place snakes on the board
	    public void MplaceSnakes() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions

	        // Red snake
	        Point redPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iRed = redPosition.x;
	        int yRed = redPosition.y;

	        Random rand2 = new Random();

			// Generate random y-coordinate within the bounds of your cellPanels array
			int yyRed = rand2.nextInt(cellPanels[0].length);

			// Generate random i-coordinate within the bounds of your cellPanels array
			int iiRed = rand2.nextInt(cellPanels.length);

			// Assign label to the randomly generated coordinates for the red snake
			ImageIcon iconr = new ImageIcon(this.getClass().getResource("/sn2.png"));
			JLabel label = new JLabel("");
			label.setIcon(iconr);
			cellPanels[iiRed][yyRed].add(label);
			label.setBounds(-10, 0, 100, 100);
			cellPanels[iiRed][yyRed].setVisible(true);
	     
			  // Red snake
	        Point redPosition12 = generateRandomPosition(cellPanels, occupiedPositions);
	      

	        Random rand212 = new Random();

			// Generate random y-coordinate within the bounds of your cellPanels array
			int yyRed12 = rand212.nextInt(cellPanels[0].length);

			// Generate random i-coordinate within the bounds of your cellPanels array
			int iiRed12 = rand212.nextInt(cellPanels.length);

			// Assign label to the randomly generated coordinates for the red snake
			ImageIcon icon12 = new ImageIcon(this.getClass().getResource("/sn2.png"));
			JLabel label12 = new JLabel("");
			label12.setIcon(icon12);
			cellPanels[iiRed12][yyRed12].add(label12);
			label12.setBounds(-10, 0, 100, 100);
			cellPanels[iiRed12][yyRed12].setVisible(true);
			System.out.println(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())+"red");
			//create red snake for easy
			Snake redSnakeEasy1 = new Snake("redSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())), Integer.parseInt(cellNumbers[iiRed][yyRed].getText()) ,Integer.parseInt(cellNumbers[0][0].getText()));
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("snake");
	      		 }
	    	}
			snakes.add(redSnakeEasy1);
			System.out.println(Integer.parseInt(cellNumbers[iiRed12][yyRed12].getText())+"red");
			//create red snake for easy
			Snake redSnakeEasy1123 = new Snake("redSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[iiRed12][yyRed12].getText())), Integer.parseInt(cellNumbers[iiRed12][yyRed12].getText()) ,Integer.parseInt(cellNumbers[0][0].getText()));
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iiRed12][yyRed12].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("snake");
	      		 }
	    	}
			snakes.add(redSnakeEasy1123);
	        // Blue snake
	        Point bluePosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iBlue = bluePosition.x;
	        int yBlue = bluePosition.y;

	        Random rand = new Random();

		     // Generate a random y-coordinate within the bounds of your cellPanels array
		     int y1Blue = rand.nextInt(cellPanels[0].length); // Assuming cellPanels is a 2D array

		     // Generate a random i-coordinate within the bounds of your cellPanels array
		     // Ensure that i allows enough space for the tallest icon to fit without going out of bounds
		     int maxIBlue = cellPanels.length - 4; // To accommodate the tallest icon at i+3
		     int i1Blue = rand.nextInt(maxIBlue);

		     // Assign labels to the randomly generated coordinates for the blue snake
		     ImageIcon icon1b = new ImageIcon(this.getClass().getResource("/hb.png"));
		     JLabel label1b = new JLabel("");
		     label1b.setIcon(icon1b);
		     cellPanels[i1Blue][y1Blue].add(label1b);
		     label1b.setBounds(-100, -45, 200, 200);
		     cellPanels[i1Blue][y1Blue].setVisible(true);

		     ImageIcon icon2b = new ImageIcon(this.getClass().getResource("/bb1.png"));
		     JLabel label2b = new JLabel("");
		     label2b.setIcon(icon2b);
		     cellPanels[i1Blue+1][y1Blue].add(label2b);
		     label2b.setBounds(-100,-100, 300, 300);
		     cellPanels[i1Blue+1][y1Blue].setVisible(true);

		     ImageIcon icon3b = new ImageIcon(this.getClass().getResource("/bb2.png"));
		     JLabel label3b = new JLabel("");
		     label3b.setIcon(icon3b);
		     cellPanels[i1Blue+2][y1Blue].add(label3b);
		     label3b.setBounds(-100,-50, 200, 200);
		     cellPanels[i1Blue+2][y1Blue].setVisible(true);

		     ImageIcon icon4b = new ImageIcon(this.getClass().getResource("/tb.png"));
		     JLabel label4b = new JLabel("");
		     label4b.setIcon(icon4b);
		     cellPanels[i1Blue+3][y1Blue].add(label4b);
		     label4b.setBounds(-125, -76, 200, 200);
		     cellPanels[i1Blue+3][y1Blue].setVisible(true);
				System.out.println(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())+"blue");

				Snake blueSnakeEasy1 = new Snake("blueSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())-Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText())), Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText()) ,Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {

		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(blueSnakeEasy1);
	        // Green snake
	        Point greenPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iGreen = greenPosition.x;
	        int yGreen = greenPosition.y;
	        ImageIcon icon5g = new ImageIcon(this.getClass().getResource("/greenhead.png"));
		     JLabel label5g = new JLabel("");
		     label5g.setIcon(icon5g);
		     cellPanels[iGreen][yGreen].add(label5g);
		     label5g.setBounds(-70, -50, 200, 200);

		     ImageIcon icon6g = new ImageIcon(this.getClass().getResource("/greenbody.png"));
		     JLabel label6g = new JLabel("");
		     label6g.setIcon(icon6g);
		     cellPanels[iGreen+1][yGreen].add(label6g);
		     label6g.setBounds(-70,-50, 200, 200);
		     cellPanels[iGreen+1][yGreen].setVisible(true);

		     ImageIcon icon7g= new ImageIcon(this.getClass().getResource("/greentail.png"));
		     JLabel label7g = new JLabel("");
		     label7g.setIcon(icon7g);
		     cellPanels[iGreen+2][yGreen].add(label7g);
		     label7g.setBounds(-60, -76, 200, 200);
		     cellPanels[iGreen+2][yGreen].setVisible(true);

		     //create green snake for easy
				System.out.println(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())+"green");
				Snake greenSnakeEasy1 = new Snake("greenSnakeEasy1", Model.Color.GREEN, -(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())-Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText())), Integer.parseInt(cellNumbers[iGreen][yGreen].getText()) ,Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {
		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(greenSnakeEasy1);
		  // Green snake
		        Point greenPosition12 = generateRandomPosition(cellPanels, occupiedPositions);
		        int iGreen12 = greenPosition12.x;
		        int yGreen12 = greenPosition12.y;
		        ImageIcon icon5g12 = new ImageIcon(this.getClass().getResource("/greenhead.png"));
			     JLabel label5g12 = new JLabel("");
			     label5g12.setIcon(icon5g12);
			     cellPanels[iGreen12][yGreen12].add(label5g12);
			     label5g12.setBounds(-70, -50, 200, 200);

		        ImageIcon icon512 = new ImageIcon(this.getClass().getResource("/greenhead.png"));
			     JLabel label512 = new JLabel("");
			     label512.setIcon(icon512);
			     cellPanels[iGreen12][yGreen12].add(label512);
			     label512.setBounds(-70, -50, 200, 200);
			     cellPanels[iGreen12][yGreen12].setVisible(true);

			     ImageIcon icon612 = new ImageIcon(this.getClass().getResource("/greenbody.png"));
			     JLabel label612 = new JLabel("");
			     label612.setIcon(icon612);
			     cellPanels[iGreen12+1][yGreen12].add(label612);
			     label612.setBounds(-70,-50, 200, 200);
			     cellPanels[iGreen12+1][yGreen12].setVisible(true);

			     ImageIcon icon712= new ImageIcon(this.getClass().getResource("/greentail.png"));
			     JLabel label712 = new JLabel("");
			     label712.setIcon(icon712);
			     cellPanels[iGreen12+2][yGreen12].add(label712);
			     label712.setBounds(-60, -76, 200, 200);
			     cellPanels[iGreen12+2][yGreen12].setVisible(true);
			     //create green snake for easy
					System.out.println(Integer.parseInt(cellNumbers[iGreen12][yGreen12].getText())+"green");
					Snake greenSnakeEasy12 = new Snake("greenSnakeEasy1", Model.Color.GREEN, -(Integer.parseInt(cellNumbers[iGreen12][yGreen12].getText())-Integer.parseInt(cellNumbers[iGreen12+2][yGreen12].getText())), Integer.parseInt(cellNumbers[iGreen12][yGreen12].getText()) ,Integer.parseInt(cellNumbers[iGreen12+2][yGreen12].getText()));
					for(CellinBoard cell: CellController.getAllCells()) {
			      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iGreen12][yGreen12].getText())))&&(cell.getType()=="nothing")) {
			      			 cell.setType("snake");
			      		 }
			    	}
					snakes.add(greenSnakeEasy12);

	        // Yellow snake
	        Point yellowPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iYellow = yellowPosition.x;
	        int yYellow = yellowPosition.y;

	        ImageIcon icon8y = new ImageIcon(this.getClass().getResource("/yellowhead.png"));
		     JLabel label8y = new JLabel("");
		     label8y.setIcon(icon8y);
		     cellPanels[iYellow+3][yYellow].add(label8y);
		     label8y.setBounds(0,-50, 200, 200);
		     cellPanels[iYellow+3][yYellow].setVisible(true);

		     ImageIcon icon9y= new ImageIcon(this.getClass().getResource("/yellowtail.png"));
		     JLabel label9y = new JLabel("");
		     label9y.setIcon(icon9y);
		     cellPanels[iYellow+4][yYellow].add(label9y);
		     label9y.setBounds(0, -76, 200, 200);
		     cellPanels[iYellow+4][yYellow].setVisible(true);
		 	System.out.println(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())+"yellowSnakeEasy1");

			Snake yellowSnakeEasy1 = new Snake("yellowSnakeEasy1", Model.Color.YELLOW, -(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())-Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText())), Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText()) ,Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText()));
			for(CellinBoard cell: CellController.getAllCells()) {

	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("snake");
	      		 }
	    	}
			snakes.add(yellowSnakeEasy1);

	    }

	    // Main method to place ladders on the board
	    public void MplaceLadders() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions
	        // Ladder 1
	        Point ladder1Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x1 = ladder1Position.x;
	        int y1 = ladder1Position.y;
	        Random rand4 = new Random();			
			// Ladder 1
			int x3 = rand4.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y3 = rand4.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			// Place ladder 3 segment 1
			ImageIcon icon26l = new ImageIcon(this.getClass().getResource("/lu.png"));
			JLabel label26l = new JLabel("");
			label26l.setIcon(icon26l);
			cellPanels[x3][y3].add(label26l);
			label26l.setBounds(0, -25, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x3][y3].setVisible(true);
			// Place ladder 3 segment 2
			ImageIcon icon27l = new ImageIcon(this.getClass().getResource("/ld.png"));
			JLabel label27l = new JLabel("");
			label27l.setIcon(icon27l);
			cellPanels[x3 + 1][y3].add(label27l);  // Assuming the next cell for segment 2
			label27l.setBounds(0, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[x3 + 1][y3].setVisible(true);
			//create ladder2easy
			int stairs2 = (Integer.parseInt(cellNumbers[x3][y3].getText())) - (Integer.parseInt(cellNumbers[x3 + 1][y3].getText()));
			Ladder l2easy = new Ladder("l2easy", stairs2, (Integer.parseInt(cellNumbers[x3 + 1][y3].getText())), (Integer.parseInt(cellNumbers[x3][y3].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x3 + 1][y3].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l2easy);
	        // Ladder 2
	        Point ladder2Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x2 = ladder2Position.x;
	        int y2 = ladder2Position.y;

	        Random rand3 = new Random();
			
			// Ladder 2
			int xx2 = rand3.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int yy2 = rand3.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			// Place ladder 2
			ImageIcon icon23ll = new ImageIcon(this.getClass().getResource("/su.png"));
			JLabel label23l = new JLabel("");
			label23l.setIcon(icon23ll);
			cellPanels[xx2][yy2].add(label23l);
			label23l.setBounds(-60, 0, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2][yy2].setVisible(true);
			
			// Place ladder 2 segments
			ImageIcon iconall = new ImageIcon(this.getClass().getResource("/sb.png"));
			JLabel labelal = new JLabel("");
			labelal.setIcon(iconall);
			cellPanels[xx2 + 1][yy2].add(labelal);  // Assuming the next cell for segment 2
			labelal.setBounds(-60, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[xx2 + 1][yy2].setVisible(true);
			
			ImageIcon icon251ll = new ImageIcon(this.getClass().getResource("/sd.png"));
			JLabel icon2511l = new JLabel("");
			icon2511l.setIcon(icon251ll);
			cellPanels[xx2 + 2][yy2].add(icon2511l);  // Assuming the next cell for segment 3
			icon2511l.setBounds(-60, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2 + 2][yy2].setVisible(true);
			//create ladder3easy
			int stairs3 = (Integer.parseInt(cellNumbers[xx2][yy2].getText())) - (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText()));
			Ladder l3easy = new Ladder("l2easy", stairs3, (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())), (Integer.parseInt(cellNumbers[xx2][yy2].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l3easy);
	        // Ladder 3
	        Point ladder3Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x5 = ladder3Position.x;
	        int y5 = ladder3Position.y;
	        Random randr = new Random();			
			//Ladder 3
			int x4 = randr.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y4 = randr.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			//Place ladder 3 segment 1
			ImageIcon icon10lll = new ImageIcon(this.getClass().getResource("/s1u.png"));
			JLabel label10l = new JLabel("");
			label10l.setIcon(icon10lll);
			cellPanels[x4][y4].add(label10l);
			label10l.setBounds(-100, -50, 250, 250);  // Setting bounds relative to the cell
			cellPanels[x4][y4].setVisible(true);
			
			//Place ladder 3 segment 2
			ImageIcon icon11lll = new ImageIcon(this.getClass().getResource("/s11u.png"));
			JLabel label11l = new JLabel("");
			label11l.setIcon(icon11lll);
			cellPanels[x4 + 1][y4].add(label11l);  // Assuming the next cell for segment 2
			label11l.setBounds(-100, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 1][y4].setVisible(true);
			
			//Place ladder 3 segment 3
			ImageIcon icon12lll = new ImageIcon(this.getClass().getResource("/s11d.png"));
			JLabel label12l = new JLabel("");
			label12l.setIcon(icon12lll);
			cellPanels[x4 + 2][y4].add(label12l);  // Assuming the next cell for segment 3
			label12l.setBounds(-100, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 2][y4].setVisible(true);
			
			//Place ladder 3 segment 4
			ImageIcon icon13lll = new ImageIcon(this.getClass().getResource("/s1d.png"));
			JLabel label13l = new JLabel("");
			label13l.setIcon(icon13lll);
			cellPanels[x4 + 3][y4].add(label13l);  // Assuming the next cell for segment 4
			label13l.setBounds(-100, -80, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 3][y4].setVisible(true);
	        // Ladder 4
	        Point ladder4Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x6 = ladder4Position.x;
	        int y6 = ladder4Position.y;

	        Random rands = new Random();
	      //create ladder4easy
			int stairs4 = (Integer.parseInt(cellNumbers[x4][y4].getText())) - (Integer.parseInt(cellNumbers[x4 + 3][y4].getText()));
			Ladder l4easy = new Ladder("l2easy", stairs4, (Integer.parseInt(cellNumbers[x4 + 3][y4].getText())), (Integer.parseInt(cellNumbers[x4][y4].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x4 + 3][y4].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l4easy);
			//Ladder 4
			int x7 = rands.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y7 = rands.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			//Place ladder 4 segment 1
			ImageIcon icon14llll = new ImageIcon(this.getClass().getResource("/llu.png"));
			JLabel label14l = new JLabel("");
			label14l.setIcon(icon14llll);
			cellPanels[x7][y7].add(label14l);
			label14l.setBounds(-150, -85, 250, 300);  // Setting bounds relative to the cell
			cellPanels[x7][y7].setVisible(true);
			
			//Place ladder 4 segment 2
			ImageIcon icon15llll = new ImageIcon(this.getClass().getResource("/llu1.png"));
			JLabel label15l= new JLabel("");
			label15l.setIcon(icon15llll);
			cellPanels[x7 + 1][y7].add(label15l);  // Assuming the next cell for segment 2
			label15l.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 1][y7].setVisible(true);
			
			//Place ladder 4 segment 3
			ImageIcon icon16llll = new ImageIcon(this.getClass().getResource("/llu2.png"));
			JLabel label16l = new JLabel("");
			label16l.setIcon(icon16llll);
			cellPanels[x7 + 2][y7].add(label16l);  // Assuming the next cell for segment 3
			label16l.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 2][y7].setVisible(true);
			
			//Place ladder 4 segment 4
			ImageIcon icon17llll = new ImageIcon(this.getClass().getResource("/llu3.png"));
			JLabel label17l = new JLabel("");
			label17l.setIcon(icon17llll);
			cellPanels[x7 + 3][y7].add(label17l);  // Assuming the next cell for segment 4
			label17l.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 3][y7].setVisible(true);
			
			//Place ladder 4 segment 5
			ImageIcon icon18llll = new ImageIcon(this.getClass().getResource("/lld.png"));
			JLabel label18l = new JLabel("");
			label18l.setIcon(icon18llll);
			cellPanels[x7 + 4][y7].add(label18l);  // Assuming the next cell for segment 5
			label18l.setBounds(-150, -125 , 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 4][y7].setVisible(true);
			//create ladder5easy
			int stairs5 = (Integer.parseInt(cellNumbers[x7][y7].getText())) - (Integer.parseInt(cellNumbers[x7 + 4][y7].getText()));
			Ladder l5easy = new Ladder("l2easy", stairs5, (Integer.parseInt(cellNumbers[x7 + 4][y7].getText())), (Integer.parseInt(cellNumbers[x7][y7].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x7 + 4][y7].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l5easy);
	    }
	  //for HARD level
	    // Main method to place snakes on the board
	    public void HplaceSnakes() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions

	        // Red snake
	        Point redPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iRed = redPosition.x;
	        int yRed = redPosition.y;

	        Random rand2 = new Random();

			// Generate random y-coordinate within the bounds of your cellPanels array
			int yyRed = rand2.nextInt(cellPanels[0].length);

			// Generate random i-coordinate within the bounds of your cellPanels array
			int iiRed = rand2.nextInt(cellPanels.length);

			// Assign label to the randomly generated coordinates for the red snake
			ImageIcon icon = new ImageIcon(this.getClass().getResource("/sn2.png"));
			JLabel label = new JLabel("");
			label.setIcon(icon);
			cellPanels[iiRed][yyRed].add(label);
			label.setBounds(-20, -20, 100, 100);
			cellPanels[iiRed][yyRed].setVisible(true);
	     
			System.out.println(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())+"red");
			//create red snake for easy
			Snake redSnakeEasy1 = new Snake("redSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())), Integer.parseInt(cellNumbers[iiRed][yyRed].getText()) ,Integer.parseInt(cellNumbers[0][0].getText()));
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iiRed][yyRed].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("snake");
	      		 }
	    	}
			snakes.add(redSnakeEasy1);

	        // Blue snake
	        Point bluePosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iBlue = bluePosition.x;
	        int yBlue = bluePosition.y;

	        Random rand = new Random();

		     // Generate a random y-coordinate within the bounds of your cellPanels array
		     int y1Blue = rand.nextInt(cellPanels[0].length); // Assuming cellPanels is a 2D array

		     // Generate a random i-coordinate within the bounds of your cellPanels array
		     // Ensure that i allows enough space for the tallest icon to fit without going out of bounds
		     int maxIBlue = cellPanels.length - 4; // To accommodate the tallest icon at i+3
		     int i1Blue = rand.nextInt(maxIBlue);

		     // Assign labels to the randomly generated coordinates for the blue snake
		     ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/hb.png"));
		     JLabel label1 = new JLabel("");
		     label1.setIcon(icon1);
		     cellPanels[i1Blue][y1Blue].add(label1);
		     label1.setBounds(-120, -60, 200, 200);
		     cellPanels[i1Blue][y1Blue].setVisible(true);

		     ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/bb1.png"));
		     JLabel label2 = new JLabel("");
		     label2.setIcon(icon2);
		     cellPanels[i1Blue+1][y1Blue].add(label2);
		     label2.setBounds(-120,-100, 300, 300);
		     cellPanels[i1Blue+1][y1Blue].setVisible(true);

		     ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/bb2.png"));
		     JLabel label3 = new JLabel("");
		     label3.setIcon(icon3);
		     cellPanels[i1Blue+2][y1Blue].add(label3);
		     label3.setBounds(-85,-50, 150, 150);
		     cellPanels[i1Blue+2][y1Blue].setVisible(true);

		     ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/tb.png"));
		     JLabel label4 = new JLabel("");
		     label4.setIcon(icon4);
		     cellPanels[i1Blue+3][y1Blue].add(label4);
		     label4.setBounds(-110, -80, 200, 200);
		     cellPanels[i1Blue+3][y1Blue].setVisible(true);
	    
		     System.out.println(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())+"blue");

				Snake blueSnakeEasy1 = new Snake("blueSnakeEasy1", Model.Color.RED, -(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())-Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText())), Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText()) ,Integer.parseInt(cellNumbers[i1Blue+3][y1Blue].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {

		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[i1Blue][y1Blue].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(blueSnakeEasy1);

	        // Green snake
	        Point greenPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iGreen = greenPosition.x;
	        int yGreen = greenPosition.y;

	        ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/greenhead.png"));
		     JLabel label5 = new JLabel("");
		     label5.setIcon(icon5);
		     cellPanels[iGreen][yGreen].add(label5);
		     label5.setBounds(-110, -55, 200, 200);
		     cellPanels[iGreen][yGreen].setVisible(true);

		     ImageIcon icon6 = new ImageIcon(this.getClass().getResource("/greenbody.png"));
		     JLabel label6 = new JLabel("");
		     label6.setIcon(icon6);
		     cellPanels[iGreen+1][yGreen].add(label6);
		     label6.setBounds(-110,-50, 200, 200);
		     cellPanels[iGreen+1][yGreen].setVisible(true);

		     ImageIcon icon7= new ImageIcon(this.getClass().getResource("/greentail.png"));
		     JLabel label7 = new JLabel("");
		     label7.setIcon(icon7);
		     cellPanels[iGreen+2][yGreen].add(label7);
		     label7.setBounds(-20, -76, 200, 200);
		     cellPanels[iGreen+2][yGreen].setVisible(true);
		     //create green snake for easy
				System.out.println(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())+"green");
				Snake greenSnakeEasy1 = new Snake("greenSnakeEasy1", Model.Color.GREEN, -(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())-Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText())), Integer.parseInt(cellNumbers[iGreen][yGreen].getText()) ,Integer.parseInt(cellNumbers[iGreen+2][yGreen].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {
		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iGreen][yGreen].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(greenSnakeEasy1);
	        // Yellow snake
	        Point yellowPosition = generateRandomPosition(cellPanels, occupiedPositions);
	        int iYellow = yellowPosition.x;
	        int yYellow = yellowPosition.y;

	        ImageIcon icon8 = new ImageIcon(this.getClass().getResource("/yellowhead.png"));
		     JLabel label8 = new JLabel("");
		     label8.setIcon(icon8);
		     cellPanels[iYellow+3][yYellow].add(label8);
		     label8.setBounds(-20,-40, 150, 150);
		     cellPanels[iYellow+3][yYellow].setVisible(true);

		     ImageIcon icon9= new ImageIcon(this.getClass().getResource("/yellowtail.png"));
		     JLabel label9 = new JLabel("");
		     label9.setIcon(icon9);
		     cellPanels[iYellow+4][yYellow].add(label9);
		     label9.setBounds(-20, -76, 200, 200);
		     cellPanels[iYellow+4][yYellow].setVisible(true);
		     Snake yellowSnakeEasy1 = new Snake("yellowSnakeEasy1", Model.Color.YELLOW, -(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())-Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText())), Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText()) ,Integer.parseInt(cellNumbers[iYellow+4][yYellow].getText()));
				for(CellinBoard cell: CellController.getAllCells()) {

		      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[iYellow+3][yYellow].getText())))&&(cell.getType()=="nothing")) {
		      			 cell.setType("snake");
		      		 }
		    	}
				snakes.add(yellowSnakeEasy1);
	    }
	
	    

	    // Main method to place ladders on the board
	    public void HplaceLadders() {
	        Set<Point> occupiedPositions = new HashSet<>(); // Set to keep track of occupied positions

	        // Ladder 1
	        Point ladder1Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x1 = ladder1Position.x;
	        int y1 = ladder1Position.y;

	        Random rand4 = new Random();
			
			// Ladder 1
			int x3 = rand4.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y3 = rand4.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			// Place ladder 3 segment 1
			ImageIcon icon26 = new ImageIcon(this.getClass().getResource("/lu.png"));
			JLabel label26 = new JLabel("");
			label26.setIcon(icon26);
			cellPanels[x3][y3].add(label26);
			label26.setBounds(-20, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x3][y3].setVisible(true);
			
			// Place ladder 3 segment 2
			ImageIcon icon27 = new ImageIcon(this.getClass().getResource("/ld.png"));
			JLabel label27 = new JLabel("");
			label27.setIcon(icon27);
			cellPanels[x3 + 1][y3].add(label27);  // Assuming the next cell for segment 2
			label27.setBounds(-20, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[x3 + 1][y3].setVisible(true);
	        // Ladder 2
	        Point ladder2Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x2 = ladder2Position.x;
	        int y2 = ladder2Position.y;

	        Random rand3 = new Random();
			
			// Ladder 2
			int xx2 = rand3.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int yy2 = rand3.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			// Place ladder 2
			ImageIcon icon23 = new ImageIcon(this.getClass().getResource("/su.png"));
			JLabel label23 = new JLabel("");
			label23.setIcon(icon23);
			cellPanels[xx2][yy2].add(label23);
			label23.setBounds(-80, -40, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2][yy2].setVisible(true);
			
			// Place ladder 2 segments
			ImageIcon icona = new ImageIcon(this.getClass().getResource("/sb.png"));
			JLabel labela = new JLabel("");
			labela.setIcon(icona);
			cellPanels[xx2 + 1][yy2].add(labela);  // Assuming the next cell for segment 2
			labela.setBounds(-80, -50, 200, 200);  // Setting bounds relative to the cell
			cellPanels[xx2 + 1][yy2].setVisible(true);
			
			ImageIcon icon251 = new ImageIcon(this.getClass().getResource("/sd.png"));
			JLabel icon2511 = new JLabel("");
			icon2511.setIcon(icon251);
			cellPanels[xx2 + 2][yy2].add(icon2511);  // Assuming the next cell for segment 3
			icon2511.setBounds(-80, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[xx2 + 2][yy2].setVisible(true);

	        // Ladder 3
	        Point ladder3Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x5 = ladder3Position.x;
	        int y5 = ladder3Position.y;

	        Random randr = new Random();
			
			//Ladder 3
			int x4 = randr.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y4 = randr.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			//Place ladder 3 segment 1
			ImageIcon icon10 = new ImageIcon(this.getClass().getResource("/s1u.png"));
			JLabel label10 = new JLabel("");
			label10.setIcon(icon10);
			cellPanels[x4][y4].add(label10);
			label10.setBounds(-100, -60, 250, 250);  // Setting bounds relative to the cell
			cellPanels[x4][y4].setVisible(true);
			
			//Place ladder 3 segment 2
			ImageIcon icon11 = new ImageIcon(this.getClass().getResource("/s11u.png"));
			JLabel label11 = new JLabel("");
			label11.setIcon(icon11);
			cellPanels[x4 + 1][y4].add(label11);  // Assuming the next cell for segment 2
			label11.setBounds(-100, -60, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 1][y4].setVisible(true);
			
			//Place ladder 3 segment 3
			ImageIcon icon12 = new ImageIcon(this.getClass().getResource("/s11d.png"));
			JLabel label12 = new JLabel("");
			label12.setIcon(icon12);
			cellPanels[x4 + 2][y4].add(label12);  // Assuming the next cell for segment 3
			label12.setBounds(-100, -50, 150, 150);  // Setting bounds relative to the cell
			cellPanels[x4 + 2][y4].setVisible(true);
			
			//Place ladder 3 segment 4
			ImageIcon icon13 = new ImageIcon(this.getClass().getResource("/s1d.png"));
			JLabel label13 = new JLabel("");
			label13.setIcon(icon13);
			cellPanels[x4 + 3][y4].add(label13);  // Assuming the next cell for segment 4
			label13.setBounds(-100, -80, 200, 200);  // Setting bounds relative to the cell
			cellPanels[x4 + 3][y4].setVisible(true);
	        // Ladder 4
	        Point ladder4Position = generateRandomPosition(cellPanels, occupiedPositions);
	        int x6 = ladder4Position.x;
	        int y6 = ladder4Position.y;

	        Random rands = new Random();
			
			//Ladder 4
			int x7 = rands.nextInt(cellPanels.length-4);  // Generate random x-coordinate
			int y7 = rands.nextInt(cellPanels[0].length);  // Generate random y-coordinate
			
			//Place ladder 4 segment 1
			ImageIcon icon14 = new ImageIcon(this.getClass().getResource("/llu.png"));
			JLabel label14 = new JLabel("");
			label14.setIcon(icon14);
			cellPanels[x7][y7].add(label14);
			label14.setBounds(-150, -120, 250, 300);  // Setting bounds relative to the cell
			cellPanels[x7][y7].setVisible(true);
			
			//Place ladder 4 segment 2
			ImageIcon icon15 = new ImageIcon(this.getClass().getResource("/llu1.png"));
			JLabel label15 = new JLabel("");
			label15.setIcon(icon15);
			cellPanels[x7 + 1][y7].add(label15);  // Assuming the next cell for segment 2
			label15.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 1][y7].setVisible(true);
			
			//Place ladder 4 segment 3
			ImageIcon icon16 = new ImageIcon(this.getClass().getResource("/llu2.png"));
			JLabel label16 = new JLabel("");
			label16.setIcon(icon16);
			cellPanels[x7 + 2][y7].add(label16);  // Assuming the next cell for segment 3
			label16.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 2][y7].setVisible(true);
			
			//Place ladder 4 segment 4
			ImageIcon icon17 = new ImageIcon(this.getClass().getResource("/llu3.png"));
			JLabel label17 = new JLabel("");
			label17.setIcon(icon17);
			cellPanels[x7 + 3][y7].add(label17);  // Assuming the next cell for segment 4
			label17.setBounds(-150, -100, 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 3][y7].setVisible(true);
			
			//Place ladder 4 segment 5
			ImageIcon icon18 = new ImageIcon(this.getClass().getResource("/lld.png"));
			JLabel label18 = new JLabel("");
			label18.setIcon(icon18);
			cellPanels[x7 + 4][y7].add(label18);  // Assuming the next cell for segment 5
			label18.setBounds(-150, -125 , 300, 300);  // Setting bounds relative to the cell
			cellPanels[x7 + 4][y7].setVisible(true);
			//create ladder2easy
			int stairs2 = (Integer.parseInt(cellNumbers[x3][y3].getText())) - (Integer.parseInt(cellNumbers[x3 + 1][y3].getText()));
			Ladder l2easy = new Ladder("l2easy", stairs2, (Integer.parseInt(cellNumbers[x3 + 1][y3].getText())), (Integer.parseInt(cellNumbers[x3][y3].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x3 + 1][y3].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l2easy);
			//create ladder3easy
			int stairs3 = (Integer.parseInt(cellNumbers[xx2][yy2].getText())) - (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText()));
			Ladder l3easy = new Ladder("l2easy", stairs3, (Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())), (Integer.parseInt(cellNumbers[xx2][yy2].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[xx2 + 2][yy2].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l3easy);
			//create ladder4easy
			int stairs4 = (Integer.parseInt(cellNumbers[x4][y4].getText())) - (Integer.parseInt(cellNumbers[x4 + 3][y4].getText()));
			Ladder l4easy = new Ladder("l2easy", stairs4, (Integer.parseInt(cellNumbers[x4 + 3][y4].getText())), (Integer.parseInt(cellNumbers[x4][y4].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x4 + 3][y4].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l4easy);
			//create ladder5easy
			int stairs5 = (Integer.parseInt(cellNumbers[x7][y7].getText())) - (Integer.parseInt(cellNumbers[x7 + 4][y7].getText()));
			Ladder l5easy = new Ladder("l2easy", stairs5, (Integer.parseInt(cellNumbers[x7 + 4][y7].getText())), (Integer.parseInt(cellNumbers[x7][y7].getText()))); 
			for(CellinBoard cell: CellController.getAllCells()) {
	      		 if((cell.getPosition()==(Integer.parseInt(cellNumbers[x7 + 4][y7].getText())))&&(cell.getType()=="nothing")) {
	      			 cell.setType("ladder");
	      		 }
	    	}
			ladders.add(l5easy);
	    }
	    
	    
	    
}
		
