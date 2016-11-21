import java.awt.*;

import javax.swing.JFrame;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class BambooTile extends RankTile {

	private static final long serialVersionUID = 1L;
	private static int height;
	private static int width;
	private static int depth;
	
	private static int bambooWidth;
	
	private static int x1;
	private static int x21;
	private static int x22;
	private static int x31;
	private static int x32;
	private static int x33;
	private static int xs1;
	private static int xs2;


	
	

	private static int y21;
	private static int y22;
	private static int y31;
	private static int y32;
	private static int y33;

	static{
		height = Tile.getHEIGHT();
		width = Tile.getWIDTH();
		depth = Tile.getDEPTH();
		if(getHEIGHT() <= getWIDTH())
		{
			bambooWidth = 12*getHEIGHT() /100;
		} else {
			bambooWidth = getWIDTH() /8;
		}
		x1 = depth+width/2-bambooWidth/4;
		x21 = depth + width/3- bambooWidth/4;
		x22 = depth + 2* width/3- bambooWidth/4;
		x31 = depth + width/4- bambooWidth/2;
		x32 = depth + 2* width/4- bambooWidth/2;
		x33 = depth + 3* width/4- bambooWidth/2;
		xs1 = depth + width/2-3*bambooWidth+bambooWidth;
		xs2 = depth + width/2+bambooWidth;


		y21 = height/3- bambooWidth/2;
		y22 = 2 *height/3- bambooWidth/2;
		y31 = height/4- bambooWidth/4;
		y32 = 2 * height/4- bambooWidth/4;
		y33 = 3 * height/4- bambooWidth/4;

	}

	public BambooTile(int rank)
	{
		super(rank);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(super.getRank())
		{
		case 2:
			paintBamboo(g,x1,y21,Color.BLUE);
			paintBamboo(g,x1,y22,Color.GREEN);
			break;
		case 3:
			paintBamboo(g,x1,y21,Color.BLUE);
			paintBamboo(g,xs1,y22,Color.GREEN);
			paintBamboo(g,xs2,y22,Color.GREEN);
			break;
		case 4:
			paintBamboo(g,x21,y21,Color.BLUE);
			paintBamboo(g,x21,y22,Color.GREEN);
			paintBamboo(g,x22,y21,Color.GREEN);
			paintBamboo(g,x22,y22,Color.BLUE);
			break;
		case 5:
			paintBamboo(g,x31,y31,Color.GREEN);
			paintBamboo(g,x31,y33,Color.BLUE);
			paintBamboo(g,x33,y31,Color.GREEN);
			paintBamboo(g,x33,y33,Color.BLUE);
			paintBamboo(g,x32, y32,Color.RED);
			break;
		case 6:
			paintBamboo(g,x31,y21,Color.GREEN);
			paintBamboo(g,x31,y22,Color.BLUE);
			paintBamboo(g,x32,y21,Color.GREEN);
			paintBamboo(g,x32,y22,Color.BLUE);
			paintBamboo(g,x33,y21,Color.GREEN);
			paintBamboo(g,x33,y22,Color.BLUE);
			break;
		case 7:
			paintBamboo(g,x32, y31,Color.RED);
			paintBamboo(g,x32, y32,Color.BLUE);
			paintBamboo(g,x32, y33,Color.BLUE);
			paintBamboo(g,x31, y32,Color.GREEN);
			paintBamboo(g,x31, y33,Color.GREEN);
			paintBamboo(g,x33, y32,Color.GREEN);
			paintBamboo(g,x33, y33,Color.GREEN);
			break;
		case 8:
			paintBamboo(g,xs1, y32,Color.RED);
			paintBamboo(g,xs2, y32,Color.RED);
			paintBamboo(g,x31, y31,Color.GREEN);
			paintBamboo(g,x32, y31,Color.GREEN);
			paintBamboo(g,x33, y31,Color.GREEN);
			paintBamboo(g,x31, y33,Color.BLUE);
			paintBamboo(g,x32, y33,Color.BLUE);
			paintBamboo(g,x33, y33,Color.BLUE);
			/*RotatedBamboo.paintBamboo(g,xs3,y21,Color.GREEN);
			RotatedBamboo.paintBamboo(g,xs3,y22,Color.BLUE);
			RotatedBamboo.paintBamboo(g,xs4,y21,Color.GREEN);
			RotatedBamboo.paintBamboo(g,xs4,y22,Color.BLUE);
			RotatedBamboo.paintBamboo(g,xrb1,yrb1,45,Color.RED);
			RotatedBamboo.paintBamboo(g,xrb2,yrb2,45,Color.BLUE);
			RotatedBamboo.paintBamboo(g,xrb3,yrb3,-45,Color.BLUE);
			RotatedBamboo.paintBamboo(g,xrb4,yrb4,-45,Color.BLACK);*/
			break;
		case 9:
			paintBamboo(g,x32, y31,Color.RED);
			paintBamboo(g,x32, y32,Color.RED);
			paintBamboo(g,x32, y33,Color.RED);
			paintBamboo(g,x31, y31,Color.BLUE);
			paintBamboo(g,x31, y32,Color.BLUE);
			paintBamboo(g,x31, y33,Color.BLUE);
			paintBamboo(g,x33, y31,Color.GREEN);
			paintBamboo(g,x33, y32,Color.GREEN);
			paintBamboo(g,x33, y33,Color.GREEN);
			break;
		}
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
		s.fillRect(x+6*width/100, y+2*width/100, 2*width/100, 7*width/100);
		s.fillRect(x+6*width/100, y+12*width/100, 2*width/100, 7*width/100);
	}
			
	@Override
	public String toString()
	{
		return "Bamboo " + super.rank;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
