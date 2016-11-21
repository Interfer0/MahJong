import java.awt.*;

import javax.swing.JFrame;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class CircleTile extends RankTile {

	private static final long serialVersionUID = 1L;
	private static int height;
	private static int width;
	private static int depth;
	
	private static int radius;
	private static int radius2;
	private static int radius3;
	private static int radius4;
	
	private static int x1;
	private static int x21;
	private static int x22;
	private static int x31;
	private static int x32;
	private static int x33;
	
	
	private static int y1;
	private static int y21;
	private static int y22;
	private static int y31;
	private static int y32;
	private static int y33;
	private static int y41;
	private static int y42;
	private static int y43;
	private static int y44;
	
	public CircleTile(int rank)
	{
		super(rank);
	}
	
	static{
		height = Tile.getHEIGHT();
		width = Tile.getWIDTH();
		depth = Tile.getDEPTH();
		if(getHEIGHT() <= getWIDTH())
		{
			radius = getHEIGHT() /5;
			radius2 = getHEIGHT() /9;
			radius3 = getHEIGHT() /12;
			radius4 = getHEIGHT() /16;
		} else {
			radius = getWIDTH() /5;
			radius2 = getHEIGHT() /8;
			radius3 = getHEIGHT() /12;
			radius4 = getHEIGHT() /16;
		}
		x1 = depth+width/2-radius;
		x21 = depth + width/3- radius2;
		x22 = depth + 2* width/3- radius2;
		x31 = depth + width/4- radius3;
		x32 = depth + 2* width/4- radius3;
		x33 = depth + 3* width/4- radius3;
		
		y1 = height/2-radius;
		y21 = height/3- radius2;
		y22 = 2 *height/3- radius2;
		y31 = height/4- radius3;
		y32 = 2 * height/4- radius3;
		y33 = 3 * height/4- radius3;
		y41 = height/5- radius4;
		y42 = 2 * height/5- radius4;
		y43 = 3 * height/5- radius4;
		y44 = 4 * height/5- radius4;
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		switch(rank)
		{
		case 5:
			drawDot(g,x31,y31,radius3,Color.BLUE);
			drawDot(g,x32,y32,radius3,Color.RED);
			drawDot(g,x33 ,y31,radius3,Color.GREEN);
			drawDot(g,x33,y33,radius3,Color.BLUE);
			drawDot(g,x31,y33,radius3,Color.GREEN);
			break;
		case 3:
			drawDot(g,x31,y31,radius3,Color.BLUE);
			drawDot(g,x32,y32,radius3,Color.RED);
			drawDot(g,x33, y33,radius3,Color.GREEN);
			break;
		case 1:
			Pancake.drawDot(g, width/2+ depth, height/2, Color.GREEN);
			drawDot(g,x1, y1,radius,Color.RED);
			
			break;
		case 4:
			drawDot(g,x21,y21,radius2,Color.BLUE);
			drawDot(g,x22,y21,radius2,Color.GREEN);
			drawDot(g,x22,y22,radius2,Color.BLUE);
			drawDot(g,x21,y22,radius2,Color.GREEN);
			break;
		case 6:
			drawDot(g,x21,y33,radius2,Color.RED);
			drawDot(g,x21,y32,radius2,Color.RED);
			drawDot(g,x22,y33,radius2,Color.RED);
			drawDot(g,x22,y32,radius2,Color.RED);
			drawDot(g,x21,y31,radius2,Color.GREEN);
			drawDot(g,x22,y31,radius2,Color.GREEN);
			break;
		case 7:
			drawDot(g,x31,height/2-height/3-radius3,radius3,Color.GREEN);
			drawDot(g,x32,height/2-height/(3*2)-radius3,radius3,Color.GREEN);
			drawDot(g,x33,height/2-height/(100)-radius3,radius3,Color.GREEN);
			drawDot(g,x21,height-height/3-radius3,radius3,Color.RED);
			drawDot(g,x21,height- height/(3*3)-radius3,radius3,Color.RED);
			drawDot(g,x22,height-height/3-radius3,radius3,Color.RED);
			drawDot(g,x22,height- height/(3*3)-radius3,radius3,Color.RED);
			break;
		case 8:
			drawDot(g,x21,y41,radius3,Color.BLUE);
			drawDot(g,x21,y42,radius3,Color.BLUE);
			drawDot(g,x21,y43,radius3,Color.BLUE);
			drawDot(g,x21,y44,radius3,Color.BLUE);
			drawDot(g,x22,y41,radius3,Color.BLUE);
			drawDot(g,x22,y42,radius3,Color.BLUE);
			drawDot(g,x22,y43,radius3,Color.BLUE);
			drawDot(g,x22,y44,radius3,Color.BLUE);
			break;
		case 9:
			drawDot(g,x31,y31,radius3,Color.GREEN);
			drawDot(g,x32,y31,radius3,Color.GREEN);
			drawDot(g,x33,y31,radius3,Color.GREEN);
			drawDot(g,x31,y33,radius3,Color.BLUE);
			drawDot(g,x32,y33,radius3,Color.BLUE);
			drawDot(g,x33,y33,radius3,Color.BLUE);
			drawDot(g,x31,y32,radius3,Color.RED);
			drawDot(g,x32,y32,radius3,Color.RED);
			drawDot(g,x33,y32,radius3,Color.RED);
			break;
		case 2:
			drawDot(g,x1,y21,radius2,Color.GREEN);
			drawDot(g,x1,y22,radius2,Color.RED);
			break;
		}
		
	}
	
	public static void drawDot(Graphics g, int x, int y,int radius, Color c)
	{
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.fillOval(x, y, radius*2, radius*2);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.WHITE);
		g.drawOval(x+radius/2+(radius%2),y+radius/2+(radius%2),radius,radius);
		g2.setStroke(new BasicStroke(1));
		g.fillOval(x+radius-2, y+radius-2, 4, 4);
		g.setColor(Color.BLACK);
	}
		
	@Override
	public String toString()
	{
		return "Circle " + super.rank;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));
		

		frame.pack();
		frame.setVisible(true);
	}
}
