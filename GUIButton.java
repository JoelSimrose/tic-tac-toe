import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.lang.Object.*;


public class GUIButton extends JButton
{

	private Character turn;
	private Player player;
	int rotate1;
	int rotate2;
	int scale1;
	int scale2;
	int incX;
	int incO;

	public GUIButton()
	{
		super();
		rotate1 = 45;
		rotate2 = 135;
		scale1 = 120;
		scale2 = 150;
		incX = 5;
		incO = 5;
	}

	public void rotateX()
	{
		scale1 = scale1 + incO;

		if(scale1 > 120) 
		{
			scale1 = 120;
			incO = -5;
		}

		if(scale1 < 20)
		{
			scale1 = 20;
			incO = 5;

		} 

		scale2 = scale2 + incO;

		if(scale2 > 150)
		{
			scale2 = 150;
			incO = -5;
		} 

		if(scale2 < 50)
		{
			scale2 = 50;
			incO = 5;
		}
	}

	public void scaleO()
	{
		scale1 = scale1 + incO;

		if(scale1 > 120) 
		{
			scale1 = 120;
			incO = -5;
		}

		if(scale1 < 20)
		{
			scale1 = 20;
			incO = 5;

		} 

		scale2 = scale2 + incO;

		if(scale2 > 150)
		{
			scale2 = 150;
			incO = -5;
		} 

		if(scale2 < 50)
		{
			scale2 = 50;
			incO = 5;
		}
	}
	/**
	*This is a method which paints either an x or o depending on the turn
	*/
	public void paint(Graphics g)
	{
		
		super.paint(g);
		
		Graphics2D gr = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();
		
		try
		{
			if(turn == 'X')
			{

				AffineTransform old = gr.getTransform();

				gr.translate((width * 2) / 7, height/4 - height/40);
				
				gr.rotate(Math.toRadians(rotate1));

				gr.setColor(Color.BLACK);
				
				gr.fillRect(0, 0, (width * 8) / 10, height/10);
		
				gr.setTransform(old);
				
				//Second Rectangle
				gr.translate((width * 165) / 200, height/3 - height/30);
				gr.rotate(Math.toRadians(rotate2));
			
				gr.fillRect(0, 0, (width * 8) / 10, height/10);		
				
			}

			if(turn == 'O')
			{
				gr.setColor(Color.BLACK);
				gr.fillOval(width/2-(scale2/2), height/2-(scale2/2), scale2,scale2);
				Color myColor = this.getBackground();
				gr.setColor(myColor);
				gr.fillOval(width/2-(scale1/2), height/2-(scale1/2), scale1, scale1);
			}
			
		}

		catch(Exception e)
		{
			//System.out.println("There was an exception " );
		}
		
	}
	
	public void setCharacter(Character turn)
	{
		this.turn = turn;
	}

	public Character getCharacter()
	{
		return turn;
	}

}