package pizza;

public class Onions extends DecoratedPizza
{
	private double cost;
	private String image;

	public Onions(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.79;
		this.image = "O";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "Onions" + "\r\n";
	}
	
	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};