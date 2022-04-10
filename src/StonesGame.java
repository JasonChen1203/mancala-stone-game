
package Stones;

/**
 * Stimulates the Stones Game
 *
 */
public class StonesGame {
	private final int EMPTY = 0;
	private int turn;
	private int stoneNum;
	private int playerNum;
	private int lastPosition;
	private int optimalPit;
	private int winner;
	private boolean rule1, rule2;
	private boolean optimalMove1, optimalMove2;
	private boolean gameEnd;
	StonesPlayer player1;
	StonesPlayer player2;
	StonesPlayer playerAI;
	
	/**
	 * Constructor
	 * Initialize player 1 & 2
	 */
	public StonesGame(int numStones, int numPlayers) {
		player1 = new StonesPlayer(numStones);
		player2 = new StonesPlayer(numStones);
		playerAI = new StonesPlayer(numStones);
		
		stoneNum = 0;
		playerNum = numPlayers;
		turn = 1;
		rule1 = false;
		rule2 = false;
		gameEnd = false;
	}
	
	/**
	 * returns whose player's turn it is
	 */
	public int getTurn() {
		return(turn);
	}
	
	
	/**
	 * returns whether or not the game ends
	 */
	public boolean getGameEnd() {
		return(gameEnd);
	}
	
	/**
	 * returns the number of stones a player has
	 */
	public int getStoneNum(int pitNum, int player) {
		if(player == 1) {
			return(player1.getPlayerPit(pitNum));
		} else if(playerNum == 2) {
			return(player2.getPlayerPit(pitNum));
		} else {
			return(playerAI.getPlayerPit(pitNum));
		}
	}
	
	/**
	 * returns the number of stones in a player's home bin
	 */
	public int getBinNum(int player) {
		if(player == 1) {
			return(player1.getHomeBin());
		} else if(playerNum == 2){
			return(player2.getHomeBin());
		} else {
			return(playerAI.getHomeBin());
		}
	}
	
	/**
	 * returns the optimal pit number for the AI to move
	 */
	public int getOptimalMove() {
		return(optimalPit);
	}
	
	/**
	 * returns the winner of the Stones game
	 */
	public int getWinner() {
		return(winner);
	}
	
	/**
	 * Manages the moves of the 2 players in the game
	 * Determines where the stones will go
	 * Special rules of the game are also taken into consideration
	 */
	public void makeMove(int pitNum) {
		if(turn == 1) {
			stoneNum = player1.getPlayerPit(pitNum);
			
			if(stoneNum != EMPTY) {
				lastPosition = (pitNum + stoneNum) % 13;
				
				if(lastPosition <= 5) {
					if(player1.getPlayerPit(lastPosition) == EMPTY && stoneNum != EMPTY) {
						rule2 = true;
					} else {
						rule2 = false;
					}
				}
				
				player1.takeStones(pitNum);
				player1.addStones(pitNum, stoneNum);
				
				stoneNum -= (6 - pitNum);
				
				if(stoneNum == EMPTY) {
					rule1 = true;
				} else {
					rule1 = false;
				}
				
				if (playerNum == 2) {
					while(stoneNum > EMPTY) {
						player2.receiveStones(stoneNum);
						stoneNum -= 6;
						
						if(stoneNum > EMPTY) {
							player1.addStones(-1, stoneNum);
							stoneNum -= 7;
							
							if(stoneNum == EMPTY) {
								rule1 = true;
							} else {
								rule1 = false;
							}
						}
					}
				}
				else {
					while(stoneNum > EMPTY) {
						playerAI.receiveStones(stoneNum);
						stoneNum -= 6;
						
						if(stoneNum > EMPTY) {
							player1.addStones(-1, stoneNum);
							stoneNum -= 7;
							
							if(stoneNum == EMPTY) {
								rule1 = true;
							} else {
								rule1 = false;
							}
						}
					}
				
				}
				
				if(rule1 == false) {
					turn = 2;
				} else {
					turn = 1;
				}
				
				if(rule2 == true) {
					if(playerNum == 2) {
						player1.addHomeBin(player2.getPlayerPit(5 - lastPosition));
						player2.takeStones(5 - lastPosition);
					} else {
						if(lastPosition <= 5) {
							player1.addHomeBin(playerAI.getPlayerPit(5 - lastPosition));
							playerAI.takeStones(5 - lastPosition);
						}
					}
				}
			}
		} else if(turn == 2 && playerNum == 2) {
			stoneNum = player2.getPlayerPit(pitNum);
			
			if(stoneNum != EMPTY) {
				lastPosition = (pitNum + stoneNum) % 13;
				
				if(lastPosition <= 5) {
					if(player2.getPlayerPit(lastPosition) == EMPTY && stoneNum != EMPTY) {
						rule2 = true;
					} else {
						rule2 = false;
					}
				}
				
				player2.takeStones(pitNum);
				player2.addStones(pitNum, stoneNum);
				
				stoneNum -= (6 - pitNum);
				
				if(stoneNum == EMPTY) {
					rule1 = true;
				} else {
					rule1 = false;
				}
				
				while(stoneNum > EMPTY) {
					player1.receiveStones(stoneNum);
					stoneNum -= 6;
					
					if(stoneNum > EMPTY) {
						player2.addStones(-1, stoneNum);
						stoneNum -= 7;
						
						if(stoneNum == EMPTY) {
							rule1 = true;
						} else {
							rule1 = false;
						}
					}
				}
				
				if(rule1 == false) {
					turn = 1;
				} else {
					turn = 2;
				}
				
				if(rule2 == true && lastPosition <= 5) {
					player2.addHomeBin(player1.getPlayerPit(5 - lastPosition));
					player1.takeStones(5 - lastPosition);
				}
			}
			
			rule1 = false;
			rule2 = false;
		} else {
			stoneNum = playerAI.getPlayerPit(pitNum);
			
			if(stoneNum != EMPTY) {
				lastPosition = (pitNum + stoneNum) % 13;
				
				if(lastPosition <= 5) {
					if(playerAI.getPlayerPit(lastPosition) == EMPTY && stoneNum != EMPTY) {
						rule2 = true;
					} else {
						rule2 = false;
					}
				}
				
				playerAI.takeStones(pitNum);
				playerAI.addStones(pitNum, stoneNum);
				
				stoneNum -= (6 - pitNum);
				
				if(stoneNum == EMPTY) {
					rule1 = true;
				} else {
					rule1 = false;
				}
				
				while(stoneNum > EMPTY) {
					player1.receiveStones(stoneNum);
					stoneNum -= 6;
					
					if(stoneNum > EMPTY) {
						playerAI.addStones(-1, stoneNum);
						stoneNum -= 7;
						
						if(stoneNum == EMPTY) {
							rule1 = true;
						} else {
							rule1 = false;
						}
					}
				}
				
				gameCheck();
				
				if(!rule1) {
					turn = 1;
				} else {
					turn = 2;
				}
				
				if (gameEnd) {
					turn = 1;
				}
				
				if(rule2 == true && lastPosition <= 5) {
					playerAI.addHomeBin(player1.getPlayerPit(5 - lastPosition));
					player1.takeStones(5 - lastPosition);
				}
			} else {
				turn = 1;
			
				rule1 = false;
				rule2 = false;
				lastPosition = 0;
			}
		}
	}
	
	/**
	 * chooses and calculates the best move for the AI
	 */
	public void moveAI() {
		optimalMove1 = false;
		optimalMove2 = false;
		
		for(int i = 5; i >= 0; i--) {
			stoneNum = playerAI.getPlayerPit(i);
			
			if(stoneNum != EMPTY && optimalMove1 == false && optimalMove2 == false) {
				lastPosition = (i + stoneNum) % 13;
				
				if(lastPosition <= 5) {
					if(playerAI.getPlayerPit(lastPosition) == EMPTY && stoneNum != EMPTY) {
						optimalMove2 = true;
					} else {
						optimalMove2 = false;
					}
				}
				
				stoneNum -= (6 - i);
				
				if(stoneNum % 13 == EMPTY) {
					optimalMove1 = true;
				} else {
					optimalMove1 = false;
				}
				
				if(optimalMove1 == true) {
					optimalPit = i;
					System.out.println("Double");
				} else if(optimalMove2 == true) {
					optimalPit = i;
					System.out.println("Steal");
				}
			}
			
		}
		
		if(optimalMove1 == false && optimalMove2 == false) {
			if(playerAI.getPlayerPit(5) != EMPTY) {
				optimalPit = 5;
			} else if(playerAI.getPlayerPit(4) != EMPTY) {
				optimalPit = 4;
			} else if(playerAI.getPlayerPit(3) != EMPTY) {
				optimalPit = 3;
			} else if(playerAI.getPlayerPit(2) != EMPTY) {
				optimalPit = 2;
			} else if(playerAI.getPlayerPit(1) != EMPTY) {
				optimalPit = 1;
			} else {
				optimalPit = 0;
			}		
		}
		
		System.out.println("Choosing pit: " + optimalPit);
	}
	
	/**
	 * Check if the game ended or not
	 */
	public void gameCheck() {
		if(player1.getPlayerPit(0) == EMPTY && player1.getPlayerPit(1) == EMPTY && player1.getPlayerPit(2) == EMPTY 
			&& player1.getPlayerPit(3) == EMPTY && player1.getPlayerPit(4) == EMPTY && player1.getPlayerPit(5) == EMPTY) {
			
			for(int i = 0; i < 6; i++) {
				if(playerNum == 2) {
					player1.addHomeBin(player2.getPlayerPit(i));
					player2.takeStones(i);
				} else {
					player1.addHomeBin(playerAI.getPlayerPit(i));
					playerAI.takeStones(i);
				}
			}
			
			gameEnd = true;
			
		} else if((player2.getPlayerPit(0) == EMPTY && player2.getPlayerPit(1) == EMPTY && player2.getPlayerPit(2) == EMPTY 
				&& player2.getPlayerPit(3) == EMPTY && player2.getPlayerPit(4) == EMPTY && player2.getPlayerPit(5) == EMPTY) && playerNum == 2) {
			
			for(int i = 0; i < 6; i++) {
				player2.addHomeBin(player1.getPlayerPit(i));
				player1.takeStones(i);
			}
			
			gameEnd = true;
			
		} else if(playerAI.getPlayerPit(0) == EMPTY && playerAI.getPlayerPit(1) == EMPTY && playerAI.getPlayerPit(2) == EMPTY 
				&& playerAI.getPlayerPit(3) == EMPTY && playerAI.getPlayerPit(4) == EMPTY && playerAI.getPlayerPit(5) == EMPTY) {
			
			for(int i = 0; i < 6; i++) {
				playerAI.addHomeBin(player1.getPlayerPit(i));
				player1.takeStones(i);
			}
			
			gameEnd = true; 
		} else {
			gameEnd = false;
		}
	}
	
	/**
	 * Determine the winner of the Stones game
	 */
	public void calculateWinner() {
		if(playerNum == 2) {
			if(player1.getHomeBin() > player2.getHomeBin()) {
				winner = 1;
			} else if(player1.getHomeBin() < player2.getHomeBin()) {
				winner = 2;
			} else if(player1.getHomeBin() == player2.getHomeBin()) {
				winner = 3;
			}
		} else {
			if(player1.getHomeBin() > playerAI.getHomeBin()) {
				winner = 1;
			} else if(player1.getHomeBin() < playerAI.getHomeBin()) {
				winner = 2;
			} else if(player1.getHomeBin() == playerAI.getHomeBin()) {
				winner = 3;
			}
		}
	}	
}
