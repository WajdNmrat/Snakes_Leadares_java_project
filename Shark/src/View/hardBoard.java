package View;

import javax.swing.*;
import java.awt.*;

public class hardBoard extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public hardBoard() {
        setTitle("10x10 Board Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with GridLayout
        JPanel boardPanel = new JPanel(new GridLayout(13, 13));
        boardPanel.setBackground(new Color(0, 255, 204));

        // Add labels with numbers to simulate cells in the grid
        for (int row = 12; row >= 0; row--) { // Start from the bottom and go up
            for (int col = 0; col < 13; col++) {
                int currentNumber = (row * 13) + (col + 1); // Calculate the correct number
                JLabel cellLabel = new JLabel(Integer.toString(currentNumber));
                cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cellLabel.setHorizontalAlignment(JLabel.CENTER);
                cellLabel.setVerticalAlignment(JLabel.CENTER);
                boardPanel.add(cellLabel);
            }
        }

        // Add the board panel to the frame
        getContentPane().add(boardPanel);

        JLabel lblNewLabel = new JLabel("You are now in Hard level!!");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
        lblNewLabel.setBackground(new Color(204, 255, 204));
        getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        // Set frame properties
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new hardBoard());
    }
}


