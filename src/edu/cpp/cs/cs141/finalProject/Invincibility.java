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
 * Inherit from PowerUp, make player invulnerable for 5 turns.
 */
public class Invincibility extends PowerUp {

	/**
	 * The constructor method to create the invincibilty powerup.
	 * @param symbol the string symbol of the item, such as: D for radar detection, A for ammo...
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Invincibility(String symbol, int row, int col) {
		super("I", row, col);
	}
	
	/**
	 * Override from the parent class, access the Spy class to set invicibility to true.
	 * @param spy the spy object that the power up item will have effect on.
	 * @param rooms the array contains all the rooms on the map.
	 */
	public void activate(Spy spy, Room[] rooms) {
		// Code here
		super.activate(spy, rooms);
	}

}
