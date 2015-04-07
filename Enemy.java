package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy{
	
	public int[] location;
	private static Enemy globalEnemy;
	EnemyAI enemyAI;
	
	public static Enemy getGlobalEnemy() {
		return globalEnemy;
	}

	public static void setGlobalEnemy(Enemy globalEnemy) {
		 Enemy.globalEnemy = globalEnemy;
	}
	
	public Enemy(){
		location = new int[2];
		location[0] = 0;
		location[1] = 1;
		this.enemyAI = new EnemyAI(this);
		
	}
	
	public Enemy(int[] intLoc){
		this.location = intLoc;
		this.enemyAI = new EnemyAI(this);
		
	}
	
	public int getX(){
		return this.location[0];
	}
	
	public int getY(){
		return this.location[1];
	}
	
	public void setX(int x){
		this.location[0] = x;
	}
	
	public void setY(int y){
		this.location[1] = y;
	}
	
	public void move(){
		enemyAI.move();
		
	}
	
	public void drawOn(Graphics2D g2)
	{
		g2.setColor(getColor());
		g2.fillOval(getX(),getY(),15,45);
	}

	
	public Color getColor() {
		return Color.LIGHT_GRAY;
	}

}
