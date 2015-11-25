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
 * Abstract class. This class represents the notion of the game power up items.
 */
public abstract class PowerUp extends Square {

	/**
	 * Default serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The status of the item, initially not active.
	 */
	boolean active = false;

	/**
	 * The constructor method to create a power up item.
	 * @param symbol the string symbol of the item, such as: D for radar detection, B for bullet...
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public PowerUp(String symbol, int row, int col) {
		super(symbol, row, col);
	}

	/**
	 * Get the status of the power up item.
	 * @return true if the item is activated.
	 */
	public boolean isActive() {
		return active;
	}
}
