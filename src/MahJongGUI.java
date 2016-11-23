

import java.awt.Button;
import java.util.ArrayList;

import javax.swing.*;

public class MahJongGUI extends JPanel {
	private Tile tileOne;
	private int tileOneIndex;
	private ArrayList<Move> myMoves;
	
	public int getTileOneIndex() {
		return tileOneIndex;
	}


	public void setTileOneIndex(int tileOneIndex) {
		this.tileOneIndex = tileOneIndex;
	}


	public MahJongGUI(int width) {
		setBounds(0, 0, width, 100);
		//add(new Button("test"));
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
		this.add(tileOne);
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

	
}
