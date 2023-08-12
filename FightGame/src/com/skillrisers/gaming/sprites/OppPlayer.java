package com.skillrisers.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.skillrisers.gaming.utils.GameConstants;

public class OppPlayer extends CommonPlayer implements GameConstants {
	
	private BufferedImage walkImages[]=new BufferedImage[6];
	private BufferedImage kickImages[]=new BufferedImage[6];
	private BufferedImage punchImages[]=new BufferedImage[6];
	private BufferedImage powerImages[]=new BufferedImage[6];
	private BufferedImage damageEffectImages[]=new BufferedImage[6];
	
	

	public OppPlayer() throws Exception {
		h=150;
		w=200;
		x=GWIDTH-w-105;
		y=FLOOR-h;
		
		image=ImageIO.read(OppPlayer.class.getResource(OPP_PLAYER_IMAGE));
		
		speed=-SPEED;

		loadWalkImages();
		loadkickImages();
		loadPunchImages();
		loadPowerImages();
		loadDamageEffect();		
	}

	
	public BufferedImage defaultImage() {
		if(currentMove==WALK) 
			return printWalk();
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
		return image.getSubimage(2027,1263,69,99);
		
	}
	

		
	
private void loadWalkImages() {
	walkImages[0]=image.getSubimage(2038,868,57,95);
	walkImages[1]=image.getSubimage(1967,865,57,95);
	walkImages[2]=image.getSubimage(1886,866,70,95);
	walkImages[3]=image.getSubimage(1817,863,70,95);
	walkImages[4]=image.getSubimage(1750,867,70,90);
	walkImages[5]=image.getSubimage(1682,865,70,90);
	
}

private void loadkickImages() {
			
kickImages[0]=image.getSubimage(2039,1563,56,100);
kickImages[1]=image.getSubimage(1965,1562,70,100);
kickImages[2]=image.getSubimage(1838,1564,115,100);
kickImages[3]=image.getSubimage(1764,1564,72,100);
kickImages[4]=image.getSubimage(1691,1568,72,100);
kickImages[5]=image.getSubimage(1965,1562,70,100);
}	

private void loadPunchImages() {
	
punchImages[0]=image.getSubimage(2026,1152,68,94);
punchImages[1]=image.getSubimage(1932,1151,95,94);
punchImages[2]=image.getSubimage(1867,1152,62,91);
punchImages[3]=image.getSubimage(1787,1147,73,99);
punchImages[4]=image.getSubimage(1667,1148,108,99);
punchImages[4]=image.getSubimage(1591,1145,76,99);
}	
private void loadPowerImages() {
	
	powerImages[0]=image.getSubimage(1919,2743,94,89);
	powerImages[1]=image.getSubimage(1817,2746,94,89);
	powerImages[2]=image.getSubimage(1653,2744,153,87);
	powerImages[3]=image.getSubimage(1569,2752,79,59);
	powerImages[4]=image.getSubimage(1491,2754,63,44);
	powerImages[5]=image.getSubimage(1433,2771,27,25);
	}
private void loadDamageEffect() {
	damageEffectImages[0]=image.getSubimage(1634,3278,62,96);
	damageEffectImages[1]=image.getSubimage(1712,3276,62,96);
	damageEffectImages[2]=image.getSubimage(1788,3275,81,91);
	damageEffectImages[3]=image.getSubimage(1876,3275,75,91);
	damageEffectImages[4]=image.getSubimage(1953,3274,75,91);
	damageEffectImages[5]=image.getSubimage(2022,3274,75,91);
		
	}
private BufferedImage printWalk() {
	setAttacking(false);
	isAttacking=false;
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
		isAttacking=false;
		}
	isAttacking=true;
	BufferedImage img=kickImages[imageIndex];
	imageIndex++;//Change image frames
	return img;
	
}
private BufferedImage printPunch() {
	if(imageIndex>5) {
		imageIndex=0;
		currentMove=WALK;
		isAttacking=false;
		}
	isAttacking=true;
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




