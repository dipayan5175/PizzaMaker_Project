package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EasyGridBag extends GridBagLayout
{
   private GridBagConstraints c;
   private int rows;
   private int columns;
   private Container cont;

   /**
    * The constructor for EasyGridBag Layout. <br>
    * Preconditions:  numRows and numColumns specify the dimension of the desired grid (not all cells need to be filled).
    *                 The values are expected to be integers greater than 0.<br>
    *                 cont is the container using EasyGridBag Layout (not null).<br>
    * Postconditions: If the preconditions are met, the desired grid is created and ready to accept components.
    */
   public EasyGridBag(int numRows, int numColumns, Container cont)
   {
      c=new GridBagConstraints();
      this.cont=cont;

      int[] rows=new int[numRows];
      int[] columns=new int[numColumns];
      double[] rowWeights=new double[numRows];
      double[] columnWeights=new double[numColumns];

      for (int x=0;x<numRows;x++)
      {
         rows[x]=1;
         rowWeights[x]=1.0;
      }

      for (int x=0;x<numColumns;x++)
      {
         columns[x]=1;
         columnWeights[x]=1.0;
      }

      this.rowHeights=rows;
      this.columnWidths=columns;
      this.rowWeights=rowWeights;
      this.columnWeights=columnWeights;

      this.rows=numRows;
      this.columns=numColumns;

   }

   /**
    * Places a component into the EasyGridBag Layout (you will want to use this method initially). <br>
    * Preconditions:  row and column specify the placement location (must be valid values).<br>
    *                 comp is the component to insert at that location (not null).<br>
    * Postconditions: If the preconditions are met, the component is inserted at the specified location in the layout using center alignment.<br>
    *                 Otherwise, no action is taken.
    */
   public void fillCell( int row, int column, Component comp )
   {
      if (cont!=null && row>=1 && row<=rows && column>=1 && column<=columns)
      {
         c.gridy=row-1;
         c.gridx=column-1;
         c.anchor=GridBagConstraints.CENTER;
         c.fill=GridBagConstraints.NONE;
         c.gridheight=1;
         c.gridwidth=1;
         c.insets=new Insets(0,0,0,0);  //top,left,bottom,right
         cont.add(comp,c);
      }
   }

   /**
    * Places a component into the EasyGridBag Layout. <br>
    * Preconditions:  row and column specify the placement location (must be valid values).<br>
    *                 comp is the component to insert at that location (not null).<br>
    *                 alignment is an integer specifying the alignment of the component within the cell (assumed to be a valid alignment).<br>
    *                 alignment examples (GridBagConstraints.CENTER, WEST, NORTHEAST)<br>
    * Postconditions: If the preconditions are met, the component is inserted at the specified location in the layout, using the specified alignment.<br>
    *                 Otherwise, no action is taken.
    */
   public void fillCell( int row, int column, int alignment, Component comp )
   {
      if (cont!=null && row>=1 && row<=rows && column>=1 && column<=columns)
      {
         c.gridy=row-1;
         c.gridx=column-1;
         c.anchor=alignment;
         c.fill=GridBagConstraints.NONE;
         c.gridheight=1;
         c.gridwidth=1;
         c.insets=new Insets(0,0,0,0);  //top,left,bottom,right
         cont.add(comp,c);
      }
   }

   /**
    * Places a component into the EasyGridBag Layout. <br>
    * Preconditions:  row and column specify the placement location (must be valid values).<br>
    *                 comp is the component to insert at that location (not null).<br>
    *                 width and height specify how many rows and columns this cell will span (usually these are both 1).<br>
    *                 fill indicates whether the component should resize to fill the entire cell or use the preferred size of the component (GridBagConstraints.NONE).<br>
    *                 fill examples (GridBagConstraints.NONE, HORIZONTAL, VERTICAL, BOTH)<br>
    * Postconditions: If the preconditions are met, the component is inserted at the specified location in the layout, using the specified alignment.<br>
    *                 Otherwise, no action is taken.
    */
   public void fillCell( int row, int column, int height, int width, int fill, Component comp )
   {
      if (cont!=null && row>=1 && row<=rows && column>=1 && column<=columns)
      {
         c.gridy=row-1;
         c.gridx=column-1;
         c.anchor=GridBagConstraints.CENTER;
         c.fill=fill;
         c.gridheight=height;
         c.gridwidth=width;
         c.insets=new Insets(0,0,0,0);  //top,left,bottom,right
         cont.add(comp,c);
      }
   }

   /**
    * Places a component into the EasyGridBag Layout. <br>
    * Preconditions:  row and column specify the placement location (must be valid values).<br>
    *                 comp is the component to insert at that location (not null).<br>
    *                 alignment is an integer specifying the alignment of the component within the cell (assumed to be a valid alignment).<br>
    *                 top, left, bottom, and right specify offsets (in that order), in pixels, from the cell boundary (assumed positive).<br>
    * Postconditions: If the preconditions are met, the component is inserted at the specified location in the layout, using the specified alignment.<br>
    *                 Otherwise, no action is taken.
    */
   public void fillCell( int row, int column, int top, int left, int bottom, int right, int alignment, Component comp )
   {
      if (cont!=null && row>=1 && row<=rows && column>=1 && column<=columns)
      {
         c.gridy=row-1;
         c.gridx=column-1;
         c.anchor=alignment;
         c.fill=GridBagConstraints.NONE;
         c.gridheight=1;
         c.gridwidth=1;
         c.insets=new Insets(top,left,bottom,right);  //top,left,bottom,right
         cont.add(comp,c);
      }
      
   }

   /**
    * Sets the weight for a given row in the EasyGridBag Layout which affects how much space that
    * row is given when the container is resized. <br>
    * Preconditions:  row indicates the desired row (must be a valid row), and weight sets desired weight of that row.<br>
    *                 The default weight is that all rows are given weight 1.0.<br>
    * Postconditions: If the preconditions are met, the weight of the row is set as indicated.
    */
   public void setRowWeight(int row, double weight)
   {
      if (row>=1 && row<=rows)
      {
         rowWeights[row-1]=weight;
      }
   }

   /**
    * Sets the weight for a given column in the EasyGridBag Layout which affects how much space that
    * column is given when the container is resized. <br>
    * Preconditions:  column indicates the desired column (must be a valid column), and weight sets desired weight of that column.<br>
    *                 The default weight is that all columns are given weight 1.0.<br>
    * Postconditions: If the preconditions are met, the weight of the column is set as indicated.
    */
   public void setColumnWeight(int column, double weight)
   {
      if (column>=1 && column<=columns)
      {
         columnWeights[column-1]=weight;
      }
   }


}