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
 * The Ninja class represents the enemies.
 */
public class Ninja extends Square {
	
	/**
	 * @param symbol
	 * @param row
	 * @param col
	 */
	public Ninja(String symbol, int row, int col) {
		super("N", row, col);
	}

	/**
	 * Represents the number of ninjas alive. 
	 * Initially there are 6.
	 */
	int ninja = 6;
	
	/**
	 * The status of ninja for current live, default false.
	 */
	boolean alive = false;
	
	/**
	 * Represents the visibility of ninja, default false.
	 * If player gets close, set to true.
	 */
	boolean visible = false;

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
