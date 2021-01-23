import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PaintX extends JButton
{


	public Dimension getPreferredSize()
	{
		return new Dimension(150,150);
	}

	public void paintComponent(Graphics g)
	{
		System.out.println("In paint");
		g.drawLine(50, 50, 150,150);
		g.drawLine(50,150,150,50);

	}

	//Override paint method to make X or O show in front of button
	//make data member in jbutton and capture that to determine to draw X or O
}