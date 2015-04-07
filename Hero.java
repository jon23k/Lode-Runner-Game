	package loderunner;


	import java.awt.Color;
	import java.awt.Graphics2D;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import loderunner.Level;

	public class Hero implements KeyListener
	{
		public int[] location;
		public int[] size;
		private static Hero globalHero;

		public static Hero getGlobalHero() {
			return globalHero;
		}

		public static void setGlobalHero(Hero globalHero) {
			Hero.globalHero = globalHero;
		}


		public Hero()
		{
			location = new int[2];
			location[0] = 0;
			location[1] = 1;
			size = new int[2];
			size[0] = 25;
			size[1] = 50;
			World.world.addKeyListener(this);
		}

		public Hero(int[] initLoc, int[] size1)
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
						int locY = location[1]+45;
						int x = l1.getXPos(l1.ladders.get(i));
						int width = l1.getWidth(l1.ladders.get(i)) + x;
						int y = l1.getYPos(l1.ladders.get(i));
						int height = l1.getHeight(l1.ladders.get(i)) + y;

						if(locX >= x && locX <= width && locY >= y && locY <= height)
						{
							count++;
						}
					}
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
						int locX = location[0] +12;
						int locY = location[1] + 51;
						int x = l1.getXPos(l1.ladders.get(i));
						int width = l1.getWidth(l1.ladders.get(i)) + x;
						int y = l1.getYPos(l1.ladders.get(i));
						int height = l1.getHeight(l1.ladders.get(i)) + y;

						if(locX >= x && locX <= width && locY >= y && locY <= height)
						{

							count++;
						}
					}
					if(count == 1)
					{
						count = 0;
						location[1] = location[1] + 5;
					}
				}
				break;
			case KeyEvent.VK_RIGHT:
					
				for(int i=0;i<l1.tiers.size();i++)
				{
					
					int locX = location[0] +12;
					int locY = location[1] +50;
					int x = l1.getXPos(l1.tiers.get(i));
					int width = l1.getWidth(l1.tiers.get(i)) + x;
					int y = l1.getYPos(l1.tiers.get(i));
					int height = l1.getHeight(l1.tiers.get(i)) + y;

					if(locY == 51)
					
						if(locX >0 && locX<400)
						{
							location[0] = location[0] +1;
						}
						if(locX==400)
						{
							location[1]= 171-50;
						}
					
						else if(locX > 425 && locX < 470)
						{
							location[0] = location[0] +1;
						}
					if(locY == 111)
						if(locX > 75 && locX < 75+250)
						{
							location[0] = location[0] +1;
						}
						if(locY == 111 && locX < 90)
						{
							location[1]= 171+10;
						}
						if(locY==111 && locX >62+250)
						{
							location[1]= 171+10;
						}
					if(locY == 171)
						if(locX > 350 && locX < 500)
						{
							location[0] = location[0] +1;
						}
						else if(locX > 0 && locX < 50)
						{
							location[0] = location[0] +1;
						}
						if(locY==171 && (locX>50 && locX < 360) )
						{
							location[1] = 231-50;
						}
					if(locY == 231 )
							if(locX > 30 && locX < 390)
							{
								location[0] = location[0] +1;
							}
							if(locY == 231 && locX<35)
							{
								location[1] = 291+10;
							}
							if(locY == 231 && locX>390)
							{
								location[1] = 291 - 50;
							}
					if(locY == 291)
					{
						if(locX>300 && locX < 500)
						{
							location[0] = location[0] +1;
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
				if(location[0] > 0)
				for(int i=0;i<l1.tiers.size();i++)
				{
					
					int locX = location[0] +12;
					int locY = location[1] +50;
					int x = l1.getXPos(l1.tiers.get(i));
					int width = l1.getWidth(l1.tiers.get(i)) + x;
					int y = l1.getYPos(l1.tiers.get(i));
					int height = l1.getHeight(l1.tiers.get(i)) + y;


					if(locY == 51)
					
						if(locX >0 && locX<400)
						{
							location[0] = location[0] -1;
						}
					
						else if(locX > 425 && locX < 470)
						{
							location[0] = location[0] -1;
						}
					if(locY == 111)
						if(locX > 75 && locX < 75+250)
						{
							location[0] = location[0] -1;
						}
					if(locY == 171)
						if(locX > 350 && locX < 500)
						{
							location[0] = location[0] -1;
						}
						else if(locX > 0 && locX < 50)
						{
							location[0] = location[0] -1;
						}
					if(locY == 231 )
							if(locX > 30 && locX < 360+30)
							{
								location[0] = location[0] -1;
							}
					if(locY == 291)
					{
						if(locX>300 && locX < 500)
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


