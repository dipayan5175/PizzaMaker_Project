package pizza;

public class Pineapple extends DecoratedPizza
{
	private double cost;
	private String image;

	public Pineapple(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.89;
		this.image = "A";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "Pineapple" + "\r\n";
	}
	
	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};