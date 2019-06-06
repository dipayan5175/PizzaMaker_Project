package pizza;

public class Ham extends DecoratedPizza
{
	private double cost;
	private String image;

	public Ham(DecoratedPizza current_decoratedPizza)
	{
		super(current_decoratedPizza);
		this.cost = 0.89;
		this.image = "H";
	}

	public double getCost()
	{
		return this.cost + super.getCost();
	}

	public String toString()
	{
		return super.toString() + "Ham" + "\r\n";
	}
	
	public String getImage()
	{
		return super.getImage() + this.image;	
	}
};