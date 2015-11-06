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
 * This class represents the rooms in game. 
 * One of them will contain the briefcase or gre4ka that lead to victory.
 */
public class Room extends Square {

	/**
	 * True if the room contains the briefcase, false by default.
	 */
	boolean briefcase = false;
	
	/** 
	 * The constructor method to create the room object.
	 * @param symbol default is "R"
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Room(String symbol, int row, int col) {
		super("R", row, col);
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 */
	public Room(int row, int col) {
		super("R", row, col);
	}

	/**
	 * Check to see if the room contain the briefcase.
	 * @return true if the room has the briefcase.
	 */
	public boolean isBriefcase() {
		return briefcase;
	}

	/**
	 * Put in briefcase inside the room.
	 * @param briefcase true to set the briefcase.
	 */
	public void setBriefcase(boolean briefcase) {
		this.briefcase = briefcase;
	}

}
