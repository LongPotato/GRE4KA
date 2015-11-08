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
	 * The array to store all the asigned room objects on the map.
	 */
	private Square[] rooms = new Square[9];
	/**
	 * To randomize the position of the map.
	 */
	private Random random = new Random();
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
	 * Set up the map with 3 different types of powerup, 1 spy, 6 ninjas, and 9 rooms.
	 */
	public void setUpMap() {
		assignRooms();
		Spy spy = assignSpy();
		assignSpyVisibility(spy);
		assignBullet();
		//TODO: assign Invincibility, and assign Radar power up here.
		assignNinjas();
	}

	/**
	 * Put 9 rooms at fixed locations on the map.
	 */
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
		
		// Add room locations to used locations array to avoid overlap when assign other objects to the map.
		Square[] tempArray = {map[1][1], map[1][4], map[1][7], map[4][1], map[4][4], map[4][7], map[7][1], map[7][4], map[7][7]};
		rooms = tempArray;
		occupiedLocations.addAll(Arrays.asList(rooms));
	}

	/**
	 * Initially create new Spy object and put him at the corner of the map.
	 * @return the spy object at location [8][0]
	 */
	public Spy assignSpy() {
		Spy spy = new Spy(8, 0);
		map[8][0] = spy;
		occupiedLocations.add(map[8][0]);
		return spy;
	}

	/**
	 * This method allows the spy to see ahead 2 squares.
	 * Remove the darkness mark "X", and switch the visibility of ninjas, powerups to true if they are nearby.
	 * @param spy the Spy object.
	 */
	public void assignSpyVisibility(Spy spy) {
		//TODO: Traverse through the spyVisibilityLocations array to switch visibility location from previous turn to false.
		
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (i == spy.getRow() && abs(spy.getCol() - j) < 3) {
					
					//TODO: Check for ninjas and powerups near by to switch their visibility to true.
					
					if (map[i][j].getSymbol().equals("X")) {
						map[i][j].setSymbol(" ");
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					} else
						map[i][j].getSymbol();
				}
				if (j == spy.getCol() && abs(spy.getRow() - i) < 3) {

					if (map[i][j].getSymbol().equals("X")) {
						map[i][j].setSymbol(" ");
						map[i][j].setVisible(true);
						spyVisibilityLocations.add(map[i][j]);
					} else
						map[i][j].getSymbol();
				}
			}
		}
	}
	
	/**
	 * Put one Bullet object at a random location on the map.
	 */
	public void assignBullet(){
		Bullet bullet;
		int rRow;
		int rCol;
		
		do{
			rRow = random.nextInt(8);
			rCol = random.nextInt(8);
		} while(isOccupied(rRow, rCol));
		
		bullet = new Bullet(rRow, rCol);
		map[rRow][rCol] = bullet;
		occupiedLocations.add(map[rRow][rCol]);
	}
	
	/**
	 * Check the postion on the map too see if it's occupied by other game object.
	 * @param row a number from 0-8
	 * @param col a number from 0-8
	 * @return true if the position is occupied.
	 */
	public boolean isOccupied(int row, int col){
		if(occupiedLocations.contains(map[row][col])){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Put 6 ninja into different random postions on the map.
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
			do{
				rRow = random.nextInt(8);
				rCol = random.nextInt(8);
			} while(isOccupied(rRow, rCol));
			
			Ninja ninja = new Ninja(rRow, rCol);
			map[rRow][rCol] = ninja;
			occupiedLocations.add(map[rRow][rCol]);
		}
	}
	
	/**
	 * Activiate Debug mode, switch the visible field of all game objects to true.
	 * All game objects will be visible.
	 */
	public void activateDebugMode() {
		for (Square[] locations : map) {
			for (Square location : locations) {
				location.setVisible(true);
			}	
		}
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
