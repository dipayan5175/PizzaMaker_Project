package pizza;
import util.Keyboard;

import java.lang.*;

import java.text.DecimalFormat;

public class PizzaDriver
{
   private static DecimalFormat fmt = new DecimalFormat("0.00");
   private static Keyboard kb = Keyboard.getKeyboard();

   public static void main (String[] args)
   {
      PizzaBuilder builder = new PizzaBuilder();
      int numPizzas = 0;
      double totalCost = 0;

      System.out.println("Would you like to order a pizza (y/n)?\r\n");
      String str = kb.readString("");

      while(str.equalsIgnoreCase("y"))
      {
         
         int requestedMenu = menu();
         if(requestedMenu == 1)
         {
            MeatLovers meatLovers = new MeatLovers();
            requestSize(meatLovers);
            requestCrust(meatLovers);
            meatLovers.buildPizza();
            askDiscount(meatLovers);
            askFee(meatLovers);
            DecoratedPizza pizza = meatLovers.pizzaDone();
            showOrder(pizza);
            numPizzas++;
            totalCost += pizza.getCost();
         }
         else if(requestedMenu == 2)
         {
            VeggieLovers veggieLovers = new VeggieLovers();
            requestSize(veggieLovers);
            requestCrust(veggieLovers);
            veggieLovers.buildPizza();
            askDiscount(veggieLovers);
            askFee(veggieLovers);
            DecoratedPizza pizza = veggieLovers.pizzaDone();
            showOrder(pizza);
            numPizzas++;
            totalCost += pizza.getCost();
         }
         else if(requestedMenu == 3)
         {
            Hawaiian hawaiian = new Hawaiian();
            requestSize(hawaiian);
            requestCrust(hawaiian);
            hawaiian.buildPizza();
            askDiscount(hawaiian);
            askFee(hawaiian);
            DecoratedPizza pizza = hawaiian.pizzaDone();
            showOrder(pizza);
            numPizzas++;
            totalCost += pizza.getCost();
         }

         else if(requestedMenu == 4)
         {
            requestSize(builder);
            requestCrust(builder);
            builder.buildPizza();
            requestToppings(builder);
            askDiscount(builder);
            askFee(builder);
            DecoratedPizza pizza = builder.pizzaDone();
            showOrder(pizza);
            numPizzas++;
            totalCost += pizza.getCost();
         }
         
         System.out.println("Would you like to order another pizza (y/n)?\r\n");
         str = kb.readString("");
      }

      System.out.println("You ordered " + numPizzas + " pizza(s)\r\nfor a grand total of $" + fmt.format(totalCost) +".");
   }

   private static int menu()
   {
      System.out.println("1. Meat Lover's\r\n" + "2. Veggie Lover's\r\n" + "3. Hawaiian\r\n" + "4. Build Your Own\r\n");

      System.out.println("Select from the above\r\n");
      int integer = kb.readInt("");
      
      while((integer < 1) || (integer > 4))
      {
         System.out.println("Select from the above\r\n");
         integer = kb.readInt("");
      }
      return integer;
   }

   private static void askFee(PizzaBuilder builder)
   {
      System.out.println("Do you need this pizza delivered (y/n)? ");
      String c = kb.readString("");
      c = c.toLowerCase();
      
      while(!(c.equals("y")) && !(c.equals("n")))
      {
         System.out.println("Do you need this pizza delivered (y/n)? ");
         c = kb.readString("");
         c = c.toLowerCase();
      }

      if(c.equals("y"))
      {
        builder.addFee();
      }
   }

   private static void askDiscount(PizzaBuilder builder)
   {
      System.out.println("Are you a senior citizen (y/n)? ");
      String c = kb.readString("");
      c = c.toLowerCase();
      
      while(!(c.equals("y")) && !(c.equals("n")))
      {
         System.out.println("Are you a senior citizen (y/n)? ");
         c = kb.readString("");
         c = c.toLowerCase();
      }

      if(c.equals("y"))
      {
        builder.addDiscount();
      }
   }

   private static void showOrder(DecoratedPizza pizza)
   {
      String order = pizza.toString();
      System.out.println(order);
      System.out.println("The cost of your pizza is " + "$" + pizza.getCost());
   }

   private static void requestCrust(PizzaBuilder builder)
   {
      System.out.println("What type of crust (thin/pan/hand)?");
      String crust_type = kb.readString("");
      boolean result = builder.setCrust(crust_type);

      while (!result)
      {
         System.out.println("What type of crust (thin/pan/hand)?");
         crust_type = kb.readString("");
         result = builder.setCrust(crust_type);
      }
   }

   private static void requestSize(PizzaBuilder builder)
   {
      System.out.println("What size pizza (s/m/l)?\r\n");
      String size = kb.readString("");
      boolean result = builder.setSize(size.charAt(0));
      
      while (!result)
      {
         System.out.println("What size pizza (s/m/l)?\r\n");
         size = kb.readString("");
         result = builder.setSize(size.charAt(0));
      }
   }

   private static void requestToppings(PizzaBuilder builder)
   {
      System.out.println("(P)epperoni, (S)ausage, (G)reen Peppers, (O)nions, (M)ushrooms, (D)one\r\n");
      String topping = kb.readString("");
      
      while (!topping.equals("d") || !topping.equals("d"))
      {
         System.out.println("(P)epperoni, (S)ausage, (G)reenPeppers, (O)nions, (M)ushrooms, (D)one\r\n");
         builder.addTopping(topping.charAt(0));
         topping = kb.readString(""); 
      }
   }

}