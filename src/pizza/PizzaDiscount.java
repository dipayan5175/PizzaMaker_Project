package pizza;

public class PizzaDiscount extends DecoratedPizza
{
	private String message;
	private double discount;

	public PizzaDiscount(DecoratedPizza pizza_component)
	{
		super(pizza_component);
		message = "senior discount";
		discount = 0.1;

	}

	public double getCost()
	{
		return super.getCost() - (this.discount * super.getCost());
	}

	public String toString()
	{
		return super.toString() + message + "\r\n";
	}
};