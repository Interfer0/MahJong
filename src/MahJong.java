
/*
 * Daniel Bigelow
 * CS3230
 * 11/21/16
 */

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

import javax.swing.JFrame;

public class MahJong extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private static MahJongBoard MAH;
	private int gameNumber;
	
	
	
	//WindowEvents
	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}



	public MahJong() {
		Random rnd = new Random();
		this.gameNumber = Math.abs(rnd.nextInt());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image img = getToolkit().getImage(getClass().getResource("images/B.png"));
		this.setIconImage(img);
		this.setTitle("MahJong - " + this.gameNumber);
		this.setBackground(new Color(11, 112, 15));
		setSize(1100, 750);
		setResizable(false);
		MahJongGUI mGUI = new MahJongGUI(this.getWidth());
		mGUI.setPreferredSize(new Dimension(1100, 100));
		add(mGUI);
		MAH = new MahJongBoard(gameNumber);
		MAH.setPreferredSize(new Dimension(1100, 600));
		add(MAH);
		setVisible(true);
	}
	
	public static MahJongBoard getMAH(){return MAH;}

	public static void setMAH(MahJongBoard mAH) {MAH = mAH;}


	public void newGame(int gameNumber) {
		this.gameNumber = gameNumber;
		this.setTitle("MahJong - " + this.gameNumber);
		remove(MAH);
		MAH = new MahJongBoard(gameNumber);
		MAH.setPreferredSize(new Dimension(1100, 600));
		add(MAH);
		repaint();
		revalidate();
	}

	public int getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
	public static void main(String[] args) {new MahJong();}
}
