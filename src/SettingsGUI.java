/*
 * SettingsGUI.java
 * Programmer Name: Jason Chen
 * Course: ICS3U
 * Date: 01/06/2019
 */

package Stones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This will create the settings board of the Stones game
 */
public class SettingsGUI implements ActionListener {
	final static String STONE_NUM_TEXT = "The initial number of stones in each of the pits: ";
	final static String PLAYER_TEXT = "The number of players: ";
	final static String SPACE = " ";
	JFrame frame;
	JPanel contentPane;
	JLabel label1, label2, space;
	JButton button1, button2, button3, button4, button5, button6, button7, button8;
	private int numStones, numPlayers;
	
	/**
	 * Constructor: creates the settings board for the Stones game
	 * Pre: None
	 * Post: a board that let the user chooses the settings of the game is created
	 */
	public SettingsGUI() {
		frame = new JFrame("Stones Game Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 5, 60, 30));
		
		label1 = new JLabel(STONE_NUM_TEXT);
		contentPane.add(label1);
		
		button1 = new JButton("2");
		button1.setBackground(Color.WHITE);
		button1.setActionCommand("2");
		button1.addActionListener(this);
		contentPane.add(button1);
		
		button2 = new JButton("3");
		button2.setBackground(Color.WHITE);
		button2.setActionCommand("3");
		button2.addActionListener(this);
		contentPane.add(button2);
		
		button3 = new JButton("4");
		button3.setBackground(Color.WHITE);
		button3.setActionCommand("4");
		button3.addActionListener(this);
		contentPane.add(button3);
		
		button4 = new JButton("5");
		button4.setBackground(Color.WHITE);
		button4.setActionCommand("5");
		button4.addActionListener(this);
		contentPane.add(button4);
		
		label2 = new JLabel(PLAYER_TEXT);
		contentPane.add(label2);
		
		button5 = new JButton("2 Players");
		button5.setBackground(Color.WHITE);
		button5.setActionCommand("2 Players");
		button5.addActionListener(this);
		contentPane.add(button5);
		
		button6 = new JButton("1 Player");
		button6.setBackground(Color.WHITE);
		button6.setActionCommand("1 Player");
		button6.addActionListener(this);
		contentPane.add(button6);
		
		for(int i = 0; i < 3; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		button7 = new JButton("Start Game");
		button7.setBackground(Color.WHITE);
		button7.setActionCommand("Start Game");
		button7.addActionListener(this);
		contentPane.add(button7);
		
		for(int i = 0; i < 2; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		button8 = new JButton("Back");
		button8.setBackground(Color.WHITE);
		button8.setActionCommand("Back");
		button8.addActionListener(this);
		contentPane.add(button8);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Handle button-clicking events
	 * Pre: Action event includes selecting the initial number of stones and the number of players;
	 * It also includes the button that would start the actual game and the button for going back to the rules page
	 * Post: the game moves on to the next page and closes the rules page
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Back")) {
			frame.setVisible(false);
			RulesGUI.runGUI(0);
		}
		
		if(eventName.equals("2")) {
			button1.setBackground(Color.RED);
			button2.setBackground(Color.WHITE);
			button3.setBackground(Color.WHITE);
			button4.setBackground(Color.WHITE);
			
			numStones = 2;
			System.out.println("Set initial stone # to " + numStones);
		} else if(eventName.equals("3")) {
			button2.setBackground(Color.RED);
			button1.setBackground(Color.WHITE);
			button3.setBackground(Color.WHITE);
			button4.setBackground(Color.WHITE);
			
			numStones = 3;
			System.out.println("Set initial stone # to " + numStones);
		} else if(eventName.equals("4")) {
			button3.setBackground(Color.RED);
			button1.setBackground(Color.WHITE);
			button2.setBackground(Color.WHITE);
			button4.setBackground(Color.WHITE);
			
			numStones = 4;
			System.out.println("Set initial stone # to " + numStones);
		} else if (eventName.equals("5")) {
			button4.setBackground(Color.RED);
			button1.setBackground(Color.WHITE);
			button2.setBackground(Color.WHITE);
			button3.setBackground(Color.WHITE);
			
			numStones = 5;
			System.out.println("Set initial stone # to " + numStones);
		}
		
		if(eventName.equals("2 Players")) {
			button5.setBackground(Color.RED);
			button6.setBackground(Color.WHITE);
			
			numPlayers = 2;
			System.out.println("Set the # of player to " + numPlayers);
		} else if(eventName.equals("1 Player")) {
			button6.setBackground(Color.RED);
			button5.setBackground(Color.WHITE);
			
			numPlayers = 1;
			System.out.println("Set the # of player to " + numPlayers);
		}
		
		if(eventName.equals("Start Game") && (numStones == 2 || numStones == 3 || numStones == 4 || numStones == 5) 
				&& (numPlayers == 1 || numPlayers == 2)) {
			frame.setVisible(false);
			StonesGameGUI.runGUI(numStones, numPlayers);
			System.out.println("Running Stones Game...");
		}
	}
	
	/**
	 * Create and show the GUI
	 * 
	 */
	public static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		SettingsGUI settings = new SettingsGUI();
	}

}