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
 * The Spy Class represents the player. It inherits the symbol and position from
 * the Square class.
 */
public class Spy extends Square {

	/**
	 * @param symbol
	 * @param row
	 * @param col
	 */
	public Spy(String symbol, int row, int col) {
		super("S", 0, 0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The status of the player for current live.
	 */
	boolean alive = true;

	/**
	 * The player has 3 lives initially.
	 */
	int lives = 3;

	/**
	 * The player is given 1 bullet initially.
	 */
	int bullets = 1;

	/*
	 * 
	 */
	boolean invincibility = false;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
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
	 * @param col
	 *            the col to set
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
	 * @param alive
	 *            the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param lives
	 *            the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * @return the bullets
	 */
	public int getBullets() {
		return bullets;
	}

	/**
	 * @param bullets
	 *            the bullets to set
	 */
	public void setBullets(int bullets) {
		this.bullets = bullets;
	}

	/**
	 * @return the invincibility
	 */
	public boolean isInvincibility() {
		return invincibility;
	}

	/**
	 * @param invincibility
	 *            the invincibility to set
	 */
	public void setInvincibility(boolean invincibility) {
		this.invincibility = invincibility;
	}

}
