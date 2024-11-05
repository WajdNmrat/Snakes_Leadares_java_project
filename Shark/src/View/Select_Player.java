package View;

import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.MusicController;
import Controller.SelectPlayer_Names_ColoersController;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Select_Player{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Player window = new Select_Player();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int flag=0;
	private JFrame frame;
	public static  JLabel test=new JLabel("");
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public Select_Player() {
		initialize();
	}
	public JFrame getFrame() {
		return frame;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);

		panel.setLayout(null);

	
		 JPanel panel_1 = new JPanel();
		 panel_1.setForeground(new Color(128, 128, 255));
		 panel_1.setBackground(new Color(128, 0, 255));
         panel_1.setBounds(0, 0, 1800, 1800);
         panel.add(panel_1);
         
		JLabel boardgame = new JLabel("");
		boardgame.setBounds(100, 150, 150, 150);
		ImageIcon board = new ImageIcon(this.getClass().getResource("/boardgame.png"));
		panel_1.setLayout(null);
		boardgame.setIcon(board);
		panel_1.add(boardgame);
		
		JLabel boardgame1 = new JLabel("");
		boardgame1.setBounds(1050, 150, 150, 150);
		ImageIcon board2 = new ImageIcon(this.getClass().getResource("/boardgame.png"));
		panel_1.setLayout(null);
		boardgame1.setIcon(board2);
		panel_1.add(boardgame1);
		
		
		
		Label label = new Label("Snakes And Ladders");
		label.setBackground(new Color(255, 255, 255));
		label.setForeground(new Color(255, 128, 0));
		label.setBounds(450, 0, 500, 55);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		panel_1.add(label);
		Label label_1 = new Label("Choose the number of competitors in the game");
		label_1.setForeground(new Color(255, 128, 0));
		label_1.setBounds(300, 280, 700, 35);
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setAlignment(Label.CENTER);
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("2 players");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(400, 350, 76, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("3 players");
		lblNewLabel_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(1000, 350, 76, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("4 players");
		lblNewLabel_2.setForeground(new Color(0, 0, 160));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(700, 550, 76, 22);
		panel_1.add(lblNewLabel_2);        
				
		
		JLabel jumpysnake = new JLabel("");
		ImageIcon sn = new ImageIcon(this.getClass().getResource("/jumpysnake.gif"));
		jumpysnake.setIcon(sn);
		panel_1.add(jumpysnake);
		jumpysnake.setBounds(500, 40, 190, 186);
		
		
	
				JButton btnNewButton1 = new JButton("");
				ImageIcon start6 = new ImageIcon(this.getClass().getResource("/2players.png"));
				btnNewButton1.setBounds(200, 400, 500, 89);
				btnNewButton1.setIcon(start6);
				panel_1.add(btnNewButton1);
				
				
				JButton btnNewButton2 = new JButton("");
				ImageIcon start7 = new ImageIcon(this.getClass().getResource("/3players.png"));
				btnNewButton2.setBounds(800, 400, 500, 85);
				btnNewButton2.setIcon(start7);
				panel_1.add(btnNewButton2);
				
				
				JButton btnNewButton3 = new JButton("");
				ImageIcon start8 = new ImageIcon(this.getClass().getResource("/4players.png"));
				btnNewButton3.setBounds(500, 600, 500, 85);
				btnNewButton3.setIcon(start8);
				panel_1.add(btnNewButton3);
				
				  // Add action listener to the button
				btnNewButton1.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Perform some action when the button is clicked
		            flag=2;
		            SelectPlayer_Names_ColoersController.flag=flag;
					frame.setVisible(false);
					Names_Colores Names_Colores = new Names_Colores();
					Names_Colores.show();

		            }
				});
				
				  // Add action listener to the button
				btnNewButton2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Perform some action when the button is clicked
		            	
		            	flag=3;
		            	SelectPlayer_Names_ColoersController.flag=flag;
		            	frame.setVisible(false);
						Names_Colores Names_Colores = new Names_Colores();
						Names_Colores.show();
		            }
				});
				 JButton btnNewButton15 = new JButton("Back");
				 btnNewButton15.setBounds(0, 0, 100, 30);
				 ImageIcon b = new ImageIcon(this.getClass().getResource("/back.png"));
				 btnNewButton15.setIcon(b);
				 btnNewButton15.setBackground(new Color(255, 128, 64));
				 panel_1.add(btnNewButton15);
		         btnNewButton15.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                // Handle the back button action
			            	  home home;
			            			home = new home();
			            			home.show();
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
		     	
		     	soundButton.setBounds(0, 35, 44, 39);
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
		     	panel_1.add(soundButton);
				  // Add action listener to the button
				btnNewButton3.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Perform some action when the button is clicked
		            	flag=4;
		            	SelectPlayer_Names_ColoersController.flag=flag;
		            	frame.setVisible(false);
						Names_Colores Names_Colores = new Names_Colores();
						Names_Colores.show();
		            }
				});
				 JLabel lblNewLabel1 = new JLabel();
				 lblNewLabel1.setBounds(0, 0, 2800, 1000);

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
		         panel_1.add(lblNewLabel1);
		         
		        
		         
		       
		         
	
				
 }
	 // Method to display the frame
    public void show() {
        EventQueue.invokeLater(() -> {
            try {
            	getFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}