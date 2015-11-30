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

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

/**
 * The UI class for handling the console interface. Take user input, print out
 * game information.
 */
public class GUI implements KeyListener {
	
	private Engine game;
	private Spy spy = new Spy(8,0);
	
	private JPanel panel = new JPanel(new GridLayout(9,9));
	private JPanel HUD = new JPanel(new BorderLayout());
	private JFrame frame = new JFrame("Find Your GRE4KA");
	
	private boolean validMove = true;
	private boolean hardMode = false;
	private int parameter = 0;
	
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
    			
    		}
    	
    	});
    	
    	JMenuItem load = new JMenuItem("Load Game");
    	load.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			game = Save.loadGame();
    			JOptionPane.showMessageDialog(frame,"Your game has been loaded.");
    			
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
    			JOptionPane.showMessageDialog(frame, "Development Team:\n\nAlexandra Klimenko\nVictor Ruiz\nKhanh Nyguyen\nIan Garrett");
    		}
    	
    	});
    	
    	JMenuItem howtoplay = new JMenuItem("How To Play");
    	howtoplay.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(frame, "Move with the following keys:\nW - move up\nS - move down\nA - move left\nD - move right"
    					+ "\n\nPowerups:\nInvincibility - Invincible for 5 turns\nRadar - Reveal the location of the document\nAmmo Increase - Increase your ammo count by 1"
    					+ "\n\nShooting: Press P to shoot, then select a direction" + "\nUP_Arrow - shoot up\nDOWN_ARROW - shoot down\nLEFT_ARROW - shoot left\nRIGHT_ARROW - shoot right"
    					+"\n\nLook for the document hiding in one of these rooms\nWatch out for ninjas, they want to shank you.");
    		}
    	
    	});
    	
    	

    	options.add(newGameEasy);
    	options.add(newGameHard);
    	options.add(newDebugGame);
    	options.add(save);
    	options.add(load);
    	options.add(quit);
    	help.add(about);
    	help.add(howtoplay);
    	
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
	
	public void printMap(Square[][] map) {
		panel.removeAll();
		JLabel display = new JLabel(new ImageIcon("GamePics/blank.jpg"));
		for (Square[] row : map) {
			for (Square location : row) {
				if (location.isVisible()) {
					
					String symbol = location.getSymbol();
					switch(symbol) {
					case "R":
						display = new JLabel(new ImageIcon("GamePics/room.jpg"));
						break;
					case "S":
						display = new JLabel(new ImageIcon("GamePics/spy.jpg"));
						break;
					case "N":
						display = new JLabel(new ImageIcon("GamePics/ninja.jpg"));
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
					case "*":
						display = new JLabel(new ImageIcon("GamePics/gre4ka.jpg"));
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

	@Override
	public void keyPressed(KeyEvent e) {
		boolean valid = false;
		int status;
			if(e.getKeyCode() == KeyEvent.VK_W) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				// Move up
				status = game.movePlayer(1);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
					valid = true;
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
					valid = true;
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
					valid = true;
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
					valid = true;
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
			
			else if(e.getKeyCode() == KeyEvent.VK_A) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				// Move left
				status = game.movePlayer(2);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
					valid = true;
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
					valid = true;
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
					valid = true;
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
					valid = true;
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
			
			else if(e.getKeyCode() == KeyEvent.VK_S) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				// Move down
				status = game.movePlayer(3);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
					valid = true;
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
					valid = true;
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
					valid = true;
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
					valid = true;
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
			
			else if(e.getKeyCode() == KeyEvent.VK_D) {
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				validMove = true;
				// Move right
				status = game.movePlayer(4);
				if (status == 1) {
					valid = true;
				} else if (status == 5) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND AN ADDITIONAL BULLET! USE IT WISELY");
					valid = true;
				} else if (status == 6) {
					JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND A RADAR!");
					valid = true;
				} else if (status == 7) {
					JOptionPane.showMessageDialog(frame, "YOU ACTIVATED GOD MODE! YOU ARE INVINCIBLE FOR 5 TURNS");
					valid = true;
				} else if (status == 4) {
					JOptionPane.showMessageDialog(frame, "YOU GOT STABBED BY A NINJA!");
					spy.getStabbed();
					valid = true;
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
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				validMove = true;
				//Shoot
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 1;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
					valid = true;
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				validMove = true;
				//Shoot
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 2;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
					valid = true;
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
				
				
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				validMove = true;
				//Shoot
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 3;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
					valid = true;
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				validMove = true;
				//Shoot
				int bulletCount = game.getSpy().getBullets();
				if (bulletCount > 0) {
					parameter = 4;
					shootNinja(parameter);
				} else {
					JOptionPane.showMessageDialog(frame, "\nYOU DON'T HAVE ANY BULLETS!\n\n");
					valid = true;
				}
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				validMove = false;
				valid = true;
				game.assignSpyVisibility();
				printMap(game.getMap());
				setHUD();
			}
			
			/*else {
				JOptionPane.showMessageDialog(frame, "Invalid Entry. Try Again.\n\nPress Enter To Continue...");
			}*/
			
			if (game.gameOver() == 1) {
				JOptionPane.showMessageDialog(frame, "YOU HAVE FOUND THE GRE4KA. YOU WIN!");
				JOptionPane.showMessageDialog(frame, "Thank You For Playing!");
				System.exit(0);
			}
			if (game.gameOver() == 2) {
				JOptionPane.showMessageDialog(frame, "YOU HAVE DIED TOO MANY TIMES. YOU LOSE!");
				JOptionPane.showMessageDialog(frame, "Thank You For Playing!");
				System.exit(0);
			}
			
		}
		
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
	
	public void setHUD()
	{		
		HUD.removeAll();
	    JLabel HUDLives = new JLabel("Lives: " + spy.getLives());
	    JLabel HUDBullets = new JLabel("Bullets: " + spy.getBullets());
	    if (game.getSpy().isInvincible()) {
	    	JLabel HUDInv = new JLabel("Turns of invincibility: " + game.getInvincibilityTurns());
	    	HUD.add(HUDInv, BorderLayout.CENTER);
	    }
		HUD.add(HUDLives, BorderLayout.PAGE_START);
		HUD.add(HUDBullets, BorderLayout.SOUTH);
		
		HUD.revalidate();
	}
	
	
}
