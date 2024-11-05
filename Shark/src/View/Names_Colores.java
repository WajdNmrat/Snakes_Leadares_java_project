package View;
import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MusicController;
import Controller.SelectPlayer_Names_ColoersController;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Names_Colores {
	public JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static  JTextField textField_3;
	public static String Player1_color="";
	public static  String Player2_color="";
	public static String Player3_color="";
	public static String Player4_color="";
	public static JLabel player1;
	public static JLabel player2;
	public static JLabel player3;
	public static JLabel player4;
	public static int go=0;
	public JFrame getFrame() {
		return frame;
	}
	public Names_Colores() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel_1);

		panel_1.setLayout(null);
		
		JLabel background = new JLabel("");
		ImageIcon back = new ImageIcon(this.getClass().getResource("/background.jpg"));
		
		JLabel jumpysnake = new JLabel("");
		ImageIcon sn = new ImageIcon(this.getClass().getResource("/jumpysnake.gif"));
		jumpysnake.setIcon(sn);
		panel_1.add(jumpysnake);
		jumpysnake.setBounds(600, 30, 190, 186);
		background.setIcon(back);
		background.setBounds(950, 200, 400, 200);
		panel_1.add(background);
		
		
		
		
		
		JLabel snake = new JLabel("");
		ImageIcon s = new ImageIcon(this.getClass().getResource("/snake.gif"));
		panel_1.add(snake);
		snake.setIcon(s);
		snake.setBounds(950, 400, 400, 197);
		
		JLabel title = new JLabel("Snakes And Ladders");
		panel_1.add(title);
		title.setForeground(new Color(189, 198, 68));
		title.setFont(new Font("Papyrus", Font.BOLD, 28));
		title.setBounds(600, 0, 406, 55);
		
		
		
		Label label_1 = new Label("Player 1 Name : ");
		label_1.setBounds(0, 200, 128, 25);
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label_1.setBackground(new Color(192, 192, 192));
		panel_1.add(label_1);
		
		Label label_1_1 = new Label("Player 2 Name : ");
		label_1_1.setBounds(0, 300, 128, 25);
		label_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_1);
		Label label_1_1_1 = new Label("Player 3 Name : ");
		label_1_1_1.setBounds(0, 400, 128, 25);
		label_1_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_1_1);
		Label label_1_1_1_1 = new Label("Player 4 Name : ");
		label_1_1_1_1.setBounds(0, 500, 128, 25);
		label_1_1_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_1_1_1);
		
		Label label_1_4_4_1 = new Label("Color");
		label_1_4_4_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		label_1_4_4_1.setBounds(280, 200, 61, 30);
		label_1_4_4_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_4_4_1);
		
		Label label_1_4_4_1_1 = new Label("Color");
		label_1_4_4_1_1.setBounds(280, 300, 61, 30);
		label_1_4_4_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		label_1_4_4_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_4_4_1_1);
		
		
		Label label_1_4_4_1_1_1_1 = new Label("Color");
		label_1_4_4_1_1_1_1.setBounds(280, 400, 61, 30);
		label_1_4_4_1_1_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		label_1_4_4_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_4_4_1_1_1_1);
		
		Label label_1_4_4_1_1_1 = new Label("Color");
		label_1_4_4_1_1_1.setBounds(280, 500, 61, 30);
		label_1_4_4_1_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		label_1_4_4_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(label_1_4_4_1_1_1);
		
		

		
		textField = new JTextField();
		textField.setBounds(130, 200, 120, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 300, 120, 20);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 400, 120, 20);
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 500, 120, 20);
		textField_3.setColumns(10);
		panel_1.add(textField_3);
		
		
		JButton continuationButton = new JButton("");
		ImageIcon start = new ImageIcon(this.getClass().getResource("/start.png"));
		continuationButton.setIcon(start);
		continuationButton.setBackground(new Color(172, 203, 81));
		continuationButton.setBounds(550, 600, 150, 70);
		panel_1.add(continuationButton);
		
		
		  // Add action listener to the button
		continuationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform some action when the button is clicked
                if(selectLevel.flag_level==1)
                {
	            if(SelectPlayer_Names_ColoersController.flag==2)
	            {
	                 player1 = new JLabel("");
	                ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	                player1.setOpaque(true);
	        		player1.setAutoscrolls(true);
	        		player1.setIcon(playerIcon1);
	                player1.setBounds(-10, 10, 50, 69); // Adjust bounds to fit the image 
	        		
	                
	                
	                player2 = new JLabel("");
	                ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	        		player2.setOpaque(true);
	        		player2.setAutoscrolls(true);
	        		player2.setIcon(playerIcon2);
	                player2.setBounds(40, 10, 50, 69); // Adjust bounds to fit the image  
	                
	            }
	            if(SelectPlayer_Names_ColoersController.flag==3)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		   player1 = new JLabel("");
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 				player1.setIcon(playerIcon1);
	 		        player1.setBounds(-10, 15, 45, 69); // Adjust bounds to fit the image        
	 				
	 		       ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		       player3 = new JLabel("");
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setIcon(playerIcon3);
	 		        player3.setBounds(23, 15, 45, 69); 
	 		        
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel("");
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 				player2.setIcon(playerIcon2);
	 		        player2.setBounds(50, 15, 45, 69); // Adjust bounds to fit the image        
	 					
	 		       
	            }
	            if(SelectPlayer_Names_ColoersController.flag==4)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		         player1 = new JLabel(playerIcon1);
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 		        player1.setBounds(0, 10, 38, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 				
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel(playerIcon2);
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 		        player2.setBounds(70, 10, 38, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 					
	 		        ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		         player3 = new JLabel(playerIcon3);
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setBounds(49, 10, 38, 69); 
	 		        
	 		        ImageIcon playerIcon4 = new ImageIcon(getClass().getResource("/"+Player4_color));
	 		         player4 = new JLabel(playerIcon4);
	 		        player4.setOpaque(true);
	 		        player4.setAutoscrolls(true);
	 		        player4.setBounds(24, 10, 38, 69); 
	            }
                }
                if(selectLevel.flag_level==2)
                {
	            if(SelectPlayer_Names_ColoersController.flag==2)
	            {
	                 player1 = new JLabel("");
	                ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	                player1.setOpaque(true);
	        		player1.setAutoscrolls(true);
	        		player1.setIcon(playerIcon1);
	                player1.setBounds(-10, 10, 50, 69); // Adjust bounds to fit the image 
	        		
	                
	                
	                player2 = new JLabel("");
	                ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	        		player2.setOpaque(true);
	        		player2.setAutoscrolls(true);
	        		player2.setIcon(playerIcon2);
	                player2.setBounds(40, 10, 50, 69); // Adjust bounds to fit the image  
	                
	            }
	            if(SelectPlayer_Names_ColoersController.flag==3)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		   player1 = new JLabel("");
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 				player1.setIcon(playerIcon1);
	 		        player1.setBounds(-20, 15, 45, 69); // Adjust bounds to fit the image        
	 				
	 		       ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		       player3 = new JLabel("");
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setIcon(playerIcon3);
	 		        player3.setBounds(13, 15, 45, 69); 
	 		        
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel("");
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 				player2.setIcon(playerIcon2);
	 		        player2.setBounds(40, 15, 45, 69); // Adjust bounds to fit the image        
	 					
	 		       
	            }
	            if(SelectPlayer_Names_ColoersController.flag==4)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		         player1 = new JLabel(playerIcon1);
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 		        player1.setBounds(-15, 10, 38, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 				
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel(playerIcon2);
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 		        player2.setBounds(55, 10, 38, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 					
	 		        ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		         player3 = new JLabel(playerIcon3);
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setBounds(34, 10, 38, 69); 
	 		        
	 		        ImageIcon playerIcon4 = new ImageIcon(getClass().getResource("/"+Player4_color));
	 		         player4 = new JLabel(playerIcon4);
	 		        player4.setOpaque(true);
	 		        player4.setAutoscrolls(true);
	 		        player4.setBounds(9, 10, 38, 69); 
	            }
                }
                if(selectLevel.flag_level==3)
                {
	            if(SelectPlayer_Names_ColoersController.flag==2)
	            {
	                 player1 = new JLabel("");
	                ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	                player1.setOpaque(true);
	        		player1.setAutoscrolls(true);
	        		player1.setIcon(playerIcon1);
	                player1.setBounds(0, 15, 30, 69); // Adjust bounds to fit the image 
	        		
	                
	                
	                player2 = new JLabel("");
	                ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	        		player2.setOpaque(true);
	        		player2.setAutoscrolls(true);
	        		player2.setIcon(playerIcon2);
	                player2.setBounds(30, 15, 30, 69); // Adjust bounds to fit the image  
	                
	            }
	            if(SelectPlayer_Names_ColoersController.flag==3)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		   player1 = new JLabel("");
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 				player1.setIcon(playerIcon1);
	 		        player1.setBounds(-5, 8, 23, 69); // Adjust bounds to fit the image        
	 				
	 		       ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		       player3 = new JLabel("");
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setIcon(playerIcon3);
	 		        player3.setBounds(11, 8, 25, 69); 
	 		        
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel("");
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 				player2.setIcon(playerIcon2);
	 		        player2.setBounds(35, 8, 20, 69); // Adjust bounds to fit the image        
	 					
	 		       
	            }
	            if(SelectPlayer_Names_ColoersController.flag==4)
	            {
	            	 ImageIcon playerIcon1 = new ImageIcon(getClass().getResource("/"+Player1_color));
	 		         player1 = new JLabel(playerIcon1);
	 		        player1.setOpaque(true);
	 				player1.setAutoscrolls(true);
	 		        player1.setBounds(-5, 8, 23, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 				
	 		        ImageIcon playerIcon2 = new ImageIcon(getClass().getResource("/"+Player2_color));
	 				 player2 = new JLabel(playerIcon2);
	 				player2.setOpaque(true);
	 				player2.setAutoscrolls(true);
	 		        player2.setBounds(30, 8, 20, 69); // Adjust bounds to fit the image        player1.setAutoscrolls(true);
	 					
	 		        ImageIcon playerIcon3 = new ImageIcon(getClass().getResource("/"+Player3_color));
	 		         player3 = new JLabel(playerIcon3);
	 		        player3.setOpaque(true);
	 		        player3.setAutoscrolls(true);
	 		        player3.setBounds(6, 8, 25, 69); 
	 		        
	 		        ImageIcon playerIcon4 = new ImageIcon(getClass().getResource("/"+Player4_color));
	 		         player4 = new JLabel(playerIcon4);
	 		        player4.setOpaque(true);
	 		        player4.setAutoscrolls(true);
	 		        player4.setBounds(40, 8, 25, 69); 
	            }
                }
	            go=1;
	            SelectPlayer_Names_ColoersController.edit();
	            BoardView game = new BoardView();
		        game.show();
		        frame.setVisible(false);

            	
            }
		});
	 
		 JButton btnNewButton30 = new JButton("Back");
		 btnNewButton30.setBounds(0, 0, 100, 40);
		 ImageIcon b = new ImageIcon(this.getClass().getResource("/back.png"));
		 btnNewButton30.setIcon(b);
		 btnNewButton30.setBackground(new Color(255, 128, 0));
		 panel_1.add(btnNewButton30);
         btnNewButton30.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Handle the back button action
	            	  Select_Player Select_Player;
	            	  Select_Player = new Select_Player();
	            	  Select_Player.show();
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
     	
     	soundButton.setBounds(0, 40, 77, 40);
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
		
		JButton btnNewButton1 = new JButton("");
		ImageIcon start1 = new ImageIcon(this.getClass().getResource("/color1.png"));
		btnNewButton1.setBounds(353, 200, 95, 85);
		btnNewButton1.setIcon(start1);
		panel_1.add(btnNewButton1);
	
		JButton btnNewButton2 = new JButton("");
		ImageIcon start2 = new ImageIcon(this.getClass().getResource("/color2.png"));
		btnNewButton2.setBounds(450, 200, 91, 85);
		btnNewButton2.setIcon(start2);
		panel_1.add(btnNewButton2);

		JButton btnNewButton3 = new JButton("");
		ImageIcon start3 = new ImageIcon(this.getClass().getResource("/color3.png"));
		btnNewButton3.setBounds(547, 200, 93, 85);
		btnNewButton3.setIcon(start3);
		panel_1.add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("");
		ImageIcon start4 = new ImageIcon(this.getClass().getResource("/color4.png"));
		btnNewButton4.setBounds(644, 200, 93, 89);
		btnNewButton4.setIcon(start4);
		panel_1.add(btnNewButton4);
		
		JButton btnNewButton5 = new JButton("");
		ImageIcon start5 = new ImageIcon(this.getClass().getResource("/color5.png"));
		btnNewButton5.setBounds(741, 200, 89, 91);
		btnNewButton5.setIcon(start5);
		panel_1.add(btnNewButton5);
		
		JButton btnNewButton6 = new JButton("");
		ImageIcon start6 = new ImageIcon(this.getClass().getResource("/color6.png"));
		btnNewButton6.setBounds(838, 200, 89, 89);
		btnNewButton6.setIcon(start6);
		panel_1.add(btnNewButton6);
		
		
		JButton btnNewButton7 = new JButton("");
		ImageIcon start7 = new ImageIcon(this.getClass().getResource("/color1.png"));
		btnNewButton7.setBounds(353, 300, 95, 85);
		btnNewButton7.setIcon(start7);
		panel_1.add(btnNewButton7);
		
		
		JButton btnNewButton8 = new JButton("");
		ImageIcon start8 = new ImageIcon(this.getClass().getResource("/color2.png"));
		btnNewButton8.setBounds(450, 300, 91, 85);
		btnNewButton8.setIcon(start8);
		panel_1.add(btnNewButton8);
		
		JButton btnNewButton9 = new JButton("");
		ImageIcon start9 = new ImageIcon(this.getClass().getResource("/color3.png"));
		btnNewButton9.setBounds(547, 300, 93, 85);
		btnNewButton9.setIcon(start9);
		panel_1.add(btnNewButton9);
		
		
		JButton btnNewButton10 = new JButton("");
		ImageIcon start10 = new ImageIcon(this.getClass().getResource("/color4.png"));
		btnNewButton10.setBounds(644, 300, 93, 89);
		btnNewButton10.setIcon(start10);
		panel_1.add(btnNewButton10);
		
		
		JButton btnNewButton11 = new JButton("");
		ImageIcon start11 = new ImageIcon(this.getClass().getResource("/color5.png"));
		btnNewButton11.setBounds(741, 300, 89, 91);
		btnNewButton11.setIcon(start11);
		panel_1.add(btnNewButton11);
		
		JButton btnNewButton12 = new JButton("");
		ImageIcon start12 = new ImageIcon(this.getClass().getResource("/color6.png"));
		btnNewButton12.setBounds(838, 300, 89, 89);
		btnNewButton12.setIcon(start12);
		panel_1.add(btnNewButton12);
		
		JButton btnNewButton13 = new JButton("");
		ImageIcon start13 = new ImageIcon(this.getClass().getResource("/color1.png"));
		btnNewButton13.setBounds(353, 400, 95, 85);
		btnNewButton13.setIcon(start13);
		panel_1.add(btnNewButton13);
		
		JButton btnNewButton14 = new JButton("");
		ImageIcon start14 = new ImageIcon(this.getClass().getResource("/color2.png"));
		btnNewButton14.setBounds(450, 400, 91, 85);
		btnNewButton14.setIcon(start14);
		panel_1.add(btnNewButton14);
		
		JButton btnNewButton15 = new JButton("");
		ImageIcon start15 = new ImageIcon(this.getClass().getResource("/color3.png"));
		btnNewButton15.setBounds(547, 400, 87, 85);
		btnNewButton15.setIcon(start15);
		panel_1.add(btnNewButton15);
		
		JButton btnNewButton16 = new JButton("");
		ImageIcon start16 = new ImageIcon(this.getClass().getResource("/color4.png"));
		btnNewButton16.setBounds(644, 400, 93, 89);
		btnNewButton16.setIcon(start16);
		panel_1.add(btnNewButton16);
		
		JButton btnNewButton17 = new JButton("");
		ImageIcon start17 = new ImageIcon(this.getClass().getResource("/color5.png"));
		btnNewButton17.setBounds(741, 400, 89, 91);
		btnNewButton17.setIcon(start17);
		panel_1.add(btnNewButton17);
		
		JButton btnNewButton18 = new JButton("");
		ImageIcon start18 = new ImageIcon(this.getClass().getResource("/color6.png"));
		btnNewButton18.setBounds(838, 400, 89, 89);
		btnNewButton18.setIcon(start18);
		panel_1.add(btnNewButton18);
		
		JButton btnNewButton19 = new JButton("");
		ImageIcon start19 = new ImageIcon(this.getClass().getResource("/color1.png"));
		btnNewButton19.setBounds(353, 500, 95, 85);
		btnNewButton19.setIcon(start19);
		panel_1.add(btnNewButton19);
		
		JButton btnNewButton20 = new JButton("");
		ImageIcon start20 = new ImageIcon(this.getClass().getResource("/color2.png"));
		btnNewButton20.setBounds(450, 500, 91, 85);
		btnNewButton20.setIcon(start20);
		panel_1.add(btnNewButton20);
		
		JButton btnNewButton21 = new JButton("");
		ImageIcon start21 = new ImageIcon(this.getClass().getResource("/color3.png"));
		btnNewButton21.setBounds(547, 500, 87, 85);
		btnNewButton21.setIcon(start21);
		panel_1.add(btnNewButton21);
		
		JButton btnNewButton22 = new JButton("");
		ImageIcon start22 = new ImageIcon(this.getClass().getResource("/color4.png"));
		btnNewButton22.setBounds(644, 500, 93, 89);
		btnNewButton22.setIcon(start22);
		panel_1.add(btnNewButton22);
		
		JButton btnNewButton23 = new JButton("");
		ImageIcon start23 = new ImageIcon(this.getClass().getResource("/color5.png"));
		btnNewButton23.setBounds(741, 500, 89, 91);
		btnNewButton23.setIcon(start23);
		panel_1.add(btnNewButton23);
		
		JButton btnNewButton24 = new JButton("");
		ImageIcon start24 = new ImageIcon(this.getClass().getResource("/color6.png"));
		btnNewButton24.setBounds(838, 500, 89, 89);
		btnNewButton24.setIcon(start24);
		panel_1.add(btnNewButton24);
	
		
		JButton btnNewButton25 = new JButton("Change Color");
		btnNewButton25.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton25.setBounds(200, 230, 150, 25);
		panel_1.add(btnNewButton25);
		
		
		btnNewButton25.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Perform some action when the button is clicked
	            	Player1_color="";
	            	btnNewButton1.setVisible(true);
	            	btnNewButton2.setVisible(true);
	            	btnNewButton3.setVisible(true);
	            	btnNewButton4.setVisible(true);
	            	btnNewButton5.setVisible(true);
	            	btnNewButton6.setVisible(true);


	            }
         });
		
		JButton btnNewButton26 = new JButton("Change Color");
		btnNewButton26.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton26.setBounds(200, 330, 150, 25);
		panel_1.add(btnNewButton26);
		
	
		btnNewButton26.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Perform some action when the button is clicked
	            	Player2_color="";
	            	btnNewButton7.setVisible(true);
	            	btnNewButton8.setVisible(true);
	            	btnNewButton9.setVisible(true);
	            	btnNewButton10.setVisible(true);
	            	btnNewButton11.setVisible(true);
	            	btnNewButton12.setVisible(true);


	            }
         });
		 
		JButton btnNewButton27 = new JButton("Change Color");
		btnNewButton27.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton27.setBounds(200, 430, 150, 25);
		panel_1.add(btnNewButton27);
		
		btnNewButton27.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Perform some action when the button is clicked
	            	Player3_color="";
	            	btnNewButton13.setVisible(true);
	            	btnNewButton14.setVisible(true);
	            	btnNewButton15.setVisible(true);
	            	btnNewButton16.setVisible(true);
	            	btnNewButton17.setVisible(true);
	            	btnNewButton18.setVisible(true);


	            }
         });
		 
		
		JButton btnNewButton28 = new JButton("Change Color");
		btnNewButton28.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton28.setBounds(200, 530, 150, 25);
		panel_1.add(btnNewButton28);
		
		
	
		btnNewButton28.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Perform some action when the button is clicked
	            	Player4_color="";
	            	btnNewButton19.setVisible(true);
	            	btnNewButton20.setVisible(true);
	            	btnNewButton21.setVisible(true);
	            	btnNewButton22.setVisible(true);
	            	btnNewButton23.setVisible(true);
	            	btnNewButton24.setVisible(true);


	            }
         });
		 
		
		if(SelectPlayer_Names_ColoersController.flag==2)
		{
			label_1_1_1.setVisible(false);
			textField_2.setVisible(false);
			label_1_4_4_1_1_1.setVisible(false);
			btnNewButton14.setVisible(false);
        	btnNewButton15.setVisible(false);
        	btnNewButton16.setVisible(false);
        	btnNewButton17.setVisible(false);
        	btnNewButton18.setVisible(false);
        	btnNewButton13.setVisible(false);
        	btnNewButton19.setVisible(false);
        	btnNewButton20.setVisible(false);
        	btnNewButton21.setVisible(false);
        	btnNewButton22.setVisible(false);
        	btnNewButton23.setVisible(false);
        	btnNewButton24.setVisible(false);
        	label_1_1_1_1.setVisible(false);
        	textField_3.setVisible(false);
        	label_1_4_4_1_1_1_1.setVisible(false);
        	btnNewButton27.setVisible(false);
        	btnNewButton28.setVisible(false);

		}
		
		if(SelectPlayer_Names_ColoersController.flag==3)
		{
			btnNewButton19.setVisible(false);
        	btnNewButton20.setVisible(false);
        	btnNewButton21.setVisible(false);
        	btnNewButton22.setVisible(false);
        	btnNewButton23.setVisible(false);
        	btnNewButton24.setVisible(false);
        	label_1_1_1_1.setVisible(false);
        	textField_3.setVisible(false);
        	label_1_4_4_1_1_1_1.setVisible(false);
        	btnNewButton28.setVisible(false);
		}
		
		  // Add action listener to the button
			btnNewButton1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Perform some action when the button is clicked
	            	Player1_color="color1.png";
	            	if(selectLevel.flag_level==3)
	            	{
		            Player1_color="color1hard.jpg";
	            	}
	            	btnNewButton2.setVisible(false);
	            	btnNewButton3.setVisible(false);
	            	btnNewButton4.setVisible(false);
	            	btnNewButton5.setVisible(false);
	            	btnNewButton6.setVisible(false);
	            	btnNewButton7.setVisible(false);
	            	btnNewButton13.setVisible(false);
	            	btnNewButton19.setVisible(false);

	        
	            	

	            }
			});
	            btnNewButton2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Perform some action when the button is clicked
		            	Player1_color="color2.png";
		            	if(selectLevel.flag_level==3)
		            	{
			            Player1_color="color2hard.jpg";
		            	}
		            	btnNewButton1.setVisible(false);
		            	btnNewButton3.setVisible(false);
		            	btnNewButton4.setVisible(false);
		            	btnNewButton5.setVisible(false);
		            	btnNewButton6.setVisible(false);
		            	btnNewButton8.setVisible(false);
		            	btnNewButton14.setVisible(false);
		            	btnNewButton20.setVisible(false);


		            }
	            });
		            btnNewButton3.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // Perform some action when the button is clicked
			            	Player1_color="color3.png";
			            	if(selectLevel.flag_level==3)
			            	{
				            Player1_color="color3hard.jpg";
			            	}
			            	btnNewButton2.setVisible(false);
			            	btnNewButton1.setVisible(false);
			            	btnNewButton4.setVisible(false);
			            	btnNewButton5.setVisible(false);
			            	btnNewButton6.setVisible(false);
			            	btnNewButton9.setVisible(false);
			            	btnNewButton15.setVisible(false);
			            	btnNewButton21.setVisible(false);

			            }
		            });
			            btnNewButton4.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                // Perform some action when the button is clicked
				            	Player1_color="color4.png";
				            	if(selectLevel.flag_level==3)
				            	{
					            Player1_color="color4hard.jpg";
				            	}
				            	btnNewButton2.setVisible(false);
				            	btnNewButton3.setVisible(false);
				            	btnNewButton1.setVisible(false);
				            	btnNewButton5.setVisible(false);
				            	btnNewButton6.setVisible(false);
				            	btnNewButton10.setVisible(false);
				            	btnNewButton16.setVisible(false);
				            	btnNewButton22.setVisible(false);

				            }
			            });
				            btnNewButton5.addActionListener(new ActionListener() {
					            @Override
					            public void actionPerformed(ActionEvent e) {
					                // Perform some action when the button is clicked
					            	Player1_color="color5.png";
					            	if(selectLevel.flag_level==3)
					            	{
						            Player1_color="color5hard.jpg";
					            	}
					            	btnNewButton2.setVisible(false);
					            	btnNewButton3.setVisible(false);
					            	btnNewButton4.setVisible(false);
					            	btnNewButton1.setVisible(false);
					            	btnNewButton6.setVisible(false);
					            	btnNewButton11.setVisible(false);
					            	btnNewButton17.setVisible(false);
					            	btnNewButton23.setVisible(false);

					            }
				            });
					            btnNewButton6.addActionListener(new ActionListener() {
						            @Override
						            public void actionPerformed(ActionEvent e) {
						                // Perform some action when the button is clicked
						            	Player1_color="color6.png";
						            	if(selectLevel.flag_level==3)
						            	{
							            Player1_color="color6hard.jpg";
						            	}
						            	btnNewButton2.setVisible(false);
						            	btnNewButton3.setVisible(false);
						            	btnNewButton4.setVisible(false);
						            	btnNewButton5.setVisible(false);
						            	btnNewButton1.setVisible(false);
						            	btnNewButton12.setVisible(false);
						            	btnNewButton18.setVisible(false);
						            	btnNewButton24.setVisible(false);

						            }
					            });
						            btnNewButton7.addActionListener(new ActionListener() {
							            @Override
							            public void actionPerformed(ActionEvent e) {
							                // Perform some action when the button is clicked
							            	Player2_color="color1.png";
							            	if(selectLevel.flag_level==3)
							            	{
							            		Player2_color="color1hard.jpg";
							            	}
							            	btnNewButton8.setVisible(false);
							            	btnNewButton9.setVisible(false);
							            	btnNewButton10.setVisible(false);
							            	btnNewButton11.setVisible(false);
							            	btnNewButton12.setVisible(false);
							            	btnNewButton13.setVisible(false);
							            	btnNewButton19.setVisible(false);
							            	

							            }
						            });
							            btnNewButton8.addActionListener(new ActionListener() {
								            @Override
								            public void actionPerformed(ActionEvent e) {
								            	  // Perform some action when the button is clicked
								            	Player2_color="color2.png";
								            	if(selectLevel.flag_level==3)
								            	{
								            		Player2_color="color2hard.jpg";
								            	}
								            	btnNewButton7.setVisible(false);
								            	btnNewButton9.setVisible(false);
								            	btnNewButton10.setVisible(false);
								            	btnNewButton11.setVisible(false);
								            	btnNewButton12.setVisible(false);
								            	btnNewButton14.setVisible(false);
								            	btnNewButton20.setVisible(false);

								            }
							            });
								            btnNewButton9.addActionListener(new ActionListener() {
									            @Override
									            public void actionPerformed(ActionEvent e) {
									                // Perform some action when the button is clicked
									            	  // Perform some action when the button is clicked
									            	Player2_color="color3.png";
									            	if(selectLevel.flag_level==3)
									            	{
									            		Player2_color="color3hard.jpg";
									            	}
									            	btnNewButton8.setVisible(false);
									            	btnNewButton7.setVisible(false);
									            	btnNewButton10.setVisible(false);
									            	btnNewButton11.setVisible(false);
									            	btnNewButton12.setVisible(false);
									            	btnNewButton15.setVisible(false);
									            	btnNewButton21.setVisible(false);

									            }
								            });
									            btnNewButton10.addActionListener(new ActionListener() {
										            @Override
										            public void actionPerformed(ActionEvent e) {
										            	  // Perform some action when the button is clicked
										            	Player2_color="color4.png";
										            	if(selectLevel.flag_level==3)
										            	{
										            		Player2_color="color4hard.jpg";
										            	}
										            	btnNewButton8.setVisible(false);
										            	btnNewButton9.setVisible(false);
										            	btnNewButton7.setVisible(false);
										            	btnNewButton11.setVisible(false);
										            	btnNewButton12.setVisible(false);
										            	btnNewButton16.setVisible(false);
										            	btnNewButton22.setVisible(false);

										            }
									            });
										            btnNewButton11.addActionListener(new ActionListener() {
											            @Override
											            public void actionPerformed(ActionEvent e) {
											            	  // Perform some action when the button is clicked
											            	Player2_color="color5.png";
											            	if(selectLevel.flag_level==3)
											            	{
											            		Player2_color="color5hard.jpg";
											            	}
											            	btnNewButton8.setVisible(false);
											            	btnNewButton9.setVisible(false);
											            	btnNewButton10.setVisible(false);
											            	btnNewButton7.setVisible(false);
											            	btnNewButton12.setVisible(false);
											            	btnNewButton17.setVisible(false);
											            	btnNewButton23.setVisible(false);

											            }
										            });
											            btnNewButton12.addActionListener(new ActionListener() {
												            @Override
												            public void actionPerformed(ActionEvent e) {
												            	  // Perform some action when the button is clicked
												            	Player2_color="color6.png";
												            	if(selectLevel.flag_level==3)
												            	{
												            		Player2_color="color6hard.jpg";
												            	}
												            	btnNewButton8.setVisible(false);
												            	btnNewButton9.setVisible(false);
												            	btnNewButton10.setVisible(false);
												            	btnNewButton11.setVisible(false);
												            	btnNewButton7.setVisible(false);
												            	btnNewButton18.setVisible(false);
												            	btnNewButton24.setVisible(false);

												            }
											            });
												            btnNewButton13.addActionListener(new ActionListener() {
													            @Override
													            public void actionPerformed(ActionEvent e) {
													                // Perform some action when the button is clicked
													            	Player3_color="color1.png";
													            	if(selectLevel.flag_level==3)
													            	{
													            		Player3_color="color1hard.jpg";
													            	}
													            	btnNewButton14.setVisible(false);
													            	btnNewButton15.setVisible(false);
													            	btnNewButton16.setVisible(false);
													            	btnNewButton17.setVisible(false);
													            	btnNewButton18.setVisible(false);
													            	btnNewButton19.setVisible(false);


													            }
												            });
													            btnNewButton14.addActionListener(new ActionListener() {
														            @Override
														            public void actionPerformed(ActionEvent e) {
														            	   // Perform some action when the button is clicked
														            	Player3_color="color2.png";
														            	if(selectLevel.flag_level==3)
														            	{
														            		Player3_color="color2hard.jpg";
														            	}
														            	btnNewButton13.setVisible(false);
														            	btnNewButton15.setVisible(false);
														            	btnNewButton16.setVisible(false);
														            	btnNewButton17.setVisible(false);
														            	btnNewButton18.setVisible(false);
														            	btnNewButton20.setVisible(false);


														            }
													            });
														            btnNewButton15.addActionListener(new ActionListener() {
															            @Override
															            public void actionPerformed(ActionEvent e) {
															            	   // Perform some action when the button is clicked
															            	Player3_color="color3.png";
															            	if(selectLevel.flag_level==3)
															            	{
															            		Player3_color="color3hard.jpg";
															            	}
															            	btnNewButton14.setVisible(false);
															            	btnNewButton13.setVisible(false);
															            	btnNewButton16.setVisible(false);
															            	btnNewButton17.setVisible(false);
															            	btnNewButton18.setVisible(false);
															            	btnNewButton21.setVisible(false);


															            }
														            });
															            btnNewButton16.addActionListener(new ActionListener() {
																            @Override
																            public void actionPerformed(ActionEvent e) {
																            	   // Perform some action when the button is clicked
																            	Player3_color="color4.png";
																            	if(selectLevel.flag_level==3)
																            	{
																            		Player3_color="color4hard.jpg";
																            	}
																            	btnNewButton14.setVisible(false);
																            	btnNewButton15.setVisible(false);
																            	btnNewButton13.setVisible(false);
																            	btnNewButton17.setVisible(false);
																            	btnNewButton18.setVisible(false);
																            	btnNewButton22.setVisible(false);


																            }
															            });
																            btnNewButton17.addActionListener(new ActionListener() {
																	            @Override
																	            public void actionPerformed(ActionEvent e) {
																	            	   // Perform some action when the button is clicked
																	            	Player3_color="color5.png";
																	            	if(selectLevel.flag_level==3)
																	            	{
																	            		Player3_color="color5hard.jpg";
																	            	}
																	            	btnNewButton14.setVisible(false);
																	            	btnNewButton15.setVisible(false);
																	            	btnNewButton16.setVisible(false);
																	            	btnNewButton13.setVisible(false);
																	            	btnNewButton18.setVisible(false);
																	            	btnNewButton23.setVisible(false);

																	            }

																	            });
																	           
																	            btnNewButton18.addActionListener(new ActionListener() {
																		            @Override
																		            public void actionPerformed(ActionEvent e) {
																		            	   // Perform some action when the button is clicked
																		            	Player3_color="color6.png";
																		            	if(selectLevel.flag_level==3)
																		            	{
																		            		Player3_color="color6hard.jpg";
																		            	}
																		            	btnNewButton14.setVisible(false);
																		            	btnNewButton15.setVisible(false);
																		            	btnNewButton16.setVisible(false);
																		            	btnNewButton17.setVisible(false);
																		            	btnNewButton13.setVisible(false);
																		            	btnNewButton24.setVisible(false);


																		            }
																	            });
																		            btnNewButton19.addActionListener(new ActionListener() {
																			            @Override
																			            public void actionPerformed(ActionEvent e) {
																			                // Perform some action when the button is clicked
																			            	Player4_color="color1.png";
																			            	if(selectLevel.flag_level==3)
																			            	{
																			            		Player4_color="color1hard.jpg";
																			            	}
																			            	btnNewButton20.setVisible(false);
																			            	btnNewButton21.setVisible(false);
																			            	btnNewButton22.setVisible(false);
																			            	btnNewButton23.setVisible(false);
																			            	btnNewButton24.setVisible(false);

																			            }
																		            });
																			            btnNewButton20.addActionListener(new ActionListener() {
																				            @Override
																				            public void actionPerformed(ActionEvent e) {
																				            	  // Perform some action when the button is clicked
																				            	Player4_color="color2.png";
																				            	if(selectLevel.flag_level==3)
																				            	{
																				            		Player4_color="color2hard.jpg";
																				            	}
																				            	btnNewButton19.setVisible(false);
																				            	btnNewButton21.setVisible(false);
																				            	btnNewButton22.setVisible(false);
																				            	btnNewButton23.setVisible(false);
																				            	btnNewButton24.setVisible(false);

																				            }
																			            });
																				            btnNewButton21.addActionListener(new ActionListener() {
																					            @Override
																					            public void actionPerformed(ActionEvent e) {
																					            	  // Perform some action when the button is clicked
																					            	Player4_color="color3.png";
																					            	if(selectLevel.flag_level==3)
																					            	{
																					            		Player4_color="color3hard.jpg";
																					            	}
																					            	btnNewButton20.setVisible(false);
																					            	btnNewButton19.setVisible(false);
																					            	btnNewButton22.setVisible(false);
																					            	btnNewButton23.setVisible(false);
																					            	btnNewButton24.setVisible(false);

																					            }
																				            });
																					            btnNewButton22.addActionListener(new ActionListener() {
																						            @Override
																						            public void actionPerformed(ActionEvent e) {
																						            	  // Perform some action when the button is clicked
																						            	Player4_color="color4.png";
																						            	if(selectLevel.flag_level==3)
																						            	{
																						            		Player4_color="color4hard.jpg";
																						            	}
																						            	btnNewButton20.setVisible(false);
																						            	btnNewButton21.setVisible(false);
																						            	btnNewButton19.setVisible(false);
																						            	btnNewButton23.setVisible(false);
																						            	btnNewButton24.setVisible(false);

																						            }
																					            });
																						            btnNewButton23.addActionListener(new ActionListener() {
																							            @Override
																							            public void actionPerformed(ActionEvent e) {
																							            	  // Perform some action when the button is clicked
																							            	Player4_color="color5.png";
																							            	if(selectLevel.flag_level==3)
																							            	{
																							            		Player4_color="color5hard.jpg";
																							            	}
																							            	btnNewButton20.setVisible(false);
																							            	btnNewButton21.setVisible(false);
																							            	btnNewButton22.setVisible(false);
																							            	btnNewButton19.setVisible(false);
																							            	btnNewButton24.setVisible(false);

																							            }
																						            });
																							            btnNewButton24.addActionListener(new ActionListener() {
																								            @Override
																								            public void actionPerformed(ActionEvent e) {
																								            	  // Perform some action when the button is clicked
																								            	Player4_color="color6.png";
																								            	if(selectLevel.flag_level==3)
																								            	{
																								            		Player4_color="color6hard.jpg";
																								            	}
																								            	btnNewButton20.setVisible(false);
																								            	btnNewButton21.setVisible(false);
																								            	btnNewButton22.setVisible(false);
																								            	btnNewButton23.setVisible(false);
																								            	btnNewButton19.setVisible(false);

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