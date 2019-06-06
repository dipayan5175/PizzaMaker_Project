package pizza;

public class PizzaFee extends DecoratedPizza
{
	private String message;
	private double fee;

	public PizzaFee(DecoratedPizza pizza_component)
	{
		super(pizza_component);
		message = "delivery";
		fee = 2.50;
	}

	public double getCost()
	{
		return this.fee + super.getCost();
	}

	public String toString()
	{
		return super.toString() + message + "\r\n";
	}
};