package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import loderunner.Level;

public class Hero2 extends Hero implements KeyListener
{
	public int[] location;
	public int[] size;
	private static Hero globalHero;

	public static Hero getGlobalHero() {
		return globalHero;
	}

	public static void setGlobalHero(Hero globalHero) 
	{
		Hero2.globalHero = globalHero;
	}


	public Hero2()
	{
		location = new int[2];
		location[0] = 0;
		location[1] = 1;
		size = new int[2];
		size[0] = 25;
		size[1] = 50;
		World.world.addKeyListener(this);
	}

	public Hero2(int[] initLoc, int[] size1)
	{
		location = initLoc;
		size = size1;
	}
	public int getX()
	{
		return location[0];
	}

	public int getY()
	{
		return location[1];
	}

	public int getWidth()
	{
		return size[0];
	}

	public int getHeight()
	{
		return size[1];
	}


	@Override
	public void keyPressed(KeyEvent event)
	{
		Level l1 = World.globalLevel;
		int count =0;
		switch(event.getKeyCode()){
		case KeyEvent.VK_UP:
			if(location[1] > 0)
			{
				for(int i=0;i<l1.ladders.size();i++)
				{

					int locX = location[0] +12;
					System.out.println("Hero Location X:" +locX);
					int locY = location[1]+45;
					System.out.println("Hero Location Y:" +locY);
					int x = l1.getXPos(l1.ladders.get(i));
					int width = l1.getWidth(l1.ladders.get(i)) + x;
					int y = l1.getYPos(l1.ladders.get(i));
					int height = l1.getHeight(l1.ladders.get(i)) + y;


					if(locX >= x && locX <= width && locY >= y && locY <= height)
					{
						count++;
					}
				}
				System.out.println("Count:" + count);
				if(count > 0)
				{
					count = 0;
					location[1] = location[1] - 5;
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			if(location[1] < 450)         //Arbitary Value should set to getHeight;
			{
				for(int i=0;i<l1.ladders.size();i++)
				{
					System.out.println("Hero Location X:" +location[0]);
					int locX = location[0] +12;
					System.out.println("Hero Location Y: " +location[1]);
					int locY = location[1] + 51;
					int x = l1.getXPos(l1.ladders.get(i));
					System.out.println("Ladder X Pos: " +x);
					int width = l1.getWidth(l1.ladders.get(i)) + x;
					System.out.println("Ladder Width: " +width);
					int y = l1.getYPos(l1.ladders.get(i));
					System.out.println("Ladder Y Pos: " +y);
					int height = l1.getHeight(l1.ladders.get(i)) + y;
					System.out.println("Ladder height: " +height);

					if(locX >= x && locX <= width && locY >= y && locY <= height)
					{
						count++;
					}
				}
				System.out.println("Count:" + count);
				if(count == 1)
				{
					count = 0;
					System.out.println("0Count:" +count);
					location[1] = location[1] + 5;
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
				
			for(int i=0;i<l1.tiers.size();i++)
			{
				
				int locX = location[0] +12;
				System.out.println("Hero Location X:" +locX);
				int locY = location[1] +50;
				System.out.println("Hero Location Y:" +locY);
				int x = l1.getXPos(l1.tiers.get(i));
				System.out.println("Tier X Pos: " +x);
				int width = l1.getWidth(l1.tiers.get(i)) + x;
				System.out.println("Tier Width: " +width);
				int y = l1.getYPos(l1.tiers.get(i));
				System.out.println("Tier Y Pos: " +y);
				int height = l1.getHeight(l1.tiers.get(i)) + y;
				System.out.println("Tier height: " +height);

				if(locY == 51)
				
					if(locX >50 && locX<375)
					{
						location[0] = location[0] +1;
					}
				
					else if(locX > 0 && locX<25)
					{
						location[0] = location[0] + 1;
					}
					else if(locX>=25 && locX<=50)
					{
						location[1] = 71-10;
					}
					else if(locX<=375)
					{
						location[1] = 61;
					}
				if(locY == 111)
					if(locX > 0 && locX < 500)
					{
						location[0] = location[0] +1;
					}
				if(locY == 171)
					if(locX > 250 && locX < 500)
					{
						location[0] = location[0] +1;
					}
					else if(locY==171 && locX<=250)
					{
						location[0] = 200;
						location[1] = 161+20;
					}
					else if(locX > 0 && locX < 50)
					{
						location[0] = location[0] +1;
					}
				if(locY == 231 )
						if(locX > 300 && locX < 430)
						{
							location[0] = location[0] +1;
						}
						else if(locX > 0 && locX < 250)
						{
							location[0] = location[0] +1;
						}
						else if(locX >=250 && locX <=300 && locY == 231)
						{
							location[1] = 251-10;
						}
						else if(locX >= 430 && locX <= 499 && locY == 231)
						{
							location[1] = 251-10;
						}
				if(locY == 291)
				{
					if(locX>130 && locX < 130+370)
					{
						location[0] = location[0] +1;
					}
					if(locX<=130 && locY == 291)
					{
						location[1] = 291 + 10; 
					}
				}
					
				if(locY == 351)
				{
					if(locX>0 && locX<250)
					{
						location[0] = location[0] + 1;
					}
				}
				
				else if(locY == 500)
				{
					location[0] = location[0] + 1;
				}
			}
				
		break;
		case KeyEvent.VK_LEFT:
			
			for(int i=0;i<l1.tiers.size();i++)
			{
				
				int locX = location[0] +12;
				System.out.println("Hero Location X:" +locX);
				int locY = location[1] +50;
				System.out.println("Hero Location Y:" +locY);
				int x = l1.getXPos(l1.tiers.get(i));
				System.out.println("Tier X Pos: " +x);
				int width = l1.getWidth(l1.tiers.get(i)) + x;
				System.out.println("Tier Width: " +width);
				int y = l1.getYPos(l1.tiers.get(i));
				System.out.println("Tier Y Pos: " +y);
				int height = l1.getHeight(l1.tiers.get(i)) + y;
				System.out.println("Tier height: " +height);

				if(locY == 51)
				
					if(locX >50 && locX<375)
					{
						location[0] = location[0] -1;
					}
				
					else if(locX > 0 && locX<25)
					{
						location[0] = location[0] - 1;
					}
				if(locY == 111)
					if(locX > 0 && locX < 500)
					{
						location[0] = location[0] -1;
					}
				if(locY == 171)
					if(locX > 250 && locX < 500)
					{
						location[0] = location[0] -1;
					}
					else if(locX > 0 && locX < 50)
					{
						location[0] = location[0] -1;
					}
				if(locY == 231 )
						if(locX > 300 && locX < 430)
						{
							location[0] = location[0] -1;
						}
						else if(locX > 0 && locX < 250)
						{
							location[0] = location[0] -1;
						}
				if(locY == 291)
				{
					if(locX>130 && locX < 130+370)
					{
						location[0] = location[0] -1;
					}
				}
					
				if(locY == 351)
				{
					if(locX>0 && locX<250)
					{
						location[0] = location[0] - 1;
					}
				}
				
				else if(locY == 500)
				{
					location[0] = location[0] - 1;
				}
			}
		}
	}

	public void drawOn(Graphics2D g2)
	{
		g2.setColor(Color.MAGENTA);
		g2.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Not Used
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Not Used
	}
}



