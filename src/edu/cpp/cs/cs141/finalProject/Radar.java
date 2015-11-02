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
 * Create a Radar Class that inherits from PowerUp. It shows the location of the
 * brief case.
 */
public class Radar extends PowerUp {

	/**
	 * @param symbol
	 * @param row
	 * @param col
	 * @param active
	 */
	public Radar(String symbol, int row, int col, boolean active,
			boolean visible) {
		super("R", row, col, true, false);
	}

}
