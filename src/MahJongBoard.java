
/*

 * Daniel Bigelow

 * CS3230

 * 11/21/16

 */

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.GenericArrayType;
import java.util.*;
import javax.swing.*;

public class MahJongBoard extends JPanel implements MouseListener {
	/**
	* 
	 */
	private static final long serialVersionUID = 1L;
	private static Tile[] TILES = new Tile[144];
	private static Image img;
	private static Sounds sound = new Sounds();
	private static Fireworks fire;

	public MahJongBoard(int gameNumber) {
		fire = new Fireworks(this);
		TILES = createTiles(gameNumber);

		this.setBackground(new Color(11, 112, 15));
		MahJongModel model = new MahJongModel(); // Custom layout Model
		MahJongModel.setTileNumber(0);
		MahJongModel.setCounter(0);
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

	// Tile List
	public static Tile[] getTILES() {
		return TILES;
	}

	public static void setTILES(Tile[] Tiles) {
		TILES = Tiles;
	}

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
							
							//if(Move.getMyMoves().size() == 144)
							//{
								System.out.println(sT.getParent().getParent());
								fire.setExplosions(0, 1000);
								fire.fire(MahJong.getWIDTH(),MahJong.getHEIGHT());
								
							//}
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

	// Reset the selected tile if the board is clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		if(MahJongGUI.getMGUI().getTileOne() != null)
		{
			TILES[MahJongGUI.getMGUI().getTileOneIndex()].setUnselected();
			MahJongGUI.getMGUI().resetTileOne();
			sound.noMatchClick();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

// TILES[0].setVisible(false);

// TILES[1].setVisible(false);

// TILES[2].setVisible(false);

// TILES[3].setVisible(false);

// TILES[4].setVisible(false);

// TILES[5].setVisible(false);

// TILES[6].setVisible(false);

// TILES[7].setVisible(false);

// TILES[8].setVisible(false);

// TILES[9].setVisible(false);

// TILES[10].setVisible(false);

// TILES[11].setVisible(false);

// TILES[12].setVisible(false);

// TILES[13].setVisible(false);

// TILES[14].setVisible(false);

// TILES[15].setVisible(false);

// TILES[16].setVisible(false);

// TILES[17].setVisible(false);

// TILES[18].setVisible(false);

// TILES[19].setVisible(false);

// TILES[20].setVisible(false);

// TILES[21].setVisible(false);

//

// TILES[22].setVisible(false);

// TILES[23].setVisible(false);

// TILES[24].setVisible(false);

// TILES[25].setVisible(false);

// TILES[26].setVisible(false);

// TILES[27].setVisible(false);

//

//

// TILES[28].setVisible(false);

// TILES[29].setVisible(false);

// TILES[30].setVisible(false);

// TILES[31].setVisible(false);

// TILES[32].setVisible(false);

// TILES[33].setVisible(false);

//

//

// TILES[34].setVisible(false);

// TILES[35].setVisible(false);

// TILES[36].setVisible(false);

// TILES[37].setVisible(false);

// TILES[38].setVisible(false);

// TILES[39].setVisible(false);

//

// TILES[40].setVisible(false);

// TILES[41].setVisible(false);

// TILES[42].setVisible(false);

// TILES[43].setVisible(false);

// TILES[44].setVisible(false);

// TILES[45].setVisible(false);

//

// TILES[46].setVisible(false);

// TILES[47].setVisible(false);

// TILES[48].setVisible(false);

// TILES[49].setVisible(false);

// TILES[50].setVisible(false);

// TILES[51].setVisible(false);

// TILES[52].setVisible(false);

// TILES[53].setVisible(false);

// TILES[54].setVisible(false);

// TILES[55].setVisible(false);

// TILES[56].setVisible(false);

// TILES[57].setVisible(false);

// TILES[58].setVisible(false);

// TILES[59].setVisible(false);

// TILES[60].setVisible(false);

// TILES[61].setVisible(false);

// TILES[62].setVisible(false);

// TILES[63].setVisible(false);

// TILES[64].setVisible(false);

// TILES[65].setVisible(false);

// TILES[66].setVisible(false);

// TILES[67].setVisible(false);

// TILES[68].setVisible(false);

// TILES[69].setVisible(false);

// TILES[70].setVisible(false);

// TILES[71].setVisible(false);

// TILES[72].setVisible(false);

// TILES[73].setVisible(false);

// TILES[74].setVisible(false);

// TILES[75].setVisible(false);

// TILES[76].setVisible(false);

// TILES[77].setVisible(false);

// TILES[78].setVisible(false);

// TILES[79].setVisible(false);

// TILES[80].setVisible(false);

// TILES[81].setVisible(false);

// TILES[82].setVisible(false);

// TILES[83].setVisible(false);

// TILES[84].setVisible(false);

// TILES[85].setVisible(false);

// TILES[86].setVisible(false);

// TILES[87].setVisible(false);

// TILES[88].setVisible(false);

// TILES[89].setVisible(false);

// TILES[90].setVisible(false);

// TILES[91].setVisible(false);

// TILES[92].setVisible(false);

// TILES[93].setVisible(false);

// TILES[94].setVisible(false);

// TILES[95].setVisible(false);

// TILES[96].setVisible(false);

// TILES[97].setVisible(false);

// TILES[98].setVisible(false);

// TILES[99].setVisible(false);

// TILES[100].setVisible(false);

// TILES[101].setVisible(false);

// TILES[102].setVisible(false);

// TILES[103].setVisible(false);

// TILES[104].setVisible(false);

// TILES[105].setVisible(false);

// TILES[106].setVisible(false);

// TILES[107].setVisible(false);

// TILES[108].setVisible(false);

// TILES[109].setVisible(false);

// TILES[110].setVisible(false);

// TILES[111].setVisible(false);

// TILES[112].setVisible(false);

// TILES[113].setVisible(false);

// TILES[114].setVisible(false);

// TILES[115].setVisible(false);

// TILES[116].setVisible(false);

// TILES[117].setVisible(false);

// TILES[118].setVisible(false);

// TILES[119].setVisible(false);