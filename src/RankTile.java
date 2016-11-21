import java.awt.Graphics;

/*
 * Daniel Bigelow
 * CS3230
 * 11/10/16
 */
public abstract class RankTile extends Tile {

	private static final long serialVersionUID = 1L;
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
		setToolTipText(toString());
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public Boolean matches(Tile other)
	{
		if(!super.matches(other))
			return false;
		RankTile rt = (RankTile) other;
		return this.rank == rt.rank;
	}
}
