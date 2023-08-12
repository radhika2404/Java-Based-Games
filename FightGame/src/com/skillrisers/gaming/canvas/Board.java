package com.skillrisers.gaming.canvas;

import javax.swing.JPanel;
import java.awt.event.KeyListener;

import com.skillrisers.gaming.sprites.OppPlayer;
import com.skillrisers.gaming.sprites.Player;
import com.skillrisers.gaming.sprites.Power;
import com.skillrisers.gaming.utils.GameConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

import javax.imageio.ImageIO;

public class Board extends JPanel implements GameConstants{
	
	BufferedImage imageBg;
	private Player player;
	private OppPlayer oplayer;
	private Power playerFullPower;
	private Power oplayerFullPower;
	private Timer timer;
	private boolean gameover;
	
	//Step 1:Constructor declaration
	public Board() throws Exception {

		//1. Bg image set
		loadBackgroundImage();
		//Add players to screen
		player=new Player();
		oplayer=new OppPlayer();
		
		setFocusable(true);
		bindEvents();
		gameLoop();
		loadPower();
	}
	private void loadBackgroundImage() {
		try {
			imageBg=ImageIO.read(Board.class.getResource(BG));
			}
			catch(Exception ex) {
				System.out.println("Background Image loading failed..");
				System.exit(0);
			}
	}
	@Override
	public void paintComponent(Graphics pen) {

		super.paintComponent(pen);
		printBackgroundImage(pen);
		player.printPlayer(pen);
		oplayer.printPlayer(pen);
		printFullPower(pen);
		printGameOVER(pen);
		
		}
	private void printBackgroundImage(Graphics pen) {
		pen.drawImage(imageBg, 0, 0, GWIDTH, GHEIGHT, null);
		
	}
	
	
	
	
	
	
	private boolean isCollide() {
		int xDistance=Math.abs(player.getX()-oplayer.getX());
		int yDistance=Math.abs(player.getY()-oplayer.getY());
		int maxH=Math.max(player.getH(), oplayer.getH());
		int maxW=Math.max(player.getW(), oplayer.getW());
		return xDistance<=(maxW) && yDistance<=maxH;
		
	}

	
		
		
		
	private void collision() {
		if(isCollide()) {
			if(player.isAttacking() && oplayer.isAttacking()) {
				oplayer.setCurrentMove(DAMAGE);
				oplayerFullPower.setHealth();
				player.setCurrentMove(DAMAGE);
				playerFullPower.setHealth();
			}
			else if(player.isAttacking()) {
				oplayer.setCurrentMove(DAMAGE);
				oplayerFullPower.setHealth();
				
			     }
			else if(oplayer.isAttacking()) {
				player.setCurrentMove(DAMAGE);
				playerFullPower.setHealth();
			}
			
			player.setCollide(true);
			player.setSpeed(0);
			oplayer.setCollide(true);
			oplayer.setSpeed(0);
		}
		else {
			oplayer.setCollide(false);
			oplayer.setSpeed(SPEED);
			player.setSpeed(SPEED);
			player.setCollide(false);
		}
	}
	private void isGameOVER() {
		if(playerFullPower.getHealth()<=0 || oplayerFullPower.getHealth()<=0)
			gameover=true;	
	}
	
	private void printGameOVER(Graphics pen) {
		if(gameover) {
			pen.setColor(Color.RED);
		pen.setFont(new Font("times",Font.BOLD,40));
		pen.drawString("GAME OVER",GWIDTH/2,GHEIGHT/2);
	}
	}
	
	//use of listener interface
	private void bindEvents() {
		KeyListener listerner=new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.println("Typed"+e.getKeyCode()+" "+e.getKeyChar());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("Released"+e.getKeyCode()+" "+e.getKeyChar());
			}
			@Override
			public void keyPressed(KeyEvent e) {
				//  RIGFT PLAYER(KEN)
				if(e.getKeyCode()==LEFT_KEY) {
					oplayer.setCurrentMove(WALK);
					oplayer.setSpeed(-SPEED);
					oplayer.move();
					//System.out.println("X LEFT "+player.getX());
					repaint();
					
				}
				if(e.getKeyCode()==RIGHT_KEY) {
					oplayer.setCurrentMove(WALK);
					oplayer.setSpeed(SPEED);
					oplayer.setCollide(false);
					oplayer.move();
					//System.out.println("X RIGHT "+player.getX());
					repaint();
					
				}
				
				else if(e.getKeyCode()==K) {
					oplayer.setCurrentMove(KICK);
					oplayer.setAttacking(true);
				}
				else if(e.getKeyCode()==L) {
					oplayer.setCurrentMove(PUNCH);
					oplayer.setAttacking(true);
				}
				else if(e.getKeyCode()==J)
						oplayer.jump();
				else if(e.getKeyCode()==UP_KEY) {
					oplayer.setCurrentMove(POW);
					oplayer.setAttacking(true);
			    }
			
				
				//LEFT PLAYER(RIU) 
				if(e.getKeyCode()==S) {
					player.setCurrentMove(WALK);
					player.setSpeed(-SPEED);
					player.setCollide(false);
					player.move();
					//System.out.println("X LEFT "+player.getX());
					repaint();
					
				}
				if(e.getKeyCode()==F) {
					player.setCurrentMove(WALK);
					player.setSpeed(SPEED);
					player.move();
					//System.out.println("X RIGHT "+player.getX());
					repaint();
					
				}
				else if(e.getKeyCode()==C) {
					player.setCurrentMove(KICK);
					player.setAttacking(true);
				}
				else if(e.getKeyCode()==R) {
					player.setCurrentMove(PUNCH);
					player.setAttacking(true);
				}
				else if(e.getKeyCode()==SPACE)
						player.jump();
				else if(e.getKeyCode()==D) {
						player.setCurrentMove(POW);
						player.setAttacking(true);
				}
				//System.out.println("Press"+e.getKeyCode()+" "+e.getKeyChar());
			}
		};
		this.addKeyListener(listerner);
		
	}
	
	private void gameLoop() {
		timer=new Timer(90, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				if(gameover){
					timer.stop();
				}
				player.fall();
				oplayer.fall();
				collision();
				isGameOVER();
			}
			
		});
		timer.start();
	}
		private void loadPower() {
			playerFullPower=new Power(100,Color.GREEN,"RYU");
			oplayerFullPower=new Power(GWIDTH-400,Color.GREEN,"KEN");
			
		
		}
		private void printFullPower(Graphics g) {
			playerFullPower.printRectangle(g);
			oplayerFullPower.printRectangle(g);
			
			
		}

}
