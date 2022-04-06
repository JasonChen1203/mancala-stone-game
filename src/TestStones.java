/*
 * TestStones.java
 * Programmer Name: Jason Chen
 * Course: ICS3U
 * Date: 01/06/2019
 */

package Stones;


/**
 * This simulates a two-player game called Stones
 * The game also features a one-player option with an AI
 */
public class TestStones {
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RulesGUI.runGUI(0);
			}
		});
		
	}
	
}