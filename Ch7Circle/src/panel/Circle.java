package panel;

import java.awt.*;

public class Circle 
{	
	private int centerX, centerY, radius;
	private Color color;
	private int _direction;
	private int _moveIncrement; // in pixels
	
	public Circle(int x, int y, int r, Color c)	
	{
		centerX = x;
		centerY = y;
		radius = r;
		color = c;		
	}
	
	
	public void draw(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		// Translates circle's center to rectangle's origin for drawing.
		g.drawOval(centerX - radius, centerY - radius,
		radius * 2, radius * 2);
		g.setColor(oldColor);
	}
	
	public void fill(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		// Translates circle's center to rectangle's origin for drawing.
		g.fillOval(centerX - radius, centerY - radius,
		radius * 2, radius * 2);
		g.setColor(oldColor);
	}
	
	public boolean containsPoint(int x, int y)
	{
		int xSquared = (x - centerX) * (x - centerX);
		int ySquared = (y - centerY) * (y - centerY);
		int radiusSquared = radius * radius;
		return xSquared + ySquared - radiusSquared <= 0;
	}
	
	public void move(int xAmount, int yAmount)
	{
		centerX = centerX + xAmount;
		centerY = centerY + yAmount;
	}
	
	// added for Ch7
	public void setSpeed (int speed)
	{
		_moveIncrement = speed;
	}
	
	// polar coordinates
	public void setDirection (int degrees)
	{
		_direction = degrees%360;
	}
	public void turn (int degrees)
	{
		_direction = (_direction + degrees)%360;
	}
	
	public void move()
	{	    
		move ( (int) (_moveIncrement * Math.cos(Math.toRadians(_direction))),
				(int) (_moveIncrement * Math.sin (Math.toRadians(_direction)))  );
						
	}
}// class Circle


