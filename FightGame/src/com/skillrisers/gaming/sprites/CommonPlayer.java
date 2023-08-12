package com.skillrisers.gaming.sprites;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.skillrisers.gaming.utils.GameConstants;


public abstract class CommonPlayer implements GameConstants {
	
		//1.Get Dimension of ryu player
		protected int x;
		protected int y;
		protected int w;
		protected int h;
		//2. Image of player
		protected BufferedImage image;
		//3. Load the default image of player
		public abstract BufferedImage defaultImage();
		
		protected int speed;
		protected int imageIndex;
		protected int currentMove;
		protected int force;
		protected boolean isCollide;
		protected boolean isAttacking;
		protected int health;
		
		public BufferedImage getImage() {
			return image;
		}

		public void setImage(BufferedImage image) {
			this.image = image;
		}
		//Draw the players
		public void printPlayer(Graphics pen) {
			pen.drawImage(defaultImage(),x,y,w,h, null);
		}

//		public void drawPlayer(Graphics pen) {
//			pen.drawImage(stand(), x,y, w,h, null);
//		}
		
		

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}

		

		
		
		public int getSpeed() {
			return speed;
		}
		public void move() {
			if(!isCollide())
			x=x+speed;
			
		}
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		public void jump() {
			force=-20;
			y=y+force;
		}

		public void fall() {
			if(y>=(FLOOR-h))
				return;
			y=y+force;
			force=force+GRAVITY;
		}
		public boolean isAttacking() {
			return isAttacking;
		}

		public void setAttacking(boolean isAttacking) {
			this.isAttacking = isAttacking;
		}

		public boolean isCollide() {
			return isCollide;
		}

		public void setCollide(boolean isCollide) {
			this.isCollide = isCollide;
		}

		public int getCurrentMove() {
			return currentMove;
		}

		public void setCurrentMove(int currentMove) {
			this.currentMove = currentMove;
		}
		public CommonPlayer() {
			health=MAX_HEALTH;
		}

		public int getHealth() {
			return health;
		}

		public void setHealth() {
			this.health =(int)(this.health - MAX_HEALTH*0.10);
		}
		
}
