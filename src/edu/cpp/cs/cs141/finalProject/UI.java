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
	
	/**
	 * Print out welcome message at the start of the game.
	 * Take user input the choose between playing in the console or GUI.
	 * ....
	 */
	public void startGame() {
		// Create new game engine.
		// Fill up the map.
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
	 */
	public void printMap(){
		
	}
	
}
