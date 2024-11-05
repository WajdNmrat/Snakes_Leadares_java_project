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

import Controller.LevelController;
import Controller.MusicController;
import Controller.ScreenController;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
public class selectLevel {

	private JFrame frame;
    public static int flag_level=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectLevel frame = new selectLevel();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public selectLevel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			frame = new JFrame();
			
			frame.setBounds(100, 100, 688, 470);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1920, 1080);
		panel.setBackground(new Color(254, 251, 144));
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
		
		
		JButton exit = new JButton("");
		ImageIcon c = new ImageIcon(this.getClass().getResource("/no.png"));
		exit.setIcon(c);
		exit.setBackground(Color.red);
		exit.setBounds(1250, 11, 44, 39);
		panel.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home myHome = new home();
				myHome.show();
				frame.setVisible(false);
			}
		});
		
		
		JButton Button2 = new JButton("");
		ImageIcon b = new ImageIcon(this.getClass().getResource("/back.png"));
		Button2.setIcon(b);
		Button2.setBackground(Color.orange);
		Button2.setBounds(10, 11, 44, 39);
		panel.add(Button2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 60, 1800, 1000);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel selectlevel = new JLabel("");
		ImageIcon level = new ImageIcon(this.getClass().getResource("/selectlevel.png"));
		selectlevel.setIcon(level);
		selectlevel.setBounds(500, 0, 400, 100);
		panel_1.add(selectlevel);
		
		
		JButton easyLevel = new JButton("");
		easyLevel.setBounds(120, 200, 200, 250);
		ImageIcon easyLevel12 = new ImageIcon(this.getClass().getResource("/easy.png"));
		Image imgesy = easyLevel12.getImage().getScaledInstance(easyLevel.getWidth(), easyLevel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledeasy = new ImageIcon(imgesy);	
		easyLevel.setIcon(scaledeasy);
		easyLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag_level=1;
				LevelController.setGameLevel("easy");
				Select_Player Select_Player = new Select_Player();
				Select_Player.show();
				frame.setVisible(false);
		       
			}
			
		});
		
		panel_1.add(easyLevel);
		
		JButton mediumLevel = new JButton("");
		mediumLevel.setBounds(580, 200, 200, 250);
		ImageIcon easyLevel123 = new ImageIcon(this.getClass().getResource("/medium.png"));
		Image imgmid = easyLevel123.getImage().getScaledInstance(mediumLevel.getWidth(), mediumLevel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledeamid = new ImageIcon(imgmid);	
        mediumLevel.setIcon(scaledeamid);
		mediumLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag_level=2;

				LevelController.setGameLevel("medium");
				Select_Player Select_Player = new Select_Player();
				Select_Player.show();
				frame.setVisible(false);
				
			}
			
			
		});
		
		panel_1.add(mediumLevel);
		
		
		
		JButton hardLevel = new JButton("");
		hardLevel.setBounds(1050, 200, 200, 250);
		ImageIcon easyLevel1234 = new ImageIcon(this.getClass().getResource("/hard.png"));
		Image imgmhard = easyLevel1234.getImage().getScaledInstance(hardLevel.getWidth(), hardLevel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledeamhard = new ImageIcon(imgmhard);	
        hardLevel.setIcon(scaledeamhard);
		hardLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag_level=3;
				LevelController.setGameLevel("hard");
				Select_Player Select_Player = new Select_Player();
				Select_Player.show();
				frame.setVisible(false);
		      
			}
			
		});
		
     
		panel_1.add(hardLevel);
	 
		
		 JLabel lblNewLabel1 = new JLabel();
		 lblNewLabel1.setBounds(0, 0, 1920, 1080);

         // Load the image from the resource
         URL imageUrl = this.getClass().getResource("/main-image.jpg");
         if (imageUrl != null) {
             ImageIcon originalIcon = new ImageIcon(imageUrl);
             
             // Scale the image to fit the JLabel
             Image img12 = originalIcon.getImage().getScaledInstance(lblNewLabel1.getWidth(), lblNewLabel1.getHeight(), Image.SCALE_SMOOTH);
             ImageIcon scaledIcon12 = new ImageIcon(img12);
             
             lblNewLabel1.setIcon(scaledIcon12);
         } else {
             System.err.println("Could not load image resource");
         }
         panel.add(lblNewLabel1);
         JLabel sky = new JLabel();
		 sky.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());

	     // Load the image from the resource
	     URL imageUrl12 = this.getClass().getResource("/main-image.jpg");
	     if (imageUrl12 != null) {
	         ImageIcon originalIcon = new ImageIcon(imageUrl12);
	         
	         // Scale the image to fit the JLabel
	         Image img = originalIcon.getImage().getScaledInstance(sky.getWidth(), sky.getHeight(), Image.SCALE_SMOOTH);
	         ImageIcon scaledIcon = new ImageIcon(img);
	         
	         sky.setIcon(scaledIcon);
	     } else {
	         System.err.println("Could not load image resource");
	     }
	     panel_1.add(sky);
	     
	 	
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

}
