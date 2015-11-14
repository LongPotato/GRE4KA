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

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Game Engine, handle the logic execution of the game.
 */
public class Engine {

	/**
	 * The map is a 2 dimensional array of type Square.
	 */
	private Square[][] map = new Square[9][9];
	/**
	 * The room that has the brief case, where briefCase fields equals true.
	 */
	private Room briefCaseRoom;
	/**
	 * The spy in the current game.
	 */
	private Spy spy;
	/**
	 * The array to store 6 ninjas in the current game.
	 */
	private ArrayList<Ninja> ninjas = new ArrayList<Ninja>();
	/**
	 * The array to store the power ups in the current game.
	 */
	private ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
	/**
	 * The status code that indicate how the game end.
	 */
	private int gameEndStatus = 0;
	/**
	 * The number of turns the spy will be invulnerable from ninjas.
	 */
	private int invincibilityTurns = 5;
	/**
	 * To randomize the position of the map.
	 */
	private Random random = new Random();
	/**
	 * To indicate if the game has debug mode activated.
	 */
	private boolean debug = false;
	/**
	 * The array to store used locations, or prohibited locations.
	 */
	private ArrayList<Square> occupiedLocations = new ArrayList<Square>();
	/**
	 * The array to store the locations of the spy visibily, from the previous turn.
	 */
	private ArrayList<Square> spyVisibilityLocations = new ArrayList<Square>();

	/**
	 * Initialize/fill up the 2 dimensional array map with Square objects.
	 * Assign the row & column attributes for each Square.
	 */
	public void fillMapWithSquare() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Square location = new Square(i, j);
				map[i][j] = location;
			}
		}
	}

	/**
	 * Set up the map with 3 different types of powerup, 1 spy, 6 ninjas, and 9
	 * rooms.
	 */
	public void setUpMap() {
		assignRooms();
		spy = assignSpy();
		assignSpyVisibility();
		assignPowerUps();
		assignNinjas();
	}

	/**
	 * Put 9 rooms at fixed locations on the map. Choose one random room to
	 * contain the briefcase, set the briefcase field to true.
	 */
	public void assignRooms() {
		Room location1 = new Room(1, 1);
		Room location2 = new Room(1, 4);
		Room location3 = new Room(1, 7);
		Room location4 = new Room(4, 1);
		Room location5 = new Room(7, 1);
		Room location6 = new Room(4, 4);
		Room location7 = new Room(4, 7);
		Room location8 = new Room(7, 4);
		Room location9 = new Room(7, 7);

		map[1][1] = location1;
		map[1][4] = location2;
		map[1][7] = location3;
		map[4][1] = location4;
		map[7][1] = location5;
		map[4][4] = location6;
		map[4][7] = location7;
		map[7][4] = location8;
		map[7][7] = location9;

		// Save all the rooms location into an array, assign one radom room to
		// contain the brief case.
		Square[] rooms = { map[1][1], map[1][4], map[1][7], map[4][1], map[4][4], map[4][7], map[7][1], map[7][4], map[7][7] };
		briefCaseRoom = (Room) rooms[random.nextInt(8)];
		briefCaseRoom.setBriefcase(true);

		// Add room locations to used locations array to avoid overlap when
		// assign other objects to the map.
		occupiedLocations.addAll(Arrays.asList(rooms));
	}

	/**
	 * Initially create new Spy object and put him at the corner of the map.
	 * 
	 * @return the spy object at location [8][0]
	 */
	public Spy assignSpy() {
		Spy spy = new Spy(8, 0);
		map[8][0] = spy;
		occupiedLocations.add(map[8][0]);
		return spy;
	}

	/**
	 * This method allows the spy to see ahead 2 squares. Remove the darkness
	 * mark "X", and switch the visibility of ninjas, powerups to true if they
	 * are nearby.
	 */
	public void assignSpyVisibility() {
		// Traverse through the spyVisibilityLocations array to switch visibility location from previous turn to false.
		if (!spyVisibilityLocations.isEmpty()){
			for (Square a : spyVisibilityLocations){
				if (a.getSymbol().equals(" "))
				{
					a.setSymbol("X");
					a.setVisible(false);
				}
				if (isNinja(a) || isPowerUp(a)) {
					a.setVisible(false);
				}
			}
			spyVisibilityLocations.clear();
		}
		
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (i == spy.getRow() && abs(spy.getCol() - j) < 3) {
					// Check for ninjas and powerups near by to switch their visibility to true.
					if (isNinja(map[i][j])) {
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					}
					
					if (isPowerUp(map[i][j])) {
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					}
					
					if (map[i][j].getSymbol().equals("X")) {
						map[i][j].setSymbol(" ");
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					} else {
						map[i][j].getSymbol();
					}
				}
				if (j == spy.getCol() && abs(spy.getRow() - i) < 3) {
					if (isNinja(map[i][j])) {
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					}
					
					if (isPowerUp(map[i][j])) {
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					}

					if (map[i][j].getSymbol().equals("X")) {
						map[i][j].setSymbol(" ");
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					} else {
						map[i][j].getSymbol();
					}
				}
			}

		}
	}

	/**
	 * Put one Bullet object at a random location on the map.
	 */
	public void assignBullet() {
		Bullet bullet;
		int rRow;
		int rCol;

		do {
			rRow = random.nextInt(8);
			rCol = random.nextInt(8);
		} while (isOccupied(rRow, rCol));

		bullet = new Bullet(rRow, rCol);
		map[rRow][rCol] = bullet;
		occupiedLocations.add(map[rRow][rCol]);
	}

	/**
	 * Put one Radar object at a random location on the map
	 */
	public void assignRadar() {
		Radar radar;
		int rRow;
		int rCol;

		do {
			rRow = random.nextInt(8);
			rCol = random.nextInt(8);
		} while (isOccupied(rRow, rCol));

		radar = new Radar(rRow, rCol);
		map[rRow][rCol] = radar;
		occupiedLocations.add(map[rRow][rCol]);
	}

	/**
	 * Put one Invincibility at one location on the nap
	 */
	public void assignInvincibility() {
		Invincibility inv;
		int rRow;
		int rCol;

		do {
			rRow = random.nextInt(8);
			rCol = random.nextInt(8);
		} while (isOccupied(rRow, rCol));

		inv = new Invincibility(rRow, rCol);
		map[rRow][rCol] = inv;
		occupiedLocations.add(map[rRow][rCol]);
	}

	/**
	 * Wrapper method to assign the bullet, radar, and invincibility to the
	 * map.
	 */
	public void assignPowerUps() {
		assignBullet();
		assignRadar();
		assignInvincibility();
	}

	/**
	 * Check the position on the map too see if it's occupied by other game
	 * object.
	 * @param row a number from 0-8
	 * @param col a number from 0-8
	 * @return true if the position is occupied.
	 */
	public boolean isOccupied(int row, int col) {
		if (occupiedLocations.contains(map[row][col])) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Put 6 ninja into different random positions on the map.
	 */
	private void assignNinjas() {
		int rRow;
		int rCol;

		// The ninja will be spawn far away from the spy at least 3 squares.
		for (int i = 1; i < 4; i++) {
			occupiedLocations.add(map[8 - i][0]);
			occupiedLocations.add(map[8][0 + i]);
		}
		occupiedLocations.add(map[7][2]);
		occupiedLocations.add(map[6][1]);

		for (int i = 0; i < 6; i++) {
			do {
				rRow = random.nextInt(8);
				rCol = random.nextInt(8);
			} while (isOccupied(rRow, rCol));

			Ninja ninja = new Ninja(rRow, rCol);
			map[rRow][rCol] = ninja;
			// Store the ninja to the array, and mark the location as occupied.
			ninjas.add(ninja);
			occupiedLocations.add(map[rRow][rCol]);
		}
	}

	/**
	 * Activate Debug mode, switch the visible field of all game objects to
	 * true. All game objects will be visible.
	 */
	public void activateDebugMode() {
		debug = true;
		for (Square[] locations : map) {
			for (Square location : locations) {
				location.setVisible(true);
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
	 * Return the room that contains the briefcase that has gre4ka inside it.
	 * 
	 * @return a Room object.
	 */
	public Room getRoomWithBriefCase() {
		return briefCaseRoom;
	}

	/**
	 * Move the spy to the directed direction. The spy can look it room, look for the
	 * gre4ka, get stab if walk into ninja, and activate the power up if found.
	 * @param direction an integer from 1-4: 1-up, 2-left, 3-down, 4-right.
	 * @return the status code: 1 - the player moved sucessfully, 2 - move failed, 3 - room empty, 4 - the player got stabbed,
	 * 5 - the player activated Bullet power up, 6 - the player activated Radar power up, 7 - the player activated Invincibility power up,
	 * 8- the spy is invicible, he can not get stabbed or walk into another ninja.
	 */
	public int movePlayer(int direction) {
		int row = spy.getRow();
		int col = spy.getCol();
		
		// Check for spy invicibility status, decrement the turn number by 1 each turn.
		if (spy.isInvincible()) {
			invincibilityTurns -= 1;
			if (invincibilityTurns <= 0) {
				spy.setInvincibility(false);
			}
		}

		switch (direction) {
		case 1: // Move up
			if (row - 1 >= 0) {
				if (!isRoom(map[row - 1][col])) {
					if (isNinja(map[row - 1][col])) {
						if (spy.isInvincible()) {
							// The spy can not get stabbed or walk into another ninja.
							return 8;
						} else {
							stabSpy();
							return 4;
						}
					} else if (map[row - 1][col] instanceof Bullet) {
						if (spy.getBullets() < 1) {
							spy.addBullet();
							spy.setRow(row - 1);
							map[row - 1][col] = spy;
							map[row][col] = new Square(debug, row, col);
							return 5;
						}
					} else if (map[row - 1][col] instanceof Radar) {
						briefCaseRoom.setSymbol("*");
						spy.setRow(row - 1);
						map[row - 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
						return 6;
					} else if (map[row - 1][col] instanceof Invincibility) {
						spy.setInvincibility(true);
						spy.setRow(row - 1);
						map[row - 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
						return 7;
					} else {
						spy.setRow(row - 1);
						map[row - 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
					}
				} else {
					return 2;
				}
			} else {
				return 2;
			}
			break;
		case 2: // Move left
			if (col - 1 >= 0) {
				if (!isRoom(map[row][col - 1])) {
					if (isNinja(map[row][col - 1])) {
						if (spy.isInvincible()) {
							// The spy can not get stabbed or walk into another ninja.
							return 8;
						} else {
							stabSpy();
							return 4;
						}
					} else if (map[row][col - 1] instanceof Bullet) {
						if (spy.getBullets() < 1) {
							spy.addBullet();
							spy.setCol(col - 1);
							map[row][col - 1] = spy;
							map[row][col] = new Square(debug, row, col);
							return 5;
						}
					} else if (map[row][col - 1] instanceof Radar) {
						briefCaseRoom.setSymbol("*");
						spy.setCol(col - 1);
						map[row][col - 1] = spy;
						map[row][col] = new Square(debug, row, col);
						return 6;
					} else if (map[row][col - 1] instanceof Invincibility) {
						spy.setInvincibility(true);
						spy.setCol(col - 1);
						map[row][col - 1] = spy;
						map[row][col] = new Square(debug, row, col);
						return 7;
					} else {
						spy.setCol(col - 1);
						map[row][col - 1] = spy;
						map[row][col] = new Square(debug, row, col);
					}
				} else {
					return 2;
				}
			} else {
				return 2;
			}
			break;
		case 3: // Move down
			if (row + 1 <= 8) {
				if (!isRoom(map[row + 1][col])) {
					if (isNinja(map[row + 1][col])) {
						if (spy.isInvincible()) {
							// The spy can not get stabbed or walk into another ninja.
							return 8;
						} else {
							stabSpy();
							return 4;
						}
					} else if (map[row + 1][col] instanceof Bullet) {
						if (spy.getBullets() < 1) {
							spy.addBullet();
							spy.setRow(row + 1);
							map[row + 1][col] = spy;
							map[row][col] = new Square(debug, row, col);
							return 5;
						}
					} else if (map[row + 1][col] instanceof Radar) {
						briefCaseRoom.setSymbol("*");
						spy.setRow(row + 1);
						map[row + 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
						return 6;
					} else if (map[row + 1][col] instanceof Invincibility) {
						spy.setInvincibility(true);
						spy.setRow(row + 1);
						map[row + 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
						return 7;
					} else {
						spy.setRow(row + 1);
						map[row + 1][col] = spy;
						map[row][col] = new Square(debug, row, col);
					}
				} else if (isRoom(map[row + 1][col])) {
					// The spy can only enter the room from this north side by moving down.
					// Enter room, check for brief case.
					if (((Room) map[row + 1][col]).hasBriefCase()) {
						gameEndStatus = 1;
					} else {
						// Return code 3 if room is empty.
						return 3;
					}
				} else {
					return 2;
				}
			} else {
				return 2;
			}
			break;
		case 4: // Move right
			if (col + 1 <= 8) {
				if (!isRoom(map[row][col + 1])) {
					if (isNinja(map[row][col + 1])) {
						if (spy.isInvincible()) {
							// The spy can not get stabbed or walk into another ninja.
							return 8;
						} else {
							stabSpy();
							return 4;
						}
					} else if (map[row][col + 1] instanceof Bullet) {
						if (spy.getBullets() < 1) {
							spy.addBullet();
							spy.setCol(col + 1);
							map[row][col + 1] = spy;
							map[row][col] = new Square(debug, row, col);
							return 5;
						}
					} else if (map[row][col + 1] instanceof Radar) {
						briefCaseRoom.setSymbol("*");
						spy.setCol(col + 1);
						map[row][col + 1] = spy;
						map[row][col] = new Square(debug, row, col);
						return 6;
					} else if (map[row][col + 1] instanceof Invincibility) {
						spy.setInvincibility(true);
						spy.setCol(col + 1);
						map[row][col + 1] = spy;
						map[row][col] = new Square(debug, row, col);
						return 7;
					} else {
						spy.setCol(col + 1);
						map[row][col + 1] = spy;
						map[row][col] = new Square(debug, row, col);
					}
				} else {
					return 2;
				}
			} else {
				return 2;
			}
			break;
		}

		return 1;
	}

	/**
	 * The Spy can not overlap the room. Check if the object belongs to the Room
	 * class.
	 * @param location the Square object, a location on the map.
	 * @return true if the object has type Room.
	 */
	private boolean isRoom(Square location) {
		if (location instanceof Room) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if the object belongs to the PowerUp class.
	 * @param location the Square object, a location on the map.
	 * @return true if the object has type PowerUp.
	 */
	private boolean isPowerUp(Square location) {
		if (location instanceof PowerUp) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if the object belongs to the Ninja class.
	 * @param location the Square object, a location on the map.
	 * @return true if the object has type Ninja.
	 */
	private boolean isNinja(Square location) {
		if (location instanceof Ninja) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param square
	 */
	public void playerShoot(Square square) {

	}

	/**
	 * Move the all the ninjas in the game to random directions. 
	 * @return true if all ninjas moved successfully, false if foud a spy near by and stabbed him.
	 */
	public boolean moveNinja() {

		// Check if the ninja has steped on any power up last turn, assign them
		// back to their location.
		if (!powerUps.isEmpty()) {
			for (PowerUp p : powerUps) {
				map[p.getRow()][p.getCol()] = p;
			}
			powerUps.clear();
		}

		for (Ninja ninja : ninjas) {
			int row = ninja.getRow();
			int col = ninja.getCol();
			Square location = null;

			ArrayList<Square> validLocations = getValidLocations(ninja);

			// Remove all the rooms and ninjas locations from possible moves.
			Iterator<Square> iterator = validLocations.iterator();
			while (iterator.hasNext()) {
				Square loc = iterator.next();
				if (isRoom(loc) || isNinja(loc)) {
					iterator.remove();
				}
			}

			// The ninja can not stab the spy if the spy has invincibility.
			if (!spy.isInvincible()) {
				// If there's the spy next to this ninja, stab him!
				if (checkForSpy(ninja)) {
					return false;
				}
			} else {
				// Remove the spy location from ninja's possible moves when the spy is invincible.
				Iterator<Square> iter = validLocations.iterator();
				while (iterator.hasNext()) {
					Square loc = iter.next();
					if (loc instanceof Spy) {
						iterator.remove();
					}
				}
			}

			// If the ninja got place in the dead end corner and has no where to
			// move, it can stay in the same position.
			if (validLocations.size() < 3) {
				validLocations.add(map[row][col]);
			}

			// Choose one random direction from possible locations.
			int index = random.nextInt(validLocations.size());
			location = validLocations.get(index);

			int Lrow = location.getRow();
			int Lcol = location.getCol();

			if (isPowerUp(location)) {
				// If the ninja step on the power up, save the power up and
				// display the ninja.
				powerUps.add((PowerUp) location);
				map[Lrow][Lcol] = ninja;
				ninja.setRow(Lrow);
				ninja.setCol(Lcol);
				map[row][col] = new Square(debug, row, col);
			} else if (location == map[row][col]) {
				// If the ninja stay in the same postion, do nothing.
				map[row][col] = ninja;
			} else {
				map[Lrow][Lcol] = ninja;
				ninja.setRow(Lrow);
				ninja.setCol(Lcol);
				if (!isPowerUp(map[row][col])) {
					map[row][col] = new Square(debug, row, col);
				}
			}
		}

		return true;
	}

	/**
	 * Check for array out of bound, get only the moveable locations from the current location.
	 * @param object the Square object of the location on the map.
	 * @return the ArrayList of valid locations.
	 */
	private ArrayList<Square> getValidLocations(Square object) {
		int row = object.getRow();
		int col = object.getCol();
		ArrayList<Square> validLocations = new ArrayList<Square>();

		// Only add reachable directions to the array.
		if (row - 1 >= 0 && col <= 8 & col >= 0) {
			validLocations.add(map[row - 1][col]);
		}
		if (row + 1 <= 8 && col <= 8 & col >= 0) {
			validLocations.add(map[row + 1][col]);
		}
		if (col - 1 >= 0 && row >= 0 && row <= 8) {
			validLocations.add(map[row][col - 1]);
		}
		if (col + 1 <= 8 && row >= 0 && row <= 8) {
			validLocations.add(map[row][col + 1]);
		}

		return validLocations;
	}

	/**
	 * Check the surround locations of this ninja. If there is the spy next to
	 * it, the spy got stabbed! Reset the spy to it's starting postion, minus
	 * one live.
	 * @param ninja the Ninja object.
	 * @return true if the spy got stabbed.
	 */
	public boolean checkForSpy(Ninja ninja) {
		ArrayList<Square> validLocations = getValidLocations(ninja);
		for (Square loc : validLocations) {
			if (loc instanceof Spy) {
				stabSpy();
				return true;
			}
		}
		return false;
	}

	/**
	 * Stab the spy, move back to original postion, minus on live. Clear the spy
	 * off the current position on the map.
	 */
	private void stabSpy() {
		int oldRow = spy.getRow();
		int oldCol = spy.getCol();
		spy.getStabbed();
		int spyLives = spy.getLives();
		if(spyLives == 0){
			gameEndStatus = 2;
		}
		map[8][0] = spy;
		spy.setRow(8);
		spy.setCol(0);
		map[oldRow][oldCol] = new Square(debug, oldRow, oldCol);
	}

	/**
	 * Check for the winning condition of the game.
	 * @return and integer for game end status code: 1-found the briefcase, 2-got stabbed to death.
	 */
	public int gameOver() {
		return gameEndStatus;
	}

	/**
	 * Return the spy in the current game.
	 * @return the Spy object.
	 */
	public Spy getSpy() {
		return spy;
	}
	
	/**
	 * Return the number of the turn of the the spy's invincibility.
	 * @return an int from 0-5
	 */
	public int getInvincibilityTurns() {
		return invincibilityTurns;
	}
	
	/**
	 * Return the status of the debug mode.
	 * @return true if debug mode is activated.
	 */
	public boolean getDebug() {
		return debug;
	}

}
