package loderunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreBoard
{

	public static ArrayList<JLabel> playerlist = new ArrayList<JLabel>();

	
	public ScoreBoard()
	{ 


	}
	
	public static void make()
	{
		playerlist.add(new JLabel("HIGH SCORES"));
		playerlist.add(new JLabel(" "));
		playerlist.add(new JLabel("AAA: 000"));
		playerlist.add(new JLabel("AAA: 000"));
		playerlist.add(new JLabel("AAA: 000"));
		playerlist.add(new JLabel("AAA: 000"));
		JFrame scoreboard = new JFrame();
		JPanel s = new JPanel();
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		playerlist.add( new JLabel(name+": "+ World.totalScore));
		for(int i =0;i<playerlist.size();i++)
		{
			if(i%2==0)
			{
				s.add((playerlist.get(i)));
			}
			
		}
		s.setBackground(Color.GREEN);
		scoreboard.add(s);
		scoreboard.pack();
		scoreboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreboard.setVisible(true);
	}
	
	
}
