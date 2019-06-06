package gui;

import java.awt.Graphics;
import java.awt.Image;

public class DrawImage
{
	private HotSpot hot_spot;
	private Image image;
	private boolean visible;
	private String img_name;
	
	public DrawImage(Image img, String name, int w, int h)
	{
		hot_spot = new HotSpot(0, 0, 0, w, h);
		image = img; 
		visible = false;
		img_name = name;
	}
	
	public String getImageName()
	{
		return img_name;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
	public boolean isSelected(int x_click, int y_click)
	{
		if (!visible) return false;
		return hot_spot.isSelected(x_click, y_click);
	}

	public void showImage(int x_center, int y_center)
	{
		if (x_center >= 0 && y_center >= 0)
		{
			hot_spot.setHotX(x_center);
			hot_spot.setHotY(y_center);
			visible = true;
		}
	}
	
	public void hideImage()
	{
		visible = false;
	}
	
	public int getXCenter()
	{
		return hot_spot.getHotX();
	}
	
	public int getYCenter()
	{
		return hot_spot.getHotY();
	}
	
	public int getWidth()
	{
		return hot_spot.getHotWidth();
	}
	
	public int getHeight()
	{
		return hot_spot.getHotHeight();
	}
	
	public int getLeft()
	{
		return hot_spot.getHotLeft();
	}
	
	public int getTop()
	{
		return hot_spot.getHotTop();
	}

   public void draw(Graphics g)
   {
	   if (visible)
	   {
			g.drawImage(image, getLeft(), getTop(), null);
	   }
	}
}
