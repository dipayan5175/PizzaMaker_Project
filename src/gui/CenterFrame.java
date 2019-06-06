package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Extend this class to set some default behavior for JFrames. <br>
 */
public abstract class CenterFrame extends JFrame 
{
	private int[] screen_dimensions;
	
	public int[] getScreenDimensions()
	{
		return screen_dimensions;
	}

   public CenterFrame(int width, int height, String title)
   {  
      super(title);
      center(width, height);
      addWindowListener(new ExitGUI());
   }

   private void center(int width, int height)
   {
      setSize(width, height);

      //center the window
	  Dimension screen_size = getToolkit().getScreenSize();
	  screen_dimensions = new int[2];
	  screen_dimensions[0] = screen_size.width;
	  screen_dimensions[1] = screen_size.height;
	  
      setLocation(screen_dimensions[0]/2 - width/2, screen_dimensions[1]/2 - height/2);
   }

private class ExitGUI extends WindowAdapter
{
   public void windowClosing(WindowEvent e)
   {
      System.exit(0);
   }
}

}
