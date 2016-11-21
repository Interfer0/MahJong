import java.awt.*;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public abstract class Tile extends JPanel
{

	private static final long serialVersionUID = 1L;
	static Polygon SIDELI;
	static Polygon SIDEBI;
	static Polygon SIDELO;
	static Polygon SIDEBO;
	static Rectangle FACE;
	static GradientPaint GRAD1;
	static GradientPaint GRAD2;
	static GradientPaint GRAD3;
	static GradientPaint GRAD4;
	private static int WIDTH = 75;
	private static int HEIGHT = 100;
	private static int DEPTH = 10;
	
	private  Tile toL;
	private  Tile toR;
	private  Tile toB;
	private Tile toR2;
	private Tile toL2;
	
	static
	{
		// inner box
		int[] lxi =
		{ DEPTH / 2, DEPTH, DEPTH, DEPTH / 2 };
		int[] lyi =
		{ DEPTH / 2, 0, HEIGHT, HEIGHT + DEPTH / 2 };
		int[] bxi =
		{ DEPTH / 2, DEPTH, WIDTH + DEPTH, WIDTH + DEPTH / 2 };
		int[] byi =
		{ HEIGHT + DEPTH / 2, HEIGHT, HEIGHT, HEIGHT + DEPTH / 2 };

		// outer box
		int[] lxo =
		{ 0, DEPTH / 2, DEPTH / 2, 0 };
		int[] lyo =
		{ DEPTH, DEPTH / 2, HEIGHT + DEPTH / 2, HEIGHT + 10 };
		int[] bxo =
		{ 0, DEPTH / 2, WIDTH + DEPTH / 2, WIDTH };
		int[] byo =
		{ HEIGHT + DEPTH, HEIGHT + DEPTH / 2, HEIGHT + DEPTH / 2, HEIGHT + DEPTH };

		SIDELI = new Polygon(lxi, lyi, 4);
		SIDEBI = new Polygon(bxi, byi, 4);
		SIDELO = new Polygon(lxo, lyo, 4);
		SIDEBO = new Polygon(bxo, byo, 4);

		GRAD1 = new GradientPaint(0, 0, Color.BLUE, DEPTH / 2, 0, Color.GREEN);
		GRAD2 = new GradientPaint(0, HEIGHT + DEPTH, Color.GREEN, WIDTH + DEPTH, HEIGHT + DEPTH / 2, Color.BLUE);
		GRAD3 = new GradientPaint(DEPTH / 2, 0, new Color(255, 255, 255), DEPTH, 0, new Color(200, 200, 200));
		GRAD4 = new GradientPaint(DEPTH / 2, HEIGHT, new Color(255, 255, 255), WIDTH + DEPTH, HEIGHT + DEPTH / 2,
				new Color(200, 200, 200));

	}


	public Tile()
	{
		setBackground(null);
		setPreferredSize(new Dimension(DEPTH + WIDTH + 1, DEPTH + HEIGHT + 1));
		
	}

	public Boolean matches(Tile other)
	{
		if (this == other)
			return true;
		if (other == null)
			return false;
		return getClass() == other.getClass();
	}

	@Override
	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setPaint(GRAD1);
		g2.fill(SIDELO);
		g2.setPaint(GRAD2);
		g2.fill(SIDEBO);
		g2.setPaint(GRAD3);
		g2.fill(SIDELI);
		g2.setPaint(GRAD4);
		g2.fill(SIDEBI);

		g2.fillRect(DEPTH, 0, WIDTH, HEIGHT);

		g2.setPaint(Color.BLACK);

		g.drawPolygon(SIDELI);
		g.drawPolygon(SIDEBI);
		g.drawPolygon(SIDELO);
		g.drawPolygon(SIDEBO);

		g.drawRect(DEPTH, 0, WIDTH, HEIGHT);
	}

	public static int getWIDTH()
	{
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH)
	{
		WIDTH = wIDTH;
	}

	public static int getHEIGHT()
	{
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT)
	{
		HEIGHT = hEIGHT;
	}

	public static int getDEPTH()
	{
		return DEPTH;
	}

	public static void setDEPTH(int dEPTH)
	{
		DEPTH = dEPTH;
	}
	
	
	
	public boolean isPlayable()
	{
		if(((toR != null || !toR.isVisible())|| (toL != null || !toL.isVisible()) || (toB != null || !toB.isVisible())))
				return false;
		return true;
	}

	public Tile getToR()
	{
		return toR;
	}
	
	public Tile getToL()
	{
		return toL;
	}
	
	public Tile getToB()
	{
		return toB;
	}

	public void setToR(Tile toR)
	{
		this.toR = toR;
		setToolTipText(getNeighbors());
	}
	
	public void setToR2(Tile toR2)
	{
		this.toR2 = toR2;
		setToolTipText(getNeighbors());
	}

	public void setToL(Tile toL)
	{
		this.toL = toL;
		setToolTipText(getNeighbors());
	}
	public void setToL2(Tile toL2)
	{
		this.toL2 = toL2;
		setToolTipText(getNeighbors());
		
	}

	public void setToB(Tile toB)
	{
		this.toB = toB;
		setToolTipText(getNeighbors());
		
	}
	
	public String getNeighbors()
	{
		String rtn = "";
		if(toL != null && toL.isVisible())
			rtn += ("| Left: " + toL.toString() );
		if(toL2 != null && toL2.isVisible())
			rtn += ("| Left2: " + toL2.toString() );
		if(toR != null && toR.isVisible())
			rtn += ("| Right: " + toR.toString() );
		if(toR2 != null && toR2.isVisible())
			rtn += ("| Right2: " + toR2.toString() );
		if(toB != null && toB.isVisible())
			rtn += ("| Behind: " + toB.toString() );
		return rtn;
		
	}
	


	

	

}
