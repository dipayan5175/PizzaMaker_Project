package gui;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class DrawFont
{

	private int x_loc;  //top left of text to be drawn
	private int y_loc;
	private Font font;
	private Color color;

	public DrawFont(String font_name, String font_style, int font_size, Color c, int x, int y)
	{
		if (font_style.equals("bold"))
		{
			font = new Font(font_name, Font.BOLD, font_size);
		}
		else if (font_style.equals("italic"))
		{
			font = new Font(font_name, Font.ITALIC, font_size);
		}
		else
		{
			font = new Font(font_name, Font.PLAIN, font_size);
		}
		
		x_loc = x;
		y_loc = y;
		color = c;
	}
	
	public void setX(int x)
	{
		x_loc = x;
	}
	
	public void setY(int y)
	{
		y_loc = y;
	}

   public void draw(Graphics g, String text)
   {
	   g.setColor(color);
       g.setFont(font);
       g.drawString(text, x_loc, y_loc);
	}
}
