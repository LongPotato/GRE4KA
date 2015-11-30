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

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The Spy Class represents the player. It inherits the symbol and position from
 * the Square class.
 */
public class Spy extends Square {

	/**
	 * Default serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The status of the player for current turn, false if died.
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
	/**
	 * The player can die initially, true if can not die after activate the power up.
	 */
	boolean invincibility = false;
	
	private JLabel SpyPic = new JLabel(new ImageIcon("GameImgs/Spy.jpg"));
	
	/**
	 * The constructor method to create the spy object.
	 * @param symbol default is "S"
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Spy(String symbol, int row, int col) {
		super("S", row, col);
	}
	
	/**
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Spy(int row, int col) {
		super("S" , row, col);
		this.setVisible(true);
	}

	/**
	 * Check to see if the spy is still alive
	 * @return true if alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Change the living status of the spy
	 * @param alive false if died
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Get the number of lives the spy currently have
	 * @return the number of lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * The spy get stabbed by the ninja, minus one lives from total.
	 */
	public void getStabbed() {
		lives = lives - 1;
	}

	/**
	 * Get the number of bullets the spy currently has
	 * @return the number of bullets
	 */
	public int getBullets() {
		return bullets;
	}

	/**
	 * Increase the current number of bullet the spy has by 1.
	 */
	public void addBullet() {
		bullets += 1;
	}
	
	/**
	 * Decrease the current number of bullets the spy has by 1.
	 */
	public void useBullet() {
		bullets -= 1;
	}
	
	/**
	 * Check if the spy is immune to death.
	 * @return true if invincible
	 */
	public boolean isInvincible() {
		return invincibility;
	}

	/**
	 * Set the invicibility of the spy, immune to death.
	 * @param invincibility true if immune to death.
	 */
	public void setInvincibility(boolean invincibility) {
		this.invincibility = invincibility;
	}
	
	public JLabel getPic() {
		return SpyPic;
	}

}
