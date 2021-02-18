//Joel Simrose
//CMPT 305
//Assignment5 GUIBoard
//November 8, 2018

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUIHumanPlayer extends Player
{
	private GUIBoard gb;

	private char playerType;

	public GUIHumanPlayer(char param)
	{
		super(param);
	}


	public void setGUIBoard(GUIBoard board)
	{
		this.gb = board;
	}
	
	public Move getMove(Board board)
	{

		gb.resetClicked();

		while(gb.getMove() == null)	//gb.getMove() == null
		{
			
			try{
				Thread.sleep(100);
			}
				
			catch(InterruptedException e){
				System.out.println("Interrupted Thread");
			}	

			if(gb.getMove() != null)
			{
				return gb.getMove();
			}


		}
		
		return null;
	}		

}