package util;

import java.io.*;

public class WriteTextFile
{
   /** The abstracted PrintWriter */
   private PrintWriter pw;

   /** Indicates whether the end of the file has been reached or not */
   private boolean EOF = false;

   /**
    *  Opens the provided text file for writing.
    */
   public WriteTextFile(String file_name) throws FileIOException
   {
      try
      {
            FileWriter fw = new FileWriter(file_name);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
      }
      catch (FileNotFoundException fnfe)
      {
         throw new FileIOException("File not found.");
      }
      catch (IOException ioe)
      {
         throw new FileIOException("IO Error");
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
    *  Writes a line of text to a file. <br>
    *  <b>Preconditions</b>: The line of text to be written supplied (not null).<br>
    *  <b>Postconditions</b>: The line of text is written to the file.<br>
    *  <b>Throws</b>: FileIOException if the file was not opened for writing or a problem occurs during writing to the file.<br>
    */
   public void writeLine(String line) throws FileIOException
   {
	   //doesn't throw an IOException
	   pw.println(line);
   }

   /**
    *  Closes the connection to a file. <br>
    *  <b>Preconditions</b>:  None.<br>
    *  <b>Postconditions</b>: The connection to the file is closed.<br>
    *  <b>Throws</b>: FileIOException if a problem occurs when closing the file.<br>
    */
   public void close() throws FileIOException
   {
		//doesn't throw an IOException
		pw.close();
		pw = null;
   }
}
