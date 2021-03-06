/**
 * 
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodriguez
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
 * Inherit from PowerUp, make player invulnerable for 5 turns.
 */
public class Invincibility extends PowerUp {
	
	/**
	 * Generated serial id.
	 */
	private static final long serialVersionUID = -5061874876041795144L;

	/**
	 * The constructor method to create the invincibility powerup.
	 * @param symbol the string symbol of the item, such as: D for radar detection, A for ammo...
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Invincibility(String symbol, int row, int col) {
		super("I", row, col);
	}
	
	public Invincibility(int row, int col){
		super("I", row, col);
	}
	
}
