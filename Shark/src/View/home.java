package View;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;

import Controller.GameHistoryController;
import Controller.MusicController;
import Controller.ScreenController;
import Model.SysData;

import java.awt.event.ActionListener;

import java.net.URL;
import java.awt.event.ActionEvent;



public class home {

	public static SysData sysData = new SysData();
	private JFrame frame;
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0,  ScreenController.getScreenWidth(),  ScreenController.getScreenHeight());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	JPanel panel = new JPanel();
	panel.setLayout(null);
	panel.setBounds(0, 0,  ScreenController.getScreenWidth(), ScreenController.getScreenHeight());
	frame.getContentPane().add(panel);
	
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
	
	soundButton.setBounds(ScreenController.getScreenWidth()-70, 11, 44, 39);
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
	
	JButton instructionsbtn = new JButton("");
	instructionsbtn.setBounds(ScreenController.getScreenWidth()-140, 11, 44, 39);
	ImageIcon i = new ImageIcon(this.getClass().getResource("/ins.png"));
	//instructionsbtn.setIcon(i);
	instructionsbtn.setBackground(new Color(255, 190, 86));
	Image insimg = i.getImage().getScaledInstance(instructionsbtn.getWidth(), instructionsbtn.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon Icon = new ImageIcon(insimg);
    instructionsbtn.setIcon(Icon);
	instructionsbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Instructions instructions = new Instructions();
			instructions.show();
			frame.setVisible(false);
		}
	});
	panel.add(instructionsbtn);
	
	
	
	JButton newGamebtn = new JButton("<html>Strat<br>New Game</html>");
	newGamebtn.setFont(new Font("Papyrus", Font.BOLD, 24));
	newGamebtn.setBackground(Color.WHITE);
	newGamebtn.setBounds(ScreenController.getScreenWidth()/10, ScreenController.getScreenHeight()/4, ScreenController.getScreenWidth()/4, ScreenController.getScreenHeight()/2);
	newGamebtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectLevel selectLevel = new selectLevel();
			selectLevel.show();
			frame.setVisible(false);

		}
	});
	panel.add(newGamebtn);
	
	
	
	
	JButton historybtn = new JButton("<html>View<br>Games<br>History</html>");
	historybtn.setFont(new Font("Papyrus", Font.BOLD, 24));
	historybtn.setBackground(Color.WHITE);
	historybtn.setBounds((ScreenController.getScreenWidth()/10)*4, ScreenController.getScreenHeight()/4, ScreenController.getScreenWidth()/4, ScreenController.getScreenHeight()/2);
	historybtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		        HistoryScreen historyScreen = new HistoryScreen();
		        GameHistoryController gameHistoryController = new GameHistoryController(sysData, historyScreen);
		        gameHistoryController.SendGameHistory();
		        historyScreen.show();
				frame.setVisible(false); 
		}
	});
	panel.add(historybtn);
	
	
	
	
	JButton loginbtn = new JButton("<html>Questions<br>Management</html>");
	loginbtn.setFont(new Font("Papyrus", Font.BOLD, 24));
	loginbtn.setBackground(Color.WHITE);
	loginbtn.setBounds((ScreenController.getScreenWidth()/10)*7, ScreenController.getScreenHeight()/4, ScreenController.getScreenWidth()/4, ScreenController.getScreenHeight()/2);
	loginbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Login log = new Login();
			log.show();
			frame.setVisible(false); 
		}
	});
	
	panel.add(loginbtn);

	
	JLabel lblNewLabel_1 = new JLabel("Welcome To Snakes And Ladders");
	lblNewLabel_1.setForeground(new Color(0, 0, 160));
	lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 19));
	lblNewLabel_1.setBounds(39, 37, 350, 20);
	panel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("choose an option");
	lblNewLabel_2.setForeground(new Color(0, 0, 160));
	lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
	lblNewLabel_2.setBounds(53, 74, 200, 20);
	panel.add(lblNewLabel_2);
	
	 JLabel lblNewLabel1 = new JLabel();
	 lblNewLabel1.setBounds(0, 0, ScreenController.getScreenWidth(), ScreenController.getScreenHeight());

     // Load the image from the resource
     URL imageUrl = this.getClass().getResource("/main-image.jpg");
     if (imageUrl != null) {
         ImageIcon originalIcon = new ImageIcon(imageUrl);
         
         // Scale the image to fit the JLabel
         Image img = originalIcon.getImage().getScaledInstance(lblNewLabel1.getWidth(), lblNewLabel1.getHeight(), Image.SCALE_SMOOTH);
         ImageIcon scaledIcon = new ImageIcon(img);
         
         lblNewLabel1.setIcon(scaledIcon);
     } else {
         System.err.println("Could not load image resource");
     }
     panel.add(lblNewLabel1);
	
	
	}
	
	  // Method to display the frame
    public void show() {
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}