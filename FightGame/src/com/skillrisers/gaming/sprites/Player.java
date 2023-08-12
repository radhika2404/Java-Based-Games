package com.skillrisers.gaming.sprites;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.skillrisers.gaming.utils.GameConstants;


public class Player extends CommonPlayer implements GameConstants{

	private BufferedImage walkImages[]=new BufferedImage[6];
	private BufferedImage kickImages[]=new BufferedImage[6];
	private BufferedImage punchImages[]=new BufferedImage[6];
	private BufferedImage powerImages[]=new BufferedImage[6];
	private BufferedImage damageEffectImages[]=new BufferedImage[3];
	
	
	
	public Player() throws Exception {
		x=100;
		h=150;
		w=200;
		y=FLOOR-h;
		
		image=ImageIO.read(Player.class.getResource(PLAYER_IMAGE));
		
		speed=SPEED;
		loadWalkImages();
		loadkickImages();
		loadPunchImages();
		loadPowerImages();
		loadDamageEffect();
	}
	public BufferedImage defaultImage() {
		
		if(currentMove==WALK) {
			return printWalk();
		}
		else if(currentMove==KICK)
			return printKick();
		else if(currentMove==POW)
			return printPower();

		else if(currentMove==PUNCH)
			return printPunch();
		else if(currentMove==DAMAGE)
			return printDamage();
		else
			return stand();
		
	}
	
	public void drawPlayer(Graphics pen) {
		pen.drawImage(stand(), x,y, w,h, null);
	}
	public BufferedImage stand() {
		return image.getSubimage(62,234,77,102);
		
	}
	
	
//	
//	
//	public BufferedImage Printwalk() {
//		return image.getSubimage(62,234,77,102);
//		
//	}
	
	private void loadWalkImages() {
			
	walkImages[0]=image.getSubimage(60,236,77,98);
	walkImages[1]=image.getSubimage(142,235,77,98);
	walkImages[2]=image.getSubimage(225,236,60,98);
	walkImages[3]=image.getSubimage(304,233,58,98);
	walkImages[4]=image.getSubimage(377,234,59,99);
	walkImages[5]=image.getSubimage(435,239,65,96);
	}
	
	private void loadkickImages() {
		kickImages[0]=image.getSubimage(38,1040,73,105);
	kickImages[1]=image.getSubimage(123,1039,65,106);
	kickImages[2]=image.getSubimage(199,1037,118,110);
	kickImages[3]=image.getSubimage(327,1045,71,99);
	kickImages[4]=image.getSubimage(405,1044,70,99);
	kickImages[5]=image.getSubimage(480,1047,97,103);
	}
	
	private void loadPunchImages() {
		
	punchImages[0]=image.getSubimage(24,816,72,105);
	punchImages[1]=image.getSubimage(106,815,72,105);
	punchImages[2]=image.getSubimage(189,816,112,105);
	punchImages[3]=image.getSubimage(311,815,79,105);
	punchImages[4]=image.getSubimage(403,811,105,105);
	punchImages[5]=image.getSubimage(515,813,81,105);
	}
	private void loadPowerImages() {
		
	powerImages[0]=image.getSubimage(25,1699,112,101);
	powerImages[1]=image.getSubimage(145,1697,100,101);
	powerImages[2]=image.getSubimage(246,1698,123,98);
	powerImages[3]=image.getSubimage(357,1706,123,98);
	powerImages[4]=image.getSubimage(83,3107,74,43);
	powerImages[5]=image.getSubimage(487,1809,150,97);
	}
	

private void loadDamageEffect() {
	damageEffectImages[0]=image.getSubimage(330,2531,86,98);
	damageEffectImages[1]=image.getSubimage(243,2532,86,98);
	damageEffectImages[2]=image.getSubimage(496,2451,127,58);
		
	}
		
		private BufferedImage printWalk() {
		    setAttacking(false);
			if(imageIndex>5) {
				imageIndex=0;}
			BufferedImage img=walkImages[imageIndex];
			imageIndex++;//Change image frames
			return img;
			
		}
		
		private BufferedImage printKick() {
			if(imageIndex>5) {
				imageIndex=0;
				currentMove=WALK;
				}
			BufferedImage img=kickImages[imageIndex];
			imageIndex++;//Change image frames
			return img;
			
		}
		private BufferedImage printPunch() {
			if(imageIndex>5) {
				imageIndex=0;
				currentMove=WALK;}
			BufferedImage img=punchImages[imageIndex];
			imageIndex++;//Change image frames
			return img;
			
		}
		private BufferedImage printPower() {
			if(imageIndex>5) {
				imageIndex=0;
				currentMove=WALK;}
			BufferedImage img=powerImages[imageIndex];
			imageIndex++;//Change image frames
			return img;
			
		}
		private BufferedImage printDamage() {
			if(imageIndex>damageEffectImages.length-1) {
				imageIndex=0;
				currentMove=WALK;
			}
			BufferedImage img=damageEffectImages[imageIndex];
			imageIndex++;
			return img;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
