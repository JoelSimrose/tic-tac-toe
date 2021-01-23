//Joel Simrose
//CMPT 305
//Assignment 3
//October 24, 2018

/**
*This is a class which creates a new board and keeps track of the moves 
*/
public class Board
{
	private Player p1;
	private Player p2;

	private int rows = 3;
	private int columns = 3;

	Player[][] setMove = new Player[getRows()][getColumns()];
	
	public Board()
	{
		
	}
	
	public Board(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;

		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				setMove[i][j] = null;
			}
		}
		
	}

	/**
	*This function is passed in from the terminal and is changed to an integer and assigned to rows.
	*@param row to change to integer
	*/
	public void setRows(String row)
	{
		rows = Integer.parseInt(row);
	}

	/**
	*This function is passed in from the terminal and is changed to an integer and assigned to columns.
	*@param column to change to integer
	*/
	public void setColumns(String column)
	{
		columns = Integer.parseInt(column);
	}
	
	public int getRows(){return rows;}

	public int getColumns(){return columns;}

	/**
	*This is a method which returns either the player at a space, or null if there is no player
	*@param row pass in the row to find the player object at the location
	*@param column to pass in the column to find the player object at the location
	*/

	Player getPlayerAtLocation(int row, int column)
	{

		if(setMove[row][column] == p1)
		{
			return p1;
		}

		else if(setMove[row][column] == p2)
		{
			return p2;
		}
		
		else
		{
			return null;
		}
	};

	/**
	*This is a method which is used to check if a player has won
	*@return returns the player that has won the game  
	*/
	Player win()
	{


		Player checkWin = null;

		try{


			for(int i=0; i<rows; i++)//check for horizontal win
			{
				if(setMove[i][0] == null)
				{
					checkWin = null;
				}

				else{

					checkWin = setMove[i][0];


					for(int j=0; j<columns; j++)
					{
						if(setMove[i][j] != checkWin )
						{
							checkWin = null;
						}

						else if(j == (columns-1) && checkWin != null)
						{
							System.out.println("In 1");
							return checkWin;
						}

					}
				}
			}

			
			for(int a=0; a<columns; a++)//check for vertical win
			{
				if(setMove[0][a] == null)
				{
					checkWin = null;
				}

				else{

					checkWin = setMove[0][a];


					for(int b=1; b<rows; b++)
					{

						if(setMove[b][a] != checkWin)
						{
							checkWin = null;
						}

						else if(b == (rows-1) && checkWin != null)
						{	
							System.out.println("In 2");
							return checkWin;
						}

					}
				}
			}	



			if(rows == columns)	//Check for positive diagonal win
			{

				int i=0;

				if(setMove[rows-1][i] == null)
				{
					checkWin = null;
				}

				else
				{
					
					checkWin = setMove[rows-1][i];
					

					for(int j=rows-1; j>=0; j--)
					{	

						if(checkWin != setMove[j][i])
						{					
							checkWin = null;
						}

						else if(j == 0 && i == (rows-1) && checkWin != null)
						{	
							System.out.println("In 3");
							return checkWin;
						}

						i++;
					}
				}	

				for(int x=0; x<rows; x++)	// check negative diagonal
				{
					if(setMove[0][0] == null)
					{
						checkWin = null;
					}

					else
					{
						checkWin = setMove[0][0];

						for(int b=0; b<rows; b++)
						{
							if(checkWin != setMove[b][b])
							{
								checkWin = null;
							}

							else if(b == (rows-1) && checkWin != null)
							{
								return checkWin;
							}
						}


					}
				}

				
			}
		}

		catch(Exception e)
		{
			System.out.println("There has been an exception: " + e);
		}
		return null;

	}

	/**
	*This is a method which checks if there are no spaces left to play and sets a tie
	*@return returns true if there has been a tie or false if not
	*/
	boolean tie()
	{
		int count = 0;
		boolean tie = false;

		for(int i=0; i < rows; i++)
		{

			for(int j=0; j < columns; j++)
			{
				if(setMove[i][j] != null)
				{
					count++;
				}
			}
		}

		System.out.println("Count = "+count);

		if(count == (rows*columns))
		{
			tie = true;
		}
		
		return tie;
	}

	/**
	*This is a function which checks if a spot is taken or not and updates the board with the player added
	*@param row to pass in the row
	*@param column to pass in the column 
	*@param player to pass in the current player wanting to make a move
	*@return returns true if the move was successful or false if not
	*/
	boolean makeMove(int row, int column, Player player)
	{
	


		if(getPlayerAtLocation(row, column) != null)
		{
			return false;
		}

		else
		{
			setMove[row][column] = player;
		
			return true;
		}
		
	
	}

}
