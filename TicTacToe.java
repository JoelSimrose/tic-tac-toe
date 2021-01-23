import javax.swing.*;
public class TicTacToe
{


	/**
	*This is the main method which runs the tic tac toe game
	*@param args for command line input
	*/
	public static void main(String[] args)
	{
		
		Player p1 = new GUIHumanPlayer('X');	//create new player objects
		Player p2 = new RandomPlayer('O');
		
		Board board = new Board(p1, p2);

		if(args.length == 2)
		{

			board.setRows(args[0]);
			board.setColumns(args[1]);

		}

		else{

			board.setRows("3");
			board.setColumns("3");
		}

		GUIBoard bs = new GUIBoard(board, "Tic-Tac-Toe", p1, p2);

		//BoardShow bs = new BoardShow(board, "My Board", p1, p2);	//show new board
		

		((GUIHumanPlayer) p1).setGUIBoard(bs);
		((RandomPlayer) p2).setGUIBoard(bs);

		Player turn = p1;	//start game with player 1's turn
		

		while(board.win() == null)
		{
			System.out.println("turn is: "+turn);

			Move newMove = turn.getMove(board);


			while(!board.makeMove(newMove.getRow(), newMove.getColumn(),turn))
			{
				System.out.println("In While");
				newMove = turn.getMove(board);	
			}

			bs.updateBoard(newMove.getRow(), newMove.getColumn(),turn.getPlayerType());

			if(board.win() == p1)
			{
				bs.updateWin('X');
				
			}

			else if(board.win() == p2)
			{
				bs.updateWin('O');
				
			
			}

			else if(board.tie())
			{
				JOptionPane.showMessageDialog(null, "Game has ended in a tie!", "Tic-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			bs.updateBoard(newMove.getRow(), newMove.getColumn(),turn.getPlayerType());
			

			if(turn == p1)	//switch turn to player 1 or player 2
			{
				turn = p2;
				
			}	

			else if(turn == p2)
			{
				turn = p1;
				
			}

		}
	
	}
	
}