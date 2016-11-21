import java.awt.*;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class Pancake {
	
	private static int radius;
	
	static{
		if(Tile.getHEIGHT() <= Tile.getWIDTH())
		{
			radius = Tile.getHEIGHT() /2-Tile.getHEIGHT()/10;
		} else
		{
			radius = Tile.getWIDTH() /2-Tile.getWIDTH()/10;
		}
	}
	
	
	
	public static void drawDot(Graphics g, int x, int y, Color c)
	{
		
		int height = Tile.getHEIGHT();
		int width = Tile.getWIDTH();
		int depth = Tile.getDEPTH();
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLACK);
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.WHITE);
		for(int i = 0; i<= 360; i=i+15)
			g.fillOval(
				(int) Math.round(((Math.sin(Math.toRadians(i))*(radius-radius/5))+depth + width/2-2)),
				(int) Math.round(((Math.cos(Math.toRadians(i))*(radius-radius/5))+height /2-2)), 
				4, 4);
		for(int i = 5; i<= 360; i=i+15)
			g.fillOval(
				(int) Math.round(((Math.sin(Math.toRadians(i))*(radius-radius/4))+depth + width/2-2)),
				(int) Math.round(((Math.cos(Math.toRadians(i))*(radius-radius/4))+height /2-2)), 
				4, 4);
		for(int i = 10; i<= 360; i=i+15)
			g.fillOval(
				(int) Math.round(((Math.sin(Math.toRadians(i))*(radius-radius/3))+depth + width/2-2)),
				(int) Math.round(((Math.cos(Math.toRadians(i))*(radius-radius/3))+height /2-2)), 
				4, 4);
		
	}
}
