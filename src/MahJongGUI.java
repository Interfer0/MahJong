

import java.awt.Button;

import javax.swing.*;

public class MahJongGUI extends JPanel {
	private Tile tileOne;
	private int tileOneIndex;
	
	
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
		tileOne = (Tile) MahJongBoard.getTILES()[i].clone();
		} catch (Exception e){
			System.out.print("That didn't work");
		}
		System.out.println(tileOne + " is here");
		this.add(tileOne);
		this.repaint();
		this.revalidate();
		
	}


	public Tile getTileOne() {
		// TODO Auto-generated method stub
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
