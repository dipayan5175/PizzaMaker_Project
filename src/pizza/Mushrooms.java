package pizza;

public class Mushrooms extends DecoratedPizza
{
	private double cost;
	private String image;

	public Mushrooms(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.79;
		this.image = "M";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "Mushrooms" + "\r\n";
	}
	
	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};