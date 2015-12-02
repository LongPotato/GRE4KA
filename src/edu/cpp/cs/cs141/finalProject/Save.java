package edu.cpp.cs.cs141.finalProject;

import java.io.*;

/**
 * This class handle the save and load funtion of the game.
 * It saves the game object to a file or retrieve the game object from the file.
 * Default file name: "GameSave.dat"
 */
public class Save implements Serializable {

	/**
	 * Generated serial key.
	 */
	private static final long serialVersionUID = 6748448343229471723L;

	/**
	 * Save the game engine to a file.
	 * @param game the game engine object.
	 */
	public static void saveGame(Engine game) {
		try {
			FileOutputStream fos = new FileOutputStream("GameSave.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(game);

			fos.close();
			oos.close();
			
			System.out.println("Game saved!\n");
		} catch (IOException e) {
			System.out.println("There is an error. Can not save this game!\n");
			e.printStackTrace();
		}
	}

	/**
	 * Load the game engine from a file.
	 * @return a game engine object.
	 */
	public static Engine loadGame() {
		
		Engine game = new Engine();

		try {
			FileInputStream fis = new FileInputStream("GameSave.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Engine engine = (Engine) ois.readObject();
			game = engine;
			fis.close();
			ois.close();
			
			System.out.println("Game loaded!\n");
		
		// If can not find the game file, initialize a new game
		} catch (IOException e) {
			System.out.println("Can not find the game! Starting new game..\n");
			game.fillMapWithSquare();
		    game.setUpMap();
		} catch (ClassNotFoundException e) {
			System.out.println("Can not find the game! Starting new game..\n");
			game.fillMapWithSquare();
		    game.setUpMap();
		}
		
		return game;
	}
}
