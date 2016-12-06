/*
 * Daniel Bigelow
 * CS3230
 * 12/2/2016
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//MahJongBoard class handles the board using the MahJong model as the layout. 
//The board also handles all tile clicks and checks for matches of those tiles
public class MahJongBoard extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private static Tile[] TILES = new Tile[144]; //list of tiles
	private static Image img;
	private static Sounds sound = new Sounds();
	private static Fireworks fire;

	public MahJongBoard(int gameNumber) {
		fire = new Fireworks(this);
		TILES = createTiles(gameNumber);

		this.setBackground(new Color(11, 112, 15));
		MahJongModel model = new MahJongModel(); // Custom layout Model
		MahJongModel.setTileNumber(0); // tracks the current tile being places
		MahJongModel.setCounter(0); // tracks the current tile after 50 or so
									// tiles
		model.preferredLayoutSize(this);
		this.setLayout(model);
		for (Tile t : TILES) {
			add(t);
			t.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Tile sT = (Tile) e.getSource();
					playClick(sT);
				}

			});
		}
		addMouseListener(this);
		setVisible(true);
		this.repaint();

	}

	// paint the background
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		img = getToolkit().getImage(getClass().getResource("images/Dragon.png"));
		g.drawImage(img, this.getWidth() / 2 - img.getWidth(this) / 2,
				40 + this.getHeight() / 2 - img.getHeight(this) / 2, this);
	}

	// create 144 tiles and return them in a array
	private Tile[] createTiles(int gameNumber) {
		ArrayList<Tile> rtn = new ArrayList<Tile>();
		// number tiles
		for (int c = 0; c < 4; c++) {
			for (int i = 1; i < 10; i++) {
				rtn.add(new CharacterTile(Character.forDigit(i, 10)));
			}
			// Direction Tiles
			rtn.add(new CharacterTile('N'));
			rtn.add(new CharacterTile('S'));
			rtn.add(new CharacterTile('E'));
			rtn.add(new CharacterTile('W'));
			// C tile
			rtn.add(new CharacterTile('C'));
			// F tile
			rtn.add(new CharacterTile('F'));
			// white Dragon
			rtn.add(new WhiteDragonTile());
			// circle tiles
			for (int i = 1; i < 10; i++) {
				rtn.add(new CircleTile(i));
			}
			// Bamboo One
			rtn.add(new Bamboo1Tile());
			// Bamboo Tiles
			for (int i = 2; i < 10; i++) {
				rtn.add(new BambooTile(i));
			}
		}
		// picture Tiles
		rtn.add(new FlowerTile("Chrysanthemum"));
		rtn.add(new FlowerTile("Orchid"));
		rtn.add(new FlowerTile("Plum"));
		rtn.add(new FlowerTile("Bamboo"));
		rtn.add(new SeasonTile("Spring"));
		rtn.add(new SeasonTile("Summer"));
		rtn.add(new SeasonTile("Fall"));
		rtn.add(new SeasonTile("Winter"));
		Collections.shuffle(rtn, new Random(gameNumber));
		Tile[] myReturn = new Tile[144];
		int i = 0;
		for (Tile t : rtn)
			myReturn[i++] = t;
		return myReturn;
	}

	//runs whenever a tile is clicked on the board. 
	public static void playClick(Tile sT) {
		if (sT.isPlayable()) {
			// check if tile is null
			for (int i = 0; i <= TILES.length - 1; i++) {
				if (TILES[i] == sT) {
					if (MahJongGUI.getMGUI().getTileOne() == null) {
						MahJongGUI.getMGUI().setTileOne(i);
						// set selected tile to showAsSelected
						sT.setSelected();
						sound.singleClick();
					} else {
						// check if tileOne and tileTwo match
						if (TILES[MahJongGUI.getMGUI().getTileOneIndex()].matches(sT)) {
							// set tile visibility to false
							TILES[MahJongGUI.getMGUI().getTileOneIndex()].setVisible(false);
							sT.setVisible(false);
							Move move = new Move(i, MahJongGUI.getMGUI().getTileOneIndex());
							MahJongGUI.getMGUI().addMove(move);
							sound.doubleClick();

							if (Move.getMyMoves().size() == 72) {

								fire.setExplosions(23, 1000);
								fire.fire(MahJong.getWIDTH(), MahJong.getHEIGHT());

							}
						} else {
							sound.noMatchClick();
						}
						// set both tiles to unselected;
						TILES[MahJongGUI.getMGUI().getTileOneIndex()].setUnselected();
						sT.setUnselected();
						MahJongGUI.getMGUI().resetTileOne();

					}
				}
			}
		}

	}

	// Tile List
	public static Tile[] getTILES() {
		return TILES;
	}

	public static void setTILES(Tile[] Tiles) {
		TILES = Tiles;
	}

	// Reset the selected tile if the board is clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		if (MahJongGUI.getMGUI().getTileOne() != null) {
			TILES[MahJongGUI.getMGUI().getTileOneIndex()].setUnselected();
			MahJongGUI.getMGUI().resetTileOne();
			sound.noMatchClick();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}