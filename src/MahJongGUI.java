/*
 * Daniel Bigelow
 * CS3230
 * 12/2/2016
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class MahJongGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private Tile tileOne;
	private int tileOneIndex;
	private JPanel buttons;

	private JPanel playedTiles;
	private JScrollPane tilesScrollPane;
	private static MahJongGUI MGUI;

	
	public MahJongGUI(int width) {
		
		MahJongGUI.setMGUI(this);
		this.setBackground(new Color(11, 112, 15));
		setBounds(0, 0, width, 110);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		Button undoButton = new Button("Undo");	//Undoes last move
		undoButton.setPreferredSize(new Dimension(190, 40));
		undoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MahJongGUI.MGUI.removeMove();
			}
		});

		Button newGame = new Button("New Game"); //Starts a new random game
		newGame.setPreferredSize(new Dimension(190, 20));
		newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					Random rnd = new Random();
					MahJongGUI.getMGUI().newGame(Math.abs(rnd.nextInt()));
				}
			}
		});

		Button playAgain = new Button("Play This Board Again");	//starts the same game over
		playAgain.setPreferredSize(new Dimension(190, 20));
		playAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(getRootPane(), "Are You Sure?") == 0) {
					MahJongGUI.getMGUI().newGame(((MahJong)getRootPane().getParent()).getGameNumber());
				}
			}
		});

		buttons = new JPanel();
		buttons.setBackground(new Color(11, 112, 15));
		buttons.setPreferredSize(new Dimension(200, 100));

		buttons.add(newGame);
		buttons.add(playAgain);
		buttons.add(undoButton);

		

		playedTiles = new JPanel();
		playedTiles.setLayout(new FlowLayout(FlowLayout.LEFT));
		playedTiles.setBackground(new Color(11, 112, 15));

		tilesScrollPane = new JScrollPane(playedTiles);
		tilesScrollPane.setPreferredSize(new Dimension(800, 100));
		JScrollBar jsb = new JScrollBar();
		jsb.setBackground(new Color(11, 112, 45));
		jsb.setForeground(new Color(11, 112, 45));
		jsb.setOrientation(JScrollBar.HORIZONTAL);
		jsb.setPreferredSize(new Dimension(800, 10));
		tilesScrollPane.setHorizontalScrollBar(jsb);
		tilesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tilesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(tilesScrollPane);
		add(buttons);
	}

	//creates a new game with a gameNumber
	protected void newGame(int gameNumber) {
		((MahJong)getRootPane().getParent()).newGame(gameNumber);
		setupGUI();
	}

	//Resets the GUI to null
	private void setupGUI() {
		resetTileOne();
		playedTiles.removeAll();
		playedTiles.repaint();
		playedTiles.revalidate();
	}

	//sets a tile as selected and moves a copy into the GUI for display
	public void setTileOne(int i) {
		tileOneIndex = i;
		try {
			tileOne = (Tile) MahJongBoard.getTILES()[tileOneIndex].clone();
		} catch (Exception e) {
			System.out.print("That didn't work");
		}
		tileOne.setUnselected();
		(MahJongBoard.getTILES()[tileOneIndex]).setUnselected();
		this.add(tileOne, BorderLayout.LINE_START);
		this.repaint();
		this.revalidate();
	}

	//resets tile one to be unselected
	public void resetTileOne() {
			this.remove(tileOne);
			tileOne = null;
			tileOneIndex = -1;
			this.repaint();
			this.revalidate(); 		
	}
	
	public void setTileOneIndex(int tileOneIndex) {this.tileOneIndex = tileOneIndex;}
	public JPanel getPlayedTiles() {return playedTiles;}
	public int getTileOneIndex(){return tileOneIndex;}
	public Tile getTileOne(){return tileOne;}
	public void addMove(Move move){Move.addMove(move, playedTiles);}
	public void removeMove(){Move.removeMove(playedTiles);}
	public static MahJongGUI getMGUI(){return MGUI;}
	public static void setMGUI(MahJongGUI mGUI){MGUI = mGUI;}

}
