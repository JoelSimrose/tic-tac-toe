import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PaintO extends JButton
{


	public Dimension getPreferredSize()
	{
		return new Dimension(150,150);
	}

	public void paintComponent(Graphics g)
	{
		System.out.println("In paint");
		g.setColor(Color.BLACK);
		g.fillOval(20, 20, 150,150);
		g.setColor(Color.WHITE);
		g.fillOval(35, 35, 120,120);

		
		//g.drawLine(50,150,150,50);

	}

	//Override paint method to make X or O show in front of button
	//make data member in jbutton and capture that to determine to draw X or O
}