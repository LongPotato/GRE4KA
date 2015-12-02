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
	 * Generated serial ID.
	 */
	private static final long serialVersionUID = 2148652559454136174L;

	//private JLabel BulletPic = new JLabel(new ImageIcon("GameImgs/Bullet.jpg"));

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
	public JLabel getPic() {
		return BulletPic;
	}
	*/
	
}
