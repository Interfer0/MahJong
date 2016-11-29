
/*
 * Daniel Bigelow
 * CS3230
 * 11/21/16
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class MahJong extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private static MahJongBoard MAH;
	private int gameNumber;
	private JMenuBar menuBar;
	
	
	
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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu game = new JMenu("Game");
		JMenuItem gamePlay = new JMenuItem("Play");
		JMenuItem gameRestart = new JMenuItem("Restart");
		JMenuItem gameNumbered = new JMenuItem("Numbered");
		JMenuItem gameExit = new JMenuItem("Exit");
		
		JMenu sound = new JMenu("Sound");
		JCheckBoxMenuItem soundOff = new JCheckBoxMenuItem("Sound Off");
		
		JMenu move = new JMenu("Move");
		JMenuItem moveUndo = new JMenuItem("Undo");
		
		JMenu help = new JMenu("Help");
		JMenuItem helpOperation = new JMenuItem("Operation");
		JMenuItem helpRules = new JMenuItem("Game Rules");
		
		game.add(gamePlay);
		gamePlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Random rnd = new Random();
					MahJongGUI.getMGUI().newGame(Math.abs(rnd.nextInt()));
					}
				});
		game.add(gameRestart);
		gameRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MahJongGUI.getMGUI().newGame(gameNumber);
				}
			});
		game.add(gameNumbered); //todo add checking and error handling
		gameNumbered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String gn = JOptionPane.showInputDialog("Enter a Game Number:");
				gameNumber = Integer.parseInt(gn);
				MahJongGUI.getMGUI().newGame(gameNumber);
				}
			});
		game.add(gameExit);
		gameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			});
		
		sound.add(soundOff); //todo
		
		move.add(moveUndo);
		moveUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MahJongGUI.getMGUI().removeMove();
				}
			});
		
		help.add(helpOperation); //todo
		help.add(helpRules); //todo
		
		menuBar.add(game);
		menuBar.add(sound);
		menuBar.add(move);
		menuBar.add(help);
		
		
		
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
		MahJongGUI.getMGUI().repaint();
		MahJongGUI.getMGUI().revalidate();
	}

	public int getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
	public static void main(String[] args) {new MahJong();}
}
