/*
 * StonesGameGUI.java
 * Programmer Name: Jason Chen
 * Course: ICS3U
 * Date: 01/06/2019
 */

package Stones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This will create the gameboard for the Stones game
 */
public class StonesGameGUI implements ActionListener {
	final static String SPACE = " ";
	final static int PLAYER_ONE = 1, PLAYER_TWO = 2, PLAYER_AI = 0;
	private JLabel[] pitLabel1 = new JLabel[6];
	private JLabel[] pitLabel2 = new JLabel[6];
	private int numPlayers;
	JFrame frame;
	JPanel contentPane;
	JLabel space;
	JLabel binLabel1, binLabel2;
	JLabel turnLabel, winnerLabel, onePlayerTurnLabel;
	JButton button1, button2, button3, button4, button5, button6;
	JButton button7, button8, button9, button10, button11, button12;
	JButton ruleButton, backButton;
	StonesGame game;
	
	/**
	 * Constructor: creates the gameboard for the Stones game
	 * Pre: the initial number of stones in each pit and the number of players are identified
	 * Post: a board that creates the gameboard for the Stones Game
	 */
	public StonesGameGUI(int stoneNum, int playerNum) {
		game = new StonesGame(stoneNum, playerNum);
		numPlayers = playerNum;
		
		frame = new JFrame("Stones Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 8, 0, 0));
		
		for(int i = 0; i < 7; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		winnerLabel = new JLabel("");
		contentPane.add(winnerLabel);
		
		space = new JLabel(SPACE);
		contentPane.add(space);
		
		if(playerNum == 2) {
			button1 = new JButton();
			button1.setPreferredSize(new Dimension(200, 50));
			button1.setActionCommand("onePlayerTwo");
			button1.addActionListener(this);
			button1.setEnabled(false);
			contentPane.add(button1);
			
			button2 = new JButton();
			button2.setPreferredSize(new Dimension(200, 50));
			button2.setActionCommand("twoPlayerTwo");
			button2.addActionListener(this);
			button2.setEnabled(false);
			contentPane.add(button2);
			
			button3 = new JButton();
			button3.setPreferredSize(new Dimension(200, 50));
			button3.setActionCommand("threePlayerTwo");
			button3.addActionListener(this);
			button3.setEnabled(false);
			contentPane.add(button3);
			
			button4 = new JButton();
			button4.setPreferredSize(new Dimension(200, 50));
			button4.setActionCommand("fourPlayerTwo");
			button4.addActionListener(this);
			button4.setEnabled(false);
			contentPane.add(button4);
			
			button5 = new JButton();
			button5.setPreferredSize(new Dimension(200, 50));
			button5.setActionCommand("fivePlayerTwo");
			button5.addActionListener(this);
			button5.setEnabled(false);
			contentPane.add(button5);
			
			button6 = new JButton();
			button6.setPreferredSize(new Dimension(200, 50));
			button6.setActionCommand("sixPlayerTwo");
			button6.addActionListener(this);
			button6.setEnabled(false);
			contentPane.add(button6);
			
		} else {
			for(int i = 0; i < 6; i++) {
				space = new JLabel(SPACE);
				contentPane.add(space);
			}
		}
			
		for(int i = 0; i < 2; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		for(int i = 5; i >= 0; i--) {
			pitLabel2[i] = new JLabel("", SwingConstants.CENTER);
			pitLabel2[i].setOpaque(true);
			pitLabel2[i].setBackground(Color.CYAN);
			pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
			contentPane.add(pitLabel2[i]);
		}
		
		space = new JLabel(SPACE);
		contentPane.add(space);
		
		binLabel2 = new JLabel("", SwingConstants.CENTER);
		binLabel2.setOpaque(true);
		binLabel2.setBackground(Color.CYAN);
		binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
		contentPane.add(binLabel2);
		
		for(int i = 0; i < 6; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		binLabel1 = new JLabel("", SwingConstants.CENTER);
		binLabel1.setOpaque(true);
		binLabel1.setBackground(Color.PINK);
		binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
		contentPane.add(binLabel1);
		
		space = new JLabel(SPACE);
		contentPane.add(space);
		
		for(int i = 0; i < 6; i++) {
			pitLabel1[i] = new JLabel("", SwingConstants.CENTER);
			pitLabel1[i].setOpaque(true);
			pitLabel1[i].setBackground(Color.PINK);
			pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
			contentPane.add(pitLabel1[i]);
		}
		
		for(int i = 0; i < 2; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		button7 = new JButton();
		button7.setPreferredSize(new Dimension(200, 50));
		button7.setActionCommand("onePlayerOne");
		button7.addActionListener(this);
		contentPane.add(button7);
		
		button8 = new JButton();
		button8.setPreferredSize(new Dimension(200, 50));
		button8.setActionCommand("twoPlayerOne");
		button8.addActionListener(this);
		contentPane.add(button8);
		
		button9 = new JButton();
		button9.setPreferredSize(new Dimension(200, 50));
		button9.setActionCommand("threePlayerOne");
		button9.addActionListener(this);
		contentPane.add(button9);
		
		button10 = new JButton();
		button10.setPreferredSize(new Dimension(200, 50));
		button10.setActionCommand("fourPlayerOne");
		button10.addActionListener(this);
		contentPane.add(button10);
		
		button11 = new JButton();
		button11.setPreferredSize(new Dimension(200, 50));
		button11.setActionCommand("fivePlayerOne");
		button11.addActionListener(this);
		contentPane.add(button11);
		
		button12 = new JButton();
		button12.setPreferredSize(new Dimension(200, 50));
		button12.setActionCommand("sixPlayerOne");
		button12.addActionListener(this);
		contentPane.add(button12);
		
		for(int i = 0; i < 9; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		turnLabel = new JLabel("Turn: Player 1", SwingConstants.CENTER);
		onePlayerTurnLabel = new JLabel("Turn: Player 1", SwingConstants.CENTER);
		
		if (numPlayers == 2)
		contentPane.add(turnLabel);
		else 
			contentPane.add(onePlayerTurnLabel);			
		
		for(int i = 0; i < 2; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		ruleButton = new JButton("Rules");
		ruleButton.setBackground(Color.WHITE);
		ruleButton.setActionCommand("Rules");
		ruleButton.addActionListener(this);
		contentPane.add(ruleButton);
		
		for(int i = 0; i < 3; i++) {
			space = new JLabel(SPACE);
			contentPane.add(space);
		}
		
		backButton = new JButton("Back");
		backButton.setBackground(Color.WHITE);
		backButton.setActionCommand("Back");
		backButton.addActionListener(this);
		contentPane.add(backButton);
		
		frame.setContentPane(contentPane);
		
		frame.pack();

		frame.setVisible(true);
	}

	/**
	 * Handle button-clicking events
	 * Pre: Action event includes selecting the number of pits that the player wants to move;
	 * It also includes going back to settings and explaining the rules
	 * Post: It reacts to the player's clicking and move on with the game until the game is over
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if(eventName.equals("Back")) {
			frame.setVisible(false);
			SettingsGUI.runGUI();
		}
		
		if(eventName.equals("Rules")) {
			RulesGUI.runGUI(1);
		}
		
		if(game.getGameEnd() == false) {
			if(eventName.equals("onePlayerOne")) {
				game.makeMove(0);
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("twoPlayerOne")) {
				game.makeMove(1);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("threePlayerOne")) {
				game.makeMove(2);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("fourPlayerOne")) {
				game.makeMove(3);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("fivePlayerOne")) {
				game.makeMove(4);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("sixPlayerOne")) {
				game.makeMove(5);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
				} else if (numPlayers == 2){
					turnLabel.setText("Turn: Player 2");
					
					button7.setEnabled(false);
					button8.setEnabled(false);
					button9.setEnabled(false);
					button10.setEnabled(false);
					button11.setEnabled(false);
					button12.setEnabled(false);
					
					if (numPlayers == 2) {
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
					}
				}
			} else if(eventName.equals("onePlayerTwo")) {
				game.makeMove(5);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
	
			} else if(eventName.equals("twoPlayerTwo")) {
				game.makeMove(4);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
			} else if(eventName.equals("threePlayerTwo")) {
				game.makeMove(3);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
			} else if(eventName.equals("fourPlayerTwo")) {
				game.makeMove(2);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
			} else if(eventName.equals("fivePlayerTwo")) {
				game.makeMove(1);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
			} else if(eventName.equals("sixPlayerTwo")) {
				game.makeMove(0);
				
				for(int i = 0; i < 6; i++) {
					pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
					pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
				}
				
				binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
				binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
				
				if(game.getTurn() == 1) {
					turnLabel.setText("Turn: Player 1");
					
					button7.setEnabled(true);
					button8.setEnabled(true);
					button9.setEnabled(true);
					button10.setEnabled(true);
					button11.setEnabled(true);
					button12.setEnabled(true);
					
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
				} else {
					turnLabel.setText("Turn: Player 2");
				}	
			} 
			
			if(numPlayers == 1) {	
				while (game.getTurn() == 2) {
					game.moveAI();
					game.makeMove(game.getOptimalMove());
					
					for(int i = 0; i < 6; i++) {
						pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
						pitLabel2[i].setText(String.valueOf(game.getStoneNum(i,PLAYER_AI)));
					}
					
					binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
					binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_AI)));
					
					turnLabel.setText("Turn: Player 1");	
			}
		}
			
			game.gameCheck();
		} 

		if(game.getGameEnd()){
			binLabel1.setText(String.valueOf(game.getBinNum(PLAYER_ONE)));
			binLabel2.setText(String.valueOf(game.getBinNum(PLAYER_TWO)));
			
			for(int i = 0; i < 6; i++) {
				pitLabel1[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_ONE)));
				pitLabel2[i].setText(String.valueOf(game.getStoneNum(i, PLAYER_TWO)));
			}
			
			
			game.calculateWinner();
			
			if(game.getWinner() == 1) {
				winnerLabel.setText("The winner is Player 1!");
			} else if(game.getWinner() == 2 && numPlayers == 2) {
				winnerLabel.setText("The winner is Player 2!");
			} else if(game.getWinner() == 2 && numPlayers == 1) {
				winnerLabel.setText("The winner is the AI!");
			} else if(game.getWinner() == 3) {
				winnerLabel.setText("It is a tie.");
			}
			
			if (numPlayers == 1)
				turnLabel.setText("Turn: Player 1");
			
		}
	}
	
	/**
	 * Create and show the GUI
	 */
	public static void runGUI(int numStones, int numPlayers) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		StonesGameGUI stonesGame = new StonesGameGUI(numStones, numPlayers);
	}
}