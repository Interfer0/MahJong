import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public class PictureTile extends Tile {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private static int height;
	private static int width;
	private static int depth;
	
	private static int picSize;

	static{
		height = Tile.getHEIGHT();
		width = Tile.getWIDTH();
		depth = Tile.getDEPTH();
		if(getHEIGHT() <= getWIDTH())
		{
			picSize = 80*(height - 15*height/100) /100;
		} else {
			picSize = 80*(width - 15*width/100) /100;
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Image img1 = getToolkit().getImage(getClass().getResource("images/"+name +".png"));
		
		g.drawImage(img1, depth+width/2-picSize/2, height/2-picSize/2,picSize,picSize, this);
		
	}
	public PictureTile(String name)
	{
		this.name = name;
		setToolTipText(toString());
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
