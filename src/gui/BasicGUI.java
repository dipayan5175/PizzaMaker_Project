package gui;

import java.awt.BorderLayout;

public class BasicGUI extends CenterFrame
{

   public BasicGUI(int width, int height, String title, Drawable d)
   {      
      super (width, height, title);

      setLayout(new BorderLayout());
      setSize(width, height);
      setResizable(false);

      DrawPanel draw = new DrawPanel();
      draw.setDrawable(d);
      add(draw, BorderLayout.CENTER);

      setVisible(true);
   }
   
}
