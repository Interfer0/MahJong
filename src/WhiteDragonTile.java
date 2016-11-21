import java.awt.*;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class WhiteDragonTile extends Tile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int height;
	private static int depth;
	
	private static int blockSize;
	
	private static int x1,x2,xi1,xi2;
	
	private static int y1,y2,yi1,yi2;
	
	private static int b1,b2;
	
	static{
		height = Tile.getHEIGHT();
		depth = Tile.getDEPTH();
		if(getHEIGHT() <= getWIDTH())
		{
			blockSize = getHEIGHT();
		} else {
			blockSize = getWIDTH();
		}
		x1 = depth + (int) Math.ceil(5*blockSize/100);
		x2 = depth+blockSize-(int) Math.ceil(5*blockSize/100) -x1;
		xi1 = x1+(int) Math.ceil(5*blockSize/100);
		xi2 = x2-2*(int) Math.ceil(5*blockSize/100);
		
		y1 = (height/2)-blockSize/2+(int) Math.ceil(5*blockSize/100);
		y2 = (height/2)+blockSize/2-y1-(int) Math.ceil(5*blockSize/100);
		yi1 = y1+5*blockSize/100;
		yi2 = y2-5*blockSize/100-(int) Math.ceil(5*blockSize/100);
		
		b1 = (y2)/6;
		b2 = yi1-y1;		
	}
	
	public WhiteDragonTile()
	{
		super();
		setToolTipText(toString());
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawRect(x1,y1, x2, y2);
		g.drawRect(xi1, yi1, xi2, yi2);
		Graphics2D s = (Graphics2D) g;
		//top
		s.fillRect(x1, y1,b1, b2+1);
		s.fillRect(x1+2*b1, y1, b1, b2);
		s.fillRect(x1+4*b1, y1, b1, b2);
		
		//right
		s.fillRect(xi1+xi2, y1, b2, b1);
		s.fillRect(xi1+xi2, y1+2*b1, b2, b1);
		s.fillRect(xi1+xi2, y1+4*b1, b2, b1);
		
		//bottom
		s.fillRect(x1+x2-b1, yi1+yi2, b1, b2+1);
		s.fillRect(x1+x2-3*b1, yi1+yi2, b1, b2);
		s.fillRect(x1+x2-5*b1, yi1+yi2, b1, b2);
		
		//left
		s.fillRect(x1, y1+y2-b1, b2+1, b1);
		s.fillRect(x1, y1+y2-3*b1, b2, b1);
		s.fillRect(x1, y1+y2-5*b1, b2, b1);
		
	}
	
	@Override
	public String toString()
	{
		return "White Dragon";
	}
}
