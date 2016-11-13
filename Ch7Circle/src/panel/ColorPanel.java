package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //For the mouse events


public class ColorPanel extends JPanel
{
	private Circle _circle;
	private Circle _circleTwo;
	
	private Circle selectedCircle; // Used to track selected shape
	private int x, y; // Used to track mouse coordinates
	
	private javax.swing.Timer _timer;

	public ColorPanel(Color backColor, int width, int height)
	{

		setBackground(backColor);
		setPreferredSize ( new Dimension (width, height) );
		
		//radius 25 pixels
		_circle = new Circle(width/2, height/2, 25, Color.cyan);
		_circle.setSpeed(5);
		
		_circleTwo = new Circle (width, height, 55, Color.green);
		_circleTwo.setSpeed (7);
		
		addMouseListener(new MoveListener());
		
		
		_timer = new javax.swing.Timer(20, new TimerListener());
		_timer.start();
	}

    
    
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // in JComponent
		//_circle.fill(g);
		_circle.draw(g);
		
		_circleTwo.fill(g);
		_circleTwo.draw(g);
	}
	
	
	
	public void setMouseCoordinates (int xCoord, int yCoord)
	{
		x = xCoord;
		y = yCoord;
	}
	
	
	/*
	private class PanelListener extends MouseAdapter
	{
	
		public void mousePressed(MouseEvent e)
		{
		// Select a circle if it contains the mouse coordinates
		x = e.getX();
		y = e.getY();
		
		if (c1.containsPoint(x, y))
			selectedCircle = c1;
		else if (c2.containsPoint(x, y))
			selectedCircle = c2;
		}
		
		
		public void mouseReleased(MouseEvent e)
		{
		// Deselect the selected circle
			selectedCircle = null;
		}
	}//PanelListener
	*/
	
	private class MoveListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			//_circle.move();
			//_circle.turn(45); // Turn 2 degrees
			
			if (_timer.isRunning())
			{
				_timer.stop();
			}
			else
			{
				_timer.start();
			}
			
			repaint();
		}
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			_circle.move();
			_circle.turn(2); // Turn 2 degrees
			
			_circleTwo.move();
			_circleTwo.turn(2);;
			
			repaint();
		}
		
	}
		

	private class PanelMotionListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			if (selectedCircle != null)
			{
				// Compute the distance and move the selected circle
				int newX = e.getX();
				int newY = e.getY();
				int dx = newX - x;
				int dy = newY - y;
				selectedCircle.move(dx, dy);
				x = newX;
				y = newY;
				
				repaint();
			}
		}
	}
}// ColorPanel
