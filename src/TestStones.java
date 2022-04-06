
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
