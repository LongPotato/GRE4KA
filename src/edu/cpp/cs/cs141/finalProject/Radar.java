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
 * Create a Radar Class that inherits from PowerUp. It shows the location of the
 * brief case when get activated.
 */
public class Radar extends PowerUp {

	/**
	 * Default serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * The constructor method to create the radar powerup.
	 * @param symbol the string symbol of the item, such as: D for radar detection, A for ammo...
	 * @param row a number from 0-8, for array position
	 * @param col a number from 0-8, for array position
	 */
	public Radar(String symbol, int row, int col) {
		super("D", row, col);
	}

	public Radar(int row, int col) {
		super("D", row, col);
	}
	
	private JLabel RadarPic = new JLabel(new ImageIcon("GameImgs/Radar.jpg"));
	
	public JLabel getPic() {
		return RadarPic;
	}
	
}
