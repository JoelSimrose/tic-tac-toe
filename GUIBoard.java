//Joel Simrose
//November 8, 2018

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
*This is a class which creates a new board and keeps track of the moves 
*/
public class GUIBoard implements ActionListener
{
	private Board board;
	private JFrame frame;
	private JLabel label;
	private int rows;
	private int columns;
	private JPanel panel;
	private PaintO paintO;
	private PaintX paintX;
	private GUIButton[][] buttons;
	private GUIButton gui;
	private int width;
	private int height;
	private Player playerX;
	private Player playerO;
	private Character character;


	private Move lastClicked = null;


	public GUIBoard(Board insertBoard, String title, Player p1, Player p2)
	{
		this.playerX = p1;
		this.playerO = p2;

		this.board = insertBoard;
		
		frame = new JFrame();	//create a new JFrame
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//make exit button close JFrame
		panel = new JPanel();

		panel.setLayout(new GridLayout(board.getRows(), board.getColumns()));

		panel.setPreferredSize(new Dimension(615,616));		//set panel size 
		frame.add(panel);

		width = board.getRows();		//set width of board
		height = board.getColumns();	//set height of board
		
		buttons = new GUIButton[width][height];	//create new button object array

		for(int i=0; i<width; i++)		//make 9 buttons and add them to panel
		{
			for(int j=0; j<height; j++)		
			{	
				buttons[i][j] = new GUIButton();				
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}

		frame.pack();
		frame.setVisible(true);
	}

	/**
	*This is a method which is used to update the board
	*/
	public void updateBoard(int row, int column, Character turn)
	{
		buttons[row][column].setCharacter(turn);
		buttons[row][column].repaint();
	}
	
	/**
	*This is a method which causes X's to spin or O's to get larger and smaller when there is a win
	*/
	public void updateWin(Character turn)
	{
		if(turn == 'X')
		{
			JOptionPane.showMessageDialog(null, "Player "+board.win()+" has won!", "Tic-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
			//break;
			while(true)
			{
				for(int i=0; i<width; i++)
				{
					for(int j=0; j<height; j++)
					{
						
					
						if(buttons[i][j].getCharacter() != null && buttons[i][j].getCharacter() == 'X')
						{
						
							buttons[i][j].rotateX();
							buttons[i][j].repaint();
						
							try
							{
								Thread.sleep(25);
							}

							catch(InterruptedException e)
							{
								System.out.println("Interrupted Exception");
							}
						}		
						
					}
				}
			}
		}

		else if(turn == 'O')
		{
	
			JOptionPane.showMessageDialog(null, "Player "+board.win()+" has won!", "Tic-Tac-Toe", JOptionPane.INFORMATION_MESSAGE);
		
			while(true)
			{
				for(int i=0; i<width; i++)
				{
					for(int j=0; j<height; j++)
					{
						
					
						if(buttons[i][j].getCharacter() != null && buttons[i][j].getCharacter() == 'O')
						{
							
							buttons[i][j].scaleO();
							buttons[i][j].repaint();
						
							try
							{
								Thread.sleep(50);
							}

							catch(InterruptedException e)
							{
								System.out.println("Interrupted Exception");
							}
						}		
						
					}
				}
			}
		}
	
	}
	
	public Player getPlayerX()
	{
		return playerX;

	}

	public Player getPlayerO()
	{
		return playerO;
		
	}

	public int getRows()
	{
		return width;
	}

	public int getColumns()
	{
		return height;
	}
	
	public Move getMove()
	{
	 	return lastClicked;
	}

	/*
	*This is a method which is called when an action is performed.
	*/
	public void actionPerformed(ActionEvent e)
	{

		for(int i=0; i<width; i++)
		{

			for(int j=0; j<height; j++)
			{
				if(e.getSource() == buttons[i][j])
				{	
					lastClicked = new Move(i, j);	
				}
			}
			
		}
	}
		
	public void resetClicked()
	{
		lastClicked = null;
	}


	
}

