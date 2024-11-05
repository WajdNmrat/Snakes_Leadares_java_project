package View;


import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import Controller.LoginController;
import Controller.MusicController;
import Controller.ScreenController;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Login {
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0,  ScreenController.getScreenWidth(), ScreenController.getScreenHeight());
		panel.setBackground(Color.WHITE);
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
		
		JButton return_btn = new JButton("");
		return_btn.setBackground(new Color(155, 202, 60));
		 ImageIcon b = new ImageIcon(this.getClass().getResource("/back.png"));
		 return_btn.setIcon(b);
		return_btn.setBounds(25, 11, 44, 39);
		return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 home home = new home();
    			home.show();
               frame.setVisible(false);
			}
		});
		panel.add(return_btn);
		
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if(LoginController.checkAdminDetails(txtUsername.getText().toString(),passwordField.getText().toString())) {
					 if(e.getSource()==btnNewButton)
						{
							JAdmin a = new JAdmin();
							a.setVisible(true);
							frame.setVisible(false);
						}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "incrorrect username or password");
				}
			}
		});
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnNewButton.setBounds((ScreenController.getScreenWidth()-90)/2, 500, 89, 50);
		panel.add(btnNewButton);
		
		txtUsername = new JTextField();
		txtUsername.setBounds((ScreenController.getScreenWidth()-195)/2, 316, 195, 30);
		panel.add(txtUsername);
		txtUsername.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds((ScreenController.getScreenWidth()-195)/2, 368, 195, 30);
		passwordField.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		passwordField.setToolTipText("");
		panel.add(passwordField);
		
		JLabel login = new JLabel("Login");
		login.setBounds((ScreenController.getScreenWidth()-180)/2, 164, 180, 200);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Papyrus", Font.BOLD, 60));
		panel.add(login);
		

		
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
