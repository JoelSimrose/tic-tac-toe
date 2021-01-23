
public abstract class Player
{

	private char playerType;

	public Player(char playerType)	{

		this.playerType = playerType;
	}

	public char getPlayerType()
	{
		return playerType;
	}

	public String toString()
	{
		return "" + playerType;
	}
	
	public abstract Move getMove(Board board);
		
	
}