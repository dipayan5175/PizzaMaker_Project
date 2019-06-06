package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

public class DrawPanel extends JPanel implements MouseListener, KeyListener
{
   private Drawable pict;

   public DrawPanel()
   {
      pict = null;
      addMouseListener(this);
      addKeyListener(this);  //allow the user to change strategies at any time
   }

   public void setDrawable(Drawable drawable)
   {
      if (drawable != null)
      {
         pict = drawable;
      }
   }

   /** Handles the complicated painting for the panel. <br> */
   public void paint(Graphics g)
   {
      int width = getSize().width;
      int height = getSize().height;

      //use double buffering
      Image offScreenBuffer = createImage(width, height);
      Graphics gOff = offScreenBuffer.getGraphics();

      gOff.setColor(Color.white);
      gOff.fillRect(0, 0, width, height);

      if (pict != null)
      {
         pict.draw(gOff, width, height);
      }
      g.drawImage(offScreenBuffer, 0, 0, null);  //copy the offScreenImage to the panel
      requestFocus();  //needed to get the key presses to work
   }

   public void mousePressed (MouseEvent event) 
   {
      repaint();  //MasterMind needs a repaint here so that the dialog works correctly
      if (pict != null)
      {
         pict.mouseClicked(event.getX(), event.getY());
      }
      repaint();
      requestFocus();  //needed to get the key presses to work
   }
   public void mouseClicked (MouseEvent event){}
   public void mouseReleased (MouseEvent event){}
   public void mouseEntered (MouseEvent event){}
   public void mouseExited (MouseEvent event){}

   public void keyTyped(KeyEvent ke)
   {
      char key = ke.getKeyChar();

      if (pict != null)
      {
         pict.keyPressed(key);
      }
   }

   public void keyPressed(KeyEvent ke){}
   public void keyReleased(KeyEvent ke){}
}

