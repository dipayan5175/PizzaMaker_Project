package gui;

public class HotSpot
{
	private int spot_id;
	private int x_loc;
	private int y_loc;
	private int width;
	private int height;
	
	public HotSpot(int hot_id, int x, int y, int w, int h)
	{
		spot_id = hot_id;
		x_loc = x;
		y_loc = y;
		width = w;
		height = h;
	}
	
	public void setHotX(int x)
	{
		x_loc = x;
	}
	
	public void setHotY(int y)
	{
		y_loc = y;
	}

	public int getHotX()
	{
		return x_loc;
	}
	
	public int getHotY()
	{
		return y_loc;
	}
	
	public int getHotWidth()
	{
		return width;
	}
	
	public int getHotHeight()
	{
		return height;
	}
	
	public int getHotLeft()
	{
		return x_loc - width/2;
	}
	
	public int getHotTop()
	{
		return y_loc - height/2;
	}
	
	public boolean isSelected(int x_click, int y_click)
	{
		int x_hit = Math.abs(x_click - x_loc);
		int y_hit = Math.abs(y_click - y_loc);
		if (x_hit < (width/2) && y_hit < (height/2))
		{
			return true;
		}

		return false;
	}
	
	public int getHotSpotID()
	{
		return spot_id;
	}
}
