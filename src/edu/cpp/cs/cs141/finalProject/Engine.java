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
 * 
 */
import static java.lang.Math.abs;

/**
 * Game Engine, handle the logic execution of the game.
 */
public class Engine {

	/**
	 * The map is a 2 dimensional array of type Square.
	 */
	private Square[][] map = new Square[9][9];

	/**
	 * Initialize/fill up the 2 dimensional array map with Square objects.
	 * Assign the row & col attributes for each Square.
	 */
	public void fillMapWithSquare() {
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
		assignRooms();
		Spy spy = assignSpy();
		assignSpyAndVisibility(spy);
		// We can do that all in one, or divide it into sub methods
	}

	public void assignRooms() {

		Room location1 = new Room(1, 1);
		Room location2 = new Room(1, 4);
		Room location3 = new Room(1, 7);
		Room location4 = new Room(4, 1);
		Room location6 = new Room(4, 4);
		Room location7 = new Room(4, 7);
		Room location5 = new Room(7, 1);
		Room location8 = new Room(7, 4);
		Room location9 = new Room(7, 7);

		map[1][1] = location1;
		map[1][4] = location2;
		map[1][7] = location3;
		map[4][1] = location4;
		map[4][4] = location5;
		map[4][7] = location6;
		map[7][1] = location7;
		map[7][4] = location8;
		map[7][7] = location9;

	}

	public Spy assignSpy() {
		Spy location = new Spy(8, 0);
		map[8][0] = location;
		return location;
	}

	public void assignSpyAndVisibility(Spy spy) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (i == spy.getRow() && abs(spy.getCol() - j) < 3) {

					if (map[i][j].getSymbol().equals("X"))
						map[i][j].setSymbol(" ");
					else
						map[i][j].getSymbol();
				}
				if (j == spy.getCol() && abs(spy.getRow() - i) < 3) {

					if (map[i][j].getSymbol().equals("X"))
						map[i][j].setSymbol(" ");
					else
						map[i][j].getSymbol();
				}
			}
		}
	}

	/**
	 * Return the game map.
	 * 
	 * @return a 2 dimensional array of type Square.
	 */
	public Square[][] getMap() {
		return map;
	}

	/**
	 * Set the game map.
	 * 
	 * @param map
	 *            a 2 dimentional array of type Square.
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
	 * 
	 * @return true if game is over
	 */
	public boolean gameOver() {
		return true;
	}

}
