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
 * The main method, where the program get executed.
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Press T to play in text mode or G to play in GUI mode.\n\nAny other button will close the program.");
		String choice = scan.next();
		choice = choice.toUpperCase();
		
		switch(choice) {
		case "T":
			UI ui = new UI();
			ui.startGame();
			break;
		case "G":
			GUI gui = new GUI();
			gui.startGame();
			break;
		default:
			System.out.println("Game exited!");
			System.exit(0);
		}
		
		scan.close();	
				
		System.out.println("Game exited!");
	}

}