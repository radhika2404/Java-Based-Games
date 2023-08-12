package com.skillrisers.gaming.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Power extends CommonPlayer{
	Color cl;
	String playerName;
	public Power(int x,Color cl,String playerName) {
		this.x=x;
		y=150;
		h=30;
		w=300;
		this.cl=cl;
		this.playerName=playerName;
	}
	@Override
	public BufferedImage defaultImage() {
		return null;
	}
	public void printRectangle(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, health, h);
		pen.setColor(Color.BLACK);
		pen.setFont(new Font("times",Font.BOLD,30));
		pen.drawString(playerName,x,y+h+30);
	}
}
