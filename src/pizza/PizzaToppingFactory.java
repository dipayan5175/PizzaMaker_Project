package pizza;
public class PizzaToppingFactory 
{
   public static DecoratedPizza addPepperoni(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Pepperoni", "P",  0.99);
   }

   public static DecoratedPizza addGreenPeppers(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "GreenPeppers", "G",  0.69);
   }

   public static DecoratedPizza addHam(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Ham", "H",  0.89);
   }

   public static DecoratedPizza addMushrooms(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Mushrooms", "M",  0.79);
   }

   public static DecoratedPizza addOnions(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Onions", "O",  0.79);
   }

   public static DecoratedPizza addPineapple(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Pineapple", "A",  0.89);
   }

   public static DecoratedPizza addSausage(DecoratedPizza current_decoratedPizza)
   {
		return new PizzaTopping(current_decoratedPizza, "Sausage", "S",  0.99);
   }

};
