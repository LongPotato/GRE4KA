/**
 * 
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodriguez
 *
 * Programming Assignment Гречка
 *
 * <Create an Assassin game,
 *  where the player is a spy
 *  that is trying to get the briefcase with documents
 *  and the ninja assassins are trying to catch him.>
 *
 * Team Гречка 
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
	
	private Engine game;
	private Spy spy = new Spy(8,0);
	
	/**
	 * Variables panel, HUD, and frame are constructors for the GUI frame
	 */
	private JPanel panel = new JPanel(new GridLayout(9,9));
	private JPanel HUD = new JPanel(new BorderLayout());
	private JFrame frame = new JFrame("Find Your Гречка");
	
	private boolean validMove = true;
	private boolean hardMode = false;
	private int parameter = 0;
	
	/**
	 * This method is called from Main and creates the JFrame GUI as well as initializing the gameboard.
	 */
	public void startGame() {
		game = new Engine();
		game.fillMapWithSquare();
		game.setUpMap();
		
		JMenuBar menuBar = new JMenuBar();
    	JMenu options = new JMenu("Options");
    	JMenu help = new JMenu("Help");
    	
    	menuBar.add(options);
    	menuBar.add(help);
    	
    	JMenuItem newGameEasy = new JMenuItem("New Game-Easy");
    	newGameEasy.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			game = new Engine();
    			game.fillMapWithSquare();
    			game.setUpMap();
    			
    			JOptionPane.showMessageDialog(frame, "Launching game on Easy.");
    			printMap(game.getMap());
    			setHUD();
    		}
    	
    	});
    	
    	JMenuItem newGameHard = new JMenuItem("New Game-Hard");
    	newGameHard.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			game = new Engine();
    			game.fillMapWithSquare();
    			game.setUpMap();
    			hardMode = true;
    			
    			JOptionPane.showMessageDialog(frame, "Launching game on Hard.");
    			printMap(game.getMap());
    			setHUD();
    		}
    	
    	});
    	
    	JMenuItem newDebugGame = new JMenuItem("Activate Debug Mode");
    	newDebugGame.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Activating Debug Mode");
    			game.activateDebugMode();
    			
    			printMap(game.getMap());
    		}
    	
    	});
    	
    	JMenuItem save = new JMenuItem("Save Game");
    	save.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			Save.saveGame(game);
    			JOptionPane.showMessageDialog(frame,"Your game has been saved.");
    			printMap(game.getMap());
    		}
    	
    	});
    	
    	JMenuItem load = new JMenuItem("Load Game");
    	load.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			game = Save.loadGame();
    			JOptionPane.showMessageDialog(frame,"Your game has been loaded.");
    			printMap(game.getMap());
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
    			JOptionPane.showMessageDialog(frame, "You are a spy in a dark room, but you are not alone. \nThere are 6 retail ninjas in the room with you."
    					+ "\nThis room is 90 yards square, \nwith 9 smaller rooms spread out within it.\n" 
    					+ "Your Mission, should you choose to accept it, \nis to infiltrate this room and find the gre4ka \nhidden in one of the smaller rooms."
    					+ "\n\nGood Luck, Have Fun!");
    		}
    	
    	});
    	
    	JMenuItem crdits = new JMenuItem("Credits");
    	crdits.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Development Team:\n\nAlexandra Klimenko\nVictor Ruiz\nKhanh Nyguyen\nIan Garrett");
    		}
    	
    	});
    	
    	JMenuItem howtoplay = new JMenuItem("How To Play");
    	howtoplay.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Move with the following keys:\nW - move up\nS - move down\nA - move left\nD - move right"
    					+ "\n\nPowerups:\nInvincibility - Invincible for 5 turns\nRadar - Reveal the location of the document\nAmmo Increase - Increase your ammo count by 1"
    					+ "\n\nShooting:" + "\nUP_Arrow - shoot up\nDOWN_ARROW - shoot down\nLEFT_ARROW - shoot left\nRIGHT_ARROW - shoot right"
    					+"\n\nLook for the document hiding in one of these rooms\nWatch out for ninjas, they want to shank you.");
    		}
    	
    	});

    	//Create and display the JFrame
    	options.add(newGameEasy);
    	options.add(newGameHard);
    	options.add(newDebugGame);
    	options.add(save);
    	options.add(load);
    	options.add(quit);
    	help.add(about);
    	help.add(howtoplay);
    	help.add(crdits);
    	
    	frame.setJMenuBar(menuBar);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(HUD, BorderLayout.SOUTH);
    	frame.add(panel);
    	frame.pack();
    	frame.setVisible(true);
    	frame.setSize(925, 850);
    	
    	printMap(game.getMap());
    	setHUD();

	}
	
	/**
	 * This method prints the game board within the JFrame GUI and handles Image Icons.
	 * @param map
	 */
	public void printMap(Square[][] map) {
		//int counter = 1;
		panel.removeAll();
		JLabel display = new JLabel(new ImageIcon("GamePics/blank.jpg"));
		for (Square[] row : map) {
			for (Square location : row) {
				if (location.isVisible() || game.getDebug()) {
					
					String symbol = location.getSymbol();
					switch(symbol) {
					case "*":
						display = new JLabel(new ImageIcon("GamePics/gre4ka.jpg"));
						break;
					case "R":
						display = new JLabel(new ImageIcon("GamePics/room.jpg"));
						break;
					case "S":
						display = new JLabel(new ImageIcon("GamePics/spy.jpg"));
						break;
					case "N":
						//String number = Integer.toString(counter);
						display = new JLabel(new ImageIcon("GamePics/ninja1.jpg"));
						//counter++;
						break;
					case "I":
						display = new JLabel(new ImageIcon("GamePics/invincibility.jpg"));
						break;
					case "B":
						display = new JLabel(new ImageIcon("GamePics/bullet.jpg"));
						break;
					case "D":
						display = new JLabel(new ImageIcon("GamePics/radar.png"));
						break;
					default:
						display = new JLabel(new ImageIcon("GamePics/show2.jpg"));
						break;
					}
				} else {
					display = new JLabel(new ImageIcon("GamePics/blank.jpg"));
				}
				panel.add(display);
				panel.validate();
			}
		}
		
	}

	/**
	 * This method picks up when the user hits a key and runs the appropriate code to move or shoot.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int status;
			//Move up
			if(e.getKeyCode() == KeyEvent.VK_W) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				status = game.movePlayer(1);
				if (status == 1) {
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
				} else {
					JOptionPane.showMessageDialog(frame, "Can not go there! Try again: ");
				}
				
				if(hardMode){
					if (validMove) {
						if (!game.moveSmartNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				} else {
					if (validMove) {
						if (!game.moveNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				}
				
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			// Move left
			else if(e.getKeyCode() == KeyEvent.VK_A) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				status = game.movePlayer(2);
				if (status == 1) {
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
				} else {
					JOptionPane.showMessageDialog(frame, "Can not go there! Try again: ");
				}
				if(hardMode){
					if (validMove) {
						if (!game.moveSmartNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				} else {
					if (validMove) {
						if (!game.moveNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				}
				
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Move down
			else if(e.getKeyCode() == KeyEvent.VK_S) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				status = game.movePlayer(3);
				if (status == 1) {
				} else if (status == 3) {
					JOptionPane.showMessageDialog(frame, "THIS ROOM IS EMPTY!");
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
				} else {
					JOptionPane.showMessageDialog(frame, "Can not go there! Try again: ");
				}
				if(hardMode){
					if (validMove) {
						if (!game.moveSmartNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				} else {
					if (validMove) {
						if (!game.moveNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				}
				
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Move right
			else if(e.getKeyCode() == KeyEvent.VK_D) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				status = game.movePlayer(4);
				if (status == 1) {
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
				} else {
					JOptionPane.showMessageDialog(frame, "Can not go there! Try again: ");
				}
				if(hardMode){
					if (validMove) {
						if (!game.moveSmartNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				} else {
					if (validMove) {
						if (!game.moveNinja()) {
							JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
							spy.getStabbed();
						}
						if (!game.getDebug()) {
							game.assignSpyVisibility();
						}
					}
				}
				
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Shoot Up
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				validMove = true;
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 1;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Shoot Down
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				validMove = true;
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 2;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();	
			}
			
			//Shoot Left
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				validMove = true;
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 3;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Shoot Right
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				validMove = true;
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 4;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				validMove = false;
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			//Game Won
			if (game.gameOver() == 1) {
				JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND THE ГРЕЧКА. YOU WIN!");
				JOptionPane.showMessageDialog(frame, "Thank You For Playing!");
				System.exit(0);
			}
			//Game Lost
			if (game.gameOver() == 2) {
				JOptionPane.showMessageDialog(frame, "YOU HAVE DIED TOO MANY TIMES. YOU LOSE!");
				JOptionPane.showMessageDialog(frame, "Thank You For Playing!");
				System.exit(0);
			}
			
		}
		
	/**
	 * This method receives the parameter "parameter" from the KeyPressed method 
	 * and runs the code to shoot the gun. It also displays whether or not a ninja has been hit.
	 * @param parameter
	 */
	public void shootNinja(int parameter) {
		int shootStatus = game.shootNinja(parameter);
		if(shootStatus == 1) {
			JOptionPane.showMessageDialog(frame, "YOU KILLED A NINJA!");
		} else
			JOptionPane.showMessageDialog(frame, "YOUR SHOT MISSED EVERYTHING");
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This method prints the players HUD at the bottom of the screen. 
	 * The HUD keeps track of how many lives, bullets, and turns of invincibility the player has left.
	 */
	public void setHUD()
	{		
		HUD.removeAll();
	    JLabel HUDLives = new JLabel("Lives: " + game.getSpy().getLives());
	    JLabel HUDBullets = new JLabel("Bullets: " + game.getSpy().getBullets());
	    if (game.getSpy().isInvincible()) {
	    	JLabel HUDInv = new JLabel("Turns of invincibility: " + game.getInvincibilityTurns());
	    	HUD.add(HUDInv, BorderLayout.CENTER);
	    }
		HUD.add(HUDLives, BorderLayout.PAGE_START);
		HUD.add(HUDBullets, BorderLayout.SOUTH);
		
		HUD.revalidate();
	}
	
	
}
