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

import java.util.Scanner;

/**
 * The UI class for handling the console interface.
 * Take user input, print out game information.
 */
public class UI {
	
	private Scanner input = new Scanner(System.in);
	private Engine game = null;

	/**
	 * Starts up the game: set up the game map, get users preferences,
	 * and execute the game loop logic.
	 */
	public void startGame() {
		game = new Engine();
		// Fill & set up the map.
		game.fillMap();
        game.setUpMap();
        printMap(game.getMap());
		// Welcome message.
		// Input choices to play in the console or GUI or quit.
		// ...
	}
	
	/**
	 * Play until the game is over.
	 * Keep printing out map and getting user input, pass it into the game engine to handle the logic.
	 */
	public void gameLoop() {
		// Keep looping until game is over
		// Call out printMap() each turn.
		// Get user input for moving up, down, shoot, etc,...
		// Make a switch case to handle different input
		// For each case, call the coresponding engine method to perform the action
		// ...
	}
	
	/**
	 * Print out the game map.
	 * @param gameMap the initialized 2 dimensional array.
	 */
	public void printMap(Square[][] map){
		for (Square[] row : map) {
			for (Square location : row) {
				System.out.print("[" + location.getSymbol() + "] ");
			}
			System.out.println("\n");
		}
	}
	
}
