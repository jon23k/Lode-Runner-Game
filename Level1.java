package loderunner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import loderunner.Enemy;
import loderunner.Hero;
import loderunner.World;


@SuppressWarnings("serial")
public class Level1 extends Level implements ActionListener
{
	
	Hero h;
	Timer tm2 = new Timer(100, this);
	int velX = 2;
	static int score = 0;
	int x = 0;
	int enemyNoMoveFrames = 1;
	int enemyFrameCurrent;
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	ArrayList<Gold> goldPeices = new ArrayList<Gold>();

	public Level1()
	{
	
		World.globalLevel = this;
		score =0;
		ladders = new ArrayList<ArrayList<Integer>>();
		tiers = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(0);
		one.add(171);
		one.add(50);
		one.add(10);
		tiers.add(one);
		ArrayList<Integer> two = new ArrayList<Integer>();
		two.add(75);
		two.add(111);
		two.add(250);
		two.add(10);
		tiers.add(two);
		ArrayList<Integer> three = new ArrayList<Integer>();
		three.add(350);
		three.add(171);
		three.add(150);
		three.add(10);
		tiers.add(three);
		ArrayList<Integer> four = new ArrayList<Integer>();
		four.add(0);
		four.add(51);
		four.add(400);
		four.add(10);
		tiers.add(four);
		ArrayList<Integer> five = new ArrayList<Integer>();
		five.add(425);
		five.add(51);
		five.add(75);
		five.add(10);
		tiers.add(five);
		ArrayList<Integer> six = new ArrayList<Integer>();
		six.add(30);
		six.add(231);
		six.add(360);
		six.add(10);
		tiers.add(six);
		ArrayList<Integer> seven = new ArrayList<Integer>();
		seven.add(300);
		seven.add(291);
		seven.add(200);
		seven.add(10);
		tiers.add(seven);
		ArrayList<Integer> eight = new ArrayList<Integer>();
		eight.add(0);
		eight.add(351);
		eight.add(250);
		eight.add(10);
		tiers.add(eight);
		ArrayList<Integer> nine = new ArrayList<Integer>();
		nine.add(10);
		nine.add(51);
		nine.add(5);
		nine.add(120);
		ladders.add(nine);
		ArrayList<Integer> ten = new ArrayList<Integer>();
		ten.add(380);
		ten.add(51);
		ten.add(5);
		ten.add(120);
		ladders.add(ten);
		ArrayList<Integer> eleven = new ArrayList<Integer>();
		eleven.add(50);
		eleven.add(171);
		eleven.add(5);
		eleven.add(60);
		ladders.add(eleven);
		ArrayList<Integer> twelve = new ArrayList<Integer>();
		twelve.add(360+2);
		twelve.add(171);
		twelve.add(5);
		twelve.add(60);
		ladders.add(twelve);
		ArrayList<Integer> thirteen = new ArrayList<Integer>();
		thirteen.add(300);
		thirteen.add(51);
		thirteen.add(5);
		thirteen.add(60);
		ladders.add(thirteen);
		ArrayList<Integer> fourteen = new ArrayList<Integer>();
		fourteen.add(200);
		fourteen.add(111);
		fourteen.add(5);
		fourteen.add(120);
		ladders.add(fourteen);
		ArrayList<Integer> fifteen = new ArrayList<Integer>();
		fifteen.add(125);
		fifteen.add(231);
		fifteen.add(5);
		fifteen.add(120);
		ladders.add(fifteen);
		ArrayList<Integer> sixteen = new ArrayList<Integer>();
		sixteen.add(450);
		sixteen.add(51);
		sixteen.add(5);
		sixteen.add(120);
		ladders.add(sixteen);
		ArrayList<Integer> seventeen = new ArrayList<Integer>();
		seventeen.add(330);
		seventeen.add(231);
		seventeen.add(5);
		seventeen.add(60);
		ladders.add(seventeen);
		ArrayList<Integer> eighteen = new ArrayList<Integer>();
		eighteen.add(230);
		eighteen.add(351);
		eighteen.add(5);
		eighteen.add(500-351);
		ladders.add(eighteen);
		ArrayList<Integer> nineteen = new ArrayList<Integer>();
		nineteen.add(402);
		nineteen.add(291);
		nineteen.add(5);
		nineteen.add(500-291);
		ladders.add(nineteen);
		
		//Entity Addition
		h = new Hero();
		Hero.setGlobalHero(h);
		enemys.add(new Enemy(new int[] {199,189})); //TODO: Locations are just to see if 
		enemys.add(new Enemy(new int[] {49,9})); // works Make on map and follow stairs
		enemys.add(new Enemy(new int[] {49,307}));
		goldPeices.add( new Gold(89,189+30));
		goldPeices.add( new Gold(150, 307+30));
		goldPeices.add(new Gold(200, 9+30));
		goldPeices.add(new Gold(360, 320-40));
		//Pieces

	}



	public int getHeight(ArrayList<Integer> answer)
	{
		return answer.get(3);
	}
	public int getWidth(ArrayList<Integer> answer)
	{
		return answer.get(2);
	}
	public int getXPos(ArrayList<Integer> answer)
	{
		return answer.get(0);
	}
	public int getYPos(ArrayList<Integer> answer)
	{
		return answer.get(1);
	}
	public ArrayList<Integer> getLadder(ArrayList<ArrayList<Integer>> ladders, int i)
	{
		return ladders.get(i);
	}
	public ArrayList<Integer> getTier(ArrayList<ArrayList<Integer>> tiers, int i)
	{
		return tiers.get(i);
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(goldPeices.isEmpty())
		{
			World.loadLevel2();
			
		}
		/**
		 * Game Background 
		 */
		 g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.CYAN);
		for(int i = 0;i<tiers.size();i++)
		{
			g.fillRect(getXPos((tiers.get(i))), getYPos((tiers.get(i))), getWidth((tiers.get(i))), getHeight((tiers.get(i))));
		}
		g.setColor(Color.WHITE);
		for(int i = 0;i<ladders.size();i++)
		{
			g.fillRect(getXPos((ladders.get(i))), getYPos((ladders.get(i))), getWidth((ladders.get(i))), getHeight((ladders.get(i))));
		}

		//Drawing Pieces now.

		this.h.drawOn(g2);

		enemyFrameCurrent++;
		for(Enemy enemy: enemys){
			if(enemyFrameCurrent>= enemyNoMoveFrames){
				enemy.move();
			}
			enemy.drawOn(g2);
		}
		if(enemyFrameCurrent>= enemyNoMoveFrames){
			enemyFrameCurrent = 0;
		}
		for(int i =0;i<goldPeices.size();i++)
		{
			if(goldPeices.get(i).isTouched(g2))
			{
				goldPeices.remove(i);
				score = score + 100;

			}

		}
		for(int j=0;j<goldPeices.size();j++)
		{
			goldPeices.get(j).drawOn(g2);
		}
		System.out.println(World.totalScore);
		World.totalScore =  score;
		System.out.println(World.totalScore);
	}

}

