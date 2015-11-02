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
 * Create a Room Class that represents the game rooms. One of them will contain
 * the briefcase or gre4ka.
 */
public class Room extends Square {

	/**
	 * @param symbol
	 * @param row
	 * @param col
	 */
	public Room(String symbol, int row, int col) {
		super("R", row, col);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The room object where the briefcase is false as default.
	 */
	boolean briefcase = false;

	/**
	 * 
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * 
	 * @param symbol
	 */
	public void setSymbol(String symbol) {

		this.symbol = symbol;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isBriefcase() {
		return briefcase;
	}

	/**
	 * 
	 * @param briefcase
	 */
	public void setBriefcase(boolean briefcase) {
		this.briefcase = briefcase;
	}

	/**
	 * 
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * 
	 * @return
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

}
