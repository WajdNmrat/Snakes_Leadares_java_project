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
import Controller.MusicController;
import Controller.ScreenController;
import Model.Music;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;


public class StartScreen{

	private JFrame frame;
			
	public StartScreen(){
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 450);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		ScreenController.setScreenSize(frame.getWidth(),frame.getHeight());
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0,  ScreenController.getScreenWidth(), ScreenController.getScreenHeight());
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		
		Music backgroundMusic = new Music(1, "resources/mixkit_fun.wav", "");
		MusicController.startMusic(backgroundMusic.getFileName()); 
		
		JButton soundButton = new JButton("");
		ImageIcon v = new ImageIcon(this.getClass().getResource("/voice.png"));
		soundButton.setIcon(v);
		soundButton.setBackground(new Color(220, 177, 223));
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
		
		
		
		JButton startButton = new JButton("");
		ImageIcon start = new ImageIcon(this.getClass().getResource("/enter.png"));
		startButton.setIcon(start);
		startButton.setBackground(new Color(209, 227, 101));
		startButton.setBounds((ScreenController.getScreenWidth()-63)/2, (ScreenController.getScreenHeight()-260)/2, 63, 59);
		panel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				home home = new home();
		        home.show();
		        frame.setVisible(false);
			}
		});
		
		
		
		JLabel background = new JLabel("");
		ImageIcon back = new ImageIcon(this.getClass().getResource("/background.jpg"));
		background.setIcon(back);
		background.setBounds((ScreenController.getScreenWidth()-400)/2, (ScreenController.getScreenHeight()-200)/2, 400, 192);
		panel.add(background);
		
		
		JLabel jumpysnake = new JLabel("");
		ImageIcon sn = new ImageIcon(this.getClass().getResource("/jumpysnake.gif"));
		jumpysnake.setIcon(sn);
		jumpysnake.setBounds(-24, ScreenController.getScreenHeight()-250, 190, 186);
		panel.add(jumpysnake);
		
		JLabel snake = new JLabel("");
		ImageIcon s = new ImageIcon(this.getClass().getResource("/snake.gif"));
		snake.setIcon(s);
		snake.setBounds(ScreenController.getScreenWidth()-230, ScreenController.getScreenHeight()-220, 222, 197);
		panel.add(snake);
		
		JLabel title = new JLabel("Snakes And Ladders");
		title.setForeground(new Color(189, 198, 68));
		title.setFont(new Font("Papyrus", Font.BOLD, 36));
		title.setBounds((ScreenController.getScreenWidth()-380)/2, 150, 380, 40);
		panel.add(title);
		
		
		 JLabel sky = new JLabel();
		 sky.setBounds(0, 0, ScreenController.getScreenWidth(), ScreenController.getScreenHeight());

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
