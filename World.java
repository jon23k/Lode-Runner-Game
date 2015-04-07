package loderunner;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import loderunner.Level;
import loderunner.Level1;
import loderunner.Level2;


public class World implements KeyListener
{
	
	public static JFrame world;
	public static ArrayList<Gold> stackComplete;
	public static Level globalLevel;
	public static Timer tm2;
	public static Timer time;
	public static int totalScore;

	public static void main(String[] args)
	{
		World myworld = new World();
		myworld.make();
	
	}
	
	public void make()
	{
		{
			totalScore = 0;
			World.stackComplete = new ArrayList<Gold>();
			world = new JFrame();
			Level1 l1 = new Level1();
			world.add(l1);
			JPanel s = new JPanel();
			JLabel score = new JLabel("Score: "+ totalScore+ "");
			s.add(score);
			s.setBackground(Color.GREEN);
			world.add(s, BorderLayout.SOUTH);
			Dimension d = new Dimension(500,530);
			world.setPreferredSize(d);
			world.pack();
			world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			world.setVisible(true);
			world.setResizable(false);
			world.addKeyListener(new World());
			if(tm2 == null)
			{
				ActionListener taskPerformer = new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt)
					{
						
						World.world.repaint();
					}
				};
				tm2 = new Timer(15, taskPerformer);
				tm2.start();
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent event)
	{
		switch(event.getKeyCode()){
		case KeyEvent.VK_U:
			World.stackComplete = new ArrayList<Gold>();
			World.world.dispose();
			world = new JFrame();
			Level2 l2 = new Level2();
			world.add(l2);
			JPanel s = new JPanel();
			JLabel score = new JLabel("Score: "+ totalScore+ "");
			s.add(score);
			s.setBackground(Color.GREEN);
			world.add(s, BorderLayout.SOUTH);
			Dimension d = new Dimension(500,530);
			world.setPreferredSize(d);
			world.pack();
			world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			world.setVisible(true);
			world.setResizable(false);
			world.addKeyListener(new World());
			if(tm2 == null)
			{
				ActionListener taskPerformer = new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt)
					{
						
						World.world.repaint();
					}
				};
				tm2 = new Timer(15, taskPerformer);
				tm2.start();
			}
			break;
			
		case KeyEvent.VK_D:
		{
			World.world.dispose();
			make();
		}
			

		}
	}
	
	public static void loadLevel2()
	{
		World.stackComplete = new ArrayList<Gold>();
		World.world.dispose();
		world = new JFrame();
		Level2 l2 = new Level2();
		world.add(l2);
		JPanel s = new JPanel();
		JLabel score = new JLabel("Score: "+ totalScore+ "");
		s.add(score);
		s.setBackground(Color.GREEN);
		world.add(s, BorderLayout.SOUTH);
		Dimension d = new Dimension(500,530);
		world.setPreferredSize(d);
		world.pack();
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		world.setVisible(true);
		world.setResizable(false);
		world.addKeyListener(new World());
		if(tm2 == null)
		{
			ActionListener taskPerformer = new ActionListener() 
			{
				public void actionPerformed(ActionEvent evt)
				{
					
					World.world.repaint();
				}
			};
			tm2 = new Timer(15, taskPerformer);
			tm2.start();
		}
		
	}


	public static void restart()
	{
		World.world.dispose();
		ScoreBoard.make();
		//Main.main(null);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}