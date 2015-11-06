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
 * Game Engine, handle the logic execution of the game.
 */
public class Engine {
	
	/**
	 * The map is a 2 dimensional array of type Square.
	 */
	private Square[][] map = new Square[9][9];
	
	/**
	 * Initialize/fill up the 2 dimentional array map with Square objects.
	 * Asign the row & col attributes for each Square.
	 */
	public void fillMap() {
		Square[][] map = this.map;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Square location = new Square(i, j);
				map[i][j] = location;
			}
		}
	}

    /**
     * Set up the map with 1 spy, 6 ninjas, and 9 rooms.
     */
    public void setUpMap() {
    	// We can do that all in one, or divide it into sub methods
    }
    
	/**
	 * Return the game map.
	 * @return a 2 dimensional array of type Square.
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
	
    /**
     * 
     * @param square
     */
	public void movePlayerUp(Square square) {
		
	}

	/**
	 * 
	 * @param square
	 */
	public void movePlayerDown(Square square) {
		
	}

	/**
	 * 
	 * @param square
	 */
	public void movePlayerLeft(Square square) {
		
	}

	/**
	 * 
	 * @param square
	 */
	public void movePlayerRight(Square square) {
		
	}

	/**
	 * 
	 * @param square
	 */
	public void playerShoot(Square square) {
		
	}
	
	/**
	 * Enter room, only from the north side
	 */
	public void enterRoom() {
		
	}
	
	/**
	 * Check for the winning condition of the game.
	 * @return true if game is over
	 */
	public boolean gameOver() {
		return true;
	}
	
	
}
