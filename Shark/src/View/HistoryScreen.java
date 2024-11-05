package View;

import java.awt.Color;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.MusicController;
import Controller.ScreenController;
import Model.Game;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class HistoryScreen {

    private JFrame frame;
    private JTable table_1;

    public HistoryScreen() {
        initialize();
    }

    private void initialize() {
    	
        frame = new JFrame();
        frame.setBounds(100, 100, 675, 450);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, ScreenController.getScreenWidth(), ScreenController.getScreenHeight());
        panel.setBackground(new Color(254, 251, 144));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        
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

        // Title label
        JLabel titleLabel = new JLabel("Game History");
        titleLabel.setForeground(new Color(75, 0, 130));
        titleLabel.setFont(new Font("Cooper Black", titleLabel.getFont().getStyle(), 20));
        titleLabel.setBounds(233, 11, 200, 30);
        panel.add(titleLabel);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(52, 50, 545, 301);
        panel.add(scrollPane_1);

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "GameID", "Level", "Winner", "Duration", "Date" }
        ));

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the back button action
            	  home home;
            			home = new home();
            			home.show();
                        frame.setVisible(false);

            		
            }
        });
        btnNewButton.setBounds(52, 362, 89, 23);
        panel.add(btnNewButton);
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
        // Display pop-up message while reading the CSV file
        JOptionPane.showMessageDialog(frame, "Reading CSV File history. Please wait...", "Reading History",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to update the JTable with game history data
    public void displayGameHistory(List<Game> gameHistory) {
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Game entry : gameHistory) {
            Object[] rowData = { entry.getGameID(), entry.getLevel(), entry.getWinner(), entry.getDuration(),
                    entry.getGamedate() };
            model.addRow(rowData);
        }
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
