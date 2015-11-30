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
 * The UI class for handling the console interface. Take user input, print out
 * game information.
 */
public class UI {

	private Scanner input = new Scanner(System.in);
	private Engine game = null;
	
	/**
	 * To check if the user input actually want to move the spy, not open option menu.
	 */
	private boolean validMove = true;
	private boolean hardMode = true;
	/**
	 * Starts up the game: initialize the game engine, set up the game map, get
	 * users preferences, and execute the game loop logic.
	 */
	public void startGame() {
		String repeat = "";
		
		
		do{
			// Clear the screen.
			if(repeat.toLowerCase().equals("y")) {
				for(int i = 0; i < 50; ++i)
					System.out.println();
			}
		        
		    printWelcomeMessage();
		    int choice = mainMenu();
		    switch (choice) {
		    case 1:
				getGameModeOption();
				System.out.println(hardMode);
				game = new Engine();
				// Fill & set up the map with game objects.
				game.fillMapWithSquare();
			    game.setUpMap();
			    
		    	gameLoop();
		        break;
		    case 2:
				game = new Engine();
				// Fill & set up the map with game objects.
				game.fillMapWithSquare();
			    game.setUpMap();
			    
		    	game.activateDebugMode();
		    	printSecretRoom();
		    	gameLoop();
		    	break;
		    case 3:
		    	// Load the stored game object.
		    	game = Save.loadGame();
		    	gameLoop();
		    	break;
		    default:
		    	System.out.println("Game exited!");
		    	System.exit(0);
		    	break;
		    }
			System.out.print("Game over. Play again? (y/n):");
			repeat = input.nextLine();
		} while(repeat.toLowerCase().equals("y"));
	}

	/**
	 * Display the location of the room that contains the briefcase.
	 */
	private void printSecretRoom() {
		Room secretRoom = game.getRoomWithBriefCase();
		System.out.println(
				"The room that has your Gre4ka is at " + secretRoom.getRow() + " " + secretRoom.getCol() + "\n");
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
	 * 
	 * @return an integer.
	 */
	private int mainMenu() {
		int option = 3;
		boolean valid = false;
		System.out.println("Select an option:");
		System.out.println("1. New game");
		System.out.println("2. Debug mode");
		System.out.println("3. Load game");
		System.out.println("4. Quit");

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
	 * Using the game engine field, play until the game is over. Keep printing
	 * out map and getting user input, pass it into the game engine to handle
	 * the logic.
	 */
	private void gameLoop() {
		while(game.gameOver() == 0) {
			printMap(game.getMap());
			printGameInfo(game);

			getPlayerDecision();
			
			// If the user actually want to move a spy, move the ninjas.
			if(hardMode){
				if (validMove) {
					if (!game.moveSmartNinja()) {
						printSpyGotStabMessage();
					}
					if (!game.getDebug()) {
						game.assignSpyVisibility();
					}
				}
			} else {
				if (validMove) {
					if (!game.moveNinja()) {
						printSpyGotStabMessage();
					}
					if (!game.getDebug()) {
						game.assignSpyVisibility();
					}
				}
			}
		}

		if (game.gameOver() == 1) {
			System.out.println("YOU HAVE FOUND THE GRE4KA. YOU WIN!");
		}
		if (game.gameOver() == 2) {
			System.out.println("YOU HAVE DIED TOO MANY TIMES. YOU LOSE!");
		}
	}

	/**
	 * Get the use input: moving direction, shooting direction. Call the
	 * corresponding method from the engine to perform the action.
	 */
	private void getPlayerDecision() {
		String directionM = "";
		int status;
		boolean valid = false;
		System.out.println("What do you want to do? "
				+ "Enter W to move up, A to move left, S to move down, D to move right or P to shoot, press M for more options:");
		
		do {
			directionM = input.nextLine();
			directionM = directionM.toUpperCase();

			switch (directionM) {
			case "W":
				validMove = true;
				// Move up
				status = game.movePlayer(1);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					printActivateBulletMessage();
					valid = true;
				} else if (status == 6) {
					printActivateRadarMessage();
					valid = true;
				} else if (status == 7) {
					printActivateInvincibilityMessage();
					valid = true;
				} else if (status == 4) {
					printSpyGotStabMessage();
					valid = true;
				} else {
					System.out.println("Can not go there! Try again: ");
				}
				break;
			case "A":
				validMove = true;
				// Move left
				status = game.movePlayer(2);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					printActivateBulletMessage();
					valid = true;
				} else if (status == 6) {
					printActivateRadarMessage();
					valid = true;
				} else if (status == 7) {
					printActivateInvincibilityMessage();
					valid = true;
				} else if (status == 4) {
					printSpyGotStabMessage();
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "S":
				validMove = true;
				// Move down
				status = game.movePlayer(3);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					printActivateBulletMessage();
					valid = true;
				} else if (status == 6) {
					printActivateRadarMessage();
					valid = true;
				} else if (status == 7) {
					printActivateInvincibilityMessage();
					valid = true;
				} else if (status == 4) {
					printSpyGotStabMessage();
					valid = true;
				} else if (status == 3) {
					System.out.print("This room is empty, keep going: ");
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "D":
				validMove = true;
				// Move right
				status = game.movePlayer(4);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					printActivateBulletMessage();
					valid = true;
				} else if (status == 6) {
					printActivateRadarMessage();
					valid = true;
				} else if (status == 7) {
					printActivateInvincibilityMessage();
					valid = true;
				} else if (status == 4) {
					printSpyGotStabMessage();
					valid = true;
				} else {
					System.out.print("Can not go there! Try again: ");
				}
				break;
			case "P":
				validMove = true;
				//Shoot
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0)
					getShootDirection();
				else
					System.out.println("\nYOU DON'T HAVE ANY BULLETS!\n\n");
				valid = true;
				break;
			case "M":
				validMove = false;
				// More options.
				getOptionInput();
				valid = true;
				break;
			default:
				System.out.println("Invalid Entry. Try Again.");
				break;
			}
		} while (!valid);
	}

	/**
	 * Print out the game map.
	 * 
	 * @param map
	 *            the initialized 2 dimensional array.
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

	/**
	 * Display the game informtaion: number of lives, number of bullets, how
	 * many turn of invicibility if activated.
	 * 
	 * @param game the game engine of the current game.
	 */
	public void printGameInfo(Engine game) {
		System.out.println("------------------");
		if (game.getSpy().isInvincible()) {
			System.out.println("Invincible for: " + game.getInvincibilityTurns() + " turns");
		}
		System.out.println("Lives: " + game.getSpy().getLives());
		System.out.println("Bullets: " + game.getSpy().getBullets());
		System.out.println("------------------");
	}

	/**
	 * Print out the message to notify the player that the spy got stabbed by a
	 * ninja. User need to press any key to acknowledge the information.
	 */
	public void printSpyGotStabMessage() {
		System.out.println("\nYOU GOT STABBED BY A NINJA!\n\n");
		System.out.println("Press enter to countinue...");
		input.nextLine();
	}

	/**
	 * Print out the message to notify the player that he activated the Bullet
	 * power up. User need to press any key to acknowledge the information.
	 */
	public void printActivateBulletMessage() {
		System.out.println("\nYOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY\n\n");
		System.out.println("Press enter to countinue...");
		input.nextLine();
	}

	/**
	 * Print out the message to notify the player that he activated the Radar
	 * power up. User need to press any key to acknowledge the information.
	 */
	public void printActivateRadarMessage() {
		System.out.println("\nYOU HAVE FOUND A RADAR!\n\n");
		printSecretRoom();
		System.out.println("Press enter to countinue...");
		input.nextLine();
	}

	/**
	 * Print out the message to notify the player that he activated the
	 * Invincibility power up. User need to press any key to acknowledge the
	 * information.
	 */
	public void printActivateInvincibilityMessage() {
		System.out.println("\nYOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS\n\n");
		System.out.println("Press enter to countinue...");
		input.nextLine();
	}
	
	/**
	 * Ask and handle the input of the direction that player want to shoot.
	 * Handle the return status code from the game engine and print out the information about shot missed or killed a ninja.
	 */
	public void getShootDirection() {
		int parameter = 0;
		boolean valid = false;
		
		do{
			System.out.println("Which direction would you like to shoot?");
			String direction = input.nextLine().toUpperCase();
			switch (direction) {
			case "W":
				parameter = 1;
				valid = true;
				break;
			case "A":
				parameter = 2;
				valid = true;
				break;
			case "S":
				parameter = 3;
				valid = true;
				break;
			case "D":
				parameter = 4;
				valid = true;
				break;
			default:
				parameter = 0;
				valid = false;
				break;
			}
		} while(!valid);
		
		int status = game.shootNinja(parameter);
		
		if(status == 1) {
			System.out.println("\nYOU HAVE KILLED A NINJA!\n\n");
			System.out.println("Press enter to countinue...");
			input.nextLine();
		} else {
			System.out.println("\nYOUR SHOT MISSED EVERYTHING\n\n");
			System.out.println("Press enter to countinue...");
			input.nextLine();
		}
	}
	
	/**
	 * Get and handle user input for more options such as activate debug mid game, save game, quit game...
	 */
	void getOptionInput() {
		String choice;
		boolean valid = false;
		
		System.out.println("More options: ");
		System.out.println("1. Activate debug mode.");
		System.out.println("2. Save game.");
		System.out.println("3. Quit.");
		
		do {
			choice = input.nextLine();
			
			switch(choice) {
			case "1":
				game.activateDebugMode();
		    	printSecretRoom();
		    	valid = true;
		    	break;
			case "2":
				// Save the current game object to a file.
				Save.saveGame(game);
				valid = true;
				break;
			case "3":
				System.out.println("Game exited!");
				System.exit(0);
				valid = true;
				break;
			default:
				System.out.println("Invalid Entry. Try Again.");
				break;
			} 
		} while (!valid);
	}
	
	/**
	 * 
	 */
	private void getGameModeOption(){
		String choice;
		boolean valid = false;
		
		System.out.println("Which Mode?:");
		System.out.println("1. Regular Mode");
		System.out.println("2. Hard Mode");
		
		
		do{
			choice = input.nextLine();
			
			switch(choice){
			case "1":
				hardMode = false;
				valid = true;
				break;
			case "2":
				hardMode = true;
				valid = true;
				break;
			default:
				System.out.println("Invalid Entry. Try Again.");
				break;
			}
		} while (!valid);
		
		
	}
}
