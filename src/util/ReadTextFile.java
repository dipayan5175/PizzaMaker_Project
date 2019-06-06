package util;

import java.io.*;

public class ReadTextFile
{
   /** The abstracted BufferedReader */
   private BufferedReader br;

   /** Indicates whether the end of the file has been reached or not */
   private boolean EOF = false;
   
   /**
    *  Opens the provided text file for reading.
    */
   public ReadTextFile(String file_name) throws FileIOException
   {
      try
      {
            FileReader fr = new FileReader(file_name);
            br = new BufferedReader(fr);
      }
      catch (FileNotFoundException fnfe)
      {
			throw new FileIOException("File not found.");
      }
   }

   /**
    *  Indicates whether the end of the file has been reached. <br>
    *  <b>Preconditions</b>: None.<br>
    *  <b>Postconditions</b>: Returns true if the end of the file has been reached or false otherwise.<br>
    */
   public boolean EOF()
   {
      return EOF;
   }

   /**
    *  Reads in a line of text from a file. <br>
    *  <b>Preconditions</b>: None.<br>
    *  <b>Postconditions</b>: Returns a string with the next line of text from the file or null if the end of the file has been reached.<br>
    *  <b>Throws</b>: FileIOException if the file was not opened for reading or if a problem occurs when reading from the file.<br>
    */
   public String readLine() throws FileIOException
   {
      String temp = null;
      try
      {
            temp = br.readLine();
            if (temp == null)
            {
               EOF = true;
            }
      }
      catch (IOException ioe)
      {
         throw new FileIOException("IO Error");
      }

      return temp;
   }

   /**
    *  Closes the connection to a file. <br>
    *  <b>Preconditions</b>:  None.<br>
    *  <b>Postconditions</b>: The connection to the file is closed.<br>
    *  <b>Throws</b>: FileIOException if a problem occurs when closing the file.<br>
    */
   public void close() throws FileIOException
   {
      try
      {
            br.close();
            br = null;
      }
      catch (IOException ioe)
      {
         throw new FileIOException("IO Error");
      }
   }
}
