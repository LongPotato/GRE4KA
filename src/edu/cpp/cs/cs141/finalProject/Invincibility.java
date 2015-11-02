/**
 * 
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment Gre4ka
 *
 * <Create an Assasin game,
 *  where the player is a spy
 *  that is trying to get the breifacse with documents
 *  and the ninja assasins are trying to catch him.>
 *
 * Team Gre4ka 
 *   <Alexandra Klimenko, Khanh Nguyen, Victor Ruiz, Ian Garrett>
 */
package edu.cpp.cs.cs141.finalProject;

/**
 * 
 */

/**
 * @author kevin
 * 
 *         III, Invincibility : inherit from PowerUp, make player invulnerable
 *         for 5 turns Methods: overload the constructor to set symbol setActive
 *         : override the setter method of PowerUp class call the
 *         setInvincibility of the Spy class to set invincibility to true set
 *         the active to true to hide this item from the map
 */
public class Invincibility extends PowerUp {

	/**
	 * @param symbol
	 * @param row
	 * @param col
	 * @param active
	 */
	public Invincibility(String symbol, int row, int col, boolean active,
			boolean visible) {
		super("I", row, col, true, false);
		// TODO Auto-generated constructor stub
	}

}
