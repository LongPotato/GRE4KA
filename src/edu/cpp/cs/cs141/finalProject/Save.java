package edu.cpp.cs.cs141.finalProject;

import java.io.*;
import java.util.Scanner;

public class Save implements Serializable {

	public void saveGame(Engine game) {
		try {
			FileOutputStream fos = new FileOutputStream("GameSave.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(game);

			fos.close();
			oos.close();

			// } catch (ClassNotFoundException e){
			// System.out.println("The class is not found" + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadGame(Engine game) {

		try {
			FileInputStream fis = new FileInputStream("GameSave.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Save object = (Save) ois.readObject();

			fis.close();
			ois.close();

		} catch (ClassNotFoundException e) {
			System.out.println("The class is not found" + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
