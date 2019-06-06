package pizza;
public class PizzaTopping extends DecoratedPizza
{
	private String topping;
	private String toppingLetter;
	private double cost;

	public PizzaTopping(DecoratedPizza pizza_component, String topping_string, String topping_letter, double topping_cost)
	{
		super(pizza_component);
		topping = topping_string;
		toppingLetter =  topping_letter;
		cost = topping_cost;
	}

	public double getCost()
	{
		return cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + topping + "\r\n";
	}

	public String getImage()
	{
		return super.getImage() + toppingLetter;
	}

};



