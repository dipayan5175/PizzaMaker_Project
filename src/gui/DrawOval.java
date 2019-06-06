package gui;

import java.awt.Graphics;
import java.awt.Color;

public class DrawOval
{
	private int width;
	private int height;

	public DrawOval(int w, int h)
	{	
		width = w;
		height = h;
	}
	
	public void draw(Graphics g, Color center_color, int x_center, int y_center)
   {
	   int left = x_center - width/2;
	   int top = y_center - height/2;
	   g.setColor(center_color);
       g.fillOval(left, top, width, height);
	}
	
   public void draw(Graphics g, Color center_color, Color outline_color, int x_center, int y_center)
   {
	   int left = x_center - width/2;
	   int top = y_center - height/2;
	   g.setColor(outline_color);
	   g.fillOval(left-2, top-2, width+4, height+4);
	   g.setColor(center_color);
       g.fillOval(left, top, width, height);
	}
}
