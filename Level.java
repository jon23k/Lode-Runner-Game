package loderunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public abstract class Level extends JComponent
{
	
	public ArrayList<ArrayList<Integer>> tiers;
	
	public ArrayList<ArrayList<Integer>> ladders;

	public int getHeight(ArrayList<Integer> answer) {
		return 0;
	}

	public int getWidth(ArrayList<Integer> answer) {
		return 0;
	}

	public int getXPos(ArrayList<Integer> answer) {
		return 0;
	}


	public int getYPos(ArrayList<Integer> answer) {
		return 0;
	}

	public ArrayList<Integer> getLadder(ArrayList<ArrayList<Integer>> ladders, int i) {
		return null;
	}

	public ArrayList<Integer> getTier(ArrayList<ArrayList<Integer>> tiers, int i) {
		return null;
	}

	public void paintComponent(Graphics g)
	{

	}

	public void actionPerformed(ActionEvent e)
	{

	}

	public int getYPos(Integer integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight(Integer integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWidth(Integer integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getXPos(Integer integer) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
