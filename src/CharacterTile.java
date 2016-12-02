/*
 * Daniel Bigelow
 * CS3230
 * 12/2/2016
 */

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class CharacterTile extends Tile {
	

	private static final long serialVersionUID = 1L;
	protected char symbol;
	private static Map<String, String> symbs = new HashMap<String, String>();
	private static Map<String, String> symbs2 = new HashMap<String, String>();
		
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;		
		setToolTipText(toString());
	}
	
	static{
		symbs.put("1","\u4E00");
		symbs.put("2","\u4E8C");
		symbs.put("3","\u4E09");
		symbs.put("4","\u56DB");
		symbs.put("5","\u4E94");
		symbs.put("6","\u516D");
		symbs.put("7","\u4E03");
		symbs.put("8","\u516B");
		symbs.put("9","\u4E5D");
		symbs2.put("N", "\u5317");
		symbs2.put("E", "\u6771");
		symbs2.put("W", "\u897F");
		symbs2.put("S", "\u5357");
		symbs2.put("C", "\u4E2D");
		symbs2.put("F", "\u767C");
	}
	

	
	public Boolean matches(Tile other)
	{
		if(!super.matches(other))
			return false;
		CharacterTile ct = (CharacterTile) other;
		return this.symbol == ct.symbol;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		int height = Tile.getHEIGHT();
		int width = Tile.getWIDTH();
		int depth = Tile.getDEPTH();
		int font = Tile.getWIDTH()/2;
		if(width >= height*3/4 || height < width)
			font = height /2;

		if(symbs.containsKey(Character.toString(symbol)))
		{
			g.setColor(Color.RED);
			g.drawString(String.valueOf(symbol), width +depth  - width/4, height/4); //Draw the number
			g.setFont(new Font("Roman",3,font));
			g.drawString("\u842C",  width/2-font/2, height-font/5);
			g.setColor(Color.BLACK);
			g.drawString(symbs.get(Character.toString(symbol)), width/2-font/2, font-font/6);
		}
		else if(symbs2.containsKey(Character.toString(symbol))){
			g.setColor(Color.RED);
			g.drawString(String.valueOf(symbol), width +depth  - width/4, height/4);
			g.setFont(new Font("Roman",0,font+depth));
			g.setColor(Color.BLACK);
			if(symbol == 'F')
				g.setColor(new Color(28,115,45));
			if(symbol == 'C')
				g.setColor(Color.RED);
			g.drawString(symbs2.get(Character.toString(symbol)), width/2-font/2, height-height/4);
		}
		
	}
	
	@Override
	public String toString()
	{
		if(Character.isDigit(symbol))
			return "Character " + Character.toString(symbol);
		switch(Character.toString(symbol))
		{
		case "N":
			return "North Wind";
		case "E":
			return "East Wind";
		case "W":
			return "West Wind";
		case "S":
			return "South Wind";
		case "C":
			return "Red Dragon";
		case "F":
			return "Green Dragon";		
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);
		

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		scroller.setPreferredSize(new Dimension(8 * Tile.getDEPTH()+Tile.getWIDTH(), 40 + Tile.getDEPTH()+Tile.getHEIGHT()));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	
}
