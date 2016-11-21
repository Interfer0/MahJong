import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class RotatedBamboo {
	private static int bambooWidth;
	private static int height;
	private static int width;
	
	
	static{
		height = Tile.getHEIGHT();
		width = Tile.getWIDTH();
		
		if(Tile.getHEIGHT() <= Tile.getWIDTH())
		{
			bambooWidth = Tile.getHEIGHT() /20;
		} else {
			bambooWidth = Tile.getWIDTH() /20;
		}
	}
	protected static void paintBamboo(Graphics g, int x, int y,int ang, Color c)
	{

		Graphics2D s = (Graphics2D) g.create();
		AffineTransform t = new AffineTransform();
		t.rotate(Math.toRadians(ang),x+6*bambooWidth/100,12*width/100);
		s.transform(t);
		paintBamboo(s,x,y,c);
	}
	
	protected static void paintBamboo(Graphics g, int x, int y, Color c)
	{
		Graphics2D s = (Graphics2D) g;
		s.setColor(c);
		s.fillRect(x,y,bambooWidth,height/5);
		s.fillArc(x-bambooWidth/2,y,2*bambooWidth,8*height/100,0,180);
		s.fillArc(x-bambooWidth/2,y+8*height/100,2*bambooWidth,8*width/100,0,180);
		s.fillArc(x-bambooWidth/2,y+15*height/100,2*bambooWidth,8*width/100,0,180);
		s.setColor(Color.WHITE);
		s.fillRect(x+bambooWidth/2, y+2*height/100, 1, 7);
		s.fillRect(x+bambooWidth/2, y+12*height/100, 1, 7);
	}
}
