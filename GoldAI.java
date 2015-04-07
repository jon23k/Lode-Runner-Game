package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;

public class GoldAI 
{
	Hero newHero;
	// Level1 game;
	Gold gold;

	public GoldAI(Gold g)
	{
		gold = g;
		newHero = Hero.getGlobalHero();
	}


	public double getHeroX()
	{
		return this.newHero.getX();
	}

	public double getHeroY() 
	{
		return this.newHero.getY();
	}

	public boolean touchHero(Graphics2D g2) 
	{
		if ((Math.abs(getHeroX() - gold.getX()) <= 20) && ((Math.abs(getHeroY() - gold.getY()) <= 40)))
		{
			return true;
		}
		
		return false;
	}


}
