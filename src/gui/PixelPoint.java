package gui;

public class PixelPoint
{
	private int x_loc;
	private int y_loc;
	
	public PixelPoint(int x, int y)
	{
		x_loc = x;
		y_loc = y;
	}
	
	public int getX()
	{
		return x_loc;
	}
	
	public int getY()
	{
		return y_loc;
	}
}
