package com.skillrisers.gaming.canvas;


import javax.swing.JFrame;

import com.skillrisers.gaming.utils.GameConstants;
public class GameFrame extends JFrame implements GameConstants{
	
	public GameFrame() throws Exception {
		setTitle(TITLE);
		setSize(GWIDTH,GHEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		Board boar=new Board();
		add(boar);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		GameFrame obj=new GameFrame();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
