package edu.cpp.cs.cs141.finalProject;

import java.io.*;
import java.util.Scanner;

public class Save implements Serializable {

	public void saveGame(String filename, Engine game) {
		try {
			FileOutputStream fos = new FileOutputStream(filename + ".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(game);

			fos.close();
			oos.close();

		} catch (FileNotFoundException e) {
			System.err.println("The file is not found" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Engine loadGame(String filename) {
		
		Engine game = null;

		try {
			FileInputStream fis = new FileInputStream(filename + ".dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Engine engine = (Engine)ois.readObject();
			game = engine;
			fis.close();
			ois.close();

		} catch (FileNotFoundException e) {
			System.err.println(filename + ".dat is not found");
			game = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			return game;
			}
		return game;
		}
}
