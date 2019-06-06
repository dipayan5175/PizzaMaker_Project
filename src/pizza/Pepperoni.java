package pizza;

public class Pepperoni extends DecoratedPizza
{
	private double cost;
	private String image;

	public Pepperoni(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.99;
		this.image = "P";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "Pepperoni" + "\r\n";
	}
	
	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};