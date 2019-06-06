package pizza;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import gui.CenterFrame;
import gui.Drawable;
import gui.ImageLoader;
import gui.DrawPanel;
import gui.SimpleDialogs;
import gui.EasyGridBag;

public class PizzaGUI extends CenterFrame implements Drawable, ActionListener
{
	
	public static void main (String[] args)
   {
      PizzaGUI pg = new PizzaGUI(800, 425);
   }
   
   public void keyPressed(char key)
   {
    
        
   }
   
   public void mouseClicked(int x, int y)
   {
       
   }

   private ImageLoader il = ImageLoader.getImageLoader();

   public void setCrust(PizzaBuilder pizza_builder)
   {
      if (thin.isSelected())
      {
         pizza_builder.setCrust("thin");
      }
      else if (handtossed.isSelected())
      {
         pizza_builder.setCrust("hand");
      }
      else
      {
         pizza_builder.setCrust("pan");
      }
   }

   public void setSize(PizzaBuilder pizza_builder)
   {
      if (small.isSelected())
      {
         pizza_builder.setSize('S');
      }
      else if (medium.isSelected())
      {
         pizza_builder.setSize('M');
      }
      else
      {
         pizza_builder.setSize('L');
      }
   }

   public void setToppings(PizzaBuilder pizza_builder)
   {

      if (pepperoni.isSelected())
      {
		  pizza_builder.addTopping('P');
      }

      if (onions.isSelected())
      {
         pizza_builder.addTopping('O');
      }

      if (peppers.isSelected())
      {
         pizza_builder.addTopping('G');
      }

      if (sausage.isSelected())
      {
         pizza_builder.addTopping('S');
      }

      if (mushrooms.isSelected())
      {
         pizza_builder.addTopping('M');
      }
   }

   public void actionPerformed(ActionEvent ae)
   {
      //the pizza has been ordered, so now we make it
      if (ae.getActionCommand().equals("Order"))
      {
         PizzaBuilder pizza_builder = new PizzaBuilder();
         setCrust(pizza_builder);
         setSize(pizza_builder);
        
         pizza_builder.buildPizza();
         setToppings(pizza_builder);  //fully decorated pizza comes back
		 DecoratedPizza dec_pizza = pizza_builder.pizzaDone();
         String pizza_img_file = "images/" + getImage(dec_pizza);
         image = il.getImage(pizza_img_file);
		 repaint();

         String temp = dec_pizza.toString();
         java.text.DecimalFormat fmt = new java.text.DecimalFormat("0.00");
         temp = temp + "$" + fmt.format(dec_pizza.getCost());
         SimpleDialogs.normalOutput(temp, "Pizza Order");
      }
	  
   }

   public void draw(Graphics g, int width, int height)
   {
      g.drawImage(image, 0, 0, null);
   }

   public String getImage(DecoratedPizza dec_pizza)
   {   
       
      return dec_pizza.getImage() + ".jpg";
     // System.out.println(dec_pizza.getImage());
}

   private Image image;
   private JPanel controls;
   private DrawPanel pizza_panel;

   private JRadioButton small;
   private JRadioButton medium;
   private JRadioButton large;

   private JRadioButton thin;
   private JRadioButton handtossed;
   private JRadioButton deepdish;

   private JLabel pizzaCrust;
   private JLabel pizzaSize;
   private JLabel pizzaToppings;

   private JButton btn;

   private JCheckBox mushrooms;
   private JCheckBox pepperoni;
   private JCheckBox peppers;
   private JCheckBox onions;
   private JCheckBox sausage;

   public PizzaGUI(int width, int height)
   {  
      super (width, height, "Pizza Time!");
      pizza_panel = new DrawPanel();
      pizza_panel.setBackground(Color.white);
      pizza_panel.setDrawable((Drawable) this);

      setResizable(false);
      setUp(width, height);
      setVisible(true);
   }

   private void setUp(int width, int height)
   {
      setBackground(Color.white);

      controls = new JPanel();
      controls.setBackground(Color.white);
      setLayout(new GridLayout(1, 2));
      add(pizza_panel);
      add(controls);

      small = new JRadioButton("S", true);
      small.setBackground(Color.white);
      medium = new JRadioButton("M");
      medium.setBackground(Color.white);
      large = new JRadioButton("L");
      large.setBackground(Color.white);
      ButtonGroup size = new ButtonGroup();
      size.add(small);
      size.add(medium);
      size.add(large);

      thin = new JRadioButton("Thin", true);
      thin.setBackground(Color.white);
      handtossed = new JRadioButton("Hand-Tossed");
      handtossed.setBackground(Color.white);
      deepdish = new JRadioButton("Deep Dish");
      deepdish.setBackground(Color.white);
      ButtonGroup crust = new ButtonGroup();
      crust.add(thin);
      crust.add(handtossed);
      crust.add(deepdish);

      btn = new JButton("Order!");
      btn.setBackground(Color.white);

      pizzaSize = new JLabel("Select Pizza Size:");
      pizzaCrust = new JLabel("Select Pizza Crust:");
      pizzaToppings = new JLabel("Select Pizza Toppings:");

      mushrooms = new JCheckBox("Mushrooms");
      mushrooms.setBackground(Color.white);
      pepperoni = new JCheckBox("Pepperoni");
      pepperoni.setBackground(Color.white);
      sausage = new JCheckBox("Sausage");
      sausage.setBackground(Color.white);
      onions = new JCheckBox("Onions");
      onions.setBackground(Color.white);
      peppers = new JCheckBox("Green Peppers");
      peppers.setBackground(Color.white);

      EasyGridBag bag = new EasyGridBag(6, 3, controls);
      controls.setLayout(bag);
      bag.fillCell(1, 1, pizzaSize);

      bag.fillCell(2,1,GridBagConstraints.WEST,small);
      bag.fillCell(3,1,GridBagConstraints.WEST,medium);
      bag.fillCell(4,1,GridBagConstraints.WEST,large);
      bag.fillCell(1,1,GridBagConstraints.WEST,pizzaSize);

      bag.fillCell(1,2,GridBagConstraints.WEST,pizzaCrust);
      bag.fillCell(2,2,GridBagConstraints.WEST,thin);
      bag.fillCell(3,2,GridBagConstraints.WEST,handtossed);
      bag.fillCell(4,2,GridBagConstraints.WEST,deepdish);

      bag.fillCell(1,3,GridBagConstraints.WEST,pizzaToppings);
      bag.fillCell(2,3,GridBagConstraints.WEST,pepperoni);
      bag.fillCell(3,3,GridBagConstraints.WEST,onions);
      bag.fillCell(4,3,GridBagConstraints.WEST,peppers);
      bag.fillCell(5,3,GridBagConstraints.WEST,sausage);
      bag.fillCell(6,3,GridBagConstraints.WEST,mushrooms);

      bag.fillCell(6, 2, btn);
      btn.addActionListener(this);
      btn.setActionCommand("Order");
   }
}
