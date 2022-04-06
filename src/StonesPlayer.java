

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
	 * Pre: The initial number of stones is identified
	 * Post: Fills each of the player's pit with stones and have the home bin at 0 stones
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
	 * Pre: The pit number is identifed
	 * Post: the number of stones in the pit is returned
	 */
	public int getPlayerPit(int pitNum) {
		return(playerPit[pitNum]);
	}
	
	/**
	 * Method returns the number of stones in the home bin
	 * Pre: None
	 * Post: the number of stones in the home bin is returned
	 */
	public int getHomeBin() {
		return(playerHomeBin);
	}
	
	/**
	 * Method takes all the stones in one particular pit
	 * Pre: the pit that is being taken must not be 0
	 * Post: all the stones in the pit are taken away
	 */
	public void takeStones(int pitNum) {
		playerPit[pitNum] = 0;
	}
	
	/**
	 * Method add each pit by 1 stone for a specific amount of stones, in this case the number of stones that are taken
	 * Pre: The pit number and the number of stones is identified
	 * Post: each pit counterclockwise to the taken pit increases by 1 stone until the total number of increased stones
	 * equals to the number of taken stones
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
	 * Pre: The taken pit must have stones exceeding the number of slots remaining on the opponent's side
	 * Post: the player receives some of the stones from the opponent
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
	 * Pre: One of the player's stones must land on the home bin, or the player performs a steal
	 * Post: player's home bin increases by a specific amount
	 */
	public void addHomeBin(int num) {
		playerHomeBin += num;
	}
	

	
	
}
