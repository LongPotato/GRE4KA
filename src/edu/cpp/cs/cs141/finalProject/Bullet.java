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
 * The Bullet Class inherits from PowerUp.
 * It has a symbol "B", the player will get extra ammo if this gets activated.
 */
public class Bullet extends PowerUp {

	/**
	 * The constructor method to create the bullet powerup.
	 * @param symbol the string symbol of the item, such as: D for radar detection, A for ammo...
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Bullet(String symbol, int row, int col) {
		super("B", row, col);
	}
	
	public Bullet(int row, int col){
		super("B", row, col);
	}
	
	/**
	 * Override from the parent class, access the Spy class to increase the number of bullets.
	 * @param spy the spy object that the power up item will have effect on.
	 * @param rooms the array contains all the rooms on the map.
	 */
	public void activate(Spy spy, Room[] rooms) {
		// Code here
		super.activate(spy, rooms);
	}
	
}
