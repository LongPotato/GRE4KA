/**
 * 
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment Gre4ka
 *
 * <Create an Assassin game,
 *  where the player is a spy
 *  that is trying to get the briefcase with documents
 *  and the ninja assassins are trying to catch him.>
 *
 * Team Gre4ka 
 *   <Alexandra Klimenko, Khanh Nguyen, Victor Ruiz, Ian Garrett>
 */
package edu.cpp.cs.cs141.finalProject;

/**
 * Game Engine, handle the logic execution of the game.
 */
public class Engine {
	
	/**
	 * Constructor to create a new game engine.
	 * A game map object will so be created.
	 */
    public Engine() {
    	Map gameMap = new Map();
    }
			
	/**
	 * Perform the moveUp action.
	 */
	public void movePlayerUp(Square square) {
		
	}

	public void movePlayerDown(Square square) {
		
	}

	public void movePlayerLeft(Square square) {
		
	}

	public void movePlayerRight(Square square) {
		
	}
	
	public void moveNinjaUp(Square square) {
		
	}
	
	public void moveNinjaDown(Square square) {
		
	}
	
	public void moveNinjaLeft(Square square) {
		
	}
	
	public void moveNinjaRight(Square square) {
		
	}

	public void Shoot(Square square) {
		
	}
	
	/**
	 * Enter room, only from the north side
	 */
	public void enterRoom() {
		
	}
	
	/**
	 * Check for the winning condition of the game.
	 * @return true if game is over
	 */
	public boolean gameOver() {
		return true;
	}
}
