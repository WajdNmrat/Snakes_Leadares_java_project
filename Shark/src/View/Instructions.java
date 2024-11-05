package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.MusicController;
import Controller.ScreenController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Instructions {

    private JFrame frame;

    public Instructions() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 875, 608);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, ScreenController.getScreenWidth(), ScreenController.getScreenHeight());
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

        JLabel boardgame = new JLabel("");
        ImageIcon board = new ImageIcon(this.getClass().getResource("/boardgame.png"));
        boardgame.setIcon(board);
        boardgame.setBounds(319, 91, 161, 168);
        boardgame.setToolTipText("Click for board game explanation");
        boardgame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightBoard = adjustBrightness(board, 1.2f);
                boardgame.setIcon(brightBoard);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boardgame.setIcon(board);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                // Show explanation when board game image is clicked
                JOptionPane.showMessageDialog(frame, "This is the Board\n there is 3 Borads\n Easy Level: 7x7\nMeduim Level: 10x10, Hard Level: 13x13.", "Game Board", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(boardgame);

        JLabel diceLabel = new JLabel("");
        ImageIcon dice = new ImageIcon(this.getClass().getResource("/dice.png"));
        diceLabel.setIcon(dice);
        diceLabel.setBounds(54, 286, 67, 69);
        diceLabel.setToolTipText("Click for dice explanation");
        diceLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightDice = adjustBrightness(dice, 1.2f);
                diceLabel.setIcon(brightDice);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                diceLabel.setIcon(dice);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                // Show explanation when dice image is clicked
                JOptionPane.showMessageDialog(frame, "The Dice has 10 posibilties\n 0 to 6 is the number of the move.\n 7 , 8 , 9 will roll you a random question, 7 for easy question,8 for meduim question, 9 for hard question.\n correct answer will make you avoid bein punshed, unless its hard question you will have a step forward .", "Dice", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(diceLabel);
        
        
        JLabel pawnsLabel = new JLabel("");
        ImageIcon pawns = new ImageIcon(this.getClass().getResource("/pawns.png"));
        int newWidth = 100; // Set the new width in pixels
        int newHeight = 100; // Set the new height in pixels
        Image scaledPawnsImage = pawns.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledPawnsIcon = new ImageIcon(scaledPawnsImage);
        pawnsLabel.setIcon(scaledPawnsIcon);
        pawnsLabel.setBounds(169, 273, newWidth, newHeight);
        pawnsLabel.setToolTipText("Click for pawns explanation");
        pawnsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightPawns = adjustBrightness(pawns, 1.2f);
                pawnsLabel.setIcon(new ImageIcon(brightPawns.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pawnsLabel.setIcon(scaledPawnsIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                // Show explanation when pawns image is clicked
                JOptionPane.showMessageDialog(frame, "This is the pawn representing each player with a unique color.", "Pawns", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(pawnsLabel);
        
     // For wincellpic
        JLabel wincellLabel = new JLabel("");
        ImageIcon wincellIcon = new ImageIcon(this.getClass().getResource("/wincellpic.png"));
        int wincellWidth = 100; // Set the width in pixels
        int wincellHeight = 100; // Set the height in pixels
        Image scaledWincellImage = wincellIcon.getImage().getScaledInstance(wincellWidth, wincellHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledWincellIcon = new ImageIcon(scaledWincellImage);
        wincellLabel.setIcon(scaledWincellIcon);
        wincellLabel.setBounds(346, 270, 111, 100);
        wincellLabel.setToolTipText("Click for wincell explanation");
        wincellLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightWincell = adjustBrightness(wincellIcon, 1.2f);
                wincellLabel.setIcon(new ImageIcon(brightWincell.getImage().getScaledInstance(wincellWidth, wincellHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                wincellLabel.setIcon(scaledWincellIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "The Trophy, the player who reach it will win the game.", "Wincell", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(wincellLabel);

        // For SupriseCellpic
        JLabel surpriseCellLabel = new JLabel("");
        ImageIcon surpriseCellIcon = new ImageIcon(this.getClass().getResource("/SupriseCellpic.png"));
        int surpriseCellWidth = 100; // Set the width in pixels
        int surpriseCellHeight = 100; // Set the height in pixels
        Image scaledSurpriseCellImage = surpriseCellIcon.getImage().getScaledInstance(surpriseCellWidth, surpriseCellHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledSurpriseCellIcon = new ImageIcon(scaledSurpriseCellImage);
        surpriseCellLabel.setIcon(scaledSurpriseCellIcon);
        surpriseCellLabel.setBounds(483, 270, surpriseCellWidth, surpriseCellHeight);
        surpriseCellLabel.setToolTipText("Click for surprise cell explanation");
        surpriseCellLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightSurpriseCell = adjustBrightness(surpriseCellIcon, 1.2f);
                surpriseCellLabel.setIcon(new ImageIcon(brightSurpriseCell.getImage().getScaledInstance(surpriseCellWidth, surpriseCellHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                surpriseCellLabel.setIcon(scaledSurpriseCellIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the surprise cell, will gurnate the player who stops on it 10 steps forward. ", "surprise cell",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(surpriseCellLabel);

        // For Questioncellpic
        JLabel questionCellLabel = new JLabel("");
        ImageIcon questionCellIcon = new ImageIcon(this.getClass().getResource("/Questioncellpic.png"));
        int questionCellWidth = 100; // Set the width in pixels
        int questionCellHeight = 100; // Set the height in pixels
        Image scaledQuestionCellImage = questionCellIcon.getImage().getScaledInstance(questionCellWidth, questionCellHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledQuestionCellIcon = new ImageIcon(scaledQuestionCellImage);
        questionCellLabel.setIcon(scaledQuestionCellIcon);
        questionCellLabel.setBounds(604, 286, questionCellWidth, questionCellHeight);
        questionCellLabel.setToolTipText("Click for question cell explanation");
        questionCellLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightQuestionCell = adjustBrightness(questionCellIcon, 1.2f);
                questionCellLabel.setIcon(new ImageIcon(brightQuestionCell.getImage().getScaledInstance(questionCellWidth, questionCellHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                questionCellLabel.setIcon(scaledQuestionCellIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the question cell, each player step on it\\n will get a Random Question", "Question Cell", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(questionCellLabel);
        
     // For bluesnakepic
        JLabel blueSnakeLabel = new JLabel("");
        ImageIcon blueSnakeIcon = new ImageIcon(this.getClass().getResource("/bluesnakepic.png"));
        int blueSnakeWidth = 100; // Set the width in pixels
        int blueSnakeHeight = 100; // Set the height in pixels
        Image scaledBlueSnakeImage = blueSnakeIcon.getImage().getScaledInstance(blueSnakeWidth, blueSnakeHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledBlueSnakeIcon = new ImageIcon(scaledBlueSnakeImage);
        blueSnakeLabel.setIcon(scaledBlueSnakeIcon);
        blueSnakeLabel.setBounds(261, 400, blueSnakeWidth, blueSnakeHeight);
        blueSnakeLabel.setToolTipText("Click for blue snake explanation");
        blueSnakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightBlueSnake = adjustBrightness(blueSnakeIcon, 1.2f);
                blueSnakeLabel.setIcon(new ImageIcon(brightBlueSnake.getImage().getScaledInstance(blueSnakeWidth, blueSnakeHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                blueSnakeLabel.setIcon(scaledBlueSnakeIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the blue snake, This snake drops you 3 lines to the bottom.", "Blue Snake", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(blueSnakeLabel);

        // For yellowsnakepic
        JLabel yellowSnakeLabel = new JLabel("");
        ImageIcon yellowSnakeIcon = new ImageIcon(this.getClass().getResource("/yellowsnakepic.png"));
        int yellowSnakeWidth = 100; // Set the width in pixels
        int yellowSnakeHeight = 100; // Set the height in pixels
        Image scaledYellowSnakeImage = yellowSnakeIcon.getImage().getScaledInstance(yellowSnakeWidth, yellowSnakeHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledYellowSnakeIcon = new ImageIcon(scaledYellowSnakeImage);
        yellowSnakeLabel.setIcon(scaledYellowSnakeIcon);
        yellowSnakeLabel.setBounds(124, 400, yellowSnakeWidth, yellowSnakeHeight);
        yellowSnakeLabel.setToolTipText("Click for yellow snake explanation");
        yellowSnakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightYellowSnake = adjustBrightness(yellowSnakeIcon, 1.2f);
                yellowSnakeLabel.setIcon(new ImageIcon(brightYellowSnake.getImage().getScaledInstance(yellowSnakeWidth, yellowSnakeHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                yellowSnakeLabel.setIcon(scaledYellowSnakeIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the yellow snake will drop you 1 line to the bottom 	", "Yellow Snake", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(yellowSnakeLabel);

        // For redsnakepic
        JLabel redSnakeLabel = new JLabel("");
        ImageIcon redSnakeIcon = new ImageIcon(this.getClass().getResource("/redsnakepic.png"));
        int redSnakeWidth = 100; // Set the width in pixels
        int redSnakeHeight = 100; // Set the height in pixels
        Image scaledRedSnakeImage = redSnakeIcon.getImage().getScaledInstance(redSnakeWidth, redSnakeHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledRedSnakeIcon = new ImageIcon(scaledRedSnakeImage);
        redSnakeLabel.setIcon(scaledRedSnakeIcon);
        redSnakeLabel.setBounds(533, 400, redSnakeWidth, redSnakeHeight);
        redSnakeLabel.setToolTipText("Click for red snake explanation");
        redSnakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightRedSnake = adjustBrightness(redSnakeIcon, 1.2f);
                redSnakeLabel.setIcon(new ImageIcon(brightRedSnake.getImage().getScaledInstance(redSnakeWidth, redSnakeHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                redSnakeLabel.setIcon(scaledRedSnakeIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the red snake, the player drop back to cell number 1 .", "Red Snake", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(redSnakeLabel);

        // For greensnakepic
        JLabel greenSnakeLabel = new JLabel("");
        ImageIcon greenSnakeIcon = new ImageIcon(this.getClass().getResource("/greensnakepic.png"));
        int greenSnakeWidth = 100; // Set the width in pixels
        int greenSnakeHeight = 100; // Set the height in pixels
        Image scaledGreenSnakeImage = greenSnakeIcon.getImage().getScaledInstance(greenSnakeWidth, greenSnakeHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledGreenSnakeIcon = new ImageIcon(scaledGreenSnakeImage);
        greenSnakeLabel.setIcon(scaledGreenSnakeIcon);
        greenSnakeLabel.setBounds(400, 400, greenSnakeWidth, greenSnakeHeight);
        greenSnakeLabel.setToolTipText("Click for green snake explanation");
        greenSnakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightGreenSnake = adjustBrightness(greenSnakeIcon, 1.2f);
                greenSnakeLabel.setIcon(new ImageIcon(brightGreenSnake.getImage().getScaledInstance(greenSnakeWidth, greenSnakeHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                greenSnakeLabel.setIcon(scaledGreenSnakeIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the green snake drop you 2 lines to the bottom", "Green Snake", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(greenSnakeLabel);
        
     // For ladderpic
        JLabel ladderLabel = new JLabel("");
        ImageIcon ladderIcon = new ImageIcon(this.getClass().getResource("/ladderpic.png"));
        int ladderWidth = 100; // Set the width in pixels
        int ladderHeight = 100; // Set the height in pixels
        Image scaledLadderImage = ladderIcon.getImage().getScaledInstance(ladderWidth, ladderHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledLadderIcon = new ImageIcon(scaledLadderImage);
        ladderLabel.setIcon(scaledLadderIcon);
        ladderLabel.setBounds(648, 384, 111, 113);
        ladderLabel.setToolTipText("Click for ladder explanation");
        ladderLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon brightLadder = adjustBrightness(ladderIcon, 1.2f);
                ladderLabel.setIcon(new ImageIcon(brightLadder.getImage().getScaledInstance(ladderWidth, ladderHeight, Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ladderLabel.setIcon(scaledLadderIcon);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(frame, "This is the ladder this ladder give you advantage to climb it up.", "Ladder", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(ladderLabel);





        JLabel title = new JLabel("Snakes And Ladders");
        title.setForeground(new Color(149, 5, 5));
        title.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        title.setBounds(309, 72, 191, 25);
        panel.add(title);

        JLabel lblInstructions = new JLabel("Instructions");
        lblInstructions.setForeground(new Color(149, 5, 5));
        lblInstructions.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        lblInstructions.setBounds(346, 24, 191, 25);
        panel.add(lblInstructions);
        
        JButton return_btn = new JButton("");
		return_btn.setBackground(Color.WHITE);
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

    // pic glow
    private ImageIcon adjustBrightness(ImageIcon icon, float brightness) {
        BufferedImage img = new BufferedImage(
            icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        img.getGraphics().drawImage(icon.getImage(), 0, 0 , null);
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color c = new Color(img.getRGB(j, i), true);
                c = new Color(
                    Math.min((int)(c.getRed() * brightness), 255),
                    Math.min((int)(c.getGreen() * brightness * 1.2), 255),
                    Math.min((int)(c.getBlue() * brightness * 0.8), 255),
                    c.getAlpha());
                img.setRGB(j, i, c.getRGB());
            }
        }
        return new ImageIcon(img);
    }
   
}
