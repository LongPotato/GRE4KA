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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The UI class for handling the console interface. Take user input, print out
 * game information.
 */
public class GUI implements KeyListener {
	
	private Engine game = new Engine();
	private Spy spy = new Spy(8,0);
	private JPanel panel = new JPanel(new GridLayout(9,9));
	private JPanel HUD = new JPanel(new BorderLayout());
	private JFrame frame = new JFrame("Find Your GRE4KA");
	
	public void startGame() {
		game.fillMapWithSquare();
		game.setUpMap();
		JMenuBar menuBar = new JMenuBar();
    	JMenu options = new JMenu("Options");
    	JMenu help = new JMenu("Help");
    	
    	menuBar.add(options);
    	menuBar.add(help);
    	
    	JMenuItem newGame = new JMenuItem("New Game");
    	newGame.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			game = new Engine();
    			JOptionPane.showMessageDialog(frame, "NEW GAME!!");
    			//paint(0);
    		}
    	
    	});
    	
    	JMenuItem quit = new JMenuItem("Quit");
    	quit.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame,"GAME HAS QUIT!!");
    			System.exit(0);
    		}
    	
    	});
    	
    	JMenuItem about = new JMenuItem("About");
    	about.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Development Team:\n\nMario Garcia\nAnuja Joshi\nMichelle Duong\nKristin Adachi\nMatthew Musquiz");
    		}
    	
    	});
    	
    	JMenuItem howtoplay = new JMenuItem("How To Play");
    	howtoplay.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Move with the following keys:\nUP_ARROW - move up\nDOWN_ARROW - move down\nLEFT_ARROW - move left\nRIGHT_ARROW - move right"
    					+ "\n\nPowerups:\nInvincibility - Invincible for 5 turns\nRadar - Reveal the location of the document\nAmmo Increase - Increase your ammo count by 1"
    					+ "\n\nShooting: " + "\nW - shoot up\nS - shoot down\nA - shoot left\nD - shoot right\n\nSearching Tile Spaces:\n\n1 - Look Up\n2 - Look Down\n3 - Look Left \n4 - Look Right"
    					+"\n\nLook for the document hiding in one of these rooms\nWatch for ninjas, they want to rek you.");
    		}
    	
    	});

    	options.add(newGame);
    	//options.add(save);
    	//options.add(load);
    	options.add(quit);
    	help.add(about);
    	help.add(howtoplay);
    	
    	frame.setJMenuBar(menuBar);
		printMap(game.getMap());;
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setHUD();
		frame.add(HUD, BorderLayout.SOUTH);
    	frame.add(panel);
    	frame.pack();
    	frame.setVisible(true);
    	frame.setSize(470, 650);

	}
	
	public void printMap(Square[][] map) {
		JLabel display = new JLabel(new ImageIcon("GamePics/blank.jpg"));
		for (Square[] row : map) {
			for (Square location : row) {
				if (location.isVisible()) {
					String symbol = location.getSymbol();
					if (symbol.equals("R"))
						display = new JLabel(new ImageIcon("GamePics/room.jpg"));
					else if (symbol.equals("S"))
						display = new JLabel(new ImageIcon("GamePics/spy.jpg"));
					// Clear out all the "X"
					if (location.getSymbol().equals("X")) {
						display = new JLabel(new ImageIcon("GamePics/shown.png"));
					}
				} else {
					// If the object is not visible, display "X"
					display = new JLabel(new ImageIcon("GamePics/blank.jpg"));
				}
				panel.add(display);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setHUD()
	{
		int lives = spy.getLives();
		int bullets = spy.getBullets();
		int invincible = game.getInvincibilityTurns();
		
		HUD.removeAll();
	    JLabel HUDLives = new JLabel("Lives: " + lives);
	    JLabel HUDBullets = new JLabel("Bullets: " + bullets);
	    JLabel HUDInv = new JLabel("Turns of invincibility: " + invincible);
		HUD.add(HUDLives, BorderLayout.PAGE_START);
		HUD.add(HUDBullets, BorderLayout.SOUTH);
		HUD.add(HUDInv, BorderLayout.CENTER);
		HUD.revalidate();
	}
}
