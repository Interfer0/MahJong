
/*
 * Daniel Bigelow
 * CS3230
 * 11/21/16
 */

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MahJong extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private static MahJongBoard MAH;
	private int gameNumber;
	private JMenuBar menuBar;

	// WindowEvents
	public void windowClosing(WindowEvent e) {
		System.out.println("here");
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public MahJong() {
		//handle window closing request
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					System.exit(0);
				}
			}
		});
		
		Random rnd = new Random();
		this.gameNumber = Math.abs(rnd.nextInt());

		
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
		JCheckBoxMenuItem soundOff = new JCheckBoxMenuItem("Sound On");

		JMenu move = new JMenu("Move");
		JMenuItem moveUndo = new JMenuItem("Undo");

		JMenu help = new JMenu("Help");
		JMenuItem helpOperation = new JMenuItem("Operation");
		JMenuItem helpRules = new JMenuItem("Game Rules");

		game.add(gamePlay);
		gamePlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					Random rnd = new Random();
					MahJongGUI.getMGUI().newGame(Math.abs(rnd.nextInt()));
				}

			}
		});
		game.add(gameRestart);
		gameRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					MahJongGUI.getMGUI().newGame(gameNumber);
				}
			}
		});
		game.add(gameNumbered);
		gameNumbered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String gn = JOptionPane.showInputDialog("Enter a Game Number:");
				if (gn != null) {
					if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
						if (gn.matches("\\d{1,10}")) {
							gameNumber = Integer.parseInt(gn);
							MahJongGUI.getMGUI().newGame(gameNumber);
						}
					} else {
						JOptionPane.showMessageDialog(getRootPane(), gn + " is not a valid game number!");
					}
				}

			}
		});
		game.add(gameExit);
		gameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					System.exit(0);
				}
			}
		});

		soundOff.setSelected(true);
		soundOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.setSoundon(((JCheckBoxMenuItem) e.getSource()).isSelected());
			}
		});

		sound.add(soundOff);

		move.add(moveUndo);
		moveUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MahJongGUI.getMGUI().removeMove();
			}
		});

		help.add(helpOperation); // todo
		help.add(helpRules); // todo 

		menuBar.add(game);
		menuBar.add(sound);
		menuBar.add(move);
		menuBar.add(help);

		setVisible(true);
	}

	public static MahJongBoard getMAH() {
		return MAH;
	}

	public static void setMAH(MahJongBoard mAH) {
		MAH = mAH;
	}

	public void newGame(int gameNumber) {
		this.gameNumber = gameNumber;
		this.setTitle("MahJong - " + this.gameNumber);
		remove(MAH);
		MAH = new MahJongBoard(gameNumber);
		MAH.setPreferredSize(new Dimension(1100, 600));
		add(MAH);
		Move.resetMyMoves();
		repaint();
		revalidate();
		menuBar.repaint();
		menuBar.revalidate();
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public static void main(String[] args) {
		new MahJong();
		
	}
}
