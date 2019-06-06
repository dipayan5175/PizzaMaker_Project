package pizza;

public class Pizza extends DecoratedPizza
{
	private Crust crust;
	
	public Pizza(Crust crust)
	{
		super();
		this.crust = crust;
	}

	public double getCost()
	{
		return  super.getCost()  + crust.getCost();
	}

	public String toString()
	{
		return super.toString() +  crust.toString();
	}
	
	public String getImage()
	{	
		
		return super.getImage() + crust.getSize();
		
	}

};