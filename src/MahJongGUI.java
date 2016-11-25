

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class MahJongGUI extends JPanel {
	private Tile tileOne;
	private int tileOneIndex;
	private JPanel buttons;
	private JPanel selected;
	private JPanel playedTiles;
	private JScrollPane tilesScrollPane;
	


	public MahJongGUI(int width) {
		setBounds(0, 0, width, 100);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		buttons = new JPanel();
		buttons.setBackground(Color.BLACK);
		buttons.setPreferredSize(new Dimension(200,90));
		add(buttons);
		
		playedTiles = new JPanel();
		playedTiles.setLayout(new FlowLayout(FlowLayout.LEFT));
		playedTiles.setBackground(Color.YELLOW);
		//playedTiles.getLayout().
		//add(playedTiles);
		
		tilesScrollPane = new JScrollPane(playedTiles);
		tilesScrollPane.setPreferredSize(new Dimension(800,95));
		JScrollBar jsb = new JScrollBar();
		jsb.setBackground(Color.GREEN);
		jsb.setOrientation(JScrollBar.HORIZONTAL);
		jsb.setPreferredSize(new Dimension(800,10));
		tilesScrollPane.setHorizontalScrollBar(jsb);
		tilesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tilesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		tilesScrollPane.setAutoscrolls(true);
		
		add(tilesScrollPane);
		
	}
	
	public int getTileOneIndex() {
		return tileOneIndex;
	}


	public void setTileOneIndex(int tileOneIndex) {
		this.tileOneIndex = tileOneIndex;
	}


	public void setTileOne(int i) {
		tileOneIndex = i;
		try{
		tileOne = (Tile) MahJongBoard.getTILES()[tileOneIndex].clone();
		} catch (Exception e){
			System.out.print("That didn't work");
		}
		tileOne.setUnselected();
			(MahJongBoard.getTILES()[tileOneIndex]).setUnselected();
		this.add(tileOne, BorderLayout.LINE_START);
		//this.add(new Button("test"), BorderLayout.LINE_END);
		this.repaint();
		this.revalidate();
		
	}
	
	public Tile getTileOne() {
		return tileOne;
	}

	public void resetTileOne() {
		this.remove(tileOne);
		tileOne = null;
		tileOneIndex = -1;
		this.repaint();
		this.revalidate();
	}
	
	public void addMove(Move move)
	{
		MahJongBoard.getTILES()[move.getTileOne()].setUnselected();
		Tile t1 = Tile.getTileClone(move.getTileOne());
		t1.setUnselected();
		t1.setVisible(true);
		playedTiles.add(t1);
		MahJongBoard.getTILES()[move.getTileTwo()].setUnselected();
		Tile t2 = Tile.getTileClone(move.getTileTwo());
		t2.setUnselected();
		t2.setVisible(true);
		playedTiles.add(t2);
		playedTiles.repaint();
		playedTiles.revalidate();
		tilesScrollPane.repaint();
		tilesScrollPane.revalidate();
		
	}
	
	public void removeMove()
	{
		playedTiles.remove(playedTiles.getComponentCount());
		playedTiles.remove(playedTiles.getComponentCount());
	}
	
	
}
