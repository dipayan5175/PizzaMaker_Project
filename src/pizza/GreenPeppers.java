package pizza;

public class GreenPeppers extends DecoratedPizza
{
	private double cost;
	private String image;

	public GreenPeppers(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.69;
		this.image = "G";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "GreenPeppers" + "\r\n";
	}

	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};