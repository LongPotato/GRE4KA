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
 * The Ninja class that represents the enemies.
 * These ninjas will wonder around the map and stab the spy if found.
 */
public class Ninja extends Square {

	
	/**
	 * The status of ninja for current live, default true.
	 */
	boolean alive = true;
	
	/**
	 * Represents the visibility of ninja, default false.
	 * If player gets close, set to true.
	 */
	boolean visible = false;
	
	/**
	 * The constructor method to create the a ninja object.
	 * @param symbol default is "N"
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Ninja(String symbol, int row, int col) {
		super("N", row, col);
	}

	/**
	 * Check to see if the ninja is still alive
	 * @return true if alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Change the living status of the ninja
	 * @param alive false if died
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Get the visibility of the ninja, default false.
	 * @return true is visible.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Set the visibility of the ninja.
	 * @param visible true if visible.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
