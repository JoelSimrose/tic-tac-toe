import java.util.*;

/*
This class creates a move for the random player
*/
public class RandomPlayer extends Player
{
	private GUIBoard gb;

	public RandomPlayer(char param)
	{
		super(param);
	}

	public void setGUIBoard(GUIBoard board)
	{
		this.gb = board;
	}

	
		
	/**
	*This is a method gets a random move on the board and returns it 
	*@param board to check if the move is available
	*@return returns the space the random player chooses
	*/	
	public Move getMove(Board board)
	{

		int randomRow = getRandom(board.getRows());
		int randomColumn = getRandom(board.getColumns());
		
		return new Move(randomRow, randomColumn);	//create new move object
		
	}


	/**
	*This is a method which creates a random integer based on the size of the board
	*@param size takes in the size of the board
	*@return returns a random integer
	*/
	public int getRandom(int size)
	{
		
		int randNum;

		Random number = new Random();		//get a random number and add it to the array
		randNum = number.nextInt(size); 

		return randNum;
	}
	


}