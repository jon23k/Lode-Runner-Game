package loderunner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.Timer;

public class EnemyAI{
	Hero newHero;
	// Level1 game;
	Enemy enemy;

	public EnemyAI(Enemy enemy) {
		this.enemy = enemy;
		newHero = Hero.getGlobalHero();
	}

	public void move() {

		if (killHeroCheck())
			return;
		for(int i=0;i<1;i++)
		{
			{
				if(enemy.getX() == 487)
				{
					enemy.setX(enemy.getX()-1);
				}
				if(enemy.getX()%2 == 1)
				{
					enemy.setX(enemy.getX()+2);
				}
				if(enemy.getX()%2 == 0)
				{
					enemy.setX(enemy.getX()-2);
				}
				if(enemy.getX() == 2)
				{
					enemy.setX(enemy.getX()+1);
				}		
			}
		}
	}
		
//		BOSS GHOST CLASS (NEED TO MAKE A SEPERATE AI FOR THIS)
//		if (killHeroCheck())
//			return;
//		double hX = getHeroX();
//		double hY = getHeroY();
//
//		double eX = getEnemyX();
//		double eY = getEnemyY();
//
//		if (hX > eX) {
//			enemy.setX(enemy.getX() + 1);
//			if (hY > eY) {
//				enemy.setY(enemy.getY() + 1);
//			} else {
//				enemy.setY(enemy.getY() - 1);
//			}
//			// System.out.println("moving right");
//		} else {
//			enemy.setX(enemy.getX() - 1);
//			if (hY < eY) {
//				enemy.setY(enemy.getY() - 1);
//			} else
//			{
//				enemy.setY(enemy.getY() + 1);
//			}
//		}
//	}

	public double getHeroX() {
		return this.newHero.getX();
	}

	public double getHeroY() {
		return this.newHero.getY();
	}

	public double getEnemyX() {
		return this.enemy.getX();
	}

	public double getEnemyY() {
		return this.enemy.getY();
	}

	public boolean killHeroCheck() {
		if ((Math.abs(newHero.getX() - enemy.getX()) < 10)
				&& (Math.abs(newHero.getY() - enemy.getY()) < 30)) 
		{
			World.restart();
			
			return true;
		}
		return false;
	}
}
