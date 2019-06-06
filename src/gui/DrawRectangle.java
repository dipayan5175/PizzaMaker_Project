package gui;

import java.awt.Graphics;
import java.awt.Color;

public class DrawRectangle
{
	private int width;
	private int height;

	public DrawRectangle(int w, int h)
	{	
		width = w;
		height = h;
	}
	
   public void draw(Graphics g, Color color, int x_center, int y_center)
   {
	   int left = x_center - width/2;
	   int top = y_center - height/2;
	   g.setColor(color);
       g.fillRect(left, top, width, height);
	}
	
	public void draw(Graphics g, Color center_color, Color outline_color, int x_center, int y_center)
   {
	   int left = x_center - width/2;
	   int top = y_center - height/2;
	   g.setColor(outline_color);
	   g.fillRect(left-2, top-2, width+4, height+4);
	   g.setColor(center_color);
       g.fillRect(left, top, width, height);
	}
}
