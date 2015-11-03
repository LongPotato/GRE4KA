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
 * This is represent the game map, a 2 dimensional array of 81 Square objects.
 */
public class Map {

	/**
	 * The map is a 2 dimensional array of type Square.
	 */
	private Square[][] map = new Square[9][9];

    /**
     * At the beginning of the game fill up the map with spy, ninjas, and rooms.
     */
    public void fillMap() {
    	
    }
    
	/**
	 * Return the game map.
	 * @return a 2 dimentional array of type Square.
	 */
	public Square[][] getMap() {
		return map;
	}

	/**
	 * Set the game map.
	 * @param map a 2 dimentional array of type Square.
	 */
	public void setMap(Square[][] map) {
		this.map = map;
	}
	
	
}
