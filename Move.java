/*
*This is a class which sets and stores the current move
*/
public class Move
{
	private int row;
	private int column;
	
	
	public Move(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return row;
	}

	public int getColumn()
	{
		return column;
	}
	
}