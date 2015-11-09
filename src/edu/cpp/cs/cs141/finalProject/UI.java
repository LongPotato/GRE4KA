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
		game.fillMapWithSquare();
        game.setUpMap();
        
        printWelcomeMessage();
        int choice = mainMenu();
        switch (choice) {
        case 1:
        	printMap(game.getMap());
        	gameLoop();
        	break;
        case 2:
        	game.activateDebugMode();
        	printMap(game.getMap());
        	gameLoop();
        	break;
        default:
        	System.out.println("Game exited!");
        	break;
        }
        	
	}
	
	/**
	 * Display the welcome message at the beginning of the game.
	 */
	private void printWelcomeMessage() {
		System.out.println("========================");
        System.out.println("*   FIND YOUR GRE4KA   *");
        System.out.println("========================");
	}
	
	private int mainMenu() {
		int option = 3;
		System.out.println("Select an option:");
		System.out.println("1, New game");
		System.out.println("2, Debug mode");
		System.out.println("3, Quit");
		
		option = input.nextInt();
		input.nextLine();
		//TODO: implement input validation.
		return option;
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
		// For each case, call the corresponding engine method to perform the action
		// ...
	}
	
	/**
	 * Print out the game map.
	 * @param map the initialized 2 dimensional array.
	 * @param debug true if debug mode is activated.
	 */
	public void printMap(Square[][] map) {
		String display = "X";
		for (Square[] row : map) {
			for (Square location : row) {
				if (location.isVisible()) {
					display = location.getSymbol();
					// Clear out all the "X"
					if (location.getSymbol().equals("X")) {
						display = " ";
					}
				} else {
					// If the object is not visible, display "X"
					display = "X";
				}
				System.out.print("[" + display + "] ");
			}
			System.out.println("\n");
		}
	}
	
}
