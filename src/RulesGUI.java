package Stones;

import javax.swing.*;
import java.awt.event.*;

/**
 * create the board for the Stones Game that displays the rules
 */
public class RulesGUI implements ActionListener {
	final static String LABEL_TEXT = "Welcome to the Stones Game!";
	final static String RULE_TEXT = "Here are the rules: ";
	final static String RULE1_TEXT = "Two players would sit on opposite sides with a bin to the right designated to be the player's home bin.";
	final static String RULE2_TEXT = "In addition to the home bin, each player would have 6 pits that are filled with stones.";
	final static String RULE3_TEXT = "For each turn, the player can choose one of the pits and remove all the stones in that pit." 
									+ "by placing a stone counterclockwise around the board in each pit including the player's home bin, but the opponent's home bin is excluded.";
	final static String SPECIAL_RULE_TEXT = "Special rules: ";
	final static String SPECIAL_RULE1_TEXT = "1. If the last stone lands in the player's home bin, the player gets another turn.";
	final static String SPECIAL_RULE2_TEXT = "2. If the last stone lands in an empty pit on the player's side of the board, " 
									+ "the player takes all stones in the correspconding pit on the opponent's side and places them in player's home bin.";
	final static String RULE4_TEXT = "When a player cannot play because there are no stones in any of the player's pit, the game is over. "; 
	final static String RULE5_TEXT = "All stones in the opponent's pit goes to the player's home bin.";
	final static String RULE6_TEXT = "The winner is the player with the most stones in the player's home bin at the end of the game.";
	JFrame frame;
	JPanel contentPane;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
	JButton button;
	
	/**
	 * Constructor: creates the rules board for the Stones Game
	 * Pre: None
	 * Post: a board that explains the rules of the Stones Game is created
	 */
	public RulesGUI(int num) {
		frame = new JFrame("Stones Game Rules");
		
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		label1 = new JLabel(LABEL_TEXT);
		label1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		label1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		contentPane.add(label1);
		
		label2 = new JLabel(RULE_TEXT);
		contentPane.add(label2);
		
		label3 = new JLabel(RULE1_TEXT);
		contentPane.add(label3);
		
		label4 = new JLabel(RULE2_TEXT);
		contentPane.add(label4);
		
		label5 = new JLabel(RULE3_TEXT);
		contentPane.add(label5);
		
		label6 = new JLabel(SPECIAL_RULE_TEXT);
		label6.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		label6.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.add(label6);
		
		label7 = new JLabel(SPECIAL_RULE1_TEXT);
		contentPane.add(label7);
		
		label8 = new JLabel(SPECIAL_RULE2_TEXT);
		contentPane.add(label8);
		
		label9 = new JLabel(RULE4_TEXT);
		label9.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		label9.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.add(label9);
		
		label10 = new JLabel(RULE5_TEXT);
		contentPane.add(label10);
		
		label11 = new JLabel(RULE6_TEXT);
		label11.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		label11.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		contentPane.add(label11);
		
		if(num == 0) {
			button = new JButton("Next");
			button.setActionCommand("Next");
			button.addActionListener(this);
			contentPane.add(button);
		}
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Handle button-clicking events
	 * Pre: Action event is Next
	 * Post: the game moves on to the next page and closes the rules page if the action event "Next" is clicked
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Next")) {
			frame.setVisible(false);
			SettingsGUI.runGUI();
		}
		
	}
	
	/**
	 * Create and show the GUI
	 * 
	 */
	public static void runGUI(int num) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		RulesGUI rules = new RulesGUI(num);
	}

}
