package loderunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class Gold
{
	GoldAI goldAI;
	Hero h;
	int xPos;
	int yPos;
	int height;
	int width;
	private static Gold globalGold;
	
	public Gold(int x, int y )
	{
		xPos = x;
		yPos = y;
		this.goldAI = new GoldAI(this);
		width = 10;
		height = 10;
	}

	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public boolean isTouched(Graphics2D g2)
	{
		if(goldAI.touchHero(g2))
		{
			return true;
		}
		return false;
		
	}

	
	public void drawOn(Graphics2D g2)
	{

			g2.setColor(Color.YELLOW);
			g2.fillRect(getX(),getY(),width,height);
	}


	
}
