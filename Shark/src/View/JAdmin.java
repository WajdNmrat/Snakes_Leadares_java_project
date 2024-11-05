package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.GameHistoryController;
import Model.SysData;


public class JAdmin extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JButton logout;
    private JMenuItem AddQ;
    private JMenuItem RemoveQ;
    private JMenuItem EditQ;
    private JMenuItem AllBestsGamers;
    private JMenuItem questions;
    private JMenuItem games;
	private JLabel lblNewLabel_0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAdmin frame = new JAdmin();
					frame.setBounds(100, 100, 1920, 1080);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/*public JAdmin() {
		
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 251, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 204, 204));
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		
		JMenu AddMenu = new JMenu("Questions Menu");
		menuBar.add(AddMenu);
		
		AddQ = new JMenuItem("Add Question");
		AddMenu.add(AddQ);
		AddQ.addActionListener(this);
		
		
		lblNewLabel = new JLabel("Hello Admin ^_^");
		lblNewLabel.setFont(new Font("David", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 26, 237, 46);
		contentPane.add(lblNewLabel);
		
		logout = new JButton("LogOut");
		logout.setFont(new Font("Tahoma", Font.BOLD, 13));
		logout.setBounds(511, 271, 89, 23);
		contentPane.add(logout);
		
		
		lblNewLabel_0 = new JLabel("");
		lblNewLabel_0.setIcon(new ImageIcon(getClass().getResource("/grass.png")));
		lblNewLabel_0.setBounds(10, 327, 105, 100);
		contentPane.add(lblNewLabel_0);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/wer.png")));
		lblNewLabel_1.setBounds(502, 297, 112, 130);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(20, 62, 472, 227);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/snake.jpg")));
		contentPane.add(lblNewLabel_2);
		logout.addActionListener(this);
		
	}*/


    public JAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to maximize
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/hiadmin.gif"));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 204, 204));
        contentPane.add(menuBar, BorderLayout.NORTH);

        JMenu AddMenu = new JMenu("Questions Menu");
        menuBar.add(AddMenu);

        AddQ = new JMenuItem("Add Question");
        AddMenu.add(AddQ);
        AddQ.addActionListener(this);

        RemoveQ = new JMenuItem("Remove Question");
        AddMenu.add(RemoveQ);
        RemoveQ.addActionListener(this);

        EditQ = new JMenuItem("Edit Question");
        AddMenu.add(EditQ);
        EditQ.addActionListener(this);


        JMenu QueryMenu = new JMenu("Query Menu");
        menuBar.add(QueryMenu);

        AllBestsGamers = new JMenuItem("AllBestsGamers");
        QueryMenu.add(AllBestsGamers);
        AllBestsGamers.addActionListener(this);

        JMenu mnNewMenu_3 = new JMenu("History Menu");
        menuBar.add(mnNewMenu_3);

        questions = new JMenuItem("Show Questions");
        mnNewMenu_3.add(questions);
        questions.addActionListener(this);

        games = new JMenuItem("Show Games");
        mnNewMenu_3.add(games);
        games.addActionListener(this);

        lblNewLabel = new JLabel("Hello Admin ^_^");
        lblNewLabel.setFont(new Font("David", Font.BOLD, 25));
        contentPane.add(lblNewLabel, BorderLayout.CENTER);

        logout = new JButton("LogOut");
        logout.setFont(new Font("Tahoma", Font.BOLD, 13));
        logout.setIcon(new ImageIcon(getClass().getResource("/logout.png")));
        contentPane.add(logout, BorderLayout.SOUTH);
        logout.addActionListener(this);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            dispose();
            home home = new home();
	        home.show();
        }
        else if(e.getSource()==AddQ || e.getSource()==RemoveQ || e.getSource()==EditQ || e.getSource()==questions)
		{
			JQuestion q = new JQuestion();
			q.setVisible(true);
		}
	    else if(e.getSource()==games)
		{
	    	SysData sysData = new SysData();
	        HistoryScreen historyScreen = new HistoryScreen();
	        GameHistoryController gameHistoryController = new GameHistoryController(sysData, historyScreen);
	        gameHistoryController.SendGameHistory();
	        historyScreen.show();
			//frame.setVisible(false); 
		}
        
    }
}
