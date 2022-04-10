

package Stones;

/**
 * Simulates a player in the Stones game
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
	 * returns the number of stones in one specific pit
	 */
	public int getPlayerPit(int pitNum) {
		return(playerPit[pitNum]);
	}
	
	/**
	 * returns the number of stones in the home bin
	 */
	public int getHomeBin() {
		return(playerHomeBin);
	}
	
	/**
	 * takes all the stones in one particular pit
	 */
	public void takeStones(int pitNum) {
		playerPit[pitNum] = 0;
	}
	
	/**
	 * add each pit by 1 stone for a specific amount of stones, in this case the number of stones that are taken
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
	 * receives stones by adding each pit by 1 stone for a specific amount of stones
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
	 * increases the number of stones in the home bin
	 */
	public void addHomeBin(int num) {
		playerHomeBin += num;
	}
	

	
	
}
