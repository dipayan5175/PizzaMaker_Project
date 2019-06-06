package util;

import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.ArrayList;

public class StringTokens
{
	/** Allows the same object to process numerous lines of text using the same delimiter */
   private String delimiter;
   
   public StringTokens(String delimit)
   {
	   if (delimit == null || delimit.equals(""))
	   {
		   delimit = " ";
	   }
	   
	   delimiter = delimit;
   }

   public Iterator<String> getTokens(String text) throws FileIOException
   {
      ArrayList<String> list = new ArrayList<String>();

      if (text != null)
      {
            String[] tokens = text.split(delimiter);
            list = new ArrayList<String>();

            for (String str : tokens)
            {
               list.add(str);
            }
      }

      return list.iterator();
   }
}
