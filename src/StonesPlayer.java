

package Stones;

/**
 * This stimulates a player in the Stones game
 * It holds the methods to access player information such as the number of the pit that the player wants to move, 
 * the number of stones in each pit, and the number of stones in the player's home bin
 */

public class StonesPlayer {
	private int[] playerPit = new int[6];
	private int playerHomeBin;
	private int numStones;
	
	/**
	 * Constructor
	 */
	public StonesPlayer(int numStones) {
		for(int i = 0; i < playerPit.length; i++) {
			playerPit[i] = numStones;
		}
		
		playerHomeBin = 0;
		numStones = 0;
	}
	
	/**
	 * Method returns the number of stones in one specific pit
	 */
	public int getPlayerPit(int pitNum) {
		return(playerPit[pitNum]);
	}
	
	/**
	 * Method returns the number of stones in the home bin
	 */
	public int getHomeBin() {
		return(playerHomeBin);
	}
	
	/**
	 * Method takes all the stones in one particular pit
	 */
	public void takeStones(int pitNum) {
		playerPit[pitNum] = 0;
	}
	
	/**
	 * Method add each pit by 1 stone for a specific amount of stones, in this case the number of stones that are taken
	 */
	public void addStones(int pitNum, int stoneNum) {
		numStones = stoneNum;
		
		while(numStones > 0 && pitNum < 5) {
			playerPit[pitNum + 1] += 1;
			
			numStones --;
			pitNum ++;
		}
		
		if(pitNum >= 5 && numStones > 0) {
			playerHomeBin ++;
			numStones --;
		}
	}
	
	/**
	 * Method receives stones by adding each pit by 1 stone for a specific amount of stones
	 */
	public void receiveStones(int remainingStoneNum) {
		int counter = 0;
		
		while(remainingStoneNum > 0 && counter < 6) {
			playerPit[counter] ++;
			remainingStoneNum --;
			counter ++;
		}
	}
	
	/**
	 * Method increases the number of stones in the home bin
	 */
	public void addHomeBin(int num) {
		playerHomeBin += num;
	}
	

	
	
}
