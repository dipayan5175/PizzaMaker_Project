package gui;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ImageLoader
{
   private static ImageLoader il = new ImageLoader();
   private Toolkit toolkit;

   //singleton design pattern hides the constructor
   private ImageLoader() 
   {
      toolkit = Toolkit.getDefaultToolkit();
   }

   //the only way to get at the singleton reference
   public static ImageLoader getImageLoader()
   {
      return il;
   }
   
   public Image getImage(String file_name)
   {
      int len = file_name.length();
      Image img = null;   

      try
      {
		  BufferedImage bi = ImageIO.read(new File(file_name));
         //BufferedImage bi = ImageIO.read(getClass().getResource(file_name));
         img = toolkit.createImage(bi.getSource());
      } 
      catch (IOException e){
          System.out.println(e.getMessage());
      }
      
      return img;
   }
   
   //assumes white is the transparent color
   public Image getTransparencyImage(String file_name)
   {
      int len = file_name.length();
      Image img = null;   

      try
      {
		  BufferedImage bi = ImageIO.read(new File(file_name));
			//BufferedImage bi = ImageIO.read(getClass().getResource(file));
			img = toolkit.createImage(bi.getSource());
		 
			ImageFilter filter = new TransparencyFilter(Color.WHITE); 
			FilteredImageSource fis = new FilteredImageSource(img.getSource(), filter);
			return toolkit.createImage(fis);
      } 
      catch (IOException e){}
      
      return img;
   }
   
}

class TransparencyFilter extends RGBImageFilter
{
    // the color we are looking for... alpha bits are set to opaque
    private int marker_rgb;
 
    //the transparent color is specified through the constructor
    public TransparencyFilter(Color color)  
    {
       marker_rgb = (color.getRGB() | 0xFF000000);
    }

	//on a pixel by pixel basis, determine if alpha should be set to zero
    public int filterRGB(int x, int y, int rgb) 
    {
        if ((rgb | 0xFF000000) == marker_rgb) 
        {
           // Mark the alpha bits as zero - transparent
           return 0x00FFFFFF & rgb;
        }
		
		return rgb;
    }
}
