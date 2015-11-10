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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The UI class for handling the console interface.
 * Take user input, print out game information.
 */
public class UI {
	
	private Scanner input = new Scanner(System.in);
	private Engine game = null;

	/**
	 * Starts up the game: initialize the game engine, set up the game map, get users preferences, 
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
        	gameLoop();
        	break;
        case 2:
        	game.activateDebugMode();
        	printSecretRoom();
        	gameLoop();
        	break;
        default:
        	System.out.println("Game exited!");
        	break;
        }
        	
	}
	
	/**
	 * Display the location of the room that contains the briefcase.
	 */
	private void printSecretRoom() {
		Room secretRoom = game.getRoomWithBriefCase();
		System.out.println("The room that has your Gre4ka is at " 
							+ secretRoom.getRow() + " " + secretRoom.getCol() + "\n");
	}

	/**
	 * Display the welcome message at the beginning of the game.
	 */
	private void printWelcomeMessage() {
		System.out.println("========================");
        System.out.println("*   FIND YOUR GRE4KA   *");
        System.out.println("========================");
	}
	
	/**
	 * The main menu for selection at the beginning of the game.
	 * @return an integer.
	 */
	private int mainMenu() {
		int option = 3;
		boolean valid = false;
		System.out.println("Select an option:");
		System.out.println("1. New game");
		System.out.println("2. Debug mode");
		System.out.println("3. Quit");
		
		while (!valid) {
			try {
				option = input.nextInt();
				input.nextLine();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.print("Invalid input, select again: ");
				input.nextLine();
			}
		}	
		return option;
	}

	/**
	 * Using the game engine field, play until the game is over.
	 * Keep printing out map and getting user input, pass it into the game engine to handle the logic.
	 */
	private void gameLoop() {
		String choice = "";
		
		while(!game.gameOver()) {
			boolean valid = false;
			
			printMap(game.getMap());
			
			do {
				System.out.println("What would you like to do? Type M for move, S for shoot.");
				choice = input.nextLine();
				choice = choice.toUpperCase();
				
				switch (choice) {
				case "M":
					getPlayerMovement();
					valid = true;
					break;
				case "S":
					playerShoot();
					valid = true;
					break;
				default:
					System.out.println("Incorrect Entry. Try Again.");
					break;
				}
			} while (!valid);
		}
	}
	
	/**
	 * 
	 */
	private void playerShoot() {
		// TODO The same as getPlayerMovement?
		
	}

	/**
	 * Get which direction the player will move via user input
	 * and then runs the corresponding method in class Engine.
	 */
	private void getPlayerMovement() {
		String directionM = "";
		boolean valid = false;
		System.out.println("Which direction would you like to move? "
				+ "Enter W to move up, A to move left, S to move down, and D to move right.");
		
		do {
			directionM = input.nextLine();
			directionM = directionM.toUpperCase();
			
			switch (directionM) {
			case "W":
				// Move up
				if (game.movePlayer(1)) {
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "A":
				// Move left
				if (game.movePlayer(2)) {
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "S":
				// Move down
				if (game.movePlayer(3)) {
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "D":
				// Move right
				if (game.movePlayer(4)) {
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			default:
				System.out.println("Invalid Entry. Try Again.");
				break;
			}
		} while (!valid);
	}

	/**
	 * Print out the game map.
	 * @param map the initialized 2 dimensional array.
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
